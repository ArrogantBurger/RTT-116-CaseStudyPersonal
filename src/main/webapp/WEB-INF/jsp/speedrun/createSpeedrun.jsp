<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<div class="container">
    <section class="bg-light1 pt-5 pb-5">
        <div class="container">
            <div class="row">
                <h1 class="m-0 text-center">Create Speedrun</h1>
            </div>
        </div>
    </section>

    <style>
        .form_input_error {
            color: red;
        }
    </style>

    <section class="bg-light2 pt-5 pb-5 row">
        <div class="container">
            <!-- when you want to do a file upload the form must submit using a post -->
            <!-- enctype="multipart/form-data" is needed to allow for file uploads -->
            <c:forEach var="game" items="${titleGameKey}">

            </c:forEach>
            <form action="/games/page/${gameAbbr}/createSpeedrunSubmit" method="POST" enctype="multipart/form-data">

                <input type="hidden" name="id" value="${form.id}"/>

                <div class="mt-3 row justify-content-center">
                    <label for="speedrunTime" class="col-sm-2 col-form-label">Speedrun Time</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="text" class="form-control" id="speedrunTime" name="speedrunTime" placeholder="hh:mm:ss" value="${form.speedrunTime}">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('speedrunTime')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('speedrunTime')}">
                                <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <div class="mt-3 row justify-content-center">
                    <label for="videoUrl" class="col-sm-2 col-form-label">Video URL (YouTube)</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="text" class="form-control" id="videoUrl" name="videoUrl" value="${form.videoUrl}">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('videoUrl')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('videoUrl')}">
                                <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <div class="mt-3 row justify-content-center">
                    <div class="col-sm-12 col-lg-8">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>

            <c:if test="${!bindingResult.hasErrors()}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <h3>${bindingResult.getFieldValue('gameName')}</h3>
                    </div>
                </div>
            </c:if>

        </div>
    </section>
</div>


<jsp:include page="../include/footer.jsp"/>