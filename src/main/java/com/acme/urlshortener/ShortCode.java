package com.acme.urlshortener;

public class ShortCode {

	private final String url;
		
	public ShortCode (String url) {
		this.url = url;
	}
	
	
	public String GetUrl() {
		return this.url;
	}
}
