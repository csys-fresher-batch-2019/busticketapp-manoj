package BusDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import AdminRole.TestConnection;
import SearchBus.FindBus;

public class busDetailsDAOImpl<bus> implements busDetailsDAO {
	public void addBus(busDetails a) throws Exception{
		Connection con = TestConnection.connection();
		String sql = "insert into bus_details (bus_id,bus_name,from_location,to_location,journey_date,ticket_price,travelling_time) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, a.busId);
		pst.setString(2, a.busName);
		pst.setString(3,a.fromLocation);
		pst.setString(4,a.toLocation);
		java.sql.Date journeyDate=java.sql.Date.valueOf(a.journeyDate);
		pst.setDate(5,journeyDate);
		pst.setInt(6, a.ticketPrice);
		pst.setString(7,a.travellingTime);
        pst.executeUpdate();
        int busId=a.busId;
        
       
		
        
        String sql1="insert into seat_availability (bus_id,maximum_seats,available_seats) values(?,?,?)";
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1,busId);
        pst1.setInt(2,a.maximumSeats);
        pst1.setInt(3,a.availableSeats);
        pst1.executeUpdate();
        
        
		System.out.println("Bus Details are added successfully\n");
		con.close();
		
		}
	public void removeBus(int busId) throws Exception{
   Connection con = TestConnection.connection();
		
		String sql = "delete from bus_details where bus_id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,busId);
         pst.executeUpdate();
         
         String sql1 = "delete from seat_availability where bus_id=?";
 		PreparedStatement pst1=con.prepareStatement(sql1);
 		pst1.setInt(1,busId);
          pst1.executeUpdate();
		
		System.out.println("Bus Details are deleted Successfully");
		con.close();
	}
	public void updateBusTiming(busDetails a) throws Exception{
		   Connection con = TestConnection.connection();
				
				String sql = "update bus_details set travelling_time=? where bus_id=?";
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,a.travellingTime);
				pst.setInt(2,a.busId);
		        pst.executeUpdate();
		        int busId=a.busId;
		        
		       
				
				System.out.println("Bus timings are Updated Successfully");
				con.close();

}
	
	}

