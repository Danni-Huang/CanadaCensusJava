<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
  <style>
  		body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
    	}
    
	    .container {
	        width: 300px;
	        margin: 0 auto;
	        padding: 20px;
	        background-color: #fff;
	        border-radius: 5px;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	    }
	    
	    h2 {
	        text-align: center;
	        margin-bottom: 20px;
	    }
	    
	    table {
	        margin: 0 auto;
	    }
	    
	    input[type="text"],
	    input[type="password"] {
	        width: calc(100% - 30px);
	        padding: 10px;
	        margin-bottom: 15px;
	        border: 1px solid #ccc;
	        border-radius: 3px;
	    }
	    
	    input[type="submit"],
	    input[type="reset"] {
	        width: calc(50% - 7px);
	        padding: 10px;
	        background-color: #28a745;
	        color: #fff;
	        border: none;
	        border-radius: 3px;
	        cursor: pointer;
	    }
	    
	    input[type="submit"]:hover,
	    input[type="reset"]:hover {
	        background-color: #218838;
	    }
        .message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="LoginServlet" method="post" align ="center">
 	<br></br>
	<h2>Log In</h2>
	<%
	    String error = request.getParameter("error");
	    if (error != null && !error.isEmpty()) {
	%>
	    <p class="message"><%= error %></p>
	<%
	    }
	%>
	 
     <table>			
       <tr>
         <td>UserName: </td>
         <td><input type="text" name="username"></td>
       </tr>
        <br></br>
       <tr>
         <td>Password: </td>
         <td><input type="password" name="password"></td>
       </tr>
     </table>
     
       <br></br>    
     <input type="submit" value="Login"/>
     <input type="reset" value="Clear"/>

   </form>

</body>
</html>