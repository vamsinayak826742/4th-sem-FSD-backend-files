import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Delete extends Frame implements ActionListener
{
	Label l;
	TextField tf1,tf2;
	Button b;
	Delete()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l=new Label("Enter id:");
		tf1=new TextField(20);
		tf2=new TextField(20);
		b=new Button("Delete");
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
			PreparedStatement ps=c.prepareStatement("delete from vamsi225 where eid=?");
			int i=Integer.parseInt(tf1.getText());  
			ps.setInt(1,i);
			ps.executeUpdate();
			tf2.setText("Delete successfully");
			add(tf2);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class AwtDeleteTry
{
	public static void main(String args[])
	{
		Delete s=new Delete();
	}
}
class WindowAdapterClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
		
			
