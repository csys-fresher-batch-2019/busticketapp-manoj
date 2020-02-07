package CreateAccount;

public interface userAccountDetailsDAO {
	public  int addUser (userAccountDetails a) ;
	public  boolean forgetPassword(int userid,String password) ;
    public boolean checkEmailId(String emailId) ;
    public boolean validateLogin(int userId) ;
    public boolean validateLogin2(int userId,String password) ;
    public boolean checkEmailId2(String emailId,int userId) ;



}
