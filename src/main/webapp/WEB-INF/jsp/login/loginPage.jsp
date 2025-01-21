<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>


<div class="container page authentication-page" id="login-page">

    <div class="authentication-box">
        <div class="row" style="text-align: center; margin-bottom: 20px;">
            <h3>Login</h3>
        </div>
        <c:if test="${param.error eq ''}">
            <div class="row justify-content-center">
                <div class="alert alert-danger" role="alert">
                    Invalid username or password
                </div>
            </div>
        </c:if>
        <form class="authentication-form" action="/login/loginSubmit" method="post" name="loginForm">
            <div>
                <input type="text" class="form-control" placeholder="Username" id="username" name="username" value=""/>
            </div>
            <div>
                <input type="password" class="form-control" placeholder="Password" id="password" name="password" value=""/>
            </div>
            <div style="text-align:center;">
                <button type="submit" class="btn">Submit</button>
            </div>
        </form>

    </div>

</div>


<jsp:include page="../include/footer.jsp"/>