<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="utf-8">
<title>本の追加</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- template -->
<%@ include file="template.jsp"%>
<!-- /template -->

<!-- Libraries Timeline CSS Files -->
<link href="/mylibrary/resources/chat_twitter_css/style.css"
	rel="stylesheet">

</head>
<body>

	<!-- Static navbar -->
	<%@ include file="navi.jsp"%>

	<div class="container">
		<!-- timeline -->
		<div class="twitter__container">
			<!-- タイトル -->

			<!-- ▼タイムラインエリア scrollを外すと高さ固定解除 -->
			<div class="twitter__contents">

				<!-- 記事エリア -->
				<c:forEach items="${list}" var="item">
					<div class="twitter__block">
						<figure>
							<img src="icon.png" />
						</figure>
						<div class="twitter__block-text">
							<div class="bookName">
								<span>題名：</span>
								<c:out value="${item[1]}" />
							</div>
							<div class="author">
								<span>著者：</span>
								<c:out value="${item[2]}" />
							</div>
							<div class="totalPage">
								<span>ページ数：</span>
								<c:out value="${item[3]}" />
							</div>
							<div class="readPage">
								<span>あなたの読んだページ数：</span>
								<c:out value="${item[6]}" />
							</div>
							<form:form class="contact-form" role="form" action="updateBook" name="form"
								method="POST">
								<input type="hidden" name="bookId" value="${item[0]}" />
								<input type="hidden" name="bookName" value="${item[1]}" />
								<input type="hidden" name="author" value="${item[2]}" />
								<input type="hidden" name="totalPage" value="${item[3]}" />
								<input type="hidden" name="img" value="${item[4]}" />
								<input type="hidden" name="userId" value="${item[5]}" />
								<input type="hidden" name="readPage" value="${item[6]}" />
								<div class="edit">
									<a id="edit" href="javascript:form.submit()"> <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"
										style="font-size: 30px;"></span>
									</a>
								</div>
							</form:form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- +++++ Footer Section +++++ -->
	<%@ include file="footer.jsp"%>
	<!-- /footer -->

	<!-- +++++ Copyrights Section +++++ -->
	<%@ include file="copyright.jsp"%>
	<!-- / copyrights -->
</body>
</html>