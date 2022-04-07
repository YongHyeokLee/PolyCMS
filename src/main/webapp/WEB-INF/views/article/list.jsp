<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>${boardId} 목록</h3>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>조회수</th>		
						<th>관리</th>					
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<th colspan="3">등록 된 게시물이 없습니다</th>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.articleId}</td>
							<td><a href="view/${item.articleId}">${item.subject}</a></td>		
							<td>${item.viewCount}</td>
							<td><a href="update/${item.articleId}">변경</a> <a href="delete/${item.articleId}">삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="4">
							<div>
								<div><a href="?page=1">처음</a></div>
								<div><a href="?page=${pager.prev}">이전</a></div>
														
								<c:forEach var="page" items="${pager.list}">  <!--${page} 리스트에서 임시로 가져오는 페이지 -->
									<div><a href="?page=${page}">${page}</a></div>
								</c:forEach>
		
								<div><a href="?page=${pager.next}">다음</a></div>
								<div><a href="?page=${pager.last}">마지막</a></div>
							</div>
						</td>
					</tr>
				</tfoot>
				
			</table>
			
		</div>
		<div>
			<div>
				<a href="dummy">대량추가</a>
			</div>
			<div>
				<a href="add">추가 </a>
			</div>
			<div>
				<a href="init">초기화</a>
			</div>
		</div>
		
	</div>
</body>
</html>