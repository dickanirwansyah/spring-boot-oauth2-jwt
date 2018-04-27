package com.jwt.oauth2.springbootoauth2jwtresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringBootOauth2JwtResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2JwtResourceApplication.class, args);
	}
}
