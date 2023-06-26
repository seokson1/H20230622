<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 	<%
	BoardVO vo = (BoardVO) request.getAttribute("board");
	%> --%>

	<h3>수정화면(boardModify)</h3>
	<form action="boardModify.do" method="post">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td><input readonly name="no" value="${board.brdNo }"></td>
				<th>조회수</th>
				<td>${board.clickCnt }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input name="title"
					value="${board.brdTitle }"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content" cols="45" rows="3">${board.brdContent }></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.brdWriter }</td>
				<th>작성일자</th>
				<td>${board.createDate }</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
<jsp:include page="footer.jsp"></jsp:include>