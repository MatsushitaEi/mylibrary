
<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index">My Library</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="create">新規登録</a></li>
					<li><a href="login">ログイン</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				<li><a href="index">マイページ</a>
				<li><a id="submit" href="" v-on:click="submit">ログアウト</a></li>
				</sec:authorize>
				<li><a href="contact">Contact</a></li>
				<form id="logout" class="form-inline" action="logout" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
  <!-- vue.js File -->
  <script type="text/javascript" src="/mylibrary/resources/js/submit.js"></script>