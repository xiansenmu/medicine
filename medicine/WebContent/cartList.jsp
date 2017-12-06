<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="cn.xiwangxueyuan.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城主页</title>
<script type="text/javascript">
	function reduce(id,number){
		var url="cartReduce?id="+id+"&number="+number+"&flag=1";
		window.location.href=url;
		
	}
	function add(id,number){
		var url="cartReduce?id="+id+"&number="+number+"&flag=2";
		window.location.href=url;		
	}

</script>
</head>
<body>
<!--判断是否登录   登录则显示个人信息   没有登录则显示登录界面  -->
<!--用户状态保存Session对象  判断Session是否有用户信息   有则显示个人信息  没有则显示登录界面-->
	${user.user_name }
<br>
<!-- 进入购物车 -->
<a href="index">返回购物车列表</a><br>

<!-- 商品列表 -->
<form action="orderAdd" method="post">
<table class="table table-bordered" width="80%" style="border:1px solid blue;" cellspacing="0">
         <tr>
         	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>选择</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>序号</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>药品名称</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>药品类型</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>药品价格</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>购买数量</strong></td>
         	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>删除</strong></td>
         </tr>
          <c:forEach items="${cartList }" var="cart" varStatus="de"> 
	      <tr>	
	      		<td align="center"><input type="checkbox" name="cartIds" value="${cart.cart_id }" /></td>         
				<td align="center">${de.count }</td>
				<td align="center">${cart.goods_name }</td>
	           <td align="center">${cart.goods_type }</td>
	           <td align="center">${cart.goods_price }</td>
	           <td align="center">
	           <input type="button" value="-" style="width:20px" onclick="reduce(${cart.cart_id},${cart.buy_number });"/>
	           <input type="text" value="${cart.buy_number }" style="width:30px" />
	           <input type="button" value="+" style="width:20px" onclick="add(${cart.cart_id},${cart.buy_number });"/>
	           </td>  
	           <td align="center"><a href="cartDelete?id=${cart.cart_id }">删除</a></td>       
	      </tr>
	      </c:forEach> 
             <tr>
	         		<td colspan="6" align="left">
	         		总价：${totalPrice }<input type="submit" value="提交订单"/>
	         		</td>
	         </tr>  
       </table> 
       </form>
</body>
</html>