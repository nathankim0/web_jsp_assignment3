<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kpu.book.domain.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
<link rel="stylesheet" href="resources/book.css" type="text/css"></link>
</head>
<body>
	<header>Memo List</header>
	<hr>
	<div align="center">
		<a href="http://localhost:8080/jinyeob_free/welcome.html"
			target="_self">메인페이지 이동</a>
		<%
			List<BookVO> MemoList = (List<BookVO>) request.getAttribute("memoList");
			for (BookVO vo : MemoList) {
		%>
		<table>
			<tr>
				<td><%=vo.getMemo()%></td>
				<td><a
					href="http://localhost:8080/jinyeob_free/BookServlet?key=memoDel&id=<%=vo.getMemo()%>"
					target="_self">삭제</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>