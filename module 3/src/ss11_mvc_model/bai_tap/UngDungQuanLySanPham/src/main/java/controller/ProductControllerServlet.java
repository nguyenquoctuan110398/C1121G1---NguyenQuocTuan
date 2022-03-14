package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductControllerServlet", value = "/products")
public class ProductControllerServlet extends HttpServlet {

    IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;

            case "edit":
                showEditProduct(request, response);
                break;

            case "delete":
                showDeleteProduct(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Product product = this.iProductService.findById(id);

        try {
            request.getRequestDispatcher("delete.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        productList = iProductService.findAll();

        request.setAttribute("products", productList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Product product = this.iProductService.findById(id);

//        RequestDispatcher dispatcher;

//        if (product == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                iProductService.findAll();
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Product product = iProductService.findById(id);

        iProductService.remove(id);

        request.setAttribute("message", "Product deleted");
        try {
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        Product product = new Product(id, name, price, description, manufacturer);
        this.iProductService.save(product);

        request.setAttribute("message", "New customer war created");
        try {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        this.iProductService.update(id, name, price, description, manufacturer);

        request.setAttribute("message", "Product updated");
        try {
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
