<%--
  Created by IntelliJ IDEA.
  User: m2arc
  Date: 1/15/2025
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>


<div class="container page" id="app-main" style="flex-direction: column;">
    <div class="container list-title game-info" style="justify-content: flex-start">
        <c:forEach var="game" items="${titleGameKey}">
            <div class="row">
                <div class="col-2">
                    <img src="${game.imageUrl}" alt="${game.gameName}"/>
                </div>
                <div class="col-10">
                    <div class="row game-title">
                        <div class="col-12"><h1>${game.gameName}</h1></div>
                    </div>
                    <div class="row game-details ms-auto">
                        <div class="col-12">Released in ${game.releaseYear}</div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="container container-main container-content col-8" id="index-main-list">

            <c:forEach var="speedrun" items="${speedrunKey}">
                <iframe width="100%" style="aspect-ratio: 16/9; margin-bottom: 16px;"
                        src="${speedrun.videoUrl}">
                </iframe>
            </c:forEach>


            <div class="container-list speedrun-list" style="margin-bottom: 16px;">
                <div class="list-title">
                    Speedrun Details
                </div>

                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="speedrun" items="${speedrunKey}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <c:set var="speedrunTimeConvert" value=
                            "${Math.round(Math.floor(speedrun.speedrunTime / 3600))}h
                            ${Math.round(Math.floor(speedrun.speedrunTime / 60 % 60))}m
                            ${Math.round(Math.floor(speedrun.speedrunTime % 60))}s"/>

                    <div class="container container-entry">

                        <div class="row">
                            <div class="col-4">
                                <h3>Username</h3>
                                <h3>Complete Time</h3>
                                <h3>Date Submitted</h3>
                            </div>
                            <div class="col-8">
                                <h3>
                                    <c:forEach var="game" items="${titleGameKey}">
                                        <div class="col-5">
                                                ${speedrun.user.username}
                                        </div>
                                    </c:forEach>
                                </h3>
                                <h3>${speedrunTimeConvert}</h3>
                                <h3>${speedrun.dateSubmitted}</h3>
                            </div>
                        </div>

                    </div>
                </c:forEach>

            </div>

        </div>

        <div class="container container-content container-helper col-4" id="index-helper-list">
            <div class="container-list">
                <div class="list-title">
                    Popular Games
                </div>

                <!-- Popular Game Entry Template, Inductive Series -->
                <c:forEach var="game" items="${latestGameListKey}">
                    <div class="container-entry">
                        <div class="row">

                            <div class="col-3">
                                <img src="${game.imageUrl}" alt="Image">
                            </div>

                            <!-- Details -->
                            <div class="col-9">
                                <div class="row" style="margin-bottom: 24px">
                                    <div class="col-12">${game.gameName}</div>
                                </div>
                                <div class="row">
                                    <div class="col-12">Released in ${game.releaseYear}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>

</div>


<jsp:include page="../include/footer.jsp"/>