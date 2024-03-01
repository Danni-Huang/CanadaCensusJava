package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.GeographicArea;
import dao.DBUtil;

@WebServlet("/GeographicAreaDetailServlet")
public class GeographicAreaDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int level = Integer.parseInt(request.getParameter("level"));
        
        try {
            // Retrieve geographic area details using DBUtil
        	List<GeographicArea> geographicAreaDetails = DBUtil.getGeographicAreaDetails(level);
            
            // Set the geographic area object as an attribute of the request
            request.setAttribute("geographicArea", geographicAreaDetails);
            
            // Assuming you have a method to get the selected areas based on the request parameters
            request.setAttribute("selectedAreaDetail", geographicAreaDetails);
            for (GeographicArea g: geographicAreaDetails) {
            	System.out.println("----selectedDetails----" + g.getName());
            }
            
            // Forward to the JSP for rendering
            request.getRequestDispatcher("/geographicAreaDetail.jsp").forward(request, response);
        } catch (NumberFormatException | SQLException e) {
            // Handle exceptions
            e.printStackTrace(); // Or log the exception
            // Redirect to an error page or display an error message to the user
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
