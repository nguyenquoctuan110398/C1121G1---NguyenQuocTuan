package controller.employee;

import model.employee.*;
import service.employee.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreateEmployee(request, response);
                break;
            case "edit":
                formEditEmployee(request, response);
                break;
            case "view":
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                listAllEmployee(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("searchEmployee");
        List<EmployeeDTO> employeeSearchList = employeeService.searchEmployeeByName(search);
        request.setAttribute("employeeList", employeeSearchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Position> positionList = employeeService.getAllPosition();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = employeeService.getAllEducation();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = employeeService.getAllDivision();
        request.setAttribute("divisionList", divisionList);
        Employee employee = employeeService.selectEmployeeById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = employeeService.getAllPosition();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = employeeService.getAllEducation();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = employeeService.getAllDivision();
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.deleteEmployee(id);
        List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("employeeName");
        String birthday = request.getParameter("birthday");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer position = Integer.parseInt(request.getParameter("position"));
        Integer education = Integer.parseInt(request.getParameter("education"));
        Integer division = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
        employeeService.updateEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("message", " Employee was update");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer position = Integer.parseInt(request.getParameter("position"));
        Integer educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        Integer division = Integer.parseInt(request.getParameter("division"));
        String usename = request.getParameter("employee_email");
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, usename);
        employeeService.createEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        request.setAttribute("message", "New employee was create ");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
