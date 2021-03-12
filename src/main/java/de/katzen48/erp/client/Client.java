package de.katzen48.erp.client;

import java.io.IOException;

import de.katzen48.erp.client.service.application.ApplicationService;
import de.katzen48.erp.client.service.scm.ScmService;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Accessors(fluent = true)
public class Client 
{
	public static final String BASE_URI = "https://erp.katzen48.de/api/";
	
	private Retrofit retrofit;
	
	/*
	 * Services
	 */
	@Getter
	private ApplicationService application;
	@Getter
	private ScmService scm;
	
	@Builder	
	private Client()
	{
		retrofit = new Retrofit.Builder().baseUrl(BASE_URI).addConverterFactory(GsonConverterFactory.create()).build();
		
		// Create Services
		application = retrofit.create(ApplicationService.class);
		scm = new ScmService(retrofit);
	}
	
	public <T> Response<T> doRequest(Call<T> call)
	{
		try 
		{
			Response<T> response = (Response<T>) call.execute();
			
			return response;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
