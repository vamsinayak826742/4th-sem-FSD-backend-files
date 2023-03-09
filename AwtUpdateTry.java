import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Update extends Frame implements ActionListener
{
	Label l1,l2;
	TextField tf1,tf2,tf3,tf4;
	Button b1;
	Update()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter id:");
		tf1=new TextField(20);
		l2=new Label("Enter Name:");
		tf2=new TextField(20);
		tf3=new TextField(20);
		tf4=new TextField(200);
		b1=new Button("Update");
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(b1);
		b1.addActionListener(this);
		WindowAdapterClose clsme=new WindowAdapterClose();
		addWindowListener(clsme);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			PreparedStatement ps=c.prepareStatement("update vamsi225 set ename=? where eid=?");
			ps.setString(1,tf2.getText());
			int i=Integer.parseInt(tf1.getText());  
			ps.setInt(2,i);
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
class AwtUpdateTry
{
	public static void main(String args[])
	{
		Update s=new Update();
	}
}
class WindowAdapterClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

				
		
			
