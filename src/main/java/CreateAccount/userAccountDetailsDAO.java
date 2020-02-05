package CreateAccount;

public interface userAccountDetailsDAO {
	public  int addUser (userAccountDetails a) throws Exception;
	public  boolean forgetPassword(int userid,String password) throws Exception;
    public boolean checkEmailId(String emailId) throws Exception;
    public boolean validateLogin(int userId) throws Exception;
    public boolean validateLogin2(int userId,String password) throws Exception;
    public boolean checkEmailId2(String emailId,int userId) throws Exception;



}
