<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.GeographicArea" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Geographic Area Detail</title>
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
    
    /* Style for the Selected Areas section */
	h2 {
	    color: #333;
	    font-size: 1.5em;
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
        <h2>Geographic Area Classification List</h2>
       
        <a href="GeographicAreaDetailServlet?level=0" class="button">0 - The country of Canada</a>
        <a href="GeographicAreaDetailServlet?level=1" class="button">1 - Provinces and Territories</a>
        <a href="GeographicAreaDetailServlet?level=2" class="button">2 - Census metropolitan areas (CMA) and census agglomerations (CA)</a>
        <a href="GeographicAreaDetailServlet?level=3" class="button">3 - One CMA and three CAs are divided between adjacent provinces</a>
    </div>
    
 	
  <% List<GeographicArea> geographicAreaDetail = (List<GeographicArea>) request.getAttribute("selectedAreaDetail"); 
       if (geographicAreaDetail != null && !geographicAreaDetail.isEmpty()) { %>
       <h2>Geographic Area Detail</h2>
       <table>
           <thead>
               <tr>
                   <th>Name</th>
                   <th>Code</th>
                   <th>Level</th>
                   <th>Total Population</th>
               </tr>
           </thead>
           <tbody>
               <% for (GeographicArea area : geographicAreaDetail) { %>
                   <tr>
                       <td><%= area.getName() %></td>
                       <td><%= area.getCode() %></td>
                       <td><%= area.getLevel() %></td>
                       <td><%= area.getCombined() %></td>
                   </tr>
               <% } %>
           </tbody>
       </table>
    <% } %>
</body>
</html>