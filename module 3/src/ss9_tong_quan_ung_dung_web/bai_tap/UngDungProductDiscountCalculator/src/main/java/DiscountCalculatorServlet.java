import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCalculatorServlet", value = "/DiscountCalculatorServlet")
public class DiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productDescription = request.getParameter("product_description");
        float listPrice = Float.parseFloat(request.getParameter("list_price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount_percent"));

        float discountAmount = (float) (listPrice * discountPercent * 0.01);
        float discountPrice = listPrice - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        writer.println("<h1>Discount Amount: " + discountAmount + "</h1></br>");
        writer.println("<h1>Discount Price: " + discountPrice + "</h1></br>");

        writer.println("</html>");
    }
}
