public class MVCHostel
{
	public static void main(String args[])
	{
		View view=new View();
		Model model=new Model();
		Controller controller=new Controller();
		LoginPage lp=new LoginPage();
		controller.calllogin(model,lp);
				

		view.setVisible(true);
	}
	
}
