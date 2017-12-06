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
<h1>订单详情</h1>

<!-- 订单详情 -->
订单号：${order.order_sn }<br>
订单总价：${order.order_price }<br>
收货人:${order.order_user_name }<br>
收货地址：${order.order_user_address }<br>
电话：${order.order_user_phone }<br>
提交时间:${order.order_time }<br>
<hr>
<c:forEach items="${ogList }" var="og">
	商品名称:${og.goods_name }<br>
	商品单价:${og.goods_price }<br>
	购买数量:${og.buy_number }<br>
</c:forEach>
<h2><a href="index">返回继续购物</a></h2>
</body>
</html>