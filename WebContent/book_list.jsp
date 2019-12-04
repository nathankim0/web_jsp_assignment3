<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kpu.book.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book list</title>
<link rel="stylesheet" href="resources/book.css" type="text/css"></link>
</head>
<body>
	<header>Book List</header>
	<hr>

	<div align="center">
		<a href="http://localhost:8080/jinyeob_free/welcome.html"
			target="_self">메인페이지 이동</a>
		<table>
			<tr>
				<td>책번호</td>
				<td>책이름</td>
				<td>작가</td>
				<td>대출여부</td>
				<td>대출일</td>
				<td>수정</td>
				<td>삭제</td>

				<c:set var="bookList" value="${requestScope.bookList}" />
				<c:forEach var="vo" items="${bookList}">


					<tr>
						<td>${vo.bookNo}</td>
						<td>${vo.bookName}</td>
						<td>${vo.author}</td>
						<td>${vo.isCheck}</td>
						<td>${vo.checkDay}</td>
						<td><a
							href="http://localhost:8080/jinyeob_free/BookServlet?key=update&id=${vo.bookNo}"
							target="_self">수정</a></td>
						<td><a
							href="http://localhost:8080/jinyeob_free/BookServlet?key=delete&id=${vo.bookNo}"
							target="_self">삭제</a></td>
					</tr>
				</c:forEach>
		</table>

	</div>
</body>
</html>