<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>送货地址</title>
</head>
<body>
	<form action="orderAddress" method="post">
		<input type="hidden" name="sn" value="${orderSn }"/>
		姓名：<input type="text" name="name"/><br>
		地址：<input type="text" name="address"/><br>
		电话：<input type="text" name="phone"/><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>