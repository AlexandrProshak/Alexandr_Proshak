<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

<div id="user-create-modal-dialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Create new user</h4>
            </div>
            <div class="modal-body">
                <%--<form action="${context}/allUsersList" method="post" role="form"--%>
                <form role="form" class="form-horizontal" autocomplete="off">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name"
                                   name="name" placeholder="Enter Name">
                            <span class="alert alert-danger col-sm-12"
                                  id="errname">Should Contain Only Characters</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="login">Login</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="login"
                                   name="login" placeholder="Enter Login">
                            <span class="alert alert-danger col-sm-12"
                                  id="errlogin">Should Contain Only Characters</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="password">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password"
                                   name="password" placeholder="Enter Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="cpassword">Confirm password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="cpassword"
                                   name="password" placeholder="Enter Password">
                            <span class="alert alert-danger col-sm-12"
                                  id="errpass">Should Match the passwords</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email"
                                   name="email" placeholder="Enter email">
                            <span class="alert alert-danger col-sm-12"
                                  id="erremail">Invalid Email Address</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="role">Role</label>
                        <div class="col-sm-10">
                            <select name="role" id="role" class="form-control" required>
                                <option value="user">user</option>
                                <option value="admin">admin</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="country-opt">Country</label>
                        <div class="col-sm-10">
                            <select id="country-opt" class="form-control" name="country"
                                    required onchange="updateCitiesByCountry()">
                                <option>...</option>
                                <c:forEach var="country" items="${sessionScope.countries}">
                                    <option>${country.name}</option>
                                </c:forEach>
                            </select>
                            <span class="alert alert-danger col-sm-12"
                                  id="errcountry">Must select the country</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="city-opt">City</label>
                        <div class="col-sm-10">
                            <select id="city-opt" class="form-control" name="city"
                                    required></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2">
                            <button class="btn btn-success" type="button" id="Rbtn">Create</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

