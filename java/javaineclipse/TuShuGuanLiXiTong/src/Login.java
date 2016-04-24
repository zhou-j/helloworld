import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.*;
import java.util.Date;
public class Login extends JFrame implements ActionListener{
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel jp=new JPanel();//创建JPanel对象
    private JLabel []jlArray={//创建标签组
    	   new JLabel("用户IP"),new JLabel("端口号"),new JLabel("用户名"),
    	   new JLabel("密  码"),new JLabel("")
    };
    private JButton[] jbArray={//创建按钮数组
    	new JButton("学生登录"),new JButton("清空"),new JButton("管理员登录")
    };
    private JTextField[] jtxtArray={ //创建文本框
    	   new JTextField("127.0.0.1"),new JTextField("3306"),new JTextField("1001")
    }; 
    private JPasswordField jpassword=new JPasswordField("number1"); //创建密码框
    String sql;
    public Login(){
    	  jp.setLayout(null); //设置JPanel的布局管理器
    	  for(int i=0;i<4;i++){ //对标签与按钮控件循环处理		
	          jlArray[i].setBounds(30,20+i*50,80,25);//设置标签与按钮的大小和位置	
	          jp.add(jlArray[i]);//将标签和按钮添加进JPanel容器中
          }
          for(int i=0;i<3;i++){//设置按钮的大小位置并为其添加事件监听器
	          jbArray[i].setBounds(10+i*120,230,100,25);
	          jp.add(jbArray[i]);	
	          jbArray[i].addActionListener(this);      
          }
          for(int i=0;i<3;i++){//设置文本框的大小位置并为其添加事件监听器
	          jtxtArray[i].setBounds(80,20+50*i,180,25);
	          jp.add(jtxtArray[i]);
	          jtxtArray[i].addActionListener(this);
          }
          jpassword.setBounds(80,170,180,25);//设置密码框的大小位置
          jp.add(jpassword);//将密码框添加进JPanel容器
          jpassword.setEchoChar('*');//设置密码框的回显字符
          jpassword.addActionListener(this);//为密码框注册监听器
          jlArray[4].setBounds(10,280,300,25);//设置用于显示登录状态的标签的大小位置
          jp.add(jlArray[4]); //将标签添加进JPanel容器
          this.add(jp);	
 	      Image image=new ImageIcon("ico.gif").getImage();//对logo图片进行初始化  
 	      this.setIconImage(image);
          //设置窗体的大小位置及可见性
          this.setTitle("登录");
          this.setResizable(false);
          this.setBounds(100,100,400,350);
          this.setVisible(true);
    }
    //实现ActionListener接口中的方法
    public  void actionPerformed(ActionEvent e)
    {//事件源为文本框
    	String mgno=jtxtArray[2].getText().trim();
    	String mgIP=jtxtArray[0].getText().trim();
	    String port=jtxtArray[1].getText().trim();
        String message=mgIP+":"+port;
	    if(e.getSource()==jtxtArray[0]){
	         jtxtArray[1].requestFocus();//切换输入焦点到下一个框
    	    }
    	    if(e.getSource()==jtxtArray[1]){
    		   jtxtArray[2].requestFocus();//切换输入焦点到下一个框
    	    }
    	    if(e.getSource()==jtxtArray[2])	{	   
    		   jpassword.requestFocus();//切换输入焦点到密码框
    	    }
    	    else if(e.getSource()==jbArray[1]){//事件源为清空按钮
    	        //清空所有信息
    		    jlArray[4].setText("");
    		    jtxtArray[2].setText("");
    		    jpassword.setText("");
    		    //将输入焦点设置到文本框
    		    jtxtArray[2].requestFocus();
    	    }
    	    else if(e.getSource()==jbArray[2]){//事件源为管理员登录按钮
    	        //判断用户名和密码是否匹配
    	        if(!mgno.matches("\\d+"))
    	        {//如果用户名格式输入有误
	    	    	JOptionPane.showMessageDialog(this,"用户名格式错误！！！","信息",
	    	    						JOptionPane.INFORMATION_MESSAGE);
	    	    	return;
	    	    }
	    	    if(jtxtArray[0].getText().trim().equals(""))
	    	    {//如果"用户IP"文本框为空，提示
	    	    	JOptionPane.showMessageDialog(this,"用户IP不能为空！！！","信息",
	    	    	                                JOptionPane.INFORMATION_MESSAGE);
	    	    	return;
	    	    }
	    	    if(jtxtArray[1].getText().trim().equals(""))
	    	    {//如果"端口号"文本框为空，提示
	    	     	    JOptionPane.showMessageDialog(this,"用户端口号不能为空！！！","信息",
	    	     	    						JOptionPane.INFORMATION_MESSAGE);
	    	    	    return;
		    	}
	    	    
	    	    sql="select mgNO,password from manager where mgNO=? and password=?";//+Integer.parseInt(mgno);
	            try{
	            	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	        		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=myDatabase";
	        		String userName = "sa";
	        		String userPwd = "1";
	        		PreparedStatement ps = null;
	        		ResultSet rs = null;
	        		Connection ct = null;
	        		Class.forName(driverName);
	        		ct = DriverManager.getConnection(dbURL, userName, userPwd);
	        		ps = ct.prepareStatement(sql);
	        		ps.setInt(1, Integer.parseInt(mgno));
	        		ps.setString(2,"1002");
	        		rs = ps.executeQuery();
	        		int mgNO=0;
	        		String password="0000";
	        		while(rs.next()){
					 mgNO=rs.getInt(1);
					 password = rs.getString(2);
	        		}
					String Password=password;
					jlArray[4].setText("恭喜您，登录成功！！！");
		    			new Root(mgNO);
		    		//	this.dispose(); 
		    			System.out.println(mgNO+Integer.parseInt(Password));
			    		 	
		        }
	            catch(Exception e1){e1.printStackTrace();}
		                    }
	    	else if(e.getSource()==jbArray[0]){//事件源为学生登录按钮
	    	     if(!jtxtArray[2].getText().trim().matches("\\d+")){
					//若学号格式错误，输出提示对话框
					JOptionPane.showMessageDialog(this,"输入有误,学号只能为数字!!!",
									"消息", JOptionPane.INFORMATION_MESSAGE);
		    		return;
	    	     }
	    	     if(jtxtArray[0].getText().trim().equals("")){//若"用户IP"文本框输入为空，提示
			    	JOptionPane.showMessageDialog(this,"用户IP不能为空！！！","信息",
			    						JOptionPane.INFORMATION_MESSAGE);
			    	return;
	    	     }
	    	     if(jtxtArray[1].getText().trim().equals("")){//若"端口号"文本框输入为空，提示
		    	    	JOptionPane.showMessageDialog(this,"用户端口号不能为空！！！",
		    	    				"信息",JOptionPane.INFORMATION_MESSAGE);
		    	    	return;
	    	     }
	    	     //查询学号文本中所输学号是否存在于STUDENT表中
	             sql="select StuNO,Password from student where StuNO="
	           				+Integer.parseInt(jtxtArray[2].getText().trim());
	             try{
						String mgNO="";
						String Password="";
						jlArray[4].setText("恭喜您，登录成功！！！");
			    			new StudentSystem();
			    		this.dispose();  		    	 
				    		 	
			        }
		            catch(Exception e1){e1.printStackTrace();}
	             
	      }
    }
    public static void main(String[]args)
    {
    	new Login();
    }
}