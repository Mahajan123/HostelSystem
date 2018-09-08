import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class View1 extends JFrame
{

	private JLabel prnnumberl=new JLabel("PRNNUMBER");
	private JLabel returnform=new JLabel("RETURN BACK FORM");
	private JTextField prnnumber=new JTextField(20);
	private JLabel datel=new JLabel("Date");
	private JTextField date=new JTextField(20);
	


	private JButton returnbutton=new JButton("Enter");

	

 	View1()
	{
		JPanel jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.pink);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		jpanel.add(returnform);
		jpanel.add(prnnumber);
		jpanel.add(prnnumberl);
		jpanel.add(datel);
		jpanel.add(date);
		
		jpanel.add(returnbutton);

		this.add(jpanel);
		
		returnform.setBounds(120,10,180,40);

		prnnumberl.setBounds(50,50,100,40);
		prnnumber.setBounds(170,50,140,40);
		datel.setBounds(50,110,100,40);
		date.setBounds(170,110,140,40);
		returnbutton.setBounds(130,170,100,40);
	}
	
	public Object getObject()
	{
		return returnbutton;
	}

	public String getprnnumber()
	{
		return (prnnumber.getText());
	}
	
	

	public void setDate(Object date1)
	{
		date.setText(date1.toString());
	}

	void addActionListener(ActionListener listenForEnterButton)
	{
		returnbutton.addActionListener(listenForEnterButton);
	}
	void displayErrorMessage(String ErrorMessage)
	{
		JOptionPane.showMessageDialog(this,ErrorMessage);
	}

}
