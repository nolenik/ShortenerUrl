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
    <div class="row">	    	
    		<div class="card p-4 offset-4 col-md-4 mt-4">
		     <form:form method="POST"   modelAttribute = "link" action="${link.id}">	
		     	<div class="form-group">
    			  <label for="longUrl" class=" col-form-label">New long URL</label>	            
                  <form:input class="form-control " id="longUrl" type = "text" required="required" 
                   path = "longUrl"/></td>
                </div> 
                  <input  type="submit" class="btn btn-primary" value="Submit"/></td>		                    
		     </form:form>
		    </div> 
        </div>
     
    </body>
</html>