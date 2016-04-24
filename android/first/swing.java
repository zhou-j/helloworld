import javax.swing.*;
public class swing extends JFrame
{
	public swing()
	{
		this.setLayout(null);
		JLabel j1=new JLabel();
		j1.setText ("第一个swing 程序");
		j1.setBounds(50,50,400,50);
		this.add(j1);
		this.setBounds(300,250,500,200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		swing S=new swing();
		// TODO Auto-generated method stub

	}

}
