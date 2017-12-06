<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ page import="cn.xiwangxueyuan.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatibal" content="IE=8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>药品管理系统</title>
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

	<jsp:include page="left.jsp" flush="true" />
	
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 	});
    });
</script>
     <div class="right"  id="mainFrame">     
     <div class="right_cont">
	  <!--标题栏  -->
	  <div class="title_right"><strong>商品图片上传</strong></div>
	  <div style="width:900px; margin:auto">
	  <!--查询条件  -->
		<!-- 上传图片格式说明 -->
      <form action="goodsPic.do" id=deptForm method="post" enctype="multipart/form-data">
      		<tbbal class="table-bordered">
      			<tr>
					<td width="15%" algin="center" nowrap="nowrap" bgcolor="#f1f1f1">图片信息上传</td>      			
      				<td witdh="35%">
      					<input type="hidden" name="goods_id" value="${goods_id }">
      					<input type="file" name="pic" class="span2-1"><i></i>
      				</td>
      			</tr><br>
      		    <tr>
      		        <td colspan="2" align="center" bgcolor="#f1f1f1">
      		        	<input type="submit" value="提交" class="btn btn-info" style="width:80px;"/> 
      		        </td>
      		    </tr>
      			<script>
      				$(function()){
      					$('#backid').click(function(){
      							window.location.href="dept!query.action";
      						
      					});     					
      				});    		
      			</script>
      		</tbbal>
      </form>
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
