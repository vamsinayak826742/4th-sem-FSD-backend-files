import java.sql.*;
import java.util.*;
class DynamicInsertDemo1
{
	public static void main(String args[]) 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter eid and ename:");
			int id=sc.nextInt();
			String name=sc.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("registered Successfully");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("connection Established");
			String sql="insert into vamsi225 values(?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,name);
			int n=ps.executeUpdate();
			System.out.println("insert successfully");
			System.out.println("no.of rows effected is:"+n);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}