import java.sql.*;
class UpdateDemo
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
			String sql="insert into vamsi225 values(105,'teja')";
			int n=s.executeUpdate(sql);
			System.out.println("insert successfully");
			System.out.println("no.of rows effected is:"+n);
			String sql1="update vamsi225 set ename='ravi' where eid=104";
			s.executeUpdate(sql1);
			System.out.println("Update successfully");
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}