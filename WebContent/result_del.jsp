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

	<header>Delete Result</header>
	<hr>
	<div align="center">

		<a href="http://localhost:8080/jinyeob_free/BookServlet?key=list"
			target="_self">도서 목록 </a>
		<p id="sect">${requestScope.message}<br>
	</div>
</body>
</html>