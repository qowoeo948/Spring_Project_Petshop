<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
<style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=button]:hover {
  background-color: #45a049;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
/*드래드 관련 */
#dragArea{
	width:100%;
	height:300px;
	overflow:scroll;
	border:1px solid #ccc;
}
.dragBorder{
	background:#ffffff;
}
.box{
	width:100px;
	float:left;
	padding:5px;
}
.box > img{
	width:100%; 
}
.close{
	color:red;
	cursor:pointer;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<%@ include file="../inc/main_navi.jsp" %>

<h3>Contact Form</h3>
<div class="container">
   <form>
 
  	<select>
  		<option>상위카테고리 선택</option>
  	</select>
  	
  	<select>
  		<option>하위카테고리 선택</option>
  	</select>
    <input type="text" name="product_name" placeholder="상품명">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="brand" placeholder="브랜드">
	<!-- 파일 최대 4개까지 지원 -->
	<p>대표이미지: <input type="file"  name="repImg"></p>
	
	<div id="dragArea"></div>
	<!-- 지원 사이즈 선택  -->
	<p>
		XS<input type="checkbox" 	name="size" value="XS">
		S<input type="checkbox" 		name="size" value="S">
		M<input type="checkbox" 		name="size" value="M">
		L<input type="checkbox" 		name="size" value="L">
		XL<input type="checkbox" 	name="size" value="XL">
		XXL<input type="checkbox" 	name="size" value="XXL">
	</p>
	
	<p>
		<input type="color" name="color[0].picker" value="#ccfefe">
		<input type="color" name="color[1].picker" value="#ffffff">
		<input type="color" name="color[2].picker" value="#000000">
		<input type="color" name="color[3].picker" value="#fdfdfd">
		<input type="color" name="color[4].picker" value="#0000ff">
		<input type="color" name="color[5].picker" value="#ff0000">
	</p>	
    
    <textarea id="detail" name="detail" placeholder="상세정보.." style="height:200px"></textarea>
    <input type="button" value="글등록" onClick="regist()">
    <input type="button" value="목록보기" onClick="location.href='/client/notice/list'">
  </form>
</div>

</body>
</html>