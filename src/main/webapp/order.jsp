<%@page import="com.virtualpairprogrammers.domain.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="com.virtualpairprogrammers.data.MenuDaoFactory"%>
<%@page import="com.virtualpairprogrammers.data.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place an order</title>
</head>
 
<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<h2>Order your food</h2>

	<form action='orderReceived.html' method='POST'>



		<%
		
		List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");
		for (MenuItem menuItem : menuItems) {
			out.println("<li>" + menuItem + "<input type='text' name='item_" +menuItem.getId() +"' /> </li>");
		}
		%>
		</ul>
		<input type='submit' />
	</form>

	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>