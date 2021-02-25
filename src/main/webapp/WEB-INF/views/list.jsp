<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>list</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous" />
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.2/dist/bootstrap-table.min.css" />
</head>
   
</head>
<body>
    <table class="table">
    <thead>
       <tr>
          <td scope="col">번호</td>
          <td scope="col">이름</td>
          <td scope="col">제목</td>
          <td scope="col">날짜</td>
          <td scope="col">조회수</td>
       </tr>
       <thead>
       <c:forEach items="${list}" var="vo">
       <tbody>
       <tr>
          <td scope="row">${vo.bid}</td>
          <td>${vo.bname}</td>
          <td>
             <c:forEach begin="1" end="${vo.bindent}">[re]</c:forEach>
             <a href="content_view?bid=${vo.bid}">${vo.btitle}</a>
          </td>
          <td>${bdate}</td>
          <td>${bhit}</td>
       </tr>
       </tbody>
       </c:forEach>
       <tr>
       <td scope="row" colspan="5"><a href="write_view">글작성</a></td>
       </tr>
    </table>
    
    	<c:if test="${pageMaker.prev}">
			<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }"
			end="${pageMaker.endPage }" var="idx">
			<c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
			<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }">
				» </a>
		</c:if>
		<br>


		<form id="actionForm" action="/board/list" method="get">
			<input type='hidden' name='pageNum'
				value='${apgeMaker.cri.pageNum}'> <input type='hidden'
				name='amount' value='${apgeMaker.cri.amount}'>
		</form>
		<!-- End of Pagination -->
</body>
</html>