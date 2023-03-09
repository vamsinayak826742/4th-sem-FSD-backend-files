import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Update1 extends Frame implements ActionListener
{
	Label l1,l2;
	TextField tf1,tf2,tf3;
	Button b;
	Update1()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter Name:");
		tf1=new TextField(20);
		l2=new Label("Enter id:");
		tf2=new TextField(20);
		tf3=new TextField(20);
		b=new Button("Update");
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
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
			PreparedStatement ps=c.prepareStatement("update vamsi225 set eid=? where ename=?");
			int i=Integer.parseInt(tf2.getText());  
			ps.setInt(1,i);
			ps.setString(2,tf1.getText());
			ps.executeUpdate();
			tf3.setText("Update successfully");
			add(tf3);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class AwtUpdateTry1
{
	public static void main(String args[])
	{
		Update1 s=new Update1();
	}
}
class WindowAdapterClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
		
			
