<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
      <style>
  	
  body{
 	padding-top: 50px; 
  	background-color: #EEEED1
  }
  	</style>
<title>注册页面</title>
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#check").click(function(){
			var userId=$("#userId").val();
			$.post("check",{userId:userId},function(data){
				//返回后执行的内容
				if(data==1){
					$("#back").html("恭喜，可以使用！");
				}else{
					$("#back").html("ID被占用，请换一个试试，谢谢！")
				}
			});
		});
	});
</script>
</head>
<body>

<form action="##" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">用户ID：</label>
    <input type="text" name="user" class="form-control"  placeholder="请输入ID："/>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail2">用户名：</label>
    <input type="text" name="user1" class="form-control"  placeholder="请输入用户名:"/>
  	</div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码：</label>
    <input type="password" name="password" class="form-control" placeholder="密码:"/>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail3">state：</label>
    <input type="text" name="user2" class="form-control"  placeholder="state只能为2"/>
  	</div>
  <button type="submit" class="btn btn-default btn-block" >点击注册</button>
</form>
<!-- 用户名:<input type="text" id="userId" name="userId"/><br> -->
<!-- 	  <input type="button" id="check" value="检测"/>	<label id="back"></label> -->
</body>
</html>