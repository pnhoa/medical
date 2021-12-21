package com.nhuhoa.medicalclientapp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.nhuhoa.medicalclientapp.api.APIClient;
import com.nhuhoa.medicalclientapp.api.ProductAPI;
import com.nhuhoa.medicalclientapp.entity.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class HomePage extends JFrame {
	
	private JButton btnNewButton;
	private JButton btnUpdateButton;
	private JButton btnDeleteButton;
	private JButton btnSearchButton;
	private JTextField searchField;
	
	private JPanel contentPane;
	private DefaultTableModel defaultTableModel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 14334L;
	private JTable productTable;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setTitle("Homepage");
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setUndecorated(true);
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
	public HomePage() {
		setTitle("HomePage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 380, 1147, 1043);
		setResizable(false);
		contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //create product
        btnNewButton = new JButton("Add product");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		ProductPage edit = new ProductPage();
        		edit.setVisible(true);
        	}
        });
        
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(23, 13, 120, 35);
        contentPane.add(btnNewButton);
        
        
        // update product
        btnUpdateButton = new JButton("Update product");
        
        btnUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdateButton.setBounds(187, 13, 160, 35);
		
     
        contentPane.add(btnUpdateButton);
        
        
        // Delete product
        btnDeleteButton = new JButton("Delete product");
        
        btnDeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDeleteButton.setBounds(372, 13, 160, 35);
		
     
        contentPane.add(btnDeleteButton);
        
        // search filed
        searchField = new JTextField();
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        searchField.setBounds(695, 13, 304, 35);
        contentPane.add(searchField);
        
        // search product
        btnSearchButton = new JButton("Search");
        
        btnSearchButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearchButton.setBounds(1006, 13, 95, 35);
		
     
        contentPane.add(btnSearchButton);
        
        
        
        
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		getContentPane().add(scrollBar, BorderLayout.SOUTH);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		getContentPane().add(scrollBar_1, BorderLayout.EAST);
		
	
        // Column Names
        String[] columnNames = { "Code", "Name", "Price", "Quantity"};
        
        
		productTable = new JTable();
		productTable.setBorder(new EmptyBorder(100, 2, 100, 2));
		productTable.setIntercellSpacing(getPreferredSize());
		productTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		productTable.setBounds(23, 83, 912, 889);
		
		
		
		defaultTableModel = new DefaultTableModel();

		defaultTableModel.setColumnIdentifiers(columnNames);
		
		addDataToTable(defaultTableModel);
		
		productTable.setModel(defaultTableModel);
		
		contentPane.add(productTable);
		
		 JScrollPane scrollPane = new JScrollPane(productTable);
		 scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 scrollPane.setBounds(23, 90, 1078, 873);
		 contentPane.add(scrollPane);
		
	}
	
	private void addDataToTable(DefaultTableModel defaultTableModel) {
		 try {
    		 
	    		ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);;
	         	
	         	productAPI.findAll().enqueue(new Callback<List<Product>>() {
	 				
	 				@Override
	 				public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
	 					if(response.isSuccessful()) {
	 						
	 						for(Product product  : response.body()) {
	 							defaultTableModel.addRow(new Object[] {
	 									product.getCode(), product.getName(),
	 									product.getPrice(), product.getQuantity()
	 							});
	 						}
	 					}
	 				}
	 				
	 				@Override
	 				public void onFailure(Call<List<Product>> call, Throwable t) {
	 					System.err.println(t);
	 					
	 				}
	 			});
	         	
	 		} catch (Exception e) {
	 			System.err.println(e);
	 		}

	}
}
