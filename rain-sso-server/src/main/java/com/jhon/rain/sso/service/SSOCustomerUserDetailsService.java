package com.jhon.rain.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述</br> 用于用户信息查询</p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName CustomerUserDetailsService
 * @date 2017/10/29 14:59
 */
@Component
public class SSOCustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 用户名的校验 TODO
		return new User(username,passwordEncoder.encode("123456"),
						AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
	}
}
