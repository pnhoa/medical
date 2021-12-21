package com.nhuhoa.medicalclientapp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.nhuhoa.medicalclientapp.api.APIClient;
import com.nhuhoa.medicalclientapp.api.CategoryAPI;
import com.nhuhoa.medicalclientapp.entity.Category;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342432L;
	private JPanel contentPane;
	private JTextField codeField;
    private JButton addProductButton;
    private JLabel codeLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel categoryLabel;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductPage frame = new ProductPage();
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
	public ProductPage() {
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 682);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Add product");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(372, 0, 273, 68);
        contentPane.add(lblNewLabel);
        codeField = new JTextField();
        codeField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        codeField.setBounds(259, 89, 481, 37);
        contentPane.add(codeField);
        codeField.setColumns(10);
        
        codeLabel = new JLabel("Code");
        codeLabel.setBackground(Color.BLACK);
        codeLabel.setForeground(Color.BLACK);
        codeLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        codeLabel.setBounds(56, 85, 146, 52);
        contentPane.add(codeLabel);
        
        nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBackground(Color.CYAN);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nameLabel.setBounds(56, 135, 193, 52);
        contentPane.add(nameLabel);
        
        descriptionLabel = new JLabel("Description");
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setBackground(Color.CYAN);
        descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        descriptionLabel.setBounds(56, 200, 193, 52);
        contentPane.add(descriptionLabel);
        
        priceLabel = new JLabel("Price");
        priceLabel.setBackground(Color.BLACK);
        priceLabel.setForeground(Color.BLACK);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        priceLabel.setBounds(56, 343, 146, 52);
        contentPane.add(priceLabel);
        
        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBackground(Color.BLACK);
        quantityLabel.setForeground(Color.BLACK);
        quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        quantityLabel.setBounds(56, 404, 146, 52);
        contentPane.add(quantityLabel);
        
        categoryLabel = new JLabel("Category");
        categoryLabel.setBackground(Color.BLACK);
        categoryLabel.setForeground(Color.BLACK);
        categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        categoryLabel.setBounds(56, 469, 146, 52);
        contentPane.add(categoryLabel);
        
        addProductButton = new JButton("Add Product");
        addProductButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        addProductButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        addProductButton.setBounds(179, 562, 187, 52);
		
        contentPane.add(addProductButton);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Monospaced", Font.PLAIN, 25));
        nameField.setColumns(10);
        nameField.setBounds(259, 139, 481, 37);
        contentPane.add(nameField);
        
        quantityField = new JTextField();
        quantityField.setFont(new Font("Monospaced", Font.PLAIN, 25));
        quantityField.setColumns(10);
        quantityField.setBounds(259, 408, 481, 37);
        contentPane.add(quantityField);
        
        priceField = new JTextField();
        priceField.setFont(new Font("Monospaced", Font.PLAIN, 25));
        priceField.setColumns(10);
        priceField.setBounds(259, 347, 481, 37);
        contentPane.add(priceField);
        
        JTextArea descriptionField = new JTextArea();
        descriptionField.setFont(new Font("Monospaced", Font.PLAIN, 20));
        descriptionField.setBounds(259, 200, 481, 130);
        contentPane.add(descriptionField);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        
        
        
        addDataToCategoryList(listModel);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		codeField.setText("");
        		nameField.setText("");
        		descriptionField.setText("");
        		priceField.setText("");
        		quantityField.setText("");
        	}
        });
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnReset.setBounds(430, 562, 187, 52);
        contentPane.add(btnReset);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();	
        		HomePage home = new HomePage();
        		home.setVisible(true);
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnBack.setBounds(675, 562, 187, 52);
        contentPane.add(btnBack);
        
        
        
        JList<String> categoryList = new JList<>(listModel);
        contentPane.add(categoryList);
        categoryList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        categoryList.setSelectedIndex(0);
        categoryList.setBounds(259, 458, 146, 63);
        categoryList.setAutoscrolls(rootPaneCheckingEnabled);
        categoryList.setVisibleRowCount(8);
           
	}
	
	private void addDataToCategoryList(DefaultListModel<String> listModel) {
		try {
			
	   		CategoryAPI categoryAPI = APIClient.getClient().create(CategoryAPI.class);
	   		
	   		categoryAPI.findAll().enqueue(new Callback<List<Category>>() {

				@Override
				public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
					for(Category category  : response.body()) {
						System.out.println(category.getName());
							String name = category.getName();
							listModel.addElement(name);
						}
					
				}

				@Override
				public void onFailure(Call<List<Category>> call, Throwable t) {
					System.err.println(t);
					
				}
	   			
			});
	        
	        	
			} catch (Exception e) {
				System.err.println(e);
			}
	}
}
