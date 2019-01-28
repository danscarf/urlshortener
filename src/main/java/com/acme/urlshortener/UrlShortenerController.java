package com.acme.urlshortener;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.acme.urlshortener.repo.ShortcodeRepository;

import java.util.Optional;
import java.util.UUID;

@Controller
public class UrlShortenerController {

	Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
	
	@Autowired
	private ShortcodeRepository repo;

	@GetMapping("/geturl")
	@ResponseBody
	public ShortCode getUrlFromShortCode(@RequestParam(name="q", required=true) String id){
		
		Optional<ShortCode> sc = repo.findById(id);
		if (sc.isPresent()) {
			return sc.get();			
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/redirect")
	public RedirectView redirectFromShortCode(@RequestParam(name="q", required=true) String id){
		
		String url;
		Optional<ShortCode> sc = repo.findById(id);
		if (sc.isPresent()) {
			url = sc.get().getUrl();			
		}
		else {
			return null;
		}

		return new RedirectView(url);
	}
	
	
	@GetMapping("/getshortcode")
	@ResponseBody
	public ShortCode setShortCode(@RequestParam(name="q", required=true) String url){
		
		String uuid = UUID.randomUUID().toString();
		
		ShortCode sc =  new ShortCode(url, uuid);
		
		if (logger.isInfoEnabled()) {
			logger.info(sc.toString());
		}
		
		repo.save(sc);
		
		return sc;
	}
}
