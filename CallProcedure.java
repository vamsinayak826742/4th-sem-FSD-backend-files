import java.sql.*;
import java.util.*;
class CallProcedure
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			CallableStatement ps=c.prepareCall("{call pushvalues(?,?,?,?)}");
			ps.setInt(1,101);
			ps.setString(2,"teja");
			ps.setString(3,"MEC");
			ps.setString(4,"10-05-2004");
			ps.execute();
			System.out.println("insert successfully");
			
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}