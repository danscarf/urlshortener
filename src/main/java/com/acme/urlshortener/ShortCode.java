package com.acme.urlshortener;

public class ShortCode {

	private final String url;
	private final String guid;
		
	public ShortCode (String url, String guid) {
		this.url = url;
		this.guid = guid;
	}
	
	
	public String GetUrl() {
		return this.url;
	}
	
	public String getGuid() {
		return this.guid;
	}
}
