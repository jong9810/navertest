<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<script src="/js/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function() {
	
}); // ready
</script>
</head>
<body>
<h3>검색창</h3>
<form action="boardsearchlist">
	<select name="item">
		<option value="all">모두</option>
		<option value="title">제목</option>
		<option value="contents">내용</option>
		<option value="writer">작성자</option>
	</select>
	<input type="text" name="word" />
	<input type="submit" value="검색" />
</form>
<h1>게시물 리스트</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${boardList}" var="one">
		<tr>
			<td>${one.seq}</td>
			<td><a href="boarddetail?seq=${one.seq}">${one.title}</a></td>
			<td>${one.writer}</td>
			<td>${one.viewcount}</td>
		</tr>
	</c:forEach>
</table>
<h3>페이지를 선택하세요.</h3>
<%
	int totalBoard = (int) request.getAttribute("totalBoard");
	int[] limit = (int[]) request.getAttribute("limit"); 
	int count = limit[1]; // 한 페이지당 게시글 개수
	int totalPage = totalBoard / count;
	if (totalBoard % count != 0) {
		totalPage += 1;
	} 
	
	for (int i = 1; i <= totalPage; i++) { %>
		<a id="<%=i %>page" href="boardlist?page=<%=i %>"><%=i %>페이지</a>
<% } %>
</body>
</html>