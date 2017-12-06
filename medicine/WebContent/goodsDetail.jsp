<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="cn.xiwangxueyuan.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城主页</title>
</head>
<body>
<!--判断是否登录   登录则显示个人信息   没有登录则显示登录界面  -->
<!--用户状态保存Session对象  判断Session是否有用户信息   有则显示个人信息  没有则显示登录界面-->
<c:choose>
	<c:when test="${user==unll }"><a href="login.jsp">登录</a></c:when>
	<c:otherwise>${user.user_name }</c:otherwise>
</c:choose>
<br>
<a href="login.jsp">返回登陆</a><br>
<!-- 进入购物车 -->
<a href="cartQuery">进入购物车</a><br><br>

<!-- 药品详情 -->
商品名称：${goods.goods_name }<br>
商品类型：${goods.goods_type }<br>
商品MDL:${goods.goods_mdl }<br>
商品价格：${goods.goods_price }<br>
商品库存：${goods.goods_number }<br>
<img  src="goodsPic/${goods.goods_pic }"><br>
<form action="cartAdd">
<input type="hidden" name="goods_id" value="${goods.goods_id }" />
购买数量：<input type="text" name="buyNumber" value="1" style="width:40px" /><br>
<input type="submit" value="购买" />
</form>
</body>
</html>