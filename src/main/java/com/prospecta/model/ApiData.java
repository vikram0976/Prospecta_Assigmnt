package com.prospecta.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiData {
		
	@JsonProperty("count")
	private Integer count;
	
	@JsonProperty("entries")
	private List<Entries> entries;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Entries> getEntries() {
		return entries;
	}

	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}

	public ApiData(Integer count, List<Entries> entries) {
		super();
		this.count = count;
		this.entries = entries;
	}

	public ApiData() {
		super();
	}
	
}
