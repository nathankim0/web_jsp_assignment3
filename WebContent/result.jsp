<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kpu.book.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
<link rel="stylesheet" href="resources/book.css" type="text/css"></link>
</head>
<body>
	<header>Result</header>
	<hr>
	<div align="center">

		<a href="http://localhost:8080/jinyeob_free/BookServlet?key=list"
			target="_self">도서 목록 </a>
		<p id="sect">${requestScope.message}<br>

			<c:set var="book" value="${requestScope.book}" />
		<table>
			<tr>
				<td>책번호</td>
				<td>책이름</td>
				<td>작가</td>
				<td>대출여부</td>
				<td>대출일</td>
			<tr>
				<td>${book.bookNo}</td>
				<td>${book.bookName}</td>
				<td>${book.author}</td>
				<td>${book.isCheck}</td>
				<td>${book.checkDay}</td>
			</tr>
		</table>
		<br>
	</div>
</body>
</html>