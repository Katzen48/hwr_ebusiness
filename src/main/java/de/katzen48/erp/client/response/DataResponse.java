package de.katzen48.erp.client.response;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent=true)
@Getter
public class DataResponse<T>
{
	private T data;
}
