import java.sql.*;
import java.util.*;
class DynamicInsertDemo2
{
	public static void main(String args[]) 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter no.of employee:");
			int k=sc.nextInt();
			int[] id=new int[20];
			String[] name=new String[100];
			for(int i=0;i<k;i++)
			{
				System.out.println("Enter eid:");
				id[i]=sc.nextInt();
				System.out.println("Enter ename:");
				name[i]=sc.next();
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("registered Successfully");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("connection Established");
			String sql="insert into vamsi225 values(?,?)";
			
			int n=0;
			PreparedStatement ps=c.prepareStatement(sql);
			for(int i=0;i<k;i++)
			{
				
				ps.setInt(1,id[i]);
				ps.setString(2,name[i]);
				n=n+ps.executeUpdate();
				
			}
			
			System.out.println("insert successfully");
			System.out.println("no.of rows effected is:"+n);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}