package de.katzen48.erp.client.service.scm;

import de.katzen48.erp.client.resource.scm.Item;
import de.katzen48.erp.client.response.DataResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ItemsService
{
	@Headers({ "Accept: application/json" })
	@GET("scm/items")
	public Call<DataResponse<Item[]>> getItems();
	
	@Headers({ "Accept: application/json" })
	@GET("scm/items/{id}")
	public Call<DataResponse<Item>> getItem(@Path("id") int id);
	
	@Headers({ "Accept: application/json" })
	@POST("scm/items")
	public Call<Void> createItem(@Body Item item);
	
	@Headers({ "Accept: application/json" })
	@PUT("scm/items/{id}")
	public Call<Void> updateItem(@Path("id") int id, @Body Item item);
	
	@Headers({ "Accept: application/json" })
	@DELETE("scm/items/{id}")
	public Call<Void> deleteItem(@Path("id") int id);
}
