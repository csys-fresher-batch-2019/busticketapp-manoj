package SearchBus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import AdminRole.TestConnection;

public class FindBusDAOImpl implements FindBusDAO{
	public ArrayList<FindBus> searchbus(String fromLocation, String toLocation, String journeyDate) throws Exception {
		
		
		
		Connection con = TestConnection.connection();
		String sql="select bus_name,bus_id,ticket_price,travelling_time from bus_details where from_location= ? and to_location= ? and journey_date= ?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,fromLocation);
		pst.setString(2,toLocation);
		java.sql.Date journeyDate1=java.sql.Date.valueOf(journeyDate);
		pst.setDate(3,journeyDate1);
		ResultSet rows=pst.executeQuery();
		ArrayList<FindBus> buses1=new ArrayList<FindBus>();
		while(rows.next()) {
			
			FindBus f=new FindBus();
	
			f.busName=rows.getString("bus_name");
			f.busId=rows.getInt("bus_id");
			f.travellingTime=rows.getString("travelling_time");
			f.ticketPrice=rows.getInt("ticket_price");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select available_seats from seat_availability where bus_id="+f.busId);
			while(rs.next())
			{
				int seats=rs.getInt("available_seats");
				if(seats>0)
				{
			buses1.add(f);
				}
			}
		}		
		con.close();
		return buses1;
	
	}
}
