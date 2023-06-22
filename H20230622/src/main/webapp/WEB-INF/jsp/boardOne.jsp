<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>boardOne.jsp</title>
</head>

<body>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("board");
	%>

	<%
		if (vo == null) {
	%>
	<p>조회된 결과가 없습니다.</p>
	<%
		} else {
	%>
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=vo.getBrdTitle() %>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=vo.getBrdWriter() %>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="10"><%=vo.getBrdContent() %></textarea></td>
		</tr>
	</table>
	<%
		}
	%>
	<a href="boardForm.do">등록화면으로</a>
</body>

</html>