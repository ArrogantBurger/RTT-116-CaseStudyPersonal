<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<div class="container page authentication-page" id="login-page" style="flex-direction: column">
    <div class="">
        <h1>Successfully created game!</h1>
    </div>
    <hr>
    <div class="authentication-box">
        <div class="row" style="text-align: center; margin-bottom: 20px;">
        </div>
        <a href="../admin/createGame" target="_parent"><button class="btn" style="margin-bottom: 20px">Create Another Game</button></a>
        <a href="../admin/runApproval" target="_parent"><button class="btn">Return to Dashboard</button></a>
    </div>

</div>
<jsp:include page="../include/footer.jsp"/>