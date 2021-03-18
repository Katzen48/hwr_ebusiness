package de.katzen48.erp.client.response;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent=true)
@Getter
public class RatesResponse
{
	private Map<String, Float> rates;
	private String base;
	private Date date;
}
