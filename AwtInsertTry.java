import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Insert extends Frame implements ActionListener
{
	Label l1,l2;
	TextField tf1,tf2,tf3,tf4;
	Button b;
	Insert()
	{
		setSize(300,300);
		setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
		setVisible(true);
		l1=new Label("Enter id:");
		tf1=new TextField(20);
		l2=new Label("Enter Name:");
		tf2=new TextField(20);
		tf3=new TextField(20);
		tf4=new TextField(20);
		b=new Button("Insert");
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
			PreparedStatement ps=c.prepareStatement("insert into vamsi225 values(?,?)");
			int i=Integer.parseInt(tf1.getText());  
			ps.setInt(1,i);
			ps.setString(2,tf2.getText());
			int n=ps.executeUpdate();
			if(n!=0)
			{
				tf3.setText("insert successfully");
				tf4.setText("no.of rows affected:"+n);
			}
			else
			{
				tf3.setText("insert not successfully");
			}
			add(tf3);add(tf4);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
class AwtInsertTry
{
	public static void main(String args[])
	{
		Insert s=new Insert();
	}
}
class WindowAdapterClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
		
			
