import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class View3 extends JFrame

{
	private JButton check=new JButton("check");
	private JButton displayrecord=new JButton("displayrecord");
		private JButton backbutton=new JButton("Back");
			private JLabel adminform=new JLabel("ADMIN WORK");




	

 	View3()
	{
		JPanel jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.pink);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		
		jpanel.add(adminform);
		jpanel.add(check);
		jpanel.add(displayrecord);
        jpanel.add(backbutton);
		this.add(jpanel);
		
		
		
		adminform.setBounds(220,10,150,40);

		check.setBounds(200,70,150,40);
		
		displayrecord.setBounds(200,140,150,40);
		backbutton.setBounds(200,200,150,40);
		
		
	}
  
	public Object getObjectc()
	{
		return check;
	}
	
	public Object getObjectd()
	{
		return displayrecord;
	}
	
	public Object getbackObject()
	{
		return backbutton;
	}
	
	

	/*public void setDate(Object date1)
	{
		date.setText(date1.toString());
	}*/

	void addActionListener(ActionListener listenForEnterButton)
	{
		check.addActionListener(listenForEnterButton);
	}
	
	void addActionListener1(ActionListener listenForEnterButton)
	{
		displayrecord.addActionListener(listenForEnterButton);
	}
	
	void addActionListener2(ActionListener listenForEnterButton)
	{
		backbutton.addActionListener(listenForEnterButton);
	}
	void displayErrorMessage(String ErrorMessage)
	{
		JOptionPane.showMessageDialog(this,ErrorMessage);
	}

}
