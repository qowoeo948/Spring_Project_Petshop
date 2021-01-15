<%@page import="com.koreait.petshop.model.common.Pager"%>
<%@page import="com.koreait.petshop.model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
   List<Product> productList =(List)request.getAttribute("productList");

   Pager pager = new Pager();
   pager.init(request,productList);   //페이지에 대한 계산
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../../shop/inc/header.jsp" %>
<style type="text/css">
table {
   border-collapse: collapse;
   border-spacing: 0;
   width: 100%;
   border: 1px solid #ddd;
   border-radius: 9px;
}

th, td {
   text-align: left;
   padding: 16px;
}

tr:nth-child(even) {
   background-color: #f2f2f2;
}
   .pageNum{
   font-size:15pt;
   color:red;
   font-weight:bold;
}

      .container2 {
        border-radius: 20px;
        background-color: white;
        padding: 20px;
        overflow: hidden;
        margin:20px 100px 20px 100px;   /*위오아왼*/
      }
</style>
<script>


function regist(){
    location.href="/admin/product/registform"; //글쓰기 폼 요청
   
}
   
</script>
</head>
<body>

<%@ include file="../../shop/inc/top.jsp" %>

<h3 style="text-align:center">상품목록</h3>
<div class="container2">
   <table>
      <tr>
         <th>No</th>
         <th>이미지</th>
         <th>카테고리명</th>
         <th>상품명</th>
         <th>가격</th>
         <th>상품삭제</th>
         <th>히트상품</th>
      </tr>
       <%int num = pager.getNum(); %>
     <%int curPos = pager.getCurPos(); %>
      <%for(int i=1;i<=pager.getPageSize();i++){%>
       <%if(num<1) break; %>
      <%Product product = productList.get(curPos++); %>
      <tr>
         <td><%=num-- %></td>
         <td><img src="/resources/pro/basic/<%=product.getProduct_id()%>.<%=product.getFilename()%>" width="50px"></td>
         <td><%=product.getSubCategory().getName() %></td>
         <td><%=product.getProduct_name() %></td>
         <td><%=product.getPrice() %></td>
         <td><a href="/admin/product/delete?product_id=<%=product.getProduct_id() %>">상품삭제</a></td>
         <%if(product.getHit()==1){ %>
         <td>
         ★
         </td>
         <%}else{ %>
         <td>
         ☆
         </td>
         <%} %>
      </tr>
      <%}%>
      <tr>
      <td colspan="7" style="text-align:center">

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
         <td colspan="7" style="text-align:center">
            <button onClick="regist()">상품등록</button>
         </td>
      </tr>
   </table>   
</div>
<%@ include file="../../shop/inc/footer.jsp" %>
<%@ include file="../../shop/inc/footerscript.jsp" %>
</body>
</html>