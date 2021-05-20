<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signJSP</title>
</head>
<body>
	<div>${message }</div>
	<div>
		<h5>註冊</h5>
		<form action="signUp">
			<label>帳號：</label>
			<input type="text" name="sup_username"><BR>
			<label>密碼：</label>
			<input type="text" name="sup_password"><BR>
			<label>性別：</label>
			<input type="text" name="sup_sex"><BR>
			<label>eMail：</label>
			<input type="text" name="sup_email"><BR>
			<input type="submit" value="註冊">
			<!-- <a href="signUp">註冊</a> -->
		</form>
	</div><BR>
	<hr>
	<div>
		<h5>登入</h5>
		<form action="signIn">
			<label>帳號：</label>
			<input type="text" name="sin_username"><BR>
			<label>密碼：</label>
			<input type="text" name="sin_password"><BR>
			<label>性別：</label>
			<input type="text" name="sin_sex"><BR>
			<label>eMail：</label>
			<input type="text" name="sin_email"><BR>
			<input type="submit" value="登入">
			<!-- <a href="signIn">登入</a> -->
			<a href="forgot">忘記密碼</a>
		</form>
	</div><BR>
	<hr>
	<div>
	</div>		
</body>
</html>