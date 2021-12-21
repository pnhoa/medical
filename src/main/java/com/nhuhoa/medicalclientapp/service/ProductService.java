package com.nhuhoa.medicalclientapp.service;

import java.util.ArrayList;
import java.util.List;

import com.nhuhoa.medicalclientapp.api.APIClient;
import com.nhuhoa.medicalclientapp.api.ProductAPI;
import com.nhuhoa.medicalclientapp.entity.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductService {
	
	
	public ProductService() {
		super();
	}



	public static List<Product> findAllProducts() {
    	 try {
    		 
    		ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);;

         	List<Product> products = new ArrayList<Product>();
         	
         	productAPI.findAll().enqueue(new Callback<List<Product>>() {
 				
 				@Override
 				public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
 					if(response.isSuccessful()) {
 						
 						for(Product product  : response.body()) {
 							products.add(product);
 						}
 						
 					}
 					
 				}
 				
 				@Override
 				public void onFailure(Call<List<Product>> call, Throwable t) {
 					System.err.println(t);
 					
 				}
 			});
         	
         	System.out.println(products.get(1));
          return products;
         
         	
 		} catch (Exception e) {
 			System.err.println(e);
 		}
    	
    	 return null;
    }

}
