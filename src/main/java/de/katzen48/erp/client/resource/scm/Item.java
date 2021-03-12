package de.katzen48.erp.client.resource.scm;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Item
{
	private int id;
	@Setter
	private String description;
	@Setter
	@SerializedName("storage_posting_method")
	private StoragePostingMethod storagePostingMethod;
	
	@Builder
	private Item(String description, StoragePostingMethod storagePostingMethod)
	{
		this.description = description;
		this.storagePostingMethod = storagePostingMethod;
	}
	
	public static enum StoragePostingMethod
	{
		FIFO, LIFO;
	}
}
