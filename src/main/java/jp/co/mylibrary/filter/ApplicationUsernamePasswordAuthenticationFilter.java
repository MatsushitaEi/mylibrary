package jp.co.mylibrary.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jp.co.mylibrary.dao.UsersDaoImpl;
import jp.co.mylibrary.entity.UsersEntity;

public class ApplicationUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		// Obtain info form request
		final String user = super.obtainUsername(request);
		final String pass = super.obtainPassword(request);

		if (user.isEmpty() || pass.isEmpty()) {
			throw new AuthenticationServiceException("Authentication info must be set");
		}

		// Validate info
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		// パスワードのハッシュ化
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		final String passEnc = bcrypt.encode(pass);

		// User情報の保存
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setMlAddress(user);
		usersEntity.setPass(passEnc);

		// すでにログイン済みか検証の為のチェック
		UsersEntity loginUsersEntity = usersDaoImpl.getLoginUser(user);

		// ユーザーがすでに存在しているかチェック
		if (loginUsersEntity == null) {
			createUser(usersEntity, usersDaoImpl);
		} else if (!bcrypt.matches(pass, loginUsersEntity.getPass())) {
			throw new AuthenticationServiceException("Authentication Error");
		}

		// Create token form input
		final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, passEnc);

		// Move to identify user phase
		return this.getAuthenticationManager().authenticate(authToken);
	}

	private void createUser(UsersEntity usersEntity, UsersDaoImpl usersDaoImpl) {
		usersEntity.prePersist();
		usersDaoImpl.setUser(usersEntity);
		usersDaoImpl.closeCurrentSessionwithTransaction();
	}
}
