import javax.swing.*;
class Animal
{
	Icon imgDog,imgSheep,imgWolf,imgUser,imgManDog,imgManWolf,imgManDogWolf;
	int strWolf=8,strDog=10;
	StringBuilder str;
	Animal()
	{
		str=new StringBuilder("/icons/sheep.png");
		imgSheep=new ImageIcon(getClass().getResource(String.valueOf(str)));

		str=new StringBuilder("/icons/dog.png");
		imgDog=new ImageIcon(getClass().getResource(String.valueOf(str)));
		
		str=new StringBuilder("/icons/wolf.png");
		imgWolf=new ImageIcon(getClass().getResource(String.valueOf(str)));
		
		str=new StringBuilder("/icons/man.png");
		imgUser=new ImageIcon(getClass().getResource(String.valueOf(str)));

		str=new StringBuilder("/icons/mandog64.png");
		imgManDog=new ImageIcon(getClass().getResource(String.valueOf(str)));

		str=new StringBuilder("/icons/manWolf.png");			
		imgManWolf=new ImageIcon(getClass().getResource(String.valueOf(str)));

		str=new StringBuilder("/icons/ManDogWolf.png");					
		imgManDogWolf=new ImageIcon(getClass().getResource(String.valueOf(str)));
	}
}
