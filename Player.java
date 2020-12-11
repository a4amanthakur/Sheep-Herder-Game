import javax.swing.*;
import java.awt.*;  
class Player
{
	private int wolfNewPos=0,dog=0;
	Player()
	{
		//new Grid();
	}
	void wolfTurnEasy(Coordinate coordinate,Animal animal,JFrame frame,JButton btn[],int manPrev,int i,int dog)
	{
		wolfNewPos=(int) (0+ (Math.random()*23));
		//**************WOLF TURN*****************
			//setting null at previous position of wolf nd initializing new position of wolf
			
				btn[coordinate.wolfPos].setIcon(null);
				btn[coordinate.wolfPos].setText(null);

				coordinate.wolfPos=wolfNewPos;
				btn[coordinate.wolfPos].setIcon(animal.imgWolf);
				btn[coordinate.wolfPos].setText(""+animal.strWolf);
			
				if(coordinate.sheepPos==coordinate.wolfPos)
				{
					JOptionPane.showMessageDialog(null,"\tGame Over...\nWolf hits the Sheep.\nHence the Sheep is no more.\nYou Lose.","Result",1);	
					frame.dispose();
					frame=null;
					System.exit(0);				
				}

				if(coordinate.wolfPos==coordinate.dogPos)
				{
					if(animal.strDog<=1)
					{
						JOptionPane.showMessageDialog(null,"The wolf killed the dog.","Result",1);	
						btn[coordinate.dogPos].setIcon(null);
						btn[coordinate.wolfPos].setIcon(animal.imgWolf);
					}
					else
					{
						animal.strDog--;
						btn[coordinate.dogPos].setIcon(animal.imgDog);
						
						manPrev=coordinate.wolfPos;
						btn[coordinate.dogPos].setText(""+animal.strDog);
					}
				}

				if(coordinate.wolfPos==i)//means man postion
				{
					if(dog>=1)
					{
						animal.strDog--;
						btn[i].setIcon(animal.imgManDogWolf);
					}
					else
					{
						btn[i].setIcon(animal.imgWolf);
						JOptionPane.showMessageDialog(null,"Game over...\n You were killed by Wolf.","Result",1);	
						frame.dispose();
						frame=null;
						System.exit(0);
					}


				}

				//****end of wolf turn********
		
	}

	void wolfTurnHard(Coordinate coordinate,Animal animal,JFrame frame,JButton btn[],int manPrev,int i,int dog)
	{
		wolfNewPos=(int) (0+ (Math.random()*23));
		if(wolfNewPos!=coordinate.sheepPos)
		{
			wolfNewPos=(int) (0+ (Math.random()*23));
			if(wolfNewPos!=coordinate.sheepPos)
			{
				wolfNewPos=(int) (0+ (Math.random()*23));
			}
			 if(wolfNewPos!=i && wolfNewPos!=coordinate.sheepPos)
			{
				wolfNewPos=(int) (0+ (Math.random()*23));
				
				if(wolfNewPos!=i && wolfNewPos!=coordinate.sheepPos)
				{
					wolfNewPos=(int) (0+ (Math.random()*23));
				}
			}
		}


		//**************WOLF TURN*****************
			//setting null at previous position of wolf nd initializing new position of wolf
			
				btn[coordinate.wolfPos].setIcon(null);
				btn[coordinate.wolfPos].setText(null);

				coordinate.wolfPos=wolfNewPos;
				btn[coordinate.wolfPos].setIcon(animal.imgWolf);
				btn[coordinate.wolfPos].setText(""+animal.strWolf);
			
				if(coordinate.sheepPos==coordinate.wolfPos)
				{
					JOptionPane.showMessageDialog(null,"\tGame Over...\nWolf hits the Sheep.\nHence the Sheep is no more.\nYou Lose.","Result",1);	
					frame.dispose();
					frame=null;
					System.exit(0);				
				}

				if(coordinate.wolfPos==coordinate.dogPos)
				{
					if(animal.strDog<=1)
					{
						JOptionPane.showMessageDialog(null,"The wolf killed the dog.","Result",1);	
						btn[coordinate.dogPos].setIcon(null);
						btn[coordinate.wolfPos].setIcon(animal.imgWolf);
					}
					else
					{
						animal.strDog--;
						btn[coordinate.dogPos].setIcon(animal.imgDog);
						
						manPrev=coordinate.wolfPos;
						btn[coordinate.dogPos].setText(""+animal.strDog);
					}
				}

				if(coordinate.wolfPos==i)//means man postion
				{
					if(dog>=1)
					{
						animal.strDog--;
						btn[i].setIcon(animal.imgManDogWolf);
					}
					else
					{
						btn[i].setIcon(animal.imgWolf);
						JOptionPane.showMessageDialog(null,"Game over...\n You were killed by Wolf.","Result",1);	
						frame.dispose();
						frame=null;
						System.exit(0);
					}


				}

				//****end of wolf turn********
		
	}
}