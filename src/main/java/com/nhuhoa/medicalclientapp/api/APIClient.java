package com.nhuhoa.medicalclientapp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class APIClient {
	
	private static Retrofit retrofit = null;
	
	public static final String BASE_URL = "http://localhost:8081/api/";
	
	public static Retrofit getClient() {
		
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		
		OkHttpClient client = new OkHttpClient.Builder()
								.addInterceptor(interceptor).build();
		retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
		return retrofit;
				
	}

}
