package com.jhon.rain.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * <p>功能描述</br> 认证服务器的配置 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName SSOAuthorizationServerConfig
 * @date 2017/10/29 13:30
 */
@Configuration
@EnableAuthorizationServer
public class SSOAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
						.withClient("sso-1")
						.secret("sso-secret1")
						.authorizedGrantTypes("authorization_code","refresh_token")
						.scopes("all")
						.and()
						.withClient("sso-2")
						.secret("sso-secret2")
						.authorizedGrantTypes("authorization_code","refresh_token")
						.scopes("all");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(jwtTokenStore())
						.accessTokenConverter(jwtAccessTokenConverter());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("isAuthenticated()");//访问TokenKey（rain）的时候需要身份验证
	}

	@Bean
	public TokenStore jwtTokenStore(){
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter(){
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("rain");//签名用的秘钥
		return accessTokenConverter;
	}
}
