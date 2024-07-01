<!-- カート内確認jsp 2024/6/17 諸橋作成 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート内確認</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr color="#3399FF" size="5">
	<main>
		<h2>カート内</h2>
		<c:forEach var="cartCheckModel" items="${itemlist }" varStatus="c">
			<form:form modelAttribute="cartCheckModel">
				<table border="1" style="margin: auto;">
					<tr>
						<th><img
							src="${pageContext.request.contextPath}/resources/${cartCheckModel.item_image}"
							width="300" height="200"/></th>

						<th width="250"><div style="font-family: Century;">
								<div style="text-align: left;">
									<font size="5"><strong><c:out
												value="${cartCheckModel.item_name }" /></strong></font>
								</div>
							</div> <br> <font size="4"><strong>

									<div style="text-align: left;">
										小計：
										<c:out value="${cartCheckModel.item_price }" />
										円
									</div>
							</strong></font> <br> <input name="index" type="hidden" value="${c.index }" />
						<th width="100"><div style="text-align: center;">
								<input type="submit" name="delete" value="削除" />
							</div></th>
				</table>
			</form:form>
		</c:forEach>
		<c:if test="${pricemessage !='カート内に商品がありません' }">
			<h2>お支払金額</h2>
		</c:if>
		<font size="5"><strong><c:out value="${pricemessage }" /></strong></font>
		<br> <br>
		<form action="item/search" method="get">
			<input type="submit" name="itemSearch" value="商品検索画面に戻る" />
		</form>
		<br>
		<c:if test="${pricemessage !='カート内に商品がありません' }">
			<form action="orderinfo" method="get">
				<input type="submit" name="Order" style="width: 150px; height: 40px"
					value="購入画面に進む" />
			</form>
		</c:if>
	</main>
</body>
</html>