<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<script>
$(function(){
	$("button").click(function(){
		location.href="/admin/product/registform"; //글쓰기 폼 요청
	});
});
</script>
</head>
<body>

<%@ include file="../inc/main_navi.jsp" %>

<h3>상품목록</h3>
<p>
	<table>
		<tr>
			<th>No</th>
			<th>이미지</th>
			<th>카테고리명</th>
			<th>상품명</th>
			<th>가격</th>
			<th>브랜드</th>
		</tr>
		
		<tr>
			<td colspan="6">
				<button>상품등록</button>
			</td>
		</tr>
	</table>	
</p>

</body>
</html>