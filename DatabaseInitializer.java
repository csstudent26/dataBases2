

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/databaseInitializer")
public class DatabaseInitializer extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "irelander26";
    private static final String DB_NAME = "hotel_database2";
    
    @Override
   /* public void init() throws ServletException {
        createDatabase();
        createGuestsTable();
        
        String name = "Harper";
        int age = 25;
        insertData(name, age);

    }*/ 
    
    public void init() throws ServletException {
        createDatabase();
        createGuestsTable();
        
        String checkInDate = "2023-07-15";
        String checkOutDate = "2023-07-20";
        String roomType = "double";
        int guests = 2;
        String name = "Harper";
        String email = "harper@example.com";
        String phone = "123456789";
        
        insertData(checkInDate, checkOutDate, roomType, guests, name, email, phone);
    }


    private void createDatabase() {
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connecy with data base");
			e1.printStackTrace();
		}
    	
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            statement.executeUpdate(sql);

            System.out.println("Database created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }// End of Create Database
    
    void createGuestsTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.out.println("Failed to connect with the database");
            e1.printStackTrace();
            return; // Stop execution if failed to load the driver
        }

        try (Connection connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS bookings (id INT AUTO_INCREMENT PRIMARY KEY, check_in_date DATE, check_out_date DATE, room_type VARCHAR(255), guests INT, name VARCHAR(255), email VARCHAR(255), phone VARCHAR(255))";
            statement.executeUpdate(sql);

            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   /* void createGuestsTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connecy with data base");
			e1.printStackTrace();
		}

        try (Connection connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS crowd (name VARCHAR(255), age INT)";
            statement.executeUpdate(sql);

            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//End of Create Table*/
    
    
  /*  private void insertData(String name, int age) {
        try (Connection connection = DriverManager.getConnection(DB_URL +DB_NAME , DB_USERNAME, DB_PASSWORD)){
        	 
            String sql = "INSERT INTO crowd (name, age) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setInt(2, age);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    private void insertData(String checkInDate, String checkOutDate, String roomType, int guests, String name, String email, String phone) {
        try (Connection connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD)) {

            String sql = "INSERT INTO bookings (check_in_date, check_out_date, room_type, guests, name, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, checkInDate);
                statement.setString(2, checkOutDate);
                statement.setString(3, roomType);
                statement.setInt(4, guests);
                statement.setString(5, name);
                statement.setString(6, email);
                statement.setString(7, phone);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  /*  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request here
        response.setContentType("text/html");
       
        PrintWriter out = response.getWriter();

        // Output the HTML content
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Database Initializer</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/Css26/stylesheet7.css\">");


        

        out.println("</head>");
        out.println("<body>");
        response.getWriter().println("<h1>Database Initializer</h1>");
        response.getWriter().println("<p>Please use the appropriate methods to initialize the database.</p>");
        
        
        
        out.println("<form method='POST'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Age: <input type='text' name='age'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        
        // Display the image
        out.println("<img src='Images/Hotel.jpg' alt='Your Image'>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }*/
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request here
        response.setContentType("text/html");
       
        PrintWriter out = response.getWriter();

        // Output the HTML content
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Database Initializer</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Css26/stylesheet8.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
    //    response.getWriter().println("<h1>Database Initializer</h1>");
        out.println("<h1 style='letter-spacing: 14px;>WILLKOMMEN IM HOTEL AM IRISCHEN SEE</h1>");

        response.getWriter().println("<p>Please use the appropriate methods to initialize the database.</p>");
        
        out.println("<img src='Images/Hotel.jpg' alt='Your Image'>");
        
       
        out.println("<form method='POST'>");
        out.println("<label for='check-in-date'>Check-in Date:</label>");
        out.println("<input type='date' id='check-in-date' name='check-in-date' required>");

        out.println("<label for='check-out-date'>Check-out Date:</label>");
        out.println("<input type='date' id='check-out-date' name='check-out-date' required>");

        out.println("<label for='room-type'>Room Type:</label>");
        out.println("<select id='room-type' name='room-type' required>");
        out.println("<option value=''>Select Room Type</option>");
        out.println("<option value='single'>Single Room</option>");
        out.println("<option value='double'>Double Room</option>");
        // Add more room type options as needed
        out.println("</select>");

        out.println("<label for='guests'>Number of Guests:</label>");
        out.println("<input type='number' id='guests' name='guests' required>");

        out.println("<label for='name'>Your Name:</label>");
        out.println("<input type='text' id='name' name='name' required>");

        out.println("<label for='email'>Email Address:</label>");
        out.println("<input type='email' id='email' name='email' required>");

        out.println("<label for='phone'>Phone Number:</label>");
        out.println("<input type='tel' id='phone' name='phone' required>");

        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

       
       
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }


  /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request here
      //  doGet(request, response);
        
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        insertData(name, age);
        
        // Redirect the user back to the form page
        response.sendRedirect(request.getContextPath() + "/databaseInitializer");
    }*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request here
        // doGet(request, response);

        String checkInDate = request.getParameter("check-in-date");
        String checkOutDate = request.getParameter("check-out-date");
        String roomType = request.getParameter("room-type");
        int guests = Integer.parseInt(request.getParameter("guests"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        insertData(checkInDate, checkOutDate, roomType, guests, name, email, phone);

        // Redirect the user back to the form page
        response.sendRedirect(request.getContextPath() + "/databaseInitializer");
    }

}
