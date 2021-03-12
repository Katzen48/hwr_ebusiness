package de.katzen48.erp.client;

import org.junit.Before;
import org.junit.Test;

import de.katzen48.erp.client.resource.scm.Item;
import de.katzen48.erp.client.resource.scm.ItemVariant;
import de.katzen48.erp.client.response.DataResponse;
import retrofit2.Response;

import static org.junit.Assert.*;

import java.io.IOException;

public class ScmServiceTest
{
	private Client client;
	
	@Before
	public void initialize()
	{
		client = Client.builder().build();
	}
	
	/*
	 * Items
	 */
	
	@Test
	public void testListItems() throws IOException
	{
		Response<DataResponse<Item[]>> itemsResponse = client.scm().items().getItems().execute();
		
		assertTrue(itemsResponse.isSuccessful());
		assertTrue(itemsResponse.body().data().length > 0);
	}
	
	@Test
	public void testGetItem() throws IOException
	{
		Response<DataResponse<Item>> itemResponse = client.scm().items().getItem(1).execute();
		
		assertTrue(itemResponse.isSuccessful());
		assertTrue(itemResponse.body().data().getId() == 1);
	}
	
	@Test
	public void testCreateItem() throws IOException
	{
		Item item = Item.builder().description("Test").storagePostingMethod(Item.StoragePostingMethod.FIFO).build();
		
		Response<Void> itemResponse = client.scm().items().createItem(item).execute();
		
		assertTrue(itemResponse.isSuccessful());
	}
	
	@Test
	public void testUpdateItem() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[getItemResponse.body().data().length - 1];
		
		item.setDescription("Test");
		
		Response<Void> updateItemResponse = client.scm().items().updateItem(item.getId(), item).execute();
		
		assertTrue(updateItemResponse.isSuccessful());
	}
	
	@Test
	public void testDeleteItem() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[getItemResponse.body().data().length - 1];
		
		Response<Void> deleteItemResponse = client.scm().items().deleteItem(item.getId()).execute();
		
		assertTrue(deleteItemResponse.isSuccessful());
	}
	
	/*
	 * Item Variants
	 */
	
	@Test
	public void testListItemVariants() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[0];
		
		assertTrue(item.getId() != 0);
		
		Response<DataResponse<ItemVariant[]>> itemVariantsResponse = client.scm().itemVariants().getItemVariants(item.getId()).execute();
		
		assertTrue(itemVariantsResponse.isSuccessful());
		assertTrue(itemVariantsResponse.body().data().length > 0);
	}
	
	@Test
	public void testGetItemVariant() throws IOException
	{
		Response<DataResponse<Item>> getItemResponse = client.scm().items().getItem(1).execute();
		
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().getId() == 1);
		
		Item item = getItemResponse.body().data();
		
		Response<DataResponse<ItemVariant>> itemVariantResponse = client.scm().itemVariants().getItemVariant(item.getId(), 1).execute();
		
		assertTrue(itemVariantResponse.isSuccessful());
	}
	
	@Test
	public void testCreateItemVariant() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[getItemResponse.body().data().length - 1];
		ItemVariant itemVariant = ItemVariant.builder().description("Test").unitPrice(39.99F).vatPercent(19).build();
		
		Response<Void> itemResponse = client.scm().itemVariants().createItemVariant(item.getId(), itemVariant).execute();
		
		assertTrue(itemResponse.isSuccessful());
	}
	
	@Test
	public void testUpdateItemVariant() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[0];
		
		assertTrue(item.getId() != 0);
		
		Response<DataResponse<ItemVariant[]>> itemVariantsResponse = client.scm().itemVariants().getItemVariants(item.getId()).execute();
		
		ItemVariant itemVariant = itemVariantsResponse.body().data()[itemVariantsResponse.body().data().length - 1];
		
		itemVariant.setDescription("Test [Updated]");
		
		Response<Void> updateItemVariantResponse = client.scm().itemVariants().updateItemVariant(item.getId(), itemVariant.getId(), itemVariant).execute();
		
		assertTrue(updateItemVariantResponse.isSuccessful());
	}
	
	@Test
	public void testDeleteItemVariant() throws IOException
	{
		Response<DataResponse<Item[]>> getItemResponse = client.scm().items().getItems().execute();
		assertTrue(getItemResponse.isSuccessful());
		assertTrue(getItemResponse.body().data().length > 0);
		
		Item item = getItemResponse.body().data()[0];
		
		assertTrue(item.getId() != 0);
		
		Response<DataResponse<ItemVariant[]>> itemVariantsResponse = client.scm().itemVariants().getItemVariants(item.getId()).execute();
		
		ItemVariant itemVariant = itemVariantsResponse.body().data()[itemVariantsResponse.body().data().length - 1];
		
		Response<Void> deleteItemResponse = client.scm().itemVariants().deleteItemVariant(item.getId(), itemVariant.getId()).execute();
		
		assertTrue(deleteItemResponse.isSuccessful());
	}
}
