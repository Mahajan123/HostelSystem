import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame
{

	private JLabel prnnumberl=new JLabel("PRNNUMBER");
	private JLabel goform=new JLabel("GO HOME FORM");
	private JTextField prnnumber=new JTextField(20);
	private JLabel datel=new JLabel("Date");
	private JTextField date=new JTextField(20);
	private JLabel numdaysl=new JLabel("NumberofDays");
	private JTextField numdays=new JTextField(20);


	private JButton enter=new JButton("Enter");
	
    

	

 	View()
	{
		JPanel jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.pink);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,200);
		jpanel.add(goform);
		jpanel.add(prnnumber);
		jpanel.add(prnnumberl);
		jpanel.add(datel);
		jpanel.add(date);
		jpanel.add(numdaysl);
		jpanel.add(numdays);
		jpanel.add(enter);
		this.add(jpanel);
		
		goform.setBounds(120,10,180,40);
		prnnumberl.setBounds(50,50,100,40);
		prnnumber.setBounds(170,50,140,40);
		datel.setBounds(50,110,100,40);
		date.setBounds(170,110,140,40);
		numdaysl.setBounds(50,160,100,40);
		numdays.setBounds(170,160,140,40);
		enter.setBounds(100,220,100,40);
		
		
		
		
		
		
	}
  
	public Object getObject()
	{
		return enter;
	}
	
	
	
	public String getprnnumber()
	{
		return (prnnumber.getText());
	}
	public int getdayscount()
	{
		return Integer.parseInt(numdays.getText());
	}
	
	
	

	public void setDate(Object date1)
	{
		date.setText(date1.toString());
	}

	void addActionListener(ActionListener listenForEnterButton)
	{
		enter.addActionListener(listenForEnterButton);
	}
	
	

	void displayErrorMessage(String ErrorMessage)
	{
		JOptionPane.showMessageDialog(this,ErrorMessage);
	}

}
