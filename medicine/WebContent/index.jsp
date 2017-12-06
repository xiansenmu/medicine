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
</c:choose>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- 进入购物车 -->
<a href="cartQuery">进入购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="orderList">用户订单</a>
<!-- 商品列表 -->
<table class="table table-bordered" width="100%" style="border:1px solid blue;" cellspacing="0">
         <tr>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>序号</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>名称</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>类型</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>MDL</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>价格</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>库存</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>图片</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>药品详情</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>进入购物车</strong></td>
         </tr>
          <c:forEach items="${goodsList }" var="goods" varStatus="de"> 
	      <tr>	          
	           <td align="center">${de.count }</td>
	           <td align="center">${goods.goods_name }</td>
	           <td align="center">${goods.goods_type }</td>
	           <td align="center">${goods.goods_mdl }</td>
	           <td align="center">${goods.goods_price }</td>
	           <td align="center">${goods.goods_number }</td>
	           <td align="center"><img src="goodsPic/${goods.goods_pic }" width="50px"/></td>
	           <td align="center"><a href="goodsDetail?id=${goods.goods_id }">药品详情</a></td>
	           <td align="center"><a href="cartAdd?goods_id=${goods.goods_id }&buyNumber=1">购买</a></td>	           
	      </tr>
	      </c:forEach> 
             <tr>
	         		<td colspan="10" align="right">
	         			<jsp:include page="admin/pager.jsp" flush="true"/>
	         		</td>
	         </tr>  
       </table> 
</body>
</html>