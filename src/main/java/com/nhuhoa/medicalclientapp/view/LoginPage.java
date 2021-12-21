package com.nhuhoa.medicalclientapp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342432L;
	private JPanel contentPane;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 790, 515);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(285, 13, 180, 93);
        contentPane.add(lblNewLabel);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        usernameField.setBounds(228, 164, 476, 46);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(228, 235, 476, 46);
        contentPane.add(passwordField);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblUsername.setBounds(71, 170, 145, 38);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblPassword.setBounds(71, 234, 162, 46);
        contentPane.add(lblPassword);
        
        btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String username = usernameField.getText();
        		String password = String.valueOf(passwordField.getPassword());
        		
        		System.out.println(username + password);
        		
        		dispose();
        		HomePage home = new HomePage();
        		//home.setTitle("Homepage");
        		home.setVisible(true);
        		//home.setExtendedState(MAXIMIZED_BOTH);
        		JOptionPane.showMessageDialog(btnNewButton, "Ban da dang nhap thanh cong");
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(297, 328, 162, 53);
		
     
        contentPane.add(btnNewButton);
        label = new JLabel("");
        label.setBounds(0, 0, 784, 405);
        contentPane.add(label);
           
	}

}
