<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<sec:csrfMetaTags />
  <meta charset="utf-8">
  <title>My Library</title>
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
 
  <!-- canvas -->
  <%@ include file="canvas.jsp" %>
  <!-- /canvas  -->
  
  <!-- +++++ Information Section +++++ -->
  <%@ include file="container.jsp" %>
  <!-- /container -->

  <!-- +++++ Footer Section +++++ -->
  <%@ include file="footer.jsp" %>
  <!-- /footer -->
  
  <!-- +++++ Copyrights Section +++++ -->
  <%@ include file="copyright.jsp" %>
  <!-- / copyrights -->
</body>
</html>