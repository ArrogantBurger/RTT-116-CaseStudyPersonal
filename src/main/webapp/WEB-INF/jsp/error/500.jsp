<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
  <div class="container" style="min-height:760px">
    <div class="row">
      <h1 class="m-0">500 Error - Server Side Issue</h1>
    </div>
    <hr>
    <div class="row">
      <h4 class="m-0">Oops! Something on our side went wrong.</h4>
      <h4 class="m-0">Please return to the home page!</h4>
    </div>
  </div>
</section>

<sec:authorize access="hasAnyAuthority('ADMIN')">
<section class="bg-light2 pt-5 pb-5">
  <div class="container">
    <div class="row">
      <h1>${exceptionMessage}</h1>
    </div>
  </div>
</section>
</sec:authorize>

<jsp:include page="../include/footer.jsp"/>