// Student Management System using JDBC and MySQL
// Features:
// 1. Add Student
// 2. View Students
// 3. Update Student
// 4. Delete Student
// Author: Karuna
import java.sql.*;
import java.util.Scanner;
public class StudentManagement {

    public static void main(String[] args) {
// Scanner object for taking user input
        Scanner sc = new Scanner(System.in);
// Infinite loop to display menu until user exits
        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
// Perform operation based on user choice
            switch (choice) {
// Add a new student into database
               case 1:

    System.out.print("Enter ID: ");
    int id = sc.nextInt();

    sc.nextLine();

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Age: ");
    int age = sc.nextInt();

    try {
// Establish connection with MySQL database
        Connection con =
            DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                "root123");
// SQL query with placeholders
        PreparedStatement ps =
            con.prepareStatement(
                "INSERT INTO students VALUES (?, ?, ?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
// Execute INSERT query
        int rows = ps.executeUpdate();

        System.out.println(rows + " row inserted successfully!");

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }

    break;

      // Display all student records         
                   case 2:

    try {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db",
            "root",
            "root123"
        );

        Statement stmt = con.createStatement();
// Execute SELECT query and store result
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
// Iterate through each row of the result set
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getInt("age")
            );
        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }

    break;

 // Update age of a student using student ID
               
                   case 3:

try {

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student_db",
        "root",
        "root123"
    );

    System.out.print("Enter Student ID: ");
    int id1 = sc.nextInt();

    System.out.print("Enter New Age: ");
    int age1 = sc.nextInt();
// SQL UPDATE query
    String query =
        "UPDATE students SET age = ? WHERE id = ?";

    PreparedStatement ps =
        con.prepareStatement(query);

    ps.setInt(1, age1);
    ps.setInt(2, id1);

    int rows = ps.executeUpdate();

    System.out.println(
        rows + " row updated successfully!"
    );

    con.close();

} catch(Exception e) {
    System.out.println(e);
}

break;
// Delete student record using ID
    case 4:
                try {

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student_db",
        "root",
        "root123"
    );

    System.out.print("Enter Student ID to delete: ");
    int deleted = sc.nextInt();
// SQL DELETE query
    String query =
        "DELETE FROM students WHERE id = ?";

    PreparedStatement ps =
        con.prepareStatement(query);

    ps.setInt(1, deleted);

    int rows = ps.executeUpdate();

    System.out.println(
        rows + " row deleted successfully!"
    );

    con.close();

} catch(Exception e) {
    System.out.println(e);
}

break;                
// Exit the application
                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

