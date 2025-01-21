<%--
  Created by IntelliJ IDEA.
  User: m2arc
  Date: 1/15/2025
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<div class="container page" id="games-page" style="align-items: flex-start">
    <div class="row game-gallery">
        <div class="">
            <h1>Main Games Page!</h1>
        </div>
        <div class="row game-gallery-contents">
            <c:forEach var="game" items="${latestGameListKey}">
                <div class="game-card col-2">
                    <a href="/games/page/${game.abbr}"><img class="card-img-top" src="${game.imageUrl}" alt="Card image cap"></a>

                    <div class="game-card-footer">
                        <div class="row">
                            <small>${game.gameName}</small>
                            <small>${game.releaseYear}</small>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--
        <div class="row">
            <div class="game-gallery col-2">
                <img class="card-img-top" src="/pub/images/sm64_art.jpg" alt="Card image cap">
                <div class="game-gallery-footer">
                    <div class="row">
                        <small>Super Mario 64</small>
                        <small>1996</small>
                    </div>
                </div>
            </div>

            <div class="game-gallery col-2">
                <img class="card-img-top" src="..." alt="Card image cap">
                <div class="card-footer">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>
            </div>
        </div>
        -->


    </div>


</div>


<jsp:include page="../include/footer.jsp"/>