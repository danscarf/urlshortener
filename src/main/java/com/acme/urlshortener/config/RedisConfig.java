package com.acme.urlshortener.config;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig {

	Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		
		String hostname =  System.getenv().getOrDefault("REDIS_HOST", "localhost");
		if (logger.isInfoEnabled()) {
			logger.info(String.format("Hostname: %s", hostname));
		}
		
		int port = Integer.parseInt(System.getenv().getOrDefault("REDIS_HOST", "6379"));
		
		if (logger.isInfoEnabled()) {
			logger.info(String.format("Port: %s", port));
		}
		
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(hostname, port);

		return new JedisConnectionFactory(config);	    
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
	
}
