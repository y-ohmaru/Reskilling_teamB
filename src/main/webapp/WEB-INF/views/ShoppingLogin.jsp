<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お客様ログイン画面</title>
</head>
<body>
　　<div class="mx-auto" style="width: 300px;">
   <h2 class="mb-3" style="text-align: center">登録済みのお客様</h2>
	<div>
	<form method="post" action="/login">
		<label>ユーザーID</label>
        <input type="text" /><br/>
        <br />
        <label>パスワード</label>
        <input type="password" /><br/>
        <br />
        <button class="btn btn-primary" type="submit">ログイン</button>

	  <div>
	 	<h2 class="mb-3" style="text-align: center">登録がお済でないお客様</h2>
	 	<button type="submit" class="btn btn-primary">新規会員登録</button>
	 	</div>
  </body>
 </html>