package controller.customer;

import model.customer.Customer;
import model.customer.CustomerDTO;
import model.customer.CustomerType;
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
import java.util.Map;

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
//            case "delete":
//                deleteCustomer(request, response);
//                break;
            case "search":
                searchCustomer(request, response);
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
        List<CustomerType> customerTypeList = new ArrayList<>();
        customerTypeList = iCustomerTypeService.findAll();

        Customer customer = iCustomerService.findById(id);

        request.setAttribute("customerTypes", customerTypeList);
        request.setAttribute("customerToEdit", customer);
        try {
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("idDelete"));

        iCustomerService.deleteCustomerById(id);

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

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("searchByName");

        List<CustomerDTO> customerDTOList = iCustomerService.searchByName(nameSearch);

        request.setAttribute("customers", customerDTOList);

        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                iCustomerService.findAll();
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = new ArrayList<>();
        customerTypeList = iCustomerTypeService.findAll();

        request.setAttribute("customer_type", customerTypeList);

        String code = request.getParameter("customer_code");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        Integer gender = Integer.valueOf(request.getParameter("customer_gender"));
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));

        Customer customer = new Customer(code, name, birthday, gender, idCard, phone,
                email, address, customerTypeId);
        Map<String, String> customerMap = iCustomerService.save(customer);

        if (customerMap.isEmpty()) {
            request.setAttribute("message", "New customer was created");
        } else {
            request.setAttribute("error", customerMap);
        }
        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        List<CustomerType> customerTypeList = new ArrayList<>();
        customerTypeList = iCustomerTypeService.findAll();

        String code = request.getParameter("customer_code");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        Integer gender = Integer.valueOf(request.getParameter("customer_gender"));
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));

        Customer customer = new Customer(id, code, name, birthday, gender, idCard,
                phone, email, address, customerTypeId);

        this.iCustomerService.update(customer);
        request.setAttribute("message", "Customer updated");

        try {
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
