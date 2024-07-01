<!--
-----------トップメニュー画面--------------
作業日：6/13
作業者：伊藤
内容： 商品画像を３つ表示
-------------------------------------------
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ショッピングサイト</title>
<style>

.image-margin{
   text-align: center;
}
.image-margin img{
   display: inline-block;
   box-shadow: 0 0 10px #333;
   margin-right: 50px;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp" />
   <hr color="#3399FF" size="5">
   <br>
  <div class="image-margin">
        <img src="${pageContext.request.contextPath}/resources/image/bed003.png" width="400" height="300" alt="ベッド">
        <img src="${pageContext.request.contextPath}/resources/image/chair002.png" width="400" height="300" alt="椅子">
        <img src="${pageContext.request.contextPath}/resources/image/table002.png" width="400" height="300" alt="テーブル">
    </div>
   <br>
   <hr color="#3399FF" size="5">
</body>
</html>