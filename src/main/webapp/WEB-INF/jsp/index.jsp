<%--
  Created by IntelliJ IDEA.
  User: m2arc
  Date: 12/18/2024
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp"/>

<div class="container page" id="app-main">

    <div class="container container-main container-content col-8" id="index-main-list">

        <div class="container container-list" id="twitch-embed-title">
            <div class="list-title">
                Speedrun is live!
            </div>
        </div>

        <!-- Add a placeholder for the Twitch embed -->
        <div id="twitch-embed"></div>

        <!-- Load the Twitch embed script -->
        <script src="https://player.twitch.tv/js/embed/v1.js"></script>

        <!-- Create a Twitch.Player object. This will render within the placeholder div -->
        <script type="text/javascript">
            new Twitch.Player("twitch-embed", {
                channel: "speedrun",
                width: "100%",
                height: "100%",
            });
        </script>

        <div class="container-list speedrun-list">
            <div class="list-title">
                Recent Speedruns
            </div>

            <!-- Speedrun Entry Template, 1 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
                    <div class="col-10">
                        <div class="row game-title">
                            <div class="col-12">Game name</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6">Category</div>
                            <div class="col-3">Placement</div>
                            <div class="col-3">Username</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6 mini-box">(empty)</div>
                            <div class="col-3 mini-box">Time</div>
                            <div class="col-3 mini-box">Date Submitted</div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Speedrun Entry Template, 2 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
                    <div class="col-10">
                        <div class="row game-title">
                            <div class="col-12">Game name</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6">Category</div>
                            <div class="col-3">Placement</div>
                            <div class="col-3">Username</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6 mini-box">(empty)</div>
                            <div class="col-3 mini-box">Time</div>
                            <div class="col-3 mini-box">Date Submitted</div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Speedrun Entry Template, 3 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
                    <div class="col-10">
                        <div class="row game-title">
                            <div class="col-12">Game name</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6">Category</div>
                            <div class="col-3">Placement</div>
                            <div class="col-3">Username</div>
                        </div>
                        <div class="row game-details">
                            <div class="col-6 mini-box">(empty)</div>
                            <div class="col-3 mini-box">Time</div>
                            <div class="col-3 mini-box">Date Submitted</div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="container container-content container-helper col-4" id="index-helper-list">
        <div class="container-list">
            <div class="list-title">
                Popular Games
            </div>

            <!-- Popular Game Entry Template, 1 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
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

            <!-- Popular Game Entry Template, 2 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
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

            <!-- Popular Game Entry Template, 3 -->
            <div class="container-entry">
                <div class="row">

                    <div class="col-2">
                        Image
                    </div>

                    <!-- Details -->
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
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>