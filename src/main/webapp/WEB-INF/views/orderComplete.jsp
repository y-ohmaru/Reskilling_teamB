<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了画面</title>
<style>
.h2{
	font-color:red;
}
</style>
</head>
<body>
		<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
		<h1 style="text-align: center;">ご注文完了</h1>
		<hr color="#3399FF" size="5">
		<h2 style="text-align: center;">ご注文いただきありがとうございます!</h2>
		<p style="text-align: center;">ご注文内容の詳細をメールにてお送りいたします。</p>
		<div style="text-align: center;">
		<a href="${pageContext.request.contextPath}/top">トップメニューへ戻る</a>
		</div>
</body>
</html>