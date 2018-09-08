import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Controller
{
	Model model=new Model();
	View view=new View();
	View1 view1=new View1();
		View3 view3=new View3();
		LoginPage  lp1=new LoginPage();
		//ButtonExample be=new ButtonExample();

	int flag=0;

	
	/*Controller(Model model,View view)
	{
		this.model=model;
		this.view=view;

		this.view.addActionListener(new DaysListener());		
	}*/
	
	
	public void calllogin(Model model,LoginPage lp)
	{
		this.model=model;
		this.lp1=lp;
		this.lp1.addActionListener(new DaysListener());		

	}
	public void callview(Model model,View view)
	{
		this.model=model;
		this.view=view;

		this.view.addActionListener(new DaysListener());
		
	}
	
	/*public void getmainObject(Object obj)
	{
		//Object o=obj;
	}*/
	public void callview1(Model model,View1 view1)
	{
		this.model=model;
		this.view1=view1;

		this.view1.addActionListener(new DaysListener());		
	}
	public void callview3(Model model,View3 view3)
	{
		this.model=model;
		this.view3=view3;
		
		this.view3.addActionListener(new DaysListener());
		this.view3.addActionListener1(new DaysListener());	
		this.view3.addActionListener2(new DaysListener());		
		

	}	
	
	
	


	class DaysListener implements ActionListener
	{
		public void actionPerformed(ActionEvent eve)
		{
			// View
			if(eve.getSource()== view.getObject())
			{
			String prnnumber="";
			int days=0;
			try
			{
				prnnumber=view.getprnnumber();
				days=view.getdayscount();
				model.connection();
				model.add(prnnumber,days);
               model.closecon();
				System.out.println("Date      ......................");
				view.setDate(model.getDate());
				//obj.dispose();
				view.dispose();
			}

			catch(Exception ex)
			{
				view.displayErrorMessage("enter proper number");
			}
			} //enter button
			
			if(eve.getSource()==view3.getbackObject())
			{
				try
				{
				
					view3.dispose();

				
				}
				catch(Exception e)
				{}
			}
			
			//View1
			
			if(eve.getSource()== view1.getObject())
			{
			String prnnumber="";
			
			try
			{
				prnnumber=view1.getprnnumber();
				
				model.connection();
				model.addDate(prnnumber);
                model.closecon();
				System.out.println("Dates      ......................");
				view1.setDate(model.getDate());
				view1.dispose();
			}

			catch(Exception ex)
			{
				view.displayErrorMessage("enter proper number");
			}
			} //return button
			
			//View3
			if(eve.getSource()== view3.getObjectc())
			{
				
			try
			{
				model.connection();
				model.incr();
				model.closecon();
				System.out.println("executed");
				
			}

			catch(Exception ex)
			{
				view.displayErrorMessage("enter proper number");
			}
			} 
			
			//check button
			if(eve.getSource()== view3.getObjectd())
			{
				try
				{
				model.connection();
				model.disrecord();
				model.closecon();
				System.out.println("display");
				
				}
				catch(Exception e1)
				{
					System.out.println("display record error");
				}
			}
			
			//
			if(eve.getSource()==lp1.getlpObject())
			{
				JTextField a1=new JTextField();
				JPasswordField a2=new JPasswordField();
				int p=0;
				try
				{
					p=model.logincheck(lp1.getpass(),lp1.getid());
					a1=lp1.getidfield();
					a1.setText(" ");
					
					a2=lp1.getpasswordb();
					a2.setText(" ");
					
					lp1.dispose();
					if(p==1)
					{
						
						View3 view4=new View3();
						new Controller().callview3(model,view4);
						view4.setVisible(true);
					}
					else
					{
									JOptionPane.showMessageDialog(null,"OOOpsss!!!!.......login failed");
					}
				}
				catch(Exception e)
				{
				}
			
			}
			
		}
	}

	
	
}