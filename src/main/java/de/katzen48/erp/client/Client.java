package de.katzen48.erp.client;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.katzen48.erp.client.service.application.ApplicationService;
import de.katzen48.erp.client.service.exchangerates.ExchangeRatesService;
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
	@Getter
	private ExchangeRatesService exchangeRates;
	
	@Builder	
	private Client()
	{
		Gson gson = new GsonBuilder()
				               .setDateFormat("yyyy-MM-dd")
				               .create();
		
		retrofit = new Retrofit.Builder()
							   .addConverterFactory(GsonConverterFactory.create(gson))
							   .baseUrl(BASE_URI).addConverterFactory(GsonConverterFactory.create()).build();
		
		// Create Services
		application = retrofit.create(ApplicationService.class);
		scm = new ScmService(retrofit);
		exchangeRates = retrofit.create(ExchangeRatesService.class);
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
