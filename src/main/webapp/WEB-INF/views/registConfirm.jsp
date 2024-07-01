<!--
-----------------会員登録完了画面--------------------
作業日：6/13
作業者：伊藤
内容： 登録完了のテキストを表示
-----------------------------------------------------
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員登録画面</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
	<hr color="#3399FF" size="5">
	<br>
	<main>
	   <form:form>
	   <div style="text-align: center;">
	   <h1>登録が完了しました！</h1><br>
	   <h2>ログイン後、お買い物をお楽しみください。</h2>
	   <p><a href="login">ログイン</a></p>
	   </div>
	   </form:form>
	</main>
</body>
</html>