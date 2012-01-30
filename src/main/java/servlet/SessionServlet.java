package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "SessionServlet",
        urlPatterns = {"/go"}
)
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SessionObj s = (SessionObj) req.getSession().getAttribute("x");
        if (s == null) {
            s = new SessionObj();
        }
        Long current = System.currentTimeMillis();
        Long last = s.last;
        Integer count = s.count;
        s.count += 1;
        s.last = current;
        req.getSession().setAttribute("x", s);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"count\":" + count + "}");
        writer.close();
    }

}