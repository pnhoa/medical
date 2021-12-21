package com.nhuhoa.medicalclientapp.api;

import java.util.List;

import com.nhuhoa.medicalclientapp.entity.Category;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryAPI {
	
	@GET("categories")
	Call<List<Category>> findAll();

}
