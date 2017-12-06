<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ page import="cn.xiwangxueyuan.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>医务管理系统</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/sdmenu.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>

</head>

<body>

<!-- 顶部 -->     
<jsp:include page="header.jsp" flush="true" />         
	<div id="middle">
	     <div class="left">	     
		  <script type="text/javascript">
		var myMenu;
		window.onload = function() {
			myMenu = new SDMenu("my_menu");
			myMenu.init();
		};
		</script>		
	     </div>
        <div class="Switch"></div>
     	<script type="text/javascript">
		$(document).ready(function(e) {
    	$(".Switch").click(function(){
		$(".left").toggle();
	 	});
    });
		function add(){
			window.location.href="goodsAdd.do";
		}
</script>
     <div class="right"  id="mainFrame">     
     <div class="right_cont">
   <div style="width:900px; margin:auto">
       <center><input type="button" value="添加信息" class="btn btn-info" onclick="add();" style="width:80px;margin-bottom:8px"/></center>
      <table class="table table-striped">
         <tr>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>序号</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>名称</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>类型</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>MDL</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>价格</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>库存</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>图片</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>修改</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>删除</strong></td>
           <td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>图片</strong></td>
         </tr>
          <c:forEach items="${goodsList }" var="goods" varStatus="de"> 
	      <tr>	          
	           <td align="center">${de.count }</td>
	           <td align="center">${goods.goods_name }</td>
	           <td align="center">${goods.goods_type }</td>
	           <td align="center">${goods.goods_mdl }</td>
	           <td align="center">${goods.goods_price }</td>
	           <td align="center">${goods.goods_number }</td>
	           <td align="center"><img src="../goodsPic/${goods.goods_pic }"/></td>
	           <td align="center"><a href="goodsUpdate.do?goods_id=${goods.goods_id }">修改</a></td>
	           <td align="center"><a href="goodsDelete.do?goods_id=${goods.goods_id }">删除</a></td>
	           <td align="center"><a href="goodsPic.do?goods_id=${goods.goods_id }">上传图片</a></td>	           
	      </tr>
	      </c:forEach> 
             <tr>
	         		<td colspan="10" align="right">
	         			<jsp:include page="pager.jsp" flush="true"/>
	         		</td>
	         </tr>  
       </table> 
	</div>          
     </div>     
     </div>
    </div>
    
<!-- 底部 -->
     
 <script>
	!function(){
	laydate.skin('molv');
	laydate({elem: '#Calendar'});
	}(); 
</script>
</body>
</html>
