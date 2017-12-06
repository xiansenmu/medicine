<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style>
  	
  body{
/*   	padding-top: 50px; */
  	background-color: #EEEED1
  }
  	</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>

	<!-- 图片轮播 -->
 	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="height: 350px">


		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active" style="height: 320px">
		      <img src="img/1.jpg" alt="0 slide"> <div class="carousel-caption">
		        1
		      </div>
		    </div>
		    <div class="item" style="height: 320px">
		      <img src="img/2.jpg" alt="1 slide"> <div class="carousel-caption">
		        2
		      </div>
		    </div>
		    <div class="item" style="height: 320px">
		      <img src="img/3.jpg" alt="2 slide"> <div class="carousel-caption">
		        3
		      </div>
		    </div>
		    <div class="item" style="height: 320px">
		      <img src="img/4.jpg" alt="3 slide"> <div class="carousel-caption">
		        4
		      </div>
		    </div>
		    <div class="item" style="height: 320px">
		      <img src="img/5.jpg" alt="4 slide"> <div class="carousel-caption">
		        5
		      </div>
		    </div>
		  </div>

		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">last</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">next</span>
		  </a>
	</div >


<form action="login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">用户ID：</label>
    <input type="text" name="user" class="form-control"  placeholder="请输入ID："/>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码：</label>
    <input type="password" name="password" class="form-control" placeholder="密码："/>
  </div>
  <div style="padding-top: 30px">
  <button type="submit" class="btn btn-default btn-block" >登录</button>
  </div>
  <div style="padding-top: 40px">
  <a class="btn btn-default btn-block" href="regist.jsp">用户注册</a>
  </div>
</form>

<!-- <form action="login" method="post"> -->
<!-- 	用户ID:<input type="text" name="user" /><br> -->
<!-- 	用户密码:<input type="password" name="password"/><br> -->
<!-- 	<input type="submit" value="登录" /> -->
<!-- </form> -->
</body>
</html>