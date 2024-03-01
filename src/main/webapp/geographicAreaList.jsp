<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Geographic Area Classification List</title>
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
	
	ul {
	    list-style-type: none;
	    padding: 0;
	}
	
	li {
	    padding: 5px 0;
	    border-bottom: 1px solid #ddd;
	}
	
	/* Hover effect for list items */
	li:hover {
	    background-color: #f9f9f9;
	}
    
</style>
</head>
<body>
	<button class="button" onclick="location.href='MainMenu.jsp'">Main Menu</button>
    <div class="container">
        <h2>Geographic Area Classification List</h2>
       
        <a href="GeographicAreaServlet?level=0" class="button">0 - The country of Canada</a>
        <a href="GeographicAreaServlet?level=1" class="button">1 - Provinces and Territories</a>
        <a href="GeographicAreaServlet?level=2" class="button">2 - Census metropolitan areas (CMA) and census agglomerations (CA)</a>
        <a href="GeographicAreaServlet?level=3" class="button">3 - One CMA and three CAs are divided between adjacent provinces</a>
    </div>
    
    <% List<String> selectedAreas = (List<String>) request.getAttribute("selectedAreas");
       if (selectedAreas != null && !selectedAreas.isEmpty()) { %>
        <h2>Selected Geographic Area</h2>
        <ul>
            <% for (String area : selectedAreas) { %>
                <li><%= area %></li>
            <% } %>
        </ul>
    <% } %>
     
</body>
</html>
