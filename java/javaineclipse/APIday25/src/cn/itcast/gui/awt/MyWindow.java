package cn.itcast.gui.awt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class MyWindow extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000;
	private static final String LINE_SEPSRSTOR = System.getProperty("line.separator");
	private JTextField jTextField1;
	private JButton jButton1;
	private JTextArea jTextArea1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyWindow inst = new MyWindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyWindow() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setLayout(null);
				jTextField1.setBounds(21, 34, 340, 32);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u8f6c\u5230");
				jButton1.setBounds(382, 33, 77, 32);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setBounds(21, 78, 438, 219);
			}
			pack();
			this.setSize(507, 336);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		//TODO add your code for jButton1.actionPerformed
		/*
		 * 通过点击按钮获取文本框中目录，
		 * 将目录的内容显示在文本框区域中。
		 * */
		
		String dir_str = jTextField1.getText();
		File dir = new File(dir_str);
		
		if(dir.exists()&&dir.isDirectory()){
			jTextArea1.setText("");
			String [] names = dir.list();
			
			for(String name:names){
				jTextArea1.append(name+LINE_SEPSRSTOR);
			}
		}
	}

}
