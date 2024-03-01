package web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBUtil;

@WebServlet("/GeographicAreaServlet")
public class GeographicAreaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            // Retrieve the level parameter from the request
            int level = Integer.parseInt(request.getParameter("level"));

            // Fetch data from the database based on the level
            List<String> geographicAreas = DBUtil.getGeographicArea(level);
            System.out.println("--------" + geographicAreas);
            
            // Set the fetched data as an attribute in request scope
            request.setAttribute("geographicAreas", geographicAreas);
            
            // Assuming you have a method to get the selected areas based on the request parameters
            request.setAttribute("selectedAreas", geographicAreas);
            System.out.println("----selected----" + geographicAreas);
            
            // Forward the request to a JSP page for rendering
            request.getRequestDispatcher("geographicAreaList.jsp").forward(request, response);
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace(); // Or log the exception
            // Redirect to an error page or display an error message to the user
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}

