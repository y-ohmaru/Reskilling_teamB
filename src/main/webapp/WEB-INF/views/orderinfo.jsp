<!-- 注文者情報入力画面 -->
<!--  並河 20240620 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
function payflg1(check){
	if(check == true){
		document.getElementById("card_Number").disabled = true;
		document.getElementById("card_Name").disabled = true;
		document.getElementById("card_Month").disabled = true;
		document.getElementById("card_Year").disabled = true;
		document.getElementById("securitycode").disabled = true;
	}else{
		document.getElementById("card_Number").disabled = false;
		document.getElementById("card_Name").disabled = false;
		document.getElementById("card_Month").disabled = false;
		document.getElementById("card_Year").disabled = false;
		document.getElementById("securitycode").disabled = false;
	}
}

function payflg2(check){
	if(check == true){
		document.getElementById("card_Number").disabled = false;
		document.getElementById("card_Name").disabled = false;
		document.getElementById("card_Month").disabled = false;
		document.getElementById("card_Year").disabled = false;
		document.getElementById("securitycode").disabled = false;
	}else{
		document.getElementById("card_Number").disabled = true;
		document.getElementById("card_Name").disabled = true;
		document.getElementById("card_Month").disabled = true;
		document.getElementById("card_Year").disabled = true;
		document.getElementById("securitycode").disabled = true;
	}
}

</script>
<style>
	.error{
	text-align: center;
	color:red;
	}
</style>
<title>お客様情報入力</title>
</head>
<body>
		<h1 style="text-align: center;">お客様情報入力</h1>
		<div class="error">
			<c:out value="${errorMessage }"/>
		</div>
		<form:form modelAttribute ="userModel">
		<table style="margin: auto;" border ="1">
			<tr>
				<td><label>氏名</label></td>
				<td><form:input path ="user_name" /></td>
			</tr>
			<tr>
				<td><label>氏名（フリガナ）</label></td>
				<td><form:input path ="user_kana" /></td>
			</tr>
			<tr>
				<td><label>メールアドレス</label></td>
				<td><form:input path ="user_email" /></td>
			</tr>
			<tr>
				<td><label>郵便番号(ハイフンなし)</label></td>
				<td><form:input path ="user_post" /></td>
			</tr>
			<tr>
				<td><label>住所</label></td>
				<td><form:input path ="user_address" /></td>
			</tr>
			<tr>
				<td>お支払い方法</td>
				<td>
					<input type="radio" name="paymentMethod" value="credit" onClick="payflg2(this.checked)" checked>クレジットカード
					<input type="radio" name="paymentMethod" value="cash" onClick="payflg1(this.checked)">代金引換
				</td>
			</tr>
			<tr>
				<td><label>カード番号</label></td>
				<td><form:input path="card_Number" id="card_Number" disabled="disabled"/></td>
			</tr>
			<tr>
				<td><label>カード名義</label></td>
				<td><form:input path="card_Name" id="card_Name" disabled="disabled"/></td>
			</tr>
			<tr>
				<td><label>有効期限</label></td>
				<td>
				<form:input path="card_Month" id="card_Month" disabled="disabled"/>月
				<form:input path="card_Year" id="card_Year" disabled="disabled"/>年
				</td>
			<tr>
				<td><label>セキュリティコード</label></td>
				<td><form:input type ="password" path="securitycode" id="securitycode" disabled="disabled"/></td>
			</tr>
		</table>
		<br>
		<div style="text-align: center;">
		<input type="submit" name ="backcart" value="カートに戻る"/>
		<input type="submit" name ="orderregist" value ="次へ"/>
		</div>
		</form:form>
</body>
</html>
