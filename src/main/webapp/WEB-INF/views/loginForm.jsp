
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" import="java.io.*"%>

<div class="container pt">
	<div class="row mt">
		<div class="col-lg-6 col-lg-offset-3 centered">
			<h3>ログイン/新規登録フォーム</h3>
			<hr>
			<p>ログイン情報を入力してください。</p>
			<p>新規登録もこちらからできます。</p>
		</div>
	</div>

	<c:if test="${param.error}">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>ログインに失敗しました。</strong>
		</div>
	</c:if>
	<c:if test="${param.logout}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>ログアウトしました。</strong>
		</div>
	</c:if>

	<div class="row mt">
		<div class="col-lg-8 col-lg-offset-2">
			<form class="contact-form php-mail-form" role="form"
				action="authentication" method="POST">

				<div class="form-group">
					<input type="text" required="required" name="username" class="form-control"
						placeholder="アカウント名" data-rule="name" data-msg="4文字以上で入力して下さい" />
					<div class="validate"></div>
				</div>

				<div class="form-group">
					<input type="password" required="required" name="password" class="form-control"
						id="password" placeholder="パスワード" data-rule="minlen:4" data-msg="" />
					<div class="validate"></div>
				</div>

					<input type="hidden" name="refer" value="<%=request.getAttribute("refer")%>" />

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="form-send">
					<button type="submit" class="btn btn-large">ログイン</button>
				</div>

			</form>
		</div>
	</div>
	<!-- /row -->
</div>