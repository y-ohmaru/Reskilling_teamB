<!-- 作業者:田邊大紀 -->
<!-- 引継ぎ作業：並河弘樹 -->
<!-- 作業日時:2024/6/13 -->
<!-- 概要:注文者情報入力後の内容確認画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文情報確認画面</title>
<style>
body {
	margin: 20px;
}

h1 {
	text-align: center;
}

h2 {
	color: red;
}

members {

}
</style>
</head>
<body>
	<hr color="#3399FF" size="5">
	<h1>
		<strong>注文情報確認画面</strong>
	</h1>

	<h2 style="text-align: center;">注文は完了しておりません</h2>
	<div style="text-align: center;">
		<h3>商品情報</h3>
		<!-- foreachでリストの要素分だけテーブルを表示させる？ -->
		<h2>カート内</h2>

			<c:forEach var="cartCheckModel" items="${itemlist}" varStatus="c">

				<table border="1" style="margin: auto;">

					<tr>
						<th><img
							src="${pageContext.request.contextPath}/resources/${cartCheckModel.item_image}"
							width="400" height="300" /></th>
						<th width="150"><c:out value="${cartCheckModel.item_name }" /><br>
							小計：<c:out value="${cartCheckModel.item_price }" />円<br>
					</tr>
				</table>

			</c:forEach>

		<h3>
			お支払金額:
			<c:out value="${pricemessage }" />
			<br>
		</h3>

		<p>購入者・お支払情報</p>

		<form:form modelAttribute="userModel">
			<div class="users">


				<div style="text-align: center;">
					<table border="1" style="margin: auto;">
						<tr>
							<td>お名前</td>
							<td width="350">${userModel.user_name }</td>
						</tr>

						<tr>
							<td>フリガナ</td>
							<td>${userModel.user_kana }</td>
						</tr>
						<tr>
							<td>メールアドレス</td>
							<td>${userModel.user_email }</td>
						</tr>
						<tr>
							<td>郵便番号</td>
							<td>${userModel.user_post }</td>
						</tr>
						<tr>
							<td>住所</td>
							<td>${userModel.user_address }</td>
						</tr>
						<tr>
							<td>お支払方法</td>
							<td>${userModel.paymentMethod }</td>
						</tr>

					</table>
				</div>
			</div>
			<br>
			<div style="text-align: center;">
				<input type="submit" name="orderInput" value="注文者情報入力画面に戻る" /> <input
					type="submit" name="orderForward" value="購入を決定する" />
			</div>
		</form:form>
	</div>
</body>
</html>