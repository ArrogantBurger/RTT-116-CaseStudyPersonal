<%--
  Created by IntelliJ IDEA.
  User: m2arc
  Date: 1/15/2025
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<h1>Game Details Page!</h1>


<c:forEach var="game" items="${titleGameKey}">
    <div>URL says this is a page for: ${game.gameName}</div>
</c:forEach>

<jsp:include page="../include/footer.jsp"/>