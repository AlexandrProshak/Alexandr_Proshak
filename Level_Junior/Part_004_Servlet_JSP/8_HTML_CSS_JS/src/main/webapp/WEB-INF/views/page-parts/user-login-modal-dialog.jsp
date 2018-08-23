<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" scope="request" value="${pageContext.request.contextPath}"/>

<div id="user-login-modal-dialog" class="modal fade" tabindex="-1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header btn-info">
                <h4 class="modal-title">Login</h4>
            </div>
            <div class="modal-body">
                <section id="login_section">
                    <div class="row">
                        <div class="col-xs-12">
                            <form name="login-form" action="${context}/login"
                                  onsubmit="return validateForm()" method="post" autocomplete="off">
                                <div class="form-group">
                                    <input type="text" name="login" id="login" class="form-control"
                                           placeholder="test login - guest">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control"
                                           placeholder="test password - guest">
                                </div>
                                <div class="checkbox">
                                    <span class="character-checkbox" onclick="showPassword()"></span>
                                    <span class="label">Show password</span>
                                </div>
                                <input type="submit" id="btn-login" class="btn btn-success btn-md btn-block" value="Enter">
                            </form>
                        </div>
                    </div>
                </section>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>