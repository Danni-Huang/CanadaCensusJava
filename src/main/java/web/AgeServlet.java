package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtil;
import entity.Age;

@WebServlet("/AgeServlet")
public class AgeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            // Retrieve geographic area details using DBUtil
        	List<Age> ageList = DBUtil.getAgeList();
        	System.out.println("----age----" + ageList);
            
            // Set the geographic area object as an attribute of the request
            request.setAttribute("ageList", ageList);
            
            // Forward to the JSP for rendering
            request.getRequestDispatcher("/ageList.jsp").forward(request, response);
        } catch (NumberFormatException | SQLException e) {
            // Handle exceptions
            e.printStackTrace(); // Or log the exception
            // Redirect to an error page or display an error message to the user
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
