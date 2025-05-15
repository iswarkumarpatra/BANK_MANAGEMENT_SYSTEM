import java.sql.*;
import java.io.*;
public class BANKAPP1 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Load JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Database
            String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
            String user = "system"; 
            String pass = "Iswar67890"; 

            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();

            while (true) {
                System.out.println("\n---- Bank Menu ----");
                System.out.println("1. Show Customers");
                System.out.println("2. Add Customer");
                System.out.println("3. Delete Customer");
                System.out.println("4. Update Customer");
                System.out.println("5. Show Account");
                System.out.println("6. Show Loan");
                System.out.println("7. Deposit");
                System.out.println("8. Withdraw");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        ResultSet rs1 = stmt.executeQuery("SELECT * FROM Customer");
                        while (rs1.next()) {
                            System.out.println("Cust No: " + rs1.getString("cust_no") +
                                    ", Name: " + rs1.getString("name") +
                                    ", Phone: " + rs1.getString("phoneno") +
                                    ", City: " + rs1.getString("city"));
                        }
                        break;

                    case 2:
                        System.out.print("Enter Cust No: ");
                        String cno = br.readLine();
                        System.out.print("Enter Name: ");
                        String name = br.readLine();
                        System.out.print("Enter Phone: ");
                        String phone = br.readLine();
                        System.out.print("Enter City: ");
                        String city = br.readLine();
                        stmt.executeUpdate("INSERT INTO Customer VALUES('" + cno + "', '" + name + "', '" + phone + "', '" + city + "')");
                        System.out.println("Customer added.");
                     // Insert into Account with auto-generated account_no
                        String accountNo = "ACC" +cno;
                       
                        String accType ="SAVINGS";
                        System.out.print("Enter Initial Balance: ");
                        double balance = Double.parseDouble(br.readLine());
                        //System.out.print("Enter Branch Code: ");
                        String bcode ="BANK001";
                       // System.out.print("Enter Branch Name: ");
                        String bname ="ISWARBANK";
                        //System.out.print("Enter Branch City: ");
                        String bcity ="BALASORE";

                        stmt.executeUpdate("INSERT INTO Account VALUES('" + accountNo + "', '" + cno + "', '" + accType + "', " + balance + ", '" + bcode + "', '" + bname + "', '" + bcity + "')");
                        System.out.println("Account created with Account No: " + accountNo);

                        // Ask if loan is needed
                        System.out.print("Do you want to create a loan? (yes/no): ");
                        String loanChoice = br.readLine();
                        if (loanChoice.equalsIgnoreCase("yes")) {
                            
                            String loanNo = "LN" +cno;
                     

                            System.out.print("Enter Loan Amount: ");
                            double loanAmt = Double.parseDouble(br.readLine());

                            stmt.executeUpdate("INSERT INTO Loan VALUES('" + loanNo + "', '" + cno + "', " + loanAmt + ", '" + bcode + "', '" + bname + "', '" + bcity + "')");
                            System.out.println("Loan created with Loan No: " + loanNo);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Cust No to delete: ");
                        String delNo = br.readLine();
                        stmt.executeUpdate("DELETE FROM Account WHERE cust_no = '" + delNo + "'");
                        stmt.executeUpdate("DELETE FROM Loan WHERE cust_no = '" + delNo + "'");
                        stmt.executeUpdate("DELETE FROM Customer WHERE cust_no = '" + delNo + "'");
                        System.out.println("Customer deleted.");
                        break;

                    case 4:
                        System.out.print("Enter Cust No: ");
                        String updNo = br.readLine();
                        System.out.println("1. Name\n2. Phone\n3. City");
                        System.out.print("What to update? ");
                        int updChoice = Integer.parseInt(br.readLine());
                        String column = "", newValue = "";
                        if (updChoice == 1) {
                            column = "name";
                            System.out.print("Enter new Name: ");
                        } else if (updChoice == 2) {
                            column = "phoneno";
                            System.out.print("Enter new Phone: ");
                        } else if (updChoice == 3) {
                            column = "city";
                            System.out.print("Enter new City: ");
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }
                        newValue = br.readLine();
                        stmt.executeUpdate("UPDATE Customer SET " + column + " = '" + newValue + "' WHERE cust_no = '" + updNo + "'");
                        System.out.println("Customer updated.");
                        break;

                    case 5:
                        System.out.print("Enter Cust No: ");
                        String accCustNo = br.readLine();
                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM Account WHERE cust_no = '" + accCustNo + "'");
                        while (rs2.next()) {
                            System.out.println("Acc No: " + rs2.getString("account_no") +
                                    ", Type: " + rs2.getString("type") +
                                    ", Balance: " + rs2.getDouble("balance") +
                                    ", Branch_Code: " + rs2.getString("branch_code") +
                                    ", Branch: " + rs2.getString("branch_name"));
                        }
                        break;

                    case 6:
                        System.out.print("Enter Cust No: ");
                        String loanCustNo = br.readLine();
                        ResultSet rs3 = stmt.executeQuery("SELECT * FROM Loan WHERE cust_no = '" + loanCustNo + "'");
                        if (!rs3.isBeforeFirst()) {
                            System.out.println(" Congratulation if customer has no loan");
                        } else {
                            while (rs3.next()) {
                                System.out.println("Loan No: " + rs3.getString("loan_no") +
                                        ", Amount: " + rs3.getDouble("loan_amount") +
                                        ", Branch_Code: " + rs3.getString("branch_code") +
                                        ", Branch: " + rs3.getString("branch_name"));
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Enter Account No: ");
                        String accNo = br.readLine();
                        System.out.print("Enter Deposit Amount: ");
                        double depAmt = Double.parseDouble(br.readLine());
                        stmt.executeUpdate("UPDATE Account SET balance = balance + " + depAmt + " WHERE account_no = '" + accNo + "'");
                        System.out.println("Amount deposited.");
                        break;

                    case 8:
                        System.out.print("Enter Account No: ");
                        String wAccNo = br.readLine();
                        System.out.print("Enter Withdraw Amount: ");
                        double wAmt = Double.parseDouble(br.readLine());
                        ResultSet rsBal = stmt.executeQuery("SELECT balance FROM Account WHERE account_no = '" + wAccNo + "'");
                        if (rsBal.next()) {
                            double bal = rsBal.getDouble("balance");
                            if (bal >= wAmt) {
                                stmt.executeUpdate("UPDATE Account SET balance = balance - " + wAmt + " WHERE account_no = '" + wAccNo + "'");
                                System.out.println("Amount withdrawn.");
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 9:
                        System.out.println("Goodbye!");
                        con.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
