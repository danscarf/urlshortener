package com.acme.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class UrlShortenerController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/GetShortcode")
	@ResponseBody
	public ShortCode getShortCode(@RequestParam(name="url", required=false, defaultValue="https://localhost") String url){
		ShortCode sc = new ShortCode(url);
		return sc;
	}


}
