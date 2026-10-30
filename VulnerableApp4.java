import javax.servlet.http.HttpServletRequest;

public class VulnerableApp5 {

    public void executeCommand(HttpServletRequest request) throws Exception {

        String host = request.getParameter("host");

        Runtime.getRuntime().exec(
            "cmd.exe /c ping " + host
        );
    }
}