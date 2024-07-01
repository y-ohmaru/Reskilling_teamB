<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品検索画面</title>
<style>
.search {
	margin: auto;
	float: left;
}

</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/top"> <img
		src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100"></a>
		<div style="text-align: right;">
	<a href="${pageContext.request.contextPath}/cartcheck">カート内容確認画面はこちら</a></div>
	<form:form modelAttribute="itemSearchModel"
		action="${pageContext.request.contextPath}/item/search" method="post">
		<div style="text-align: center;">
		<form:select path="item_type">
			<form:option value="0">ジャンルで検索する</form:option>
			<form:option value="1">ベッド</form:option>
			<form:option value="2">本棚</form:option>
			<form:option value="3">椅子</form:option>
			<form:option value="4">電灯</form:option>
			<form:option value="5">ソファ</form:option>
			<form:option value="6">机</form:option>
		</form:select>

		<form:input path="item_name" placeholder="キーワードを入力する" />
		<button type="submit">検索</button>
		</div>
	</form:form>

	<hr color="#3399FF" size="5">

		<p style="text-align: center;"><c:out value="${searchMessage}" /></p>

		<c:if test="${not empty itemsList}">
			<c:forEach var="items" items="${itemsList}">
				<table>
					<tr>
						<th><img
							src="${pageContext.request.contextPath}/resources/${items.item_image}"
							alt="${items.item_name }" width="400" height="300" style="display: block; margin-left: 170px; margin-right: auto;"></th>
						<th width="20">
						<th><div style="font-family: Century;"><div style="text-align: left;"><div style="margin-left: 10px;">
								<font size="6"><strong><c:out value="${items.item_name}" /></strong></font>
							</div></div></div> <br> <br>
							<div style="text-align: left;">
								<c:out value="${items.item_announce}" />
							</div> <br> <br>
							<div style="text-align: left;">

								<font size="5"><strong><c:out value="${items.item_price}" /></strong></font>
								円
							</div> <br> <c:if test="${not empty loginModel}">
								<br>

								<div style="text-align: left;">
									<form
										action="${pageContext.request.contextPath}/item/addToCart"
										method="post">
										<input type="hidden" name="item_id" value="${items.item_id}" />
										数量： <input type="number" id="quantity" name="quantity"
											value="1" min="1" size="1" />
										<button type="submit" class="addCart">カートに追加する</button>
										<br>
										<br>
										<font color="red"><c:out value="${message}" /></font>
										<c:out value="${number}" />
									</form>
								</div>
							</c:if>
				</table>
			</c:forEach>
		</c:if>
</body>
</html>
