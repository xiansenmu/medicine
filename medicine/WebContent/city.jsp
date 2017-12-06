<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="cn.xiwangxueyuan.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax案列2</title>
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#provice").change(function(){
			$("#getCity").html("<select id='city'><option>请选择市</option></select>");
			var id=$("#provice").val();
			 $.post("queryCity",{id:id},function(data){
				var get=eval(data);
				for(var i=0;i<get.length;i++){
					var name=get[i].regionName;
					var id=get[i].regionId;
					var str="<option value='"+id+"'>"+name+"</option>";
					$("#city").append(str);
				}
			}); 
		});
	});
	
	$(document).ready(function(){
		$("#xian").change(function(){
			$("#getXian").html("<select id='xian'><option>请选择县</option></select>");
			var id=$("#xian").val();
			 $.post("queryXian",{id:id},function(data){
				var get=eval(data);
				for(var i=0;i<get.length;i++){
					var name=get[i].regionName;
					var id=get[i].regionId;
					var stt="<option value='"+id+"'>"+name+"</option>";
					$("#xian").append(stt);
				}
			}); 
		});
	});
	
</script>
</head>
<body>
<select id="provice">
	<option>请选择省份</option>
	<c:forEach items="${regionList }" var="region">
		<option value="${region.regionId }">${region.regionName }</option>
	</c:forEach>
</select>
<label id="getCity">
<select id="city">
	<option>请选择市</option>	
</select>
</label>

<label id="getXian">
<select id="xian">
	<option>请选择县</option>	
</select>
</label>
</body>
</html>