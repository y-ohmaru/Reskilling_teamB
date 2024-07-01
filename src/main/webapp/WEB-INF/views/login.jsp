<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix ="form"%>
<!DOCTYPE html>
<html lang ="ja">
<head>
<meta charset="UTF-8">
<title>お客様ログイン画面</title>
<style>
	.error{
	color: red;
	}
	.mx-auto{
	width: fit-content;
    margin:auto;
    padding:10px;
    border:1px solid;
    }
    .mb-3{
    width: fit-content;
    margin:auto;
    }
</style>
</head>
<body>
<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
<hr color="#3399FF" size="5">
   <br>
	<h2 style="text-align: center">登録済みのお客様</h2>
	<div class="mx-auto" style="width: 300px;">
		<form:form modelAttribute ="loginModel">
			<div class ="error"><c:out value="${errormessage}" /></div>
			<div class ="error"><c:out value="${message}"/></div>
			<table>
				<tr>
					<td><div style="text-align: right">メールアドレス:</div></td>
					<td>
						<form:input path ="user_email" /><br/>
					</td>
				</tr>
				<tr>
					<td><div style="text-align: right">パスワード:</div></td>
					<td>
						<form:input type="password" path ="user_password" /><br/>
					</td>
				</tr>
				<tr>
					<td colspan ="3">
					<div style="text-align: center"><input type ="submit" value ="ログイン"></div>
					</td>
				</tr>
				</table>
			</form:form>
		</div>
	  <br>
	<div class="mb-3">
		<h2 style="text-align: center">登録がお済でないお客様</h2>
		 <a href="/shopping/regist">新規会員登録</a>
		 <a href="/shopping/top">トップに戻る</a>
</div>
 </body>
 </html>