package com.nhuhoa.medicalclientapp;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.nhuhoa.medicalclientapp.api.APIClient;
import com.nhuhoa.medicalclientapp.api.CategoryAPI;
import com.nhuhoa.medicalclientapp.api.ProductAPI;
import com.nhuhoa.medicalclientapp.entity.Category;
import com.nhuhoa.medicalclientapp.entity.Product;
import com.nhuhoa.medicalclientapp.view.LoginPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		LoginPage frame = new LoginPage();
		frame.setVisible(true);

		findAllProducts();

		findAllCategories();

		createProduct();

	}

	public static void findAllProducts() {
		try {

			ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);

			productAPI.findAll().enqueue(new Callback<List<Product>>() {

				@Override
				public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
					if (response.isSuccessful()) {
						// TODO create frame
						for (Product product : response.body()) {
							System.out.println(product.getName());
						}
					}

				}

				@Override
				public void onFailure(Call<List<Product>> call, Throwable t) {
					// TODO Auto-generated method stub

				}
			});

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void findAllCategories() {
		try {

			CategoryAPI categoryAPI = APIClient.getClient().create(CategoryAPI.class);

			categoryAPI.findAll().enqueue(new Callback<List<Category>>() {

				@Override
				public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
					for (Category product : response.body()) {
						System.out.println(product.getName());
					}

				}

				@Override
				public void onFailure(Call<List<Category>> call, Throwable t) {
					// TODO Auto-generated method stub

				}

			});

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void createProduct() {

		Product theProduct = new Product();

		theProduct.setName("Gạc y tế");
		theProduct.setCode("gac");
		theProduct.setDescription("");
		theProduct.setPrice(new BigDecimal(10000));
		theProduct.setQuantity(1000);
		theProduct.setCategoryCode("thiet-bi");

		ProductAPI productAPI = APIClient.getClient().create(ProductAPI.class);

		try {
			productAPI.createProduct(theProduct).execute();
			System.out.println("-------");
			findAllProducts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
