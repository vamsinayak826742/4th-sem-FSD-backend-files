import java.sql.*;
class InsertDemo
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
			String sql="insert into vamsi225 values(101,'vamsi')";
			int n=s.executeUpdate(sql);
			System.out.println("insert successfully");
			System.out.println("no.of rows effected is:"+n);

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}