<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<div class="container">
    <section class="bg-light1 pt-5 pb-5">
        <div class="container">
            <div class="row">
                <h1 class="m-0 text-center">Create Game</h1>
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
            <form action="/admin/createGameSubmit" method="POST" enctype="multipart/form-data">

                <input type="hidden" name="id" value="${form.id}"/>

                <div class="mt-3 row justify-content-center">
                    <label for="gameName" class="col-sm-2 col-form-label">Game Name</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="text" class="form-control" id="gameName" name="gameName" value="${form.gameName}">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('gameName')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('gameName')}">
                                <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>


                <div class="mt-3 row justify-content-center">
                    <label for="abbr" class="col-sm-2 col-form-label">HTML Abbreviation</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="text" class="form-control" id="abbr" name="abbr" value="${form.abbr}">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('abbr')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('abbr')}">
                                <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <div class="mt-3 row justify-content-center">
                    <label for="upload" class="col-sm-2 col-form-label">Upload Image</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="file" class="form-control" id="upload" name="upload">
                    </div>
                </div>

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