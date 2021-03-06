import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.*;

public class ViewAccountDetails implements  ActionListener
{
	
	JPanel buttonPanel;
	JButton exitButton;
	
	JLabel quantityLabel, nameLabel;

	JPanel totalGUI = new JPanel();
	
	JTextField itemNameTextField, quantityTextField;
	static JFrame frame = new JFrame("View Account Details");
	static int id;


	
	public JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		//JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(295, 185);
		totalGUI.add(buttonPanel);
		int i = 0;
		
		//get number of rows returned
		try
		{
			//Connect to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creationary", "root", "");
			Statement mystat = myConn.createStatement();
			ResultSet myRe = mystat.executeQuery("select * from creationary.items");
				
			//get db data
			while (myRe.next())
				i++;
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		
		
		//Assign values to listData based on DB values.
		String[] listData = new String[i];
		String[] userData = new String[i];
		
		i = 0;
		try
		{
			//get array of names/quantities
			//Connect to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creationary", "root", "");
			Statement mystat = myConn.createStatement();			
			//"select LastModified from CacheTable where url = '" + url +"'"
			String sql = "select * from creationary.users WHERE idusers= '" + id +"'";
			System.out.println(sql);
			ResultSet myRe = mystat.executeQuery(sql);
			
			String name = new String();
			String email = new String();
			String address = new String();
			String password =new String();
		
			//get db data
			while (myRe.next())
			{
				
				
				name = "\nUserName: " + myRe.getString(2) + ", ";
				address = "\nAddress:  " +  myRe.getString(6) + ", ";
				email = "Email: " + myRe.getString(5) + ", " ;	
				email = "Password: " + myRe.getString(4) ;	
				listData[i] =  name + password + address  + email;
				userData[i] =  name ;
				
				
				i++;
			}
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		

		
		//Make List and scroll pane for items
		JList items = new JList(listData);
		
		
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(items);
	    scrollPane.setLocation(0,0);
	    scrollPane.setSize(270, 150);
	    
	    buttonPanel.add(scrollPane);

		
	    //Make buttons
		exitButton = new JButton("Exit");
		exitButton.setLocation(0, 150);
		exitButton.setSize(85, 30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);
		

		
		
		
		

		totalGUI.setVisible(true);


		try
		{	
			//Connect to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creationary", "root", "");
			Statement mystat = myConn.createStatement();
			
			String sql = "select * from users";
			ResultSet myRe = mystat.executeQuery(sql);

			//get db data
			while (myRe.next())
			{
				System.out.println(myRe.getString(2));
				System.out.println(myRe.getString(4));
				System.out.println(myRe.getString(6));
			}
		}

		catch(Exception exc)
		{
			System.out.println("Error");
		}

		return totalGUI;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitButton)
		{
			frame.dispose();
		}
		
	}

	private static void createAndShowGUI()
	{
		//Create and set up the content pane.
		ViewAccountDetails window = new ViewAccountDetails();
		frame.setContentPane(window.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void display(String []line)
	{		
		
		id = Integer.parseInt(line[1]);
		System.out.println(id);
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				createAndShowGUI();
			}
		});
	}


}
