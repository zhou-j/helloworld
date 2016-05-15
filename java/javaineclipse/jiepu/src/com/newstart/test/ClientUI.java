package com.newstart.test;

import javax.swing.*;

import java.awt.*; //导入必要的包
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientUI extends JFrame {

	// 用户登录状态标记
	private static int LOGIN_TAG = -1;

	JTextField userName; // 定义文本框组件
	JPasswordField password; // 定义密码框组件
	JLabel jLabel1, jLabel2, jLabel3;
	JPanel jp1, jp2, jp3, jp4;
	JButton jb1, jb2; // 创建按钮

	private ObjectClient client;

	public static void main(String[] args) {

		new ClientUI();

	}

	public ClientUI() {

		userName = new JTextField(12);
		password = new JPasswordField(13);
		jLabel1 = new JLabel("用户名");
		jLabel2 = new JLabel("密码");
		jLabel3 = new JLabel("用户状态： ");
		jb1 = new JButton("登录");
		jb2 = new JButton("退出");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		// 登录事件
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 判断用户名或密码是否为空，如果为空，提示用户输入用户密码，如果不为空，则直接登录

				String name = userName.getText().trim();
				String psd = password.getText().trim();

				if (name == null || "".equals(name) || psd == null
						|| "".equals(psd)) {
					jLabel3.setText("用户名或密码不能为空！");
					return;
				} else {

					// 用户拨号登录

					client = new ObjectClient(name, psd);

					if (client.connectServer()) {

						LOGIN_TAG = 1;

						jLabel3.setText("登录成功");
						jb1.setEnabled(false);

						System.out.println(name + "登录成功！");

					} else {

						jLabel3.setText("登录失败");

						System.out.println("登录失败！");

					}
				}
			}
		});

		// 退出事件
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (LOGIN_TAG == -1) {

					jLabel3.setText("您还未登录！");

				} else {

					String name = userName.getText().trim();
					String psd = password.getText().trim();

					boolean logoutResult = client.disconnectServer(name, psd);

					if (logoutResult) {

						jLabel3.setText("退出成功！");
						LOGIN_TAG = -1;
						jb1.setEnabled(true);

					} else {

						jLabel3.setText("退出失败！");

					}

				}

			}
		});

		// 设置布局
		this.setLayout(new GridLayout(4, 1));

		jp1.add(jLabel1);
		jp1.add(userName);// 第一块面板添加用户名和文本框

		jp2.add(jLabel2);
		jp2.add(password);// 第二块面板添加密码和密码输入框

		jp3.add(jb1);
		jp3.add(jb2); // 第三块面板添加确认和取消
		jp4.add(jLabel3);

		this.add(jp1);
		this.add(jp2);
		this.add(jp4);
		this.add(jp3); // 将三块面板添加到登陆框上面
		// 设置显示
		this.setSize(300, 200);
		// this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("登陆");

	}

}