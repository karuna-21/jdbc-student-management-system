import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "root123";

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
int id = sc.nextInt();

sc.nextLine(); // consume leftover newline

System.out.print("Enter Name: ");
String name = sc.nextLine();

System.out.print("Enter Age: ");
int age = sc.nextInt();
            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password);
                            PreparedStatement ps =
    con.prepareStatement(
        "INSERT INTO students VALUES (?, ?, ?)");
       ps.setInt(1, 4);
ps.setString(2, "Ravi");
ps.setInt(3, 23); 
                    //Statement stmt = con.createStatement();
//String query =
   //     "UPDATE students SET age = 22 WHERE id = 3";

//int rows = stmt.executeUpdate(query);

//System.out.println(rows + " row updated successfully!");


//String query = "SELECT * FROM students";

//ResultSet rs = stmt.executeQuery(query);

//while (rs.next()) {

 //   System.out.println(
   //     rs.getInt("id") + " "
     //   + rs.getString("name") + " "
       // + rs.getInt("age")
   // );
  // String query = "DELETE FROM students WHERE id = 3";
   //int rows = stmt.executeUpdate(query);
   int rows = ps.executeUpdate();

System.out.println(rows + " row inserted successfully!");

//System.out.println(rows + " row inserted successfully!");

            //System.out.println("Database Connected Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}