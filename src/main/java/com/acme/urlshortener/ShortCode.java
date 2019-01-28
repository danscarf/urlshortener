package com.acme.urlshortener;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("ShortCode")
public class ShortCode implements Serializable {


	private static final long serialVersionUID = 1L;
	private final String url;
	private final String guid;
	
	private String id;
		
	public ShortCode (String url, String guid) {
		this.url = url;
		this.guid = guid;
	}
	
	
	public String getUrl() {
		return this.url;
	}
	
	public String getGuid() {
		return this.guid;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Shortcode{" + "id='" + id + '\'' + ", url='" + url + '\'' + ", guid=\'" + guid+ "'}";
	}
}
