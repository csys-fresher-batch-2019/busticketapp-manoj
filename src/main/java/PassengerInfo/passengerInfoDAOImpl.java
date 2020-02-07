package PassengerInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AdminRole.TestConnection;


public class passengerInfoDAOImpl implements passengerInfoDAO {
	public int insertPassengerInfo(passengerInfo a) {
		try (Connection con = TestConnection.connection();) {
			String sql = "insert into passenger_details(booking_id,user_id,bus_id,passenger_name,age,gender,mobile_number,no_of_tickets) values (sequence_booking_id.nextval,?,?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, a.getUserId());
				pst.setInt(2, a.getBusId());
				pst.setString(3, a.getPassengerName());
				pst.setInt(4, a.getAge());
				pst.setString(5, a.getGender());
				pst.setLong(6, a.getMobileNumber());
				pst.setInt(7, a.getNoOfTickets());
				pst.executeUpdate();
				int numTickets = a.getNoOfTickets();

				System.out.println("you are successfully entered your details..\n");
				try (Statement stmt = con.createStatement();) {
					String sql1 = "select sequence_booking_id.currval from dual";
					try(ResultSet rs = stmt.executeQuery(sql1);){
					rs.next();

					int bId = rs.getInt("currval");

					String sql2 = "update seat_availability set available_seats=available_seats-" + a.getNoOfTickets()
							+ " where bus_id=?";
					try (PreparedStatement pst1 = con.prepareStatement(sql2);) {
						pst1.setInt(1, a.getBusId());
						pst1.executeUpdate();

						int price = 0, totalPrice = 0;
						String sql3 = "select ticket_price from bus_details where bus_id=?";
						try (PreparedStatement pst2 = con.prepareStatement(sql3);) {
							pst2.setInt(1, a.getBusId());
							try (ResultSet rs1 = pst2.executeQuery();) {
								rs1.next();
								price = rs1.getInt("ticket_price");
								totalPrice = price * a.getNoOfTickets();

								Statement stmt2 = con.createStatement();
								String sql4 = "insert into payment_status(user_id,bus_id,booking_id,total_price)values("
										+ a.getUserId() + "," + a.getBusId() + "," + bId + "," + totalPrice + ")";
								stmt2.executeUpdate(sql4);
								return bId;
							}
						}
					}
				}}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	public ArrayList<passengerInfo> BookingDetails(int bookingId) {
		try (Connection con = TestConnection.connection();) {
			String sql5 = "select *from passenger_details where booking_id=?";
			try (PreparedStatement pst5 = con.prepareStatement(sql5);) {
				pst5.setInt(1, bookingId);
				try (ResultSet rows = pst5.executeQuery();) {
					ArrayList<passengerInfo> details = new ArrayList<passengerInfo>();
					while (rows.next()) {

						passengerInfo p = new passengerInfo();
						p.setBookingId(rows.getInt("booking_id"));
						p.setUserId(rows.getInt("user_id"));
						p.setBusId(rows.getInt("bus_id"));
						p.setPassengerName(rows.getString("passenger_name"));
						p.setMobileNumber(rows.getLong("mobile_number"));
						p.setNoOfTickets(rows.getInt("no_of_tickets"));
						p.setAge(rows.getInt("age"));
						p.setGender(rows.getString("gender"));

						details.add(p);
					}

					return details;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

	public void cancelBooking(int bookingId) {
		try (Connection con = TestConnection.connection();) {
			String sql6 = "update passenger_details set booking_status= 'cancelled' where booking_id=?";
			try (PreparedStatement pst6 = con.prepareStatement(sql6);) {
				pst6.setInt(1, bookingId);
				pst6.executeUpdate();

				String sql7 = "update seat_availability set available_seats=available_seats+(select no_of_tickets from passenger_details where booking_id=?) where bus_id=(select bus_id from passenger_details where booking_id=?)";
				try (PreparedStatement pst7 = con.prepareStatement(sql7);) {
					pst7.setInt(1, bookingId);
					pst7.setInt(2, bookingId);
					pst7.executeUpdate();

					String sql8 = "update payment_status set paid_status= 'returned' where booking_id=?";
					try (PreparedStatement pst8 = con.prepareStatement(sql8);) {
						pst8.setInt(1, bookingId);
						pst8.executeUpdate();

						String sql9 = "update passenger_details set no_of_tickets= 0 where booking_id=?";
						try (PreparedStatement pst9 = con.prepareStatement(sql9);) {
							pst9.setInt(1, bookingId);
							pst9.executeUpdate();
						}
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public boolean validateBookingId(int bookingId) {

		try (Connection con = TestConnection.connection();) {
			String bId = "select booking_id from passenger_details where booking_id=?";
			try (PreparedStatement smt = con.prepareStatement(bId);) {
				smt.setInt(1, bookingId);
				try (ResultSet row = smt.executeQuery();) {
					int bookid = 0;
					if (row.next()) {
						bookid = row.getInt("booking_id");
					}
					if (bookid == bookingId) {

						return true;
					} else {

						return false;
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean validateBusId(int busId) {
		try (Connection con = TestConnection.connection();) {
			String bus = "select bus_id from bus_details where bus_id = ?";
			try (PreparedStatement smt9 = con.prepareStatement(bus);) {
				smt9.setInt(1, busId);
				try(ResultSet row9 = smt9.executeQuery();){
				int busid = 0;
				if (row9.next()) {
					busid = row9.getInt("bus_id");
				}
				if (busId == busid) {

					return true;
				} else {

					return false;
				}

			}}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}
}
