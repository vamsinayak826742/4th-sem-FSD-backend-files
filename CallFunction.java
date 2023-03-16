import java.sql.*;
import java.util.*;
class CallFunction
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			CallableStatement ps=c.prepareCall("{?=call call143(?,?)}");
			ps.setInt(2,30);
			ps.setInt(3,30);
			ps.registerOutParameter(1,Types.INTEGER);
			ps.execute();
			System.out.println("Result="+ps.getInt(1));

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}