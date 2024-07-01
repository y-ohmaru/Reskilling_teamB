<!-- 作業者:田邊大紀 -->
<!-- 作業日時:2024/6/13 -->
<!-- 概要:ログインやログアウトに応じて表示非表示を行うヘッダー -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
		.header {
			margin:1px;
			display: flex;
		}
		.search-bar {
			margin: 30px;
			display: flex;
			align-items: center;
		}
		.search-text {
			margin: 5px;
			display: flex;
			align-items: center;
		}
		.buttons {
		    text-align: center;
			margin-left:50px;
			display: block;
		}
		.buttons_loginout {
		    text-align: center;
			margin-left:5px;

		}


</style>
<body>
	<form:form>
	<a href="${pageContext.request.contextPath}/top"><img src="${pageContext.request.contextPath}/resources/image/logo_SS.png" alt="ロゴ" width="150" height="100"></a>
	<a href="${pageContext.request.contextPath}/item/search">商品検索画面に進む</a>

		<c:if test="${not empty loginModel}">
		 <div class="buttons">
				<div id="members"><div style="text-align: right;">
					<a href="${pageContext.request.contextPath}/userinfo">会員情報確認</a>
					<!-- <input type="submit" name="members" value="会員情報確認" /> -->
				</div>
				<div id="cart"><div style="text-align: right;">
					<a href="${pageContext.request.contextPath}/cartcheck">カート内容確認</a>
					<!-- <input type="submit" name="cart" value="カート内容確認" /> -->
				</div>
		</div>
		<div class="buttons_loginout">
				<div id="logout"><div style="text-align: right;">
					<a href="${pageContext.request.contextPath}/login">ログアウト</a>
				</div>
		</div>
		</c:if>
		<div class="buttons_loginout">
			<c:if test="${empty loginModel}">
				<div id="login">
					<input type="submit" name="login" value="ログイン/新規会員登録" />
				</div>
		    </c:if>
		</div>
</form:form>
</body>
</html>
