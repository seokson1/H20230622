<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>boardForm.jsp</title>
</head>

<body>
	<%
	String msg = (String) request.getAttribute("errorMsg");
	%>
	<%
	if (msg != null) {
	%>
	<p>
		메세지: <b><%=msg %></b>
	</p>
	<%
	}
	%>
	<h3>게시글 등록</h3>
	<form action="addBoard.do" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<th><input type="text" name="title"></th>
			</tr>
			<tr>
				<th>작성자</th>
				<th><input type="text" name="writer"></th>
			</tr>
			<tr>
				<th>내용</th>
				<th><textarea name="content" cols="30" rows="10"></textarea></th>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"> <input
					type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
	<a href="boardList.do">목록화면으로</a>
</body>

</html>