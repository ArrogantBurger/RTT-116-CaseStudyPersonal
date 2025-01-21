<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<div class="container page authentication-page" id="login-page">

  <div class="authentication-box">
    <div class="row" style="text-align: center; margin-bottom: 20px;">
      <h3>Admin Dashboard</h3>
    </div>
    <a href="../admin/createGame" target="_parent"><button class="btn" style="margin-bottom: 20px">Create Game</button></a>
    <a href="../admin/runApproval" target="_parent"><button class="btn">Speedrun Review</button></a>
  </div>

</div>

<jsp:include page="../include/footer.jsp"/>