import java.sql.*;
class CreateDemo
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
			String sql="create table nayak(rollno integer,name varchar2(20),branch varchar2(20))";
			s.execute(sql);
			System.out.println("Table is created");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}