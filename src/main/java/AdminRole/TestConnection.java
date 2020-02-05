
package AdminRole;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static Connection connection()  throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
	
	return connection;
	//Statement stat=connection.createStatement();
	
	//String sql="insert into bus_info values(7,110,'KPN',50,'sleeper',1,'chennai','tirupur')";
	//String sql1="update bus_info set bus_name='ABC' where bus_id=100";
	//int rows=stat.executeUpdate(sql1);
	//System.out.println(rows);
	}
	
	

}
