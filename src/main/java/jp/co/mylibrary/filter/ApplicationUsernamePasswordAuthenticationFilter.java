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
		final String refer = request.getParameter("refer");

		if (user.isEmpty() || pass.isEmpty()) {
			throw new AuthenticationServiceException("Authentication info must be set");
		}

		// Validate info
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

		if (refer.equals("login")) {
			UsersEntity usersEntity = usersDaoImpl.getLoginUser(user);
			// パスワードの比較
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			if (usersEntity == null || !(bcrypt.matches(pass, usersEntity.getPass()))) {
				throw new AuthenticationServiceException("Authentication Error");
			}

			// Create token form input
			final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,
					usersEntity.getPass());

			// Move to identify user phase
			return this.getAuthenticationManager().authenticate(authToken);
		} else if (refer.equals("create")) {

			// パスワードのハッシュ化
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			final String passEnc = bcrypt.encode(pass);

			// User情報の保存
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setMlAddress(user);
			usersEntity.setPass(passEnc);
			usersEntity.prePersist();
			usersDaoImpl.setUser(usersEntity);
			usersDaoImpl.closeCurrentSessionwithTransaction();

			// Create token form input
			final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user,
					passEnc);

			// Move to identify user phase
			return this.getAuthenticationManager().authenticate(authToken);
		} else {
			throw new AuthenticationServiceException("Authentication Error");
		}

	}

}
