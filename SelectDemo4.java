import java.sql.*;
class SelectDemo4
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
			String sql="select * from vamsi225 where eid=101";
			ResultSet rs=s.executeQuery(sql);
			System.out.println("\n\t-----------------------------"+"\n\t\teid\tename"+"\n\t----------------------------");
			while(rs.next())
			{
				System.out.println("\t\t"+rs.getInt(1)+"\t"+rs.getString("ename"));
				
			}
			System.out.println("\t----------------------------");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}