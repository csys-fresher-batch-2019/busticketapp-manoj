package CreateAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

import AdminRole.TestConnection;

public class userAccountDetailsDAOImpl implements userAccountDetailsDAO {
	public int addUser(userAccountDetails a) throws Exception {
		Connection con = TestConnection.connection();
		String sql = "insert into user_account(user_name,user_id,user_password,gender,dob,contact_number,email_id) values(?,user_id.nextval,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, a.userName);
		pst.setString(2, a.password);
		pst.setString(3, a.gender);
		java.sql.Date dob = java.sql.Date.valueOf(a.dob);
		pst.setDate(4, dob);
		pst.setLong(5, a.contactNumber);
		pst.setString(6, a.emailId);
		pst.executeUpdate();

		System.out.println("User Account created successfully\n");

		int userid = 0;
		String sql1 = "select user_id from user_account where email_id=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setString(1, a.emailId);
		ResultSet row = pst1.executeQuery();
		if (row.next()) {
			userid = row.getInt("user_id");

		}
		con.close();
		return userid;
		

	}

	public boolean forgetPassword(int userid, String password) throws Exception {
		Connection con = TestConnection.connection();

		String sql2 = "update user_account set user_password=? where user_id=?";
		PreparedStatement pst2 = con.prepareStatement(sql2);
		pst2.setString(1, password);
		pst2.setInt(2, userid);
		int rows = pst2.executeUpdate();
		if (rows > 0) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}

	}

	public boolean checkEmailId(String emailId) throws Exception {
		Connection con = TestConnection.connection();
		String email1 = "select email_id from user_account where email_id=?";
		PreparedStatement smt = con.prepareStatement(email1);

		smt.setString(1, emailId);
		ResultSet row = smt.executeQuery();
		String email = "";
		if (row.next()) {
			email = row.getString("email_id");
		}
		if (email.equals(emailId)) {
			con.close();
			return false;
		} else {
			con.close();
			return true;
		}

	}
	

	public boolean checkEmailId2(String emailId,int userId) throws Exception {
		Connection con = TestConnection.connection();
		String email1 = "select email_id from user_account where user_id=?";
		PreparedStatement smt = con.prepareStatement(email1);
		smt.setInt(1, userId);
		ResultSet row = smt.executeQuery();
		String email = "";
		if (row.next()) {
			email = row.getString("email_id");
		}
		if (email.equals(emailId)) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}

	}

	public boolean validateLogin(int userId) throws Exception {
		Connection con = TestConnection.connection();
		String sql3 = "select user_id from user_account where user_id = ?";
		PreparedStatement smt2 = con.prepareStatement(sql3);
		smt2.setInt(1, userId);
		ResultSet row2 = smt2.executeQuery();
		int userid = 0;
		if (row2.next()) {
			userid = row2.getInt("user_id");
		}
		if (userId == userid) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}

	}

	public boolean validateLogin2(int userId, String password) throws Exception {
		Connection con = TestConnection.connection();
		String sql4 = "select user_password from user_account where user_id = ?";
		PreparedStatement smt3 = con.prepareStatement(sql4);
		smt3.setInt(1, userId);
		ResultSet row3 = smt3.executeQuery();
		if (row3.next())
			if (password.equals(row3.getString("user_password")))
				{con.close();
				return true;}
			else
				{con.close();
				return false;}
		con.close();
		return false;
	}
}
