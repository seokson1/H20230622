<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl2.jsp</title>
</head>
<body>
	<c:import url="jutl1.jsp"></c:import>
	<%
	if (30 > 20) {
	} else {
	}
	%>
	<c:if test="${30>20 }">
		<p>true</p>
	</c:if>
	<c:set var="score" value="50"></c:set>
	<c:out value="${score }"></c:out>

	<c:choose>
		<c:when test="${score>20 }">
			<p>값이 참입니다.</p>
		</c:when>

		<c:otherwise>
			<p>값이 거짓입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<c:set var="mathScore" value="80"></c:set>
	
	<c:choose>
	<c:when test="${mathScpare>90 }">
	<p>A학점 입니다.</p>
	</c:when>
	<c:when test="${mathScore > 80)">
	<p>B학점 입니다.</p>
	</c:when>
	<c:when test="${mathScore > 70 }">
	<p>C학점 입니다.</p>
	</c:when>
	<c:otherwise>
	<p>F학점 입니다.
	</c:otherwise>
	</c:choose>
	
	<c:choose>
	<c:when test="${!empty loginId }">
	<p>이름: <c:out value="${loginName }"></c:out></p>
	</c:when>
	<c:otherwise>
	<p>손님입니다.</p>
	</c:otherwise>
	</c:choose>
</body>
</html>