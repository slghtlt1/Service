import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String arg[]) throws SQLException, ClassNotFoundException {
        Scanner s= new Scanner(System.in);

        System.out.println("Do you CheckIn your car?: \n 1-> Yes \n 2-> No \n Our prices is 120 for oil exchange" +
                " and 400 for other changes");
        int customerOption = s.nextInt();

//        if(customerOption == 1){
////            System.out.println("Please enter your VehicleNr:");
//
//            switch()
//        }
        switch (customerOption){
                case 1:
                    try {
                    String url = "jdbc:mysql://localhost:3306/ServiceDB";
                    Connection conn = DriverManager.getConnection(url, "root", "slghtlt1");
                    Class.forName("com.mysql.jdbc.Driver");
                    Statement st = conn.createStatement();
                    System.out.println("Please enter your vehicle Nr:");
                    String vehicleNr = s.next();
                    System.out.println("What do you wanna do to your car?:");
                    String vehicleOperation = s.next();
                    if (vehicleOperation.equalsIgnoreCase("oil")) {
                        st.executeUpdate("Insert into ServiceCheckin" + " Values(default, '" + vehicleNr + "', '" + vehicleOperation + "', '120')");
                        System.out.println("The final price will be " + 120);
                    } else {
                        st.executeUpdate("Insert into ServiceCheckin" + " Values(default, '" + vehicleNr + "', '" + vehicleOperation + "', '400')");
                        System.out.println("Final price will be: " + 400);
                    }
            }catch (Exception e){
                System.out.println("Something wrong with DB");
            }
                break;
                case 2:
                System.out.println("Have a good day, and go to another service");
                break;
        }

    }
}
