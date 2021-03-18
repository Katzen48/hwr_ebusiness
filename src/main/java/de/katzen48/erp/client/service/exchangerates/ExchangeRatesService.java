package de.katzen48.erp.client.service.exchangerates;

import de.katzen48.erp.client.response.RatesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ExchangeRatesService
{
	 @Headers({ "Accept: application/json" })
	 @GET("https://api.exchangeratesapi.io/latest")
	 public Call<RatesResponse> getLatestRates();
	 
	 @Headers({ "Accept: application/json" })
	 @GET("https://api.exchangeratesapi.io/{date}")
	 public Call<RatesResponse> getRates(@Path("date") String date);
}
