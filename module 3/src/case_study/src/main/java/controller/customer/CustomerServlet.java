package controller.customer;

import model.Customer.Customer;
import model.Customer.CustomerDTO;
import model.Customer.CustomerType;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;
import service.customer.impl.CustomerService;
import service.customer.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    ICustomerService iCustomerService = new CustomerService();

    ICustomerTypeService iCustomerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "delete":
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) {

        List<CustomerType> customerTypeList = new ArrayList<>();
        customerTypeList = iCustomerTypeService.findAll();

        request.setAttribute("customer_type", customerTypeList);

        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Customer customer = iCustomerService.findById(id);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customerDTOList = iCustomerService.findAll();

        request.setAttribute("customers", customerDTOList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                iCustomerService.findAll();
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//        Integer id = Integer.valueOf(request.getParameter("customer_id"));
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        Integer gender = Integer.valueOf(request.getParameter("customer_gender"));
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));

        Customer customer = new Customer(name, birthday, gender, idCard, phone,
                email, address, customerTypeId);
        iCustomerService.save(customer);

        request.setAttribute("message", "New customer was created");

        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
