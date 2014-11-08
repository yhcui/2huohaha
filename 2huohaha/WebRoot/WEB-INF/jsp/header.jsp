<%@ page language="java" pageEncoding="GBK" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>二货哈哈</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="笑话,成人,成人笑话,二货,二货哈哈">
	<meta http-equiv="description" content="笑话,成人,成人笑话,二货,二货哈哈">
	<META http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%= basePath %>bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
	<link href="<%= basePath %>static/css/pagination.css" rel="stylesheet" media="screen">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?c921026801a344a39f38cd83a7b80d61";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
	</script>
	 <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
	
  </head>
  
  <body>
 
	<div class="container">

      <div class="masthead">
        <h3 class="muted">二货哈哈</h3>
        <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
		<!-- 大型页首横幅广告 -->
		<ins class="adsbygoogle"
		     style="display:inline-block;width:970px;height:90px"
		     data-ad-client="ca-pub-5079052844587731"
		     data-ad-slot="5401357165"></ins>
		<script>
		(adsbygoogle = window.adsbygoogle || []).push({});
		</script>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
              <c:if test="${type==0}">
                <li class="active">
                </c:if>
                <c:if test="${type!=0}">
                <li>
                </c:if><a href="#">最新</a></li>
                <c:if test="${type==1}">
                <li class="active">
                </c:if>
                <c:if test="${type!=1}">
                <li>
                </c:if>
                <a href="erhuonvyou.sb">二货女友</a></li>
                
                <c:if test="${type==2}">
                <li class="active">
                </c:if>
                <c:if test="${type!=2}">
                <li>
                </c:if>
                <a href="erhuonanyou.sb">二货男友</a></li>
                <c:if test="${type==3}">
                <li class="active">
                </c:if>
                <c:if test="${type!=3}">
                <li>
                </c:if><a href="erhuosheyou.sb">二货舍友</a></li>
                <c:if test="${type==4}">
                <li class="active">
                </c:if>
                <c:if test="${type!=4}">
                <li>
                </c:if><a href="qitaerhuo.sb">其他二货</a></li>
                <c:if test="${type==250}">
                <li class="active">
                </c:if>
                <c:if test="${type!=250}">
                <li>
                </c:if>
                <a href="abouterhuo.sb">关于二货哈哈</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>
