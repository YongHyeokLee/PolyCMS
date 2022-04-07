<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>사용자 목록</h3>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>성명</th>
						<th>가입일</th>
						<th>등급</th>			
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<th colspan="7">등록 된 게시판이 없습니다</th>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.id}</td>
							<td>${item.passwd}</td>
							<td>${item.name}</td>
							<td><fmt:formatDate value="${item.regDate}" pattern="yyyy년 mm월 dd일 HH:mm:ss"/></td>
							<td>${item.grade}</td>			
							<td><a href="update/${item.id}">변경</a> <a href="delete/${item.id}">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="add">추가</a>
		</div>
	</div>
</body>
</html>