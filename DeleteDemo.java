import java.sql.*;
class DeleteDemo
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("registered Successfully");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("connection Established");
			Statement s=c.createStatement();
			String sql="delete from vamsi225 where ename='teja'";
			s.executeUpdate(sql);
			System.out.println("Delete successfully");
			
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}