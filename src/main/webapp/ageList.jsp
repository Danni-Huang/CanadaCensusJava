<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Age" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Age List</title>
<style>
	 body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }
    .container {
        margin-top: 50px;
    }
    h2 {
        color: #333;
    }
    .button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 8px;
        transition: background-color 0.3s ease;
    }
    
    .button:hover {
        background-color: #45a049;
    } 
    
	/* Hover effect for list items */
	li:hover {
	    background-color: #f9f9f9;
	}
	table {
	    width: 100%;
	    border-collapse: collapse;
	}
	
	th, td {
	    padding: 8px;
	    text-align: left;
	    border-bottom: 1px solid #ddd;
	}
	
	tr:hover {
	    background-color: #f9f9f9;
	}
</style>
</head>
<body>
	<button class="button" onclick="location.href='MainMenu.jsp'">Main Menu</button>
	<div class="container">
        <h2>Age List</h2>
       
        <a href="AgeServlet" class="button">Age List</a>
    </div>

<%-- For a given 2016 and 2021 Canada Census year Canada-wide population separated by male and female --%>
  <% List<Age> age = (List<Age>) request.getAttribute("ageList");  
  		if (age != null && !age.isEmpty()) { %>
       <table>
           <thead>
               <tr>
                   <th>Census Year</th>
                   <th>Male Population</th>
                   <th>Female Population</th>
               </tr>
           </thead>
           <tbody>
               <% for (Age area : age) { %>
                   <tr>
                       <td><%= area.getCensusYear() %></td>
                       <td><%= area.getMale() %></td>
                       <td><%= area.getFemale() %></td>
                   </tr>
               <% } %>
           </tbody>
       </table>
    <% } %>

</body>
</html>