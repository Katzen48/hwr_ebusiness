package de.katzen48.erp.client.service.scm;

import de.katzen48.erp.client.resource.scm.ItemVariant;
import de.katzen48.erp.client.response.DataResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ItemsVariantsService
{
	@Headers({ "Accept: application/json" })
	@GET("scm/items/{item_id}/item_variants")
	public Call<DataResponse<ItemVariant[]>> getItemVariants(@Path("item_id") int itemId);
	
	@Headers({ "Accept: application/json" })
	@GET("scm/items/{item_id}/item_variants/{id}")
	public Call<DataResponse<ItemVariant>> getItemVariant(@Path("item_id") int itemId, @Path("id") int id);
	
	@Headers({ "Accept: application/json" })
	@POST("scm/items/{item_id}/item_variants")
	public Call<Void> createItemVariant(@Path("item_id") int itemId, @Body ItemVariant item);
	
	@Headers({ "Accept: application/json" })
	@PUT("scm/items/{item_id}/item_variants/{id}")
	public Call<Void> updateItemVariant(@Path("item_id") int itemId, @Path("id") int id, @Body ItemVariant item);
	
	@Headers({ "Accept: application/json" })
	@DELETE("scm/items/{item_id}/item_variants/{id}")
	public Call<Void> deleteItemVariant(@Path("item_id") int itemId, @Path("id") int id);
}
