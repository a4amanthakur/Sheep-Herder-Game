	import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
class Grid implements ActionListener
{
	private JFrame frame;
	JPanel phead,pbody;
	JLabel lblHead;
	private JButton btn[];
	private int i,manPrev=0,choice=0,dog=0;
	Animal animal;
	Coordinate coordinate;
	Player player;
	JMenu menuFile;
	JMenuBar menuBar;
	JMenuItem itmRestart,itmExit,itmEasy,itmHard;
	String name,gamelvl;
	Grid()
	{
		System.out.println("hii");
	}
	public Grid(String name,String gamelvl)
	{
		this.name=name;
		this.gamelvl=gamelvl;

		frame=new JFrame("Sheep Herder");
		frame.setVisible(true);
		
		frame.setResizable(false);


		menuBar=new JMenuBar();
		menuFile=new JMenu("Option");
		
		itmRestart=new JMenuItem("Restart");
		itmExit=new JMenuItem("Exit");

		menuFile.add(itmRestart);
		menuFile.add(itmExit);
		menuBar.add(menuFile);

		frame.setJMenuBar(menuBar);
		
		//panel   ****************
		phead=new JPanel();
		pbody=new JPanel();
		frame.add(phead,"North");
		phead.setBackground(Color.yellow);
		lblHead=new JLabel("<html><center><h2>Welcome "+name+"</h2></center><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Level : "+gamelvl+"</html>");
		phead.add(lblHead);

		frame.add(pbody,"Center");
		pbody.setLayout(new GridLayout(5,5));

		btn=new JButton[26];
		//creating object of Animal class to access animal and its images
		animal=new Animal();
		//Creating object of Coordinate class and generating coordinates for animals
		coordinate=new Coordinate();
		player=new Player();
		for(i=0;i<25;i++)			
		{
			if(i==coordinate.sheepPos)
			{
				btn[i]=new JButton(animal.imgSheep);
				//btn[i].setBackground(Color.yellow);
				pbody.add(btn[i]);
			}
			else if(i==coordinate.dogPos)
			{
				btn[i]=new JButton(animal.imgDog);
				//btn[i].setBackground(Color.yellow);
				btn[i].setText(""+animal.strDog);
				pbody.add(btn[i]);	
			}
			else if(i==coordinate.wolfPos)
			{
				btn[i]=new JButton(animal.imgWolf);
				//btn[i].setBackground(Color.yellow);
				//wolf strength
				btn[i].setText(""+animal.strWolf);

				pbody.add(btn[i]);
			}
			else
			{
				btn[i]=new JButton(" ");
				//btn[i].setBackground(Color.yellow);
				pbody.add(btn[i]);
			}
		}
		frame.setSize(700,600);
		//adding action listener
		for(i=0;i<25;i++)
		{
			//System.out.println("ActionListener");
			btn[i].addActionListener(this);
		}

		frame.setJMenuBar(menuBar);
		itmExit.addActionListener(this);
		itmRestart.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}



	//**********action listener*************


	public void actionPerformed(ActionEvent evt)
	{
		Object clicked=evt.getSource();

		if(clicked==itmExit )
			{
				frame.dispose();
				frame=null;
				System.exit(0);
				//pbody.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING ));
			}
			if(clicked==itmRestart)
			{	
				frame.dispose();
				frame=null;
				new Grid(name,gamelvl); 
			}
			else
			{

			i=0;
			btn[manPrev].setIcon(null);
			btn[manPrev].setText(null);

			while(clicked!=btn[i])
				{i++;}
			
			manPrev=i;
			if(clicked==btn[coordinate.sheepPos])
			{
				choice=1;
			}
			else if(clicked==btn[coordinate.dogPos])
			{
				choice=2;
			}
			else if(clicked==btn[coordinate.wolfPos])
			{
				choice=3;
			}
			else
			{
					choice=4;
			}


			switch(choice)
			{
				case 1:
				{
					JOptionPane.showMessageDialog(null,"User Wins","Result",1);
					frame.dispose();
					frame=null;
					System.exit(0);
					break;
				}
				case 2:
				{
					JOptionPane.showMessageDialog(null,"Yeah...Now you have a Dog. ","head",1);
					btn[coordinate.dogPos].setIcon(null);
					btn[coordinate.dogPos].setText(null);
					manPrev=coordinate.dogPos;

					btn[i].setIcon(animal.imgManDog);
					coordinate.dogPos=25;
					dog=1;
					break;
				}

				case 3:
				{
					//fight
					if(dog==1)
					{
						if(animal.strWolf<=0)
						{
							btn[coordinate.wolfPos].setIcon(animal.imgManDog);
							btn[coordinate.wolfPos].setText(""+animal.strDog);
							manPrev=coordinate.wolfPos;

							JOptionPane.showMessageDialog(null,"\tYou Wins...\nYou hit the Wolf.","Result",1);			
							frame.dispose();
							frame=null;
							System.exit(0);
						}
						else
						{
							animal.strWolf--;
							btn[coordinate.wolfPos].setIcon(animal.imgManDog);
							btn[coordinate.wolfPos].setText(""+animal.strDog);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"\tYou Wins...\nYou kill the Wolf.","Result",1);			
						frame.dispose();
						frame=null;
						System.exit(0);
					}
						//**************WOLF TURN*****************
						if(gamelvl=="Easy")
						{
							player.wolfTurnEasy(coordinate,animal,frame,btn,manPrev,i,dog);
						}
						else if(gamelvl=="Hard")
						{
							player.wolfTurnHard(coordinate,animal,frame,btn,manPrev,i,dog);
						}

						//****end of wolf turn********
						break;
				}

				case 4:
				{
					//**************MAN TURN*******************
					if(dog>0)
					{
						btn[i].setIcon(animal.imgManDog);
				
						manPrev=i;
						//System.out.println("jjjj"+manPrev);
						btn[i].setText(""+animal.strDog);
					}
					else
					{
						btn[i].setIcon(animal.imgUser);
						btn[i].setText(null);
					}

					//**************WOLF TURN*****************
					if(gamelvl=="Easy")
						{
							player.wolfTurnEasy(coordinate,animal,frame,btn,manPrev,i,dog);
						}
						else if(gamelvl=="Hard")
						{
							player.wolfTurnHard(coordinate,animal,frame,btn,manPrev,i,dog);
						}//****end of wolf turn********
					break;
				}

				default:
				{
					JOptionPane.showMessageDialog(null,"Not a valid move.","Result",1);	
					break;
				}

			}//end of switch case

			}//end of itm restart
		}//end of action listener

		public static void main(String[] args) {
			new Grid("aman","Easy");
		}
	
}