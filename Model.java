import java.util.*;
import java.time.LocalDate;  
import java.sql.*;
import javax.swing.*;

public class Model
{
	 LocalDate today=LocalDate.now();
	 String stoday=today.toString();
	
	 
		
	 	Connection con;
			PreparedStatement stat;
		
			public void connection()
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","swati");
				System.out.println("\n Data connected Successfully");
				
			}
			catch(Exception e3)
			{}
			}
	   
		
		
	
	
	public void add(String prnnumber,int count)
	{
		System.out.println("hi");
		
		try
		{
			System.out.println("kkkk");
			String sql="insert into GoTable values(?,?,?,?,?)";
			System.out.println("k1");
			
			stat=con.prepareStatement(sql);
			System.out.println("k2");
			stat.setString(1,prnnumber);
			System.out.println("k3");
			stat.setInt(2,count);
			System.out.println("k4");
			stat.setString(3,stoday);
			System.out.println("k5");
			stat.setInt(4,1);
			System.out.println("k6");
			stat.setString(5,null);
			System.out.println("k7");
			stat.executeUpdate();
			System.out.println("Data Inserted Successfully");
			
			JOptionPane.showMessageDialog(null,"Data Inserted........Happy Journey");
			

		}
		catch(Exception e)
		{
			System.out.println("exception");
		}
		
		

	}
	
	public void delete(String prnnumber)
	{
		
		
		try
		{
			System.out.println("1");
			
			String sql="delete from GoTable where PRNNUMBER=?";
						System.out.println("2");

			stat=con.prepareStatement(sql);
			System.out.println("3");
			
			stat.setString(1,prnnumber);
						System.out.println("4");

			  stat.executeUpdate();
						System.out.println("5");

			
			System.out.println("successfully deleted records");
						System.out.println("1");


			
		}
		catch(Exception e)
		{
			System.out.println("error in deletion of records");
			
		}
		
		
	}
	public boolean search(String prnnumber)
	{
		try
		{
			String s="";
			String sql="select PRNNUMBER from GoTable where PRNNUMBER=?";
			stat=con.prepareStatement(sql);  
			stat.setString(1,prnnumber);
			ResultSet rs=stat.executeQuery();
			while(rs.next())
			{
				 s=rs.getString(1);
			}
			if(s.equals(prnnumber))
			{
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("SearchResult");
			return false;
		}
	}
	public void addDate(String prnnumber)
	{
			System.out.println("hello");
			
			if(search(prnnumber)==false)
			{
				System.out.println("Enter valid PRNNUMBER or Record Not Exist");
				
				JOptionPane.showMessageDialog(null,"Enter valid PRNNUMBER or Record Not Exist");
				
			}
			else
			{
				try{
			String sql="update GoTable set RETURNDATE=? where PRNNUMBER=?";
			System.out.println("k1");
			
			stat=con.prepareStatement(sql);
			System.out.println("k2");
			stat.setString(1,stoday);
			stat.setString(2,prnnumber);
			System.out.println("k2");

			stat.executeUpdate();
			System.out.println("Data Inserted Successfully");
			
			JOptionPane.showMessageDialog(null,"Welcome Back.............");
			
			//delete
			sql="select * from GoTable where PRNNUMBER=?";
			
			stat=con.prepareStatement(sql);
			stat.setString(1,prnnumber);
			ResultSet rs=stat.executeQuery();
			int a=0;
			int b=0;
			System.out.println("1");
			while(rs.next()){  
				System.out.println(rs.getInt(2)+" "+rs.getInt(4));
				a=rs.getInt(2);
				b=rs.getInt(4);
					
				}

			if(a>=b)
			delete(prnnumber);
			
			
			
			}
			catch(Exception ee)
			{
				System.out.println("errorrrrrrrrrrrr");

			}
			}
	}
	
	public boolean fetch()
	{
		System.out.println("1");
		String st="";
		try
		{
			System.out.println("2");
			
			
			
			stat=con.prepareStatement("select * from datestore");  
			ResultSet rs=stat.executeQuery();  
			while(rs.next()){  
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				st=rs.getString(2);
					
				}
			System.out.println("3");
			//stat.setInt(1,1);
						System.out.println("3");

			//ResultSet rs=stat.executeQuery(sql);
			
			//rs.absolute(1);
			System.out.println("4");
		
		if(!(st.equals(stoday)))
			
		{
			System.out.println("5");
			return true;
		}
		
		else
		{
			System.out.println("6");
			return false;
		}
		
		}
		catch(Exception eee)
		{
			System.out.println("error in fetching");
			return false;
		}
			
		
	}

		
		public void incr()
		{
			
		 
		if(fetch())
		{
		
		try
		{
			String sql="update GoTable set INCRCNT=INCRCNT+1";
			stat=con.prepareStatement(sql);
			stat.executeUpdate();
			System.out.println("7");
			
			JOptionPane.showMessageDialog(null,"Successfully incremented");

			sql="update datestore set DATES=? where ID=?";
			System.out.println("8");
			stat=con.prepareStatement(sql);
			System.out.println("10");
			stat.setString(1,stoday);
			
			
			System.out.println("9");
			stat.setInt(2,1);
			System.out.println("11");

			stat.executeUpdate();
			
		
		}
		
	    catch(Exception e)
		{
			System.out.println("error in incr");
		}
		}
		else
		{
			System.out.println("\n Record alredy updated");
			JOptionPane.showMessageDialog(null,"Already incremented");

		}
	}
     		
		// View3
		
		public void disrecord()
		{
			try{
				
				String sql="select * from GoTable where NOOFDAYS < INCRCNT";
				stat=con.prepareStatement(sql);
				ResultSet rs=stat.executeQuery();
				
				while(rs.next())
				{
					System.out.println(" "+rs.getString(1));
					String s2=rs.getString(1);
					 dismob(s2);
					
				}
			}
		
		catch(Exception ex1)
		{
			System.out.println("error in the display");
		}
		
	}
		
	public void dismob(String s2)
	{
		
		try
		{
		String sql1="select * from maintable where PRNNUMBER=?";
		stat=con.prepareStatement(sql1);
		stat.setString(1,s2);
		
		ResultSet rs1=stat.executeQuery();
		String s="ALL Records: \n";
		while(rs1.next())
		{
			s=rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(5)+" "+rs1.getString(6)+"\n ";
		}
		
					JOptionPane.showMessageDialog(null,s);

		}
		catch(Exception e2)
		{
			System.out.println(" mobile number");
		}
	}
	
	public int logincheck(String password,int id)
	{
		if(id==0000 && password.equals("threeshines"))
		{
			JOptionPane.showMessageDialog(null,"Authenticated");
			return 1;
		}
		else
		{
			return 0;
		}
	}

		
	public  void closecon()
	{
		try
		{
			con.close();
		}
		catch(Exception e2){}
	}
	public Object getDate()
	{
		return today;
	}
}
