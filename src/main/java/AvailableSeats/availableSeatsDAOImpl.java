package AvailableSeats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminRole.TestConnection;

public class availableSeatsDAOImpl implements availableSeatsDAO {

	public int seatavail(int busid) throws Exception {
		Connection con = TestConnection.connection();
		String sql = "select available_seats from seat_availability where bus_id=? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, busid);
		ResultSet row = pst.executeQuery();
		int seats = 0;
		if (row.next()) {
			seats= row.getInt("available_seats");
			
		}
		con.close();
		return seats;
	
	}

}
