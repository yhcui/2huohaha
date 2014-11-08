<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台管理界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<form action="admin/addjoke.sb" method="post">
	    <label for="title">标题:</label><input type= "text" name ="title" id="title"/><br/>
	    <label for="type">类型</label>
	    <select id="type" name="type">
	    	<option value="0">默认值</option>
	    	<option value="1">二货女友</option>
	    	<option value="2">二货男友</option>
	    	<option value="3">二货舍友</option>
	    	<option value="4">其他二货</option>
	    </select>
	    <br/>
	    <label for="content">内容:</label>
		<div id="sample">
		  <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
		//<![CDATA[
		        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
		  //]]>
		  </script>
		  <textarea name="content" style="width: 500px; height: 200px;" id="content">
		 </textarea>
		</div>
		<input type="submit" value = "保存" />
	</form>
  </body>
</html>