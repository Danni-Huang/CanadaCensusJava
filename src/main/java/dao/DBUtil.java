package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Age;
import entity.GeographicArea;


public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/canadacensusdb";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
//		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static List<String> getGeographicArea(int level) throws ClassNotFoundException, SQLException {
        String query = "SELECT name, level FROM geographicarea WHERE level = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, level);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> result = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int areaLevel = resultSet.getInt("level");
                result.add(name + " (Level " + areaLevel + ")");
            }
            return result;
        }
    }
	
	public static List<GeographicArea> getGeographicAreaDetails(int level) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<GeographicArea> geographicAreaDetail = new ArrayList<>();

        try {
			conn = getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql = "SELECT name, code, level, SUM(combined) AS total_population " +
                     "FROM geographicarea ga " +
                     "JOIN age ag ON ga.geographicAreaID = ag.geographicArea " +
                     "JOIN censusyear cy ON ag.censusYear = cy.censusYearId " +
                     "WHERE ga.level = ? AND cy.censusYear = 2021 " +
                     "GROUP BY name, code, level";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, level);
        rs = pstmt.executeQuery();
             
        while (rs.next()) {
        	 GeographicArea geographicArea = new GeographicArea();
	    	 geographicArea.setName(rs.getString("name"));
	         geographicArea.setCode(rs.getInt("code"));
	         geographicArea.setLevel(rs.getInt("level"));
	         geographicArea.setCombined(rs.getInt("total_population"));
	         geographicAreaDetail.add(geographicArea);
        }

        return geographicAreaDetail;
    }
	
	public static List<Age> getAgeList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Age> ageList = new ArrayList<>();

        try {
			conn = getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql = "SELECT cy.censusyear, SUM(a.male) AS male_population, SUM(a.female) AS female_population " +
                     "FROM age a " +
                     "JOIN censusyear cy ON a.censusYear = cy.censusYearID " +
                     "WHERE cy.censusYear IN (2016, 2021) " +
                     "GROUP BY censusYear";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
             
        while (rs.next()) {
        	 Age age = new Age();
        	 age.setCensusYear(rs.getInt("censusyear"));
        	 age.setMale(rs.getInt("male_population"));
        	 age.setFemale(rs.getInt("female_population"));
	         ageList.add(age);
        }

        return ageList;
    }
}
