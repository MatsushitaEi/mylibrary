<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <title>本の追加</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- template -->
  <%@ include file="template.jsp" %>
  <!-- /template -->
</head>
<body>

  <!-- Static navbar -->
  <%@ include file="navi.jsp" %>

  <!-- +++++ form Section +++++ -->
  <div class="container pt">
    <div class="row mt">
      <div class="col-lg-6 col-lg-offset-3 centered">
        <h3>書籍の情報を入力して下さい</h3>
        <hr>
      </div>
    </div>
    <div class="row mt">
      <div class="col-lg-8 col-lg-offset-2">
        <form:form modelAttribute="booksEntity" class="contact-form php-mail-form" role="form" action="registBook" method="POST">
        
        	<div class="form-group">
        	<label>書籍名：</label>
              <form:input path="bookName" required="required" type="name" name="bookName" class="form-control" placeholder="書籍名" data-rule="name" data-msg="4文字以上で入力して下さい"/>
              <div class="validate"></div>
            </div>
            
            <div class="form-group">
        	<label>作者名：</label>
              <form:input path="author" required="required" type="name" name="editor" class="form-control" placeholder="作者名" data-rule="name" data-msg="4文字以上で入力して下さい"/>
              <div class="validate"></div>
            </div>

            <div class="form-group">
            <label>ページ数：</label>
              <form:input path="totalPage" required="required" type="number" name="totalPage" class="form-control" placeholder="ページ数" data-rule="number" data-msg="数値を入力して下さい"/>
              <div class="validate"></div>
            </div>
            
            <div class="form-group">
            <label>書籍画像：</label>
              <form:input path="img" type="file" name="file" class="form-control" placeholder="画像url" data-rule="file" data-msg="画像を指定して下さい"/>
              <div class="validate"></div>
            </div>

            <div class="form-send">
              <button type="submit" class="btn btn-large">登録</button>
            </div>

          </form:form>
      </div>
    </div>
    <!-- /row -->
  </div>
  <!-- /form -->

  <!-- +++++ Footer Section +++++ -->
  <%@ include file="footer.jsp" %>
  <!-- /footer -->
  
  <!-- +++++ Copyrights Section +++++ -->
  <%@ include file="copyright.jsp" %>
  <!-- / copyrights -->
</body>
</html>