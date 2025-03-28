import java.sql.*;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/your_database"; 
        String user = "your_username"; 
        String password = "your_password"; 

        
        String query = "SELECT EmpID, Name, Salary FROM Employee";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            
            Statement stmt = conn.createStatement();

            
            ResultSet rs = stmt.executeQuery(query);

            
            System.out.println("EmpID | Name | Salary");
            System.out.println("----------------------");
            while (rs.next()) {
                int empID = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empID + " | " + name + " | " + salary);
            }

           
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found! " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
