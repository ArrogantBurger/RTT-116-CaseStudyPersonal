<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>


<div class="container page authentication-page" id="signup-page">

    <div class="authentication-box">
        <div class="row" style="text-align: center; margin-bottom: 20px;">
            <h3>Sign Up</h3>
        </div>
        <c:if test="${bindingResult.hasFieldErrors('username')}">
            <div class="row justify-content-center">
                <div class="alert alert-danger" role="alert">
                    Username already exists.
                </div>
            </div>
        </c:if>
        <form class="authentication-form" action="/signupSubmit" method="post" name="signupForm">
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