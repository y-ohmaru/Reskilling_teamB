<!--
-----------------会員登録画面--------------------
作業日：6/13
作業者：伊藤
内容： 入力フォームに入力後、登録またはキャンセル
-------------------------------------------------
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
<style>
 h2{
		  text-align: center;
}
 .button{
          padding: 20px;
		  text-align: center;
}
</style>
</head>
<body>
	<a href="${pageContext.request.contextPath}/top">
		<img src="${pageContext.request.contextPath}/resources/image/logo_SS.png"
		alt="ロゴ" width="150" height="100">
	</a>
	<hr color="#3399FF" size="5">
	      <h2>新規会員登録</h2>
	   <form:form modelAttribute="registModel">
	   <h2><c:out value ="${message }"/></h2>
	   <table style="margin: auto;">
	     <tr>
	       <td><div style="text-align: right">氏名(フルネーム)</div></td>
	       <td><form:input type="text" path="name" placeholder = "名前" /></td>
	     </tr>

	     <tr>
	       <td><div style="text-align: right">メールアドレス</div></td>
	       <td><form:input type="text" path="mail" placeholder = "メールアドレス" /></td>
	     </tr>

	     <tr>
	       <td><div style="text-align: right">メールアドレス(確認用)</div></td>
	       <td><form:input type="text" path="mailCheck" placeholder = "メールアドレス" /></td>
	     </tr>
	     <tr>
	       <td><div style="text-align: right">パスワード</div></td>
	       <td><form:input type="password" path="password" placeholder = "パスワード" /></td>
	     </tr>
	     <tr>
	       <td><div style="text-align: right">パスワード(確認用)</div></td>
	       <td><form:input type="password" path="passwordCheck" placeholder = "パスワード" /></td>
	     </tr>
 	</table>
       <div class="button">
	       <input type="submit" name="back" value="キャンセル">
	       <input type="submit" name="go" value="登録">
	       </div>
	   </form:form>
    </body>
</html>