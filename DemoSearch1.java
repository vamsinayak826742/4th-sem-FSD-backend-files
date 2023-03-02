import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Search extends Frame implements ActionListener
{
	Label l;
	TextField tf1,tf2;
	Button b;
	Search()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l=new Label("Enter Roll No:");
		tf1=new TextField(20);
		tf2=new TextField(20);
		b=new Button("Search");
		add(l);
		add(tf1);
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
			String k=tf1.getText();
			ps.setString(1,k);
			ResultSet rs=ps.executeQuery();
			int x=0;
			
			while(rs.next())
			{
				tf2.setText(rs.getString(2));
				x++;
			}
			if(x==0)
				tf2.setText("Record Not Found");
			add(tf2);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class DemoSearch1
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
		
			
