import java.io.*;
import java.sql.*;
import java.security.MessageDigest;

public class VulnerableApp {

    // Hardcoded credential
    private static final String PASSWORD = "SuperSecret123!";
    // private static final String PASSWORD = System.getenv("APP_PASSWORD");
    // No powershell -> $env:APP_PASSWORD="SuperSecret123!"


    public void sqlInjection(Connection conn, String username) throws SQLException {
        Statement stmt = conn.createStatement();

        String query =
            "SELECT * FROM users WHERE username = '" + username + "'";

        stmt.executeQuery(query);
    }

    public void safeExecution(String userInput) throws IOException {
    // Substitua "comando.exe" pelo executável pretendido
    ProcessBuilder processBuilder = new ProcessBuilder("comando.exe", userInput);
    processBuilder.start();
    }

    public void pathTraversal(String filename) throws IOException {
        File file = new File("C:\\uploads\\" + filename);

        FileInputStream input = new FileInputStream(file);
        input.close();
    }

    public byte[] weakHash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(password.getBytes());
    }
}