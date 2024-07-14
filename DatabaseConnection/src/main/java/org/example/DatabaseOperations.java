package org.example;

import java.sql.*;

public class DatabaseOperations {
    private static final String URL = "jdbc:mysql://localhost:3306/yourDatabaseName";
    private static final String USER = "root";
    private static final String PASSWORD = "BluetruckB8@";

    public static void main(String[] args) {
        // Add a deposit
        callAddDeposit(2, "Salary Deposit", "Company", 1000.00);

        // Make a payment
        callMakePayment(2, "Grocery Shopping", "Supermarket", 150.00);

        // Custom search
        callCustomSearch(2, "2023-01-01", "2023-12-31", "Company");

        // Search by vendor
        callSearchByVendor(2, "Supermarket");

        // Show all deposits
        callShowAllDeposits(2);

        // Show all ledgers
        callShowAllLedgers(2);

        // Show all payments
        callShowAllPayments(2);

        // Show reports by month-to-date
        callShowReportsByMonthToDate(2);

        // Show reports by previous month
        callShowReportsByPreviousMonth(2);

        // Show reports by previous year
        callShowReportsByPreviousYear(2);

        // Show reports by year-to-date
        callShowReportsByYearToDate(2);
    }

    public static void callAddDeposit(int userId, String description, String vendor, double amount) {
        String sql = "{CALL AddDeposit(?, ?, ?, ?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, description);
            stmt.setString(3, vendor);
            stmt.setDouble(4, amount);
            stmt.executeUpdate();
            System.out.println("Deposit added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callMakePayment(int userId, String description, String vendor, double amount) {
        String sql = "{CALL MakePayment(?, ?, ?, ?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, description);
            stmt.setString(3, vendor);
            stmt.setDouble(4, amount);
            stmt.executeUpdate();
            System.out.println("Payment made successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callCustomSearch(int userId, String startDate, String endDate, String vendor) {
        String sql = "{CALL CustomSearch(?, ?, ?, ?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, startDate);
            stmt.setString(3, endDate);
            stmt.setString(4, vendor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendorResult = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendorResult, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callSearchByVendor(int userId, String vendor) {
        String sql = "{CALL SearchByVendor(?, ?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, vendor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendorResult = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendorResult, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowAllDeposits(int userId) {
        String sql = "{CALL ShowAllDeposits(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowAllLedgers(int userId) {
        String sql = "{CALL ShowAllLedgers(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowAllPayments(int userId) {
        String sql = "{CALL ShowAllPayments(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowReportsByMonthToDate(int userId) {
        String sql = "{CALL ShowReportsByMonthToDate(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowReportsByPreviousMonth(int userId) {
        String sql = "{CALL ShowReportsByPreviousMonth(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowReportsByPreviousYear(int userId) {
        String sql = "{CALL ShowReportsByPreviousYear(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void callShowReportsByYearToDate(int userId) {
        String sql = "{CALL ShowReportsByYearToDate(?)}";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int transactionId = rs.getInt("transaction_id");
                    String date = rs.getString("date");
                    String description = rs.getString("description");
                    String vendor = rs.getString("vendor");
                    double amount = rs.getDouble("amount");
                    System.out.printf("ID: %d, Date: %s, Description: %s, Vendor: %s, Amount: %.2f%n",
                            transactionId, date, description, vendor, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}