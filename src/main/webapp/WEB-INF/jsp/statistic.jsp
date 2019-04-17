<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" 
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
		crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" 
	crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
	crossorigin="anonymous"></script>
<title>Main</title>
</head>
     <body class="bg-light">
    
    		<nav class="navbar navbar-dark bg-dark">
  
    			<img style="width:100px"  class="p-3" src="https://aily.team/img/about_logo.png">
    			<a class="float-right" href="/">Home</a>
    		</nav>
    <div class="row m-3">
    <div class="col-md-12">		
     <table class="table table-striped table-dark table-bordered ">
     <thead>
     	<th class="text-center">Link ID</th>
     	<th class="text-center">Short URL</th>
     	<th class="text-center">Long URL</th>
     	<th class="text-center">Date of redirection</th>
     	<th class="text-center">Referrer</th>
     	<th class="text-center">IP</th>
     	<th class="text-center">Browser</th>
     </thead>
      <c:forEach var="stat" items="${stats}">
       <tr>
        <td>${stat.lId}</td>
        <td>${stat.shortUrl}</td>
        <td style="word-break: break-all">${stat.longUrl}</td>
        <td>${stat.date}</td>
        <td>${stat.referer}</td>
        <td>${stat.ip}</td>
        <td>${stat.browser}</td>
       </tr>
      </c:forEach>
     </table>
     </div>
     </div>
    </body>
</html>