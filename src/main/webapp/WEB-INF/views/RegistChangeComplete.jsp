<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員情報変更完了</title>
</head>
<style>
h1{
		text-align: center;
}

h3{
		text-align: center;
}
</style>
<body>
<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
<h1>会員情報変更完了</h1>
<h3>会員情報が変更されました</h3>
<h3>再度ログイン願います。</h3>
<table>
				<h3>
 				<a href="${pageContext.request.contextPath}/login">ログイン</a>
				</h3>
	</table>
</body>
</html>