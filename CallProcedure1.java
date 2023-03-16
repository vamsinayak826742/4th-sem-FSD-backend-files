import java.sql.*;
import java.util.*;
class CallProcedure1
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			CallableStatement ps=c.prepareCall("{call pushvalues(?,?,?,?)}");
			ps.setInt(1,103);
			ps.setString(2,"ravi");
			ps.setString(3,"MEC");
			ps.setString(4,"10-01-2004");
			ps.execute();
			System.out.println("insert successfully");
			String sql1="select * from vamsi143";
			PreparedStatement ps1=c.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			System.out.println("\n\t---------------------------------------------"+"\n\t\teid\tename\tedpt\tedob"+"\n\t--------------------------------------------");
			while(rs.next())
			{
				System.out.println("\t\t"+rs.getInt(1)+"\t"+rs.getString("ename")+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
			}
			System.out.println("\t--------------------------------------------");
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}