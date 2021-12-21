package com.nhuhoa.medicalclientapp.api;

import java.util.List;

import com.nhuhoa.medicalclientapp.entity.Product;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductAPI {
	
	@GET("products")
	Call<List<Product>> findAll();
	
	@GET("products/{id}")
	Call<Product> findById(@Path("id") Long id);
	
	@POST("products")
	Call<Void> createProduct(@Body Product product);
	
	@PUT("products")
	Call<Void> updateProduct(@Body Product product);
	
	@DELETE("products/{id}")
	Call<Void> deleteProduct(@Path("id") Long id);

}
