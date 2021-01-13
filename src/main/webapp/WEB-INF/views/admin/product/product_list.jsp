<%@page import="com.koreait.petshop.model.common.Pager"%>
<%@page import="com.koreait.petshop.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
   List<Product> productList =(List)request.getAttribute("productList");

	Pager pager = new Pager();
	pager.init(request,productList);	//페이지에 대한 계산
%>
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
<style type="text/css">
	.pageNum{
	font-size:15pt;
	color:red;
	font-weight:bold;
}
</style>
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
      </tr>
       <%int num = pager.getNum(); %>
	  <%int curPos = pager.getCurPos(); %>
      <%for(int i=1;i<=pager.getPageSize();i++){%>
       <%if(num<1) break; %>
      <%Product product = productList.get(curPos++); %>
      <tr>
         <td><%=num-- %></td>
         <td><img src="/resources/data/basic/<%=product.getProduct_id()%>.<%=product.getFilename()%>" width="50px"></td>
         <td><%=product.getSubCategory().getName() %></td>
         <td><%=product.getProduct_name() %></td>
         <td><%=product.getPrice() %></td>
      </tr>
      <%}%>
      <tr>
		<td colspan="5" style="text-align:center">

	<%if((pager.getFirstPage()-1)>=1){   //페이지가 있다면%> 
		<a href="/admin/product/list?currentPage=<%=pager.getFirstPage()-1%>">◀</a>
		<%}else{ %>
		<a href="javascript:alert('처음 페이지입니다');">◀</a>
		<%} %>
		
			<%for(int i=pager.getFirstPage();i<=pager.getLastPage();i++){ %>
				<%if(i>pager.getTotalPage()) break; //페이지를 출력하는i가 총페이지수에 도달하면 반복문 탈출 %>
			<a href="/admin/product/list?currentPage=<%=i%>" <%if(pager.getCurrentPage()==i){ %> class="pageNum" <%} %>>[<%=i %>]</a>
			
			<%} %>
			<%if((pager.getLastPage()+1)<pager.getTotalPage()){ %>
			<a href="/admin/product/list?currentPage=<%=pager.getLastPage()+1%>">▶</a>
			<%}else{ %>
				<a href="javascript:alert('마지막 페이지입니다');">▶</a>		
				<%} %>		
		</td>
	</tr>
      <tr>
         <td colspan="6" style="text-align:center">
            <button>상품등록</button>
         </td>
      </tr>
   </table>   
</p>

</body>
</html>