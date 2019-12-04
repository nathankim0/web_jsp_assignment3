<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kpu.book.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" href="resources/book.css" type="text/css"></link>
</head>
<body>
	<header>Book Update</header>
	<HR>
	<div align="center">
		<a href="http://localhost:8080/jinyeob_free/welcome.html"
			target="_self">메인페이지 이동</a>
		<form
			action="http://localhost:8080/jinyeob_free/BookServlet?key=update"
			method="post">

			<c:set var="book" value="${requestScope.book}" />

			<fieldset>
				<legend>Book Info</legend>
				<ul>
					<li>책번호 : <input type="number" name="bookNo"
						value="${book.bookNo}" readonly></li>
					<li>책이름 : <input type="text" name="bookname"
						value="${book.bookName}" autofocus></li>
					<li>작가 : <input type="text" name="author"
						value="${book.author}"></li>
					<li>대출여부 : <input type="radio" name="ischeck" value="0"
						checked> X <input type="radio" name="ischeck" value="1">
						O
					</li>
					<li>대출일 : <input type="date" name="checkDay"
						value="${book.checkDay}"></li>
				</ul>
			</fieldset>
			<br>
			<fieldset>
				<input type="submit" name="submit" value="최종 수정"> <input
					type="reset" name="reset" value="다시 작성">
			</fieldset>

		</form>

	</div>
</body>
</html>