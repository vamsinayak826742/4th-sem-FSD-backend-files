import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Search extends Frame implements ActionListener
{
	Label l;
	TextField tf;
	Button b;
	Search()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l=new Label("Enter Roll No:");
		tf=new TextField(20);
		b=new Button("Search");
		add(l);
		add(tf);
		add(b);
		b.addActionListener(this);
		WindowAdapterClose clsme=new WindowAdapterClose();
		addWindowListener(clsme);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			PreparedStatement ps=c.prepareStatement("select * from vamsi225 where eid=?");
			String k=tf.getText();
			ps.setString(1,k);
			ResultSet rs=ps.executeQuery();
			int x=0;
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				x++;
			}
			if(x==0)
				System.out.println("Record Not Found");
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class DemoSearch
{
	public static void main(String args[])
	{
		Search s=new Search();
	}
}
class WindowAdapterClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
		
			
