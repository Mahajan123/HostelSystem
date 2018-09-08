import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame
{

	private JLabel idl=new JLabel("ADMINID");
	private JLabel loginform=new JLabel("LOGIN ");
	private JTextField idfield=new JTextField(20);
	private JLabel password=new JLabel("PASSWORD");
	private JPasswordField passwordb=new JPasswordField(20);
	

    
	private JButton rbutton=new JButton("Login");

	

 	LoginPage()
	{
		JPanel jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.pink);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		jpanel.add(loginform);
		jpanel.add(idl);
		jpanel.add(idfield);
		jpanel.add(password);
		jpanel.add(passwordb);
		
		jpanel.add(rbutton);

		this.add(jpanel);
		
		
		passwordb.setEchoChar('*');
		
		
		
		loginform.setBounds(120,10,180,40);

		idl.setBounds(50,50,100,40);
		idfield.setBounds(170,50,140,40);
		password.setBounds(50,110,100,40);
		passwordb.setBounds(170,110,140,40);
		rbutton.setBounds(130,170,100,40);
	}
	
	public Object getlpObject()
	{
		return rbutton;
	}
	public JTextField getidfield()
	{
		return idfield;
	}
    public JPasswordField getpasswordb()
	{
		return passwordb;
	}


	public int getid()
	{
		return Integer.parseInt(idfield.getText());
	}
	public String getpass()
	{
	
		return (new String(passwordb.getPassword()));

	}
	
	

	/*public void setDate(Object date1)
	{
		date.setText(date1.toString());
	}*/

	void addActionListener(ActionListener listenForEnterButton)
	{
		rbutton.addActionListener(listenForEnterButton);
	}
	void displayErrorMessage(String ErrorMessage)
	{
		JOptionPane.showMessageDialog(this,ErrorMessage);
	}

}
