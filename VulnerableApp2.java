import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class VulnerableApp4 {

    public ResultSet searchUser(
            HttpServletRequest request,
            Connection connection) throws Exception {

        String username = request.getParameter("username");

        Statement statement = connection.createStatement();

        String query =
                "SELECT * FROM users WHERE username = '"
                + username
                + "'";

        return statement.executeQuery(query);
    }
}