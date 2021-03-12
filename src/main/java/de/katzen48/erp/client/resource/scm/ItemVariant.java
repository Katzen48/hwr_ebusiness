package de.katzen48.erp.client.resource.scm;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ItemVariant
{
	private int id;
	@SerializedName("item_id")
	private int itemId;
	@Setter
	private String description;
	@Setter
	@SerializedName("unit_price")
	private float unitPrice;
	@Setter
	@SerializedName("vat_percent")
	private float vatPercent;
	
	
	@Builder
	private ItemVariant(String description, float unitPrice, float vatPercent)
	{
		this.description = description;
		this.unitPrice = unitPrice;
		this.vatPercent = vatPercent;
	}
}
