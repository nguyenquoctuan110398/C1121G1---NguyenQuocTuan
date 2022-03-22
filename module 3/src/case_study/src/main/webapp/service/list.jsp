<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/21/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <div class="dropdown">
            <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"><i class="material-icons">&#xE147;</i>Add New Service
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach var="serviceType" items="${serviceTypes}">
                    <a class="dropdown-item" href="/services?action=create&idType=${serviceType.serviceTypeId}">
                            ${serviceType.serviceTypeName}</a>
                </c:forEach>
            </div>
        </div>
    </h2>
    <form method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="searchByName" placeholder="Search by name">
        <button type="submit" id="submit">Search</button>
    </form>


</center>
<%--<div align="center">--%>
<%--    <form method="get">--%>
<%--        <input type="hidden" name="action" value="sort">--%>
<%--        <button type="submit">Sort by name</button>--%>
<%--    </form>--%>
<%--</div>--%>


<div align="center">
    <caption><h2>List of services</h2></caption>
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>Rent Type Name</th>
            <th>Service Type Name</th>
            <th>Standard Room</th>
            <th>Description Other Convenience</th>
            <th>Pool Area</th>
            <th>Number Of Floors</th>
<%--            <th></th>--%>
<%--            <th></th>--%>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="service" items="${services}">
            <tr>
                <td><c:out value="${service.id}"/></td>
                <td><c:out value="${service.name}"/></td>
                <td><c:out value="${service.area}"/></td>
                <td><c:out value="${service.cost}"/></td>
                <td><c:out value="${service.maxPeople}"/></td>
                <td><c:out value="${service.rentTypeName}"/></td>
                <td><c:out value="${service.serviceTypeName}"/></td>
                <td><c:out value="${service.standardRoom}"/></td>
                <td><c:out value="${service.descriptionOtherConvenience}"/></td>
                <td>
                    <c:if test="${service.poolArea == -1}">Null</c:if>
                    <c:if test="${service.poolArea != -1}">${service.poolArea}</c:if>
                </td>
                <td>
                    <c:if test="${service.numberOfFloors == -1}">Null</c:if>
                    <c:if test="${service.numberOfFloors != -1}">${service.numberOfFloors}</c:if>
                </td>
            </tr>
        </c:forEach>

<%--        <tr>--%>
<%--            <td>--%>
<%--                <a href="/services?action=edit&id=${customer.id}">Edit</a>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>--%>
<%--                <a class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"--%>
<%--                   href="/services?action=delete&id=${customer.id}" onclick="getID(${customer.id})">--%>
<%--                    Delete--%>
<%--                </a>--%>
<%--            </td>--%>
<%--        </tr>--%>
        </tbody>
    </table>

<%--    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--         aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <form method="post" action="/customers?action=delete&id=${customer.id}">--%>
<%--                    <input type="hidden" name="idDelete" id="modalDelete">--%>
<%--                    <div class="modal-header">--%>
<%--                        <h5 class="modal-title" id="exampleModalLabel">Delete customer</h5>--%>
<%--                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                            <span aria-hidden="true">&times;</span>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body">--%>
<%--                        Do you want to delete the customer?--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                        <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</div>--%>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>


<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
<%--<script>--%>
<%--    function getID(id) {--%>
<%--        document.getElementById("modalDelete").value = id;--%>
<%--    }--%>
<%--</script>--%>
</html>
