<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/23/2022
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contract List</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto%7CVarela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/list.css">
</head>
<body>
<div class="container-fluid">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title container">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Manage <b>Contract</b></h2>
                    </div>
                    <div class="col-sm-6">
                        <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                class="material-icons">&#xE147;</i> <span>Add New Contract</span></a>
                        <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i
                                class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover" id="example">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>M?? b???nh ??n</th>
                    <th>M?? b???nh nh??n</th>
                    <th>T??n b???nh nh??n</th>
                    <th>Ng??y nh???p vi???n</th>
                    <th>Ng??y ra vi???n</th>
                    <th>L?? do nh???p vi???n</th>
                    <th>T??c v???</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" items="${contractList}">
                    <tr>
                        <td><c:out value="${contract.contractId}"/></td>
                        <td><c:out value="${contract.startDate}"/></td>
                        <td><c:out value="${contract.endDay}"/></td>
                        <td><c:out value="${contract.deposit}"/></td>
                        <td><c:out value="${contract.totalMoney}"/></td>
                        <td><c:out value="${contract.employeeName}"/></td>
                        <td><c:out value="${contract.customerName}"/></td>
                        <td><c:out value="${contract.serviceName}"/></td>
                        <td>
<%--                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>--%>
<%--                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>--%>
                            <a href="/customers?action=edit&id=${customer.id}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="/customers?action=delete&id=${customer.id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--            <div class="clearfix">--%>
            <%--                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>--%>
            <%--                <ul class="pagination">--%>
            <%--                    <li class="page-item disabled"><a href="#">Previous</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">1</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">2</a></li>--%>
            <%--                    <li class="page-item active"><a href="#" class="page-link">3</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">4</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">5</a></li>--%>
            <%--                    <li class="page-item"><a href="#" class="page-link">Next</a></li>--%>
            <%--                </ul>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>
<!-- Add contact Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Add contract</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Ng??y b???t ?????u</label>
                        <input type="date" class="form-control" name="startDate" required>
                    </div>
                    <div class="form-group">
                        <label>Ng??y k???t th??c</label>
                        <input type="date" class="form-control" name="endDate" required>
                    </div>
                    <div class="form-group">
                        <label>????t c???c</label>
                        <input type="text" class="form-control" name="deposit" required>
                    </div>
                    <div class="form-group">
                        <label>T???ng ti???n</label>
                        <input type="text" class="form-control" name="totalMoney" required>
                    </div>
                    <div class="form-group">
                        <label>Nh??n vi??n t???o h???p ?????ng</label>
                        <select name="employeeName" class="form-control">
                            <c:forEach items="${employeeList}" var="employee">
                                <option value="${employee.id}">${employee.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>T??n kh??ch h??ng</label>
                        <select name="customerName" class="form-control">
                            <c:forEach items="${customerList}" var="customer">
                                <option value="${customer.id}">${customer.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>T??n d???ch v???</label>
                        <select name="serviceName" class="form-control">
                            <c:forEach items="${serviceList}" var="service">
                                <option value="${service.serviceId}">${service.serviceName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Contact</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>


</body>

<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": true
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
<script>
    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function () {
            if (this.checked) {
                checkbox.each(function () {
                    this.checked = true;
                });
            } else {
                checkbox.each(function () {
                    this.checked = false;
                });
            }
        });
        checkbox.click(function () {
            if (!this.checked) {
                $("#selectAll").prop("checked", false);
            }
        });
    });
</script>
</html>