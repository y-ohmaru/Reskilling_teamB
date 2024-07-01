<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員情報変更画面</title>
</head>
<style>
h1{
		text-align: center;
}

h3{
		color:red;
		text-align: center;
}
.change{
		padding: 15px;
		text-align: center;
}
.Secession{
		padding: 5px;
		text-align: center;
}
</style>
<body>
<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
<a href="/shopping/top">トップに戻る</a>
<hr color="#3399FF" size="5">
			<h1>会員情報変更画面</h1>
  <form:form modelAttribute="RegistInfoChangeModel">
 		<h3><c:out value="${message }" /></h3>
 		<h3><c:out value="${message2 }" /></h3>
 		<table style="width: fit-content; margin: auto;">
 			<tr>
 				<td>会員No.</td>
 				<td><c:out  value="${RegistInfoChangeModel.user_id}"/></td>
 				</tr>
 			<tr>
 				<td>氏名</td>
 				<td><input type="text" name="user_name" value ="${RegistInfoChangeModel.user_name}"/></td>
 				</tr>
			<tr>
 				<td>メールアドレス</td>
 				<td><input type="text" name="user_email" value ="${RegistInfoChangeModel.user_email}"/></td>
 				</tr>
			<tr>
 				<td>古いパスワード</td>
 				<td><input type="password" name="user_password"/></td>
 				</tr>
 			<tr>
 				<td>新しいパスワード</td>
 				<td><input type="password" name="new_password"/></td>
 				</tr>
 			<tr>
 				<td>新しいパスワード(確認)</td>
 				<td><input type="password" name="new_passwordCheck"/></td>
 				</tr>
 			</table>
 		<div class="change">

 				<input type="submit" name="change" value="変更する"/>
 		</div>
 		<div class="Secession">
 				<input type="submit" name="Secession" value="退会する"/>
 		</div>
</form:form>
</body>
</html>