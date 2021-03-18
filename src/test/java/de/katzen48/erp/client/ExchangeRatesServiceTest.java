package de.katzen48.erp.client;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import de.katzen48.erp.client.response.RatesResponse;
import retrofit2.Response;

public class ExchangeRatesServiceTest
{
	private Client client;
	
	@Before
	public void initialize()
	{
		client = Client.builder().build();
	}
	
	/*
	 * Exchange Rates
	 */
	
	@Test
	public void testLatestRates() throws IOException
	{
		Response<RatesResponse> ratesResponse = client.exchangeRates().getLatestRates().execute();
		
		assertTrue(ratesResponse.isSuccessful());
		assertTrue(ratesResponse.body().rates().size() > 0);
		assertNotNull(ratesResponse.body().base());
		assertNotNull(ratesResponse.body().date());
	}
	
	@Test
	public void testDateRates() throws IOException, ParseException
	{
		Response<RatesResponse> ratesResponse = client.exchangeRates().getRates("2018-10-01").execute();
		
		assertTrue(ratesResponse.isSuccessful());
		assertTrue(ratesResponse.body().rates().size() > 0);
		assertNotNull(ratesResponse.body().base());
		assertNotNull(ratesResponse.body().date());
	}
}
