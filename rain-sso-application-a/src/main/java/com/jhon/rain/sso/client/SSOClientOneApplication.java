package com.jhon.rain.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述</br> 应用A </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName SSOClientOneApplication
 * @date 2017/10/29 13:51
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SSOClientOneApplication {

	@GetMapping("/user")
	public Authentication user(Authentication user) {
		return user;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SSOClientOneApplication.class, args);
	}
}
