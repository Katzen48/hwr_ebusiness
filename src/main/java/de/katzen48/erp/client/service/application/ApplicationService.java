package de.katzen48.erp.client.service.application;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApplicationService
{
	@Headers({ "Accept: application/json" })
	@GET("application/structure")
	public Call<?> getApplicationStructure();
}
