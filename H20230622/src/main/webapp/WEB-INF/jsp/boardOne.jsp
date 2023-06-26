<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>상세화면 (boardOne.jsp).</h3>

<%-- 	<%
	BoardVO vo = (BoardVO) request.getAttribute("board");
	%> --%>
	
	
	
	<c:choose>
	<c:when test="${board == null }">
	${"조회된 결과가 없습니다." }
	</c:when>
	<c:otherwise>
	
	<form action="modifyForm.do" method="post" name="myFrm">
		<input type="hidden" name="bno" value="${board.brdNo}">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"
					value="${board.brdTitle }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"
					value="${board.brdWriter }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="30" rows="10">${board.brdContent }</textarea></td>
			</tr>
			<tr>
			
				<td colspan="2" align="center">
				
				<c:if test="${board.brdWriter eq loginId  }">
					<button type="submit">수정</button>
					<button type="button">삭제</button>
				</c:if>
				<c:if test="${loginId == null or board.brdWriter ne loginId  }">
					<button type="submit" disabled>수정</button>
					<button type="button" disabled>삭제</button>
				</c:if>
			</tr>
		</table>
	</form>
	</c:otherwise>
	</c:choose>
	<a href="boardList.do">목록화면으로</a>

	<script>
	console.log(this);
		document.querySelector('form[name="myFrm"] button[type="button"]').addEventListener('click',function(e) {
			console.log(e);
			document.forms[0].action = "boardRemove.do";
			document.forms[0].submit();
			
			//window.location.href = "boardRemove.do?bno=3&title-???&";
		});
	</script>
<jsp:include page="footer.jsp"></jsp:include>