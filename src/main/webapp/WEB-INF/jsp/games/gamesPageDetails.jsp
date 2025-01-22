
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

            <div class="container-list speedrun-list" style="margin-bottom: 16px;">
                <div class="list-title">
                    <c:forEach var="game" items="${titleGameKey}">
                        Speedruns for ${game.gameName}, Any% Category
                    </c:forEach>
                </div>

                <!-- Speedrun Entry Template
                <div class="container-entry">
                    <div class="row">

                        <div class="col-12">
                            <div class="row game-details">
                                <div class="col-1">1st</div>
                                <div class="col-5">Username</div>
                                <div class="col-3">Time</div>
                                <div class="col-3">Submitted on</div>
                            </div>
                        </div>
                    </div>
                </div>  -->

                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="speedrun" items="${titleSpeedrunsKey}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <c:set var="speedrunTimeConvert" value=
                            "${Math.round(Math.floor(speedrun.speedrunTime / 3600))}h
                            ${Math.round(Math.floor(speedrun.speedrunTime / 60 % 60))}m
                            ${Math.round(Math.floor(speedrun.speedrunTime % 60))}s"/>

                    <div class="container-entry">
                        <div class="row">
                            <!-- Details -->
                            <div class="col-12">
                                <div class="row game-details">
                                    <div class="col-1">${count}</div>
                                    <c:forEach var="game" items="${titleGameKey}">
                                        <div class="col-5">
                                            <a href="/games/page/${game.abbr}/speedrun/${speedrun.id}">
                                                    ${speedrun.user.username}
                                            </a>
                                        </div>
                                    </c:forEach>

                                    <div class="col-3">${speedrunTimeConvert}</div>
                                    <div class="col-3">Submitted on ${speedrun.dateSubmitted}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div style="text-align: center;">
                <c:forEach var="game" items="${titleGameKey}">
                    <a href="./${game.abbr}/createSpeedrun" target="_self">
                        <button class="btn" id="speedrun-button" style="margin-bottom: 20px">Submit Speedrun</button>
                    </a>
                </c:forEach>
            </div>
        </div>

        <div class="container container-content container-helper col-4" id="index-helper-list">
            <div class="container-list">
                <div class="list-title">
                    Popular Games
                </div>

                <!-- Popular Game Entry Template
                <div class="container-entry">
                    <div class="row">

                        <div class="col-2">
                            Image
                        </div>

                        <div class="col-10">
                            <div class="row">
                                <div class="col-12">Game name</div>
                            </div>
                            <div class="row">
                                <div class="col-12">Release Date</div>
                            </div>
                        </div>
                    </div>
                </div>
                -->

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