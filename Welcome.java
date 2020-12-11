	import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Welcome extends JDialog implements ActionListener
{
	JPanel phead,pbody;
	JLabel lblhead;
	JTextField txtname;
	JComboBox cmbLvl;
	JLabel lblName,lblLvl;
	JButton btnStart;
	String lvl[]={"Easy","Hard"};      
	String name,gamelvl;
	Welcome()
	{
		super(new JFrame(),"WELCOME");
		setSize(new Dimension(370,410));
		setResizable(false);
		
		phead=new JPanel();
		getContentPane().add(phead,"North");
		phead.setBackground(Color.yellow);
		lblhead=new JLabel("<html><h2><center>Welcome <br>to<br> Sheep Herded Game.</center	></h2></html>");
		phead.add(lblhead);

		pbody=new JPanel();
		pbody.setLayout(null);
		getContentPane().add(pbody,"Center");

		lblName=new JLabel("Enter Name");
		pbody.add(lblName);
		lblName.setBounds(50,50,100,30);

		txtname=new JTextField(30);
		pbody.add(txtname);
		txtname.setBounds(160,50,150,30);

		lblLvl=new JLabel("Select Level");
		pbody.add(lblLvl);
		lblLvl.setBounds(50,90,100,30);

		cmbLvl =new JComboBox(lvl);  
		pbody.add(cmbLvl);  
		cmbLvl.setBounds(160,90,150,30);

		btnStart=new JButton("Start Game");
		pbody.add(btnStart);
		btnStart.setBounds(100,130,140,40);

		btnStart.addActionListener(this);		
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}//end of constructor
	
	public void actionPerformed(ActionEvent evt)
	{
		Object clicked=evt.getSource();
		if(clicked==btnStart)
		{
			if(txtname.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter your good name","Empty Field",1);
			}
			else
			{
				name=txtname.getText().toString();
				gamelvl=String.valueOf(cmbLvl.getSelectedItem());
				//System.out.println("name:"+name+"\n lvl:"+gamelvl);
				this.dispose();
				new Grid(name,gamelvl);
			}
		}
	}
	public static void main(String args[])
	{
		new Welcome();
	}
}