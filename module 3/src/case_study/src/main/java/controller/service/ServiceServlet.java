package controller.service;

import model.service.Service;
import model.service.ServiceDTO;
import model.service.ServiceType;
import service.service.IServiceService;
import service.service.impl.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ServiceServlet", value = "/services")
public class ServiceServlet extends HttpServlet {

    private IServiceService iServiceService = new ServiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateServiceForm(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) {

        List<ServiceType> serviceTypeList = new ArrayList<>();
        serviceTypeList = iServiceService.findServiceType();
        request.setAttribute("serviceTypes", serviceTypeList);
        Integer idType= Integer.valueOf(request.getParameter("idType"));
        request.setAttribute("idType", idType);

        try {
            request.getRequestDispatcher("service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        serviceDTOList = iServiceService.findAll();

        List<ServiceType> serviceTypeList = new ArrayList<>();
        serviceTypeList = iServiceService.findServiceType();

        request.setAttribute("services", serviceDTOList);
        request.setAttribute("serviceTypes", serviceTypeList);
        try {
            request.getRequestDispatcher("service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createService(request, response);
            default:
                iServiceService.findAll();
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        Service service = null;

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer area = Integer.valueOf(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        Integer maxPeople = Integer.valueOf(request.getParameter("maxPeople"));
        Integer rentTypeId = Integer.valueOf(request.getParameter("rentTypeId"));
        Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
//        Double poolArea = Double.valueOf(request.getParameter("poolArea"));
//        Integer numberOfFloors = Integer.valueOf(request.getParameter("numberOfFloors"));

        if (serviceTypeId == 1) {
            Double poolArea = Double.valueOf(request.getParameter("poolArea"));
            Integer numberOfFloors = Integer.valueOf(request.getParameter("numberOfFloors"));
            service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId,
                    standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
            iServiceService.saveVilla(service);
//            iServiceService.save(service);
        } else if (serviceTypeId == 2) {
            Integer numberOfFloors = Integer.valueOf(request.getParameter("numberOfFloors"));
            service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId,
                    standardRoom, descriptionOtherConvenience, numberOfFloors);
            iServiceService.saveHouse(service);
        } else if (serviceTypeId==3){
           service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId);
           iServiceService.saveRoom(service);
        }

//        iServiceService.save(service);

        request.setAttribute("message", "New service was created");

        try {
            request.getRequestDispatcher("service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
