package jp.co.mylibrary.filter;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jp.co.mylibrary.dao.UsersDaoImpl;
import jp.co.mylibrary.entity.UsersEntity;

public class ApplicationUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Identify user
		final String username = authentication.getName();
		final String password = authentication.getCredentials().toString();
		final UsersEntity user = new UsersEntity();
		user.setMlAddress(username);
		user.setPass(password);

		// userIdをセットする
		// TODO 無理やりセットしてるのでもっと簡単にしたい。。
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		usersDaoImpl.openCurrentSession();
		user.setUserId(usersDaoImpl.getLoginUser(username).getUserId());

		// Create authentication token
		return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}
