package com.acme.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

import java.util.UUID;

@Controller
public class UrlShortenerController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/getshortcode")
	@ResponseBody
	public ShortCode getShortCode(@RequestParam(name="url", required=false, defaultValue="https://localhost") String url){
		
		String uuid = UUID.randomUUID().toString();
		ShortCode sc = new ShortCode(url, uuid);
		return sc;
	}

	
	@GetMapping("/setshortcode")
	@ResponseBody
	public ShortCode setShortCode(@RequestParam(name="url", required=false, defaultValue="https://localhost") String url){
		
		String uuid = UUID.randomUUID().toString();
		
		ShortCode sc = new ShortCode(url, uuid);
		
		return sc;
	}
	

}
