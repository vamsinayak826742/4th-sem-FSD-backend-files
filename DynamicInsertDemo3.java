import java.sql.*;
import java.util.*;
class DynamicInsertDemo3
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
			String sql1="select * from Vamsi225";
			PreparedStatement ps1=c.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
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