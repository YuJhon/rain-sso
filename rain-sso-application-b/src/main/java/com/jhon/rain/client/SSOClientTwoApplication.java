package com.jhon.rain.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述</br> 应用B</p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName SSOClientTwoApplication
 * @date 2017/10/29 14:00
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SSOClientTwoApplication {

	@GetMapping("/user")
	public Authentication user(Authentication user) {
		return user;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SSOClientTwoApplication.class, args);
	}
}
