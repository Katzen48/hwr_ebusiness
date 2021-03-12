package de.katzen48.erp.client.service.scm;

import lombok.Getter;
import lombok.experimental.Accessors;
import retrofit2.Retrofit;

@Accessors(fluent=true)
@Getter
public class ScmService
{
	private ItemsService items;
	private ItemsVariantsService itemVariants;
	
	public ScmService(Retrofit retrofit)
	{
		items = retrofit.create(ItemsService.class);
		itemVariants = retrofit.create(ItemsVariantsService.class);
	}
}
