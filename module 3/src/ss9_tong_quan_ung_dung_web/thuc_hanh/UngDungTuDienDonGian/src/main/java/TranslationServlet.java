
import javafx.print.Printer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", value = "/TranslationServlet")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("Hello", "Xin chào");
        dictionary.put("How", "Thế nào");
        dictionary.put("Book", "Quyển vở");
        dictionary.put("Computer", "Máy tính");
        dictionary.put("Game", "Trò chơi");

        String search = request.getParameter("txtSearch");


        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);

        if (result != null) {
            writer.println("World: " + search);
            writer.println("</br>");
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println("</html>");

    }
}
