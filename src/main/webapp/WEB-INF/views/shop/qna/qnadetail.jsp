<%@page import="com.koreait.petshop.model.domain.Board"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>
	<%@ include file="../inc/header.jsp" %>
	
	<style type="text/css">
	body {font-family: Arial, Helvetica, sans-serif;}
	* {box-sizing: border-box;}
		
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
		
		input[type=button:hover {
		  background-color: #45a049;
		}
		
		.container {
		  border-radius: 5px;
		  background-color: #f2f2f2;
		  padding: 20px;
		}
	
	</style>
<script type="text/javascript">
	$(function(){
		CKEDITOR.replace("content"); //textarea의 id가 content인 컴포넌트를 편집기 스킨으로 변경
		
		$($("input[type='button']")[0]).click(function(){
			edit();
		});
		$($("input[type='button']")[1]).click(function(){
			del();
		});
		
		getCommentList(); //댓글 목록 비동기로 가져오기!!!
	});
	//글등록 요청
	function 	edit(){
		if(confirm("수정하시겠어요?")){
		$("#formData").attr({
			action:"/shop/qna/edit",
			method:"post"
		});		
		$("#formData").submit();
		}
	}
	
	function 	del(){
		if(confirm("삭제하시겠어요?")){
			
		$("#formData").attr({
			action:"/shop/qna/delete",
			method:"get"	//form태그 안에 있는 히든값인 board_id가 전송됨
		});		
		$("#formData").submit();
		}
	}
	
</script>


</head>

<body>
    	<%@include file="../inc/top.jsp" %>
        <!-- ****** Top Discount Area End ****** -->
	<h3>Detail Form</h3>

<div class="container">
  <form id="formData">
  	
    <input type="hidden" name="board_id" value="<%=board.getBoard_id()%>">
    <input type="hidden" name="hit" value="<%=board.getHit()%>" >
    <input type="text" name="title" value="<%=board.getTitle()%>" readonly>
    <input type="text" name="writer" value="<%=board.getWriter()%>" readonly>
    <textarea id="content" name="content" style="height:200px" readonly><%=board.getContent() %></textarea>
    
    <input type="button" value="글수정">
    <input type="button" value="글삭제">
    <input type="button" value="목록보기" onClick="location.href='/shop/qna/list'">
	<div class="reply-box">
		<input type="text" name="msg" placeholder="댓글 입력.." style="width:75%">
		<input type="text" name="author" placeholder="작성자 입력.." style="width:15%">
		<button type="button" onClick="registComment()">댓글등록</button>
	</div> 
	<div id="list-area"></div>	   
  </form>
</div>
        <!-- ****** Footer Area Start ****** -->
        <%@ include file="../inc/footer.jsp" %>
        <!-- ****** Footer Area End ****** -->
    <!-- /.wrapper end -->
</body>

</html>