<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報確認</title>
</head>
<body>
	<jsp:include page="header.jsp" />
   <hr color="#3399FF" size="5">
   <main>
   		<h1>会員情報</h1>
   		<form:form modelAttribute ="userInfoModel">
			<div class ="error">${errormessage}</div>
			<table style="margin: auto;" border ="1">
				<tr>
					<td>会員No.</td>
					<td>
						<c:out value ="${userInfoModel.user_id}" /><br/>
					</td>
				</tr>
				<tr>
					<td>氏名</td>
					<td>
						<c:out value ="${userInfoModel.user_name}" /><br/>
					</td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td>
						<c:out value ="${userInfoModel.user_email}" /><br/>
					</td>
				</tr>
			</table>
				<tr>
					<td colspan ="3">
				</form:form>
				<a href="${pageContext.request.contextPath}/RegistInfoChange">会員情報の変更、退会はこちら</a>
					</td>
				</tr>


   </main>
</body>
</html>