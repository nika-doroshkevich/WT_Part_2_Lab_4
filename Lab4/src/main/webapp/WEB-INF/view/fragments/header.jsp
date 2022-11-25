<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <jsp:include page="headerLinks.jsp"/>
</head>


<header>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="localization.language" var="loc"/>
    <fmt:setBundle basename="information" var="info"/>


    <form action=${pageContext.request.contextPath}/hotel method="get">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary" style="font-size: 20px">

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <a class="navbar-brand" style="font-size: 22px">
                        <fmt:message bundle="${info}" key="information.name"/>
                    </a>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/hotel?command=main">
                            <fmt:message bundle="${loc}" key="language.home"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/hotel?command=catalog">
                            <fmt:message bundle="${loc}" key="language.catalog"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/hotel?command=contacts">
                            <fmt:message bundle="${loc}" key="language.contacts"/>
                        </a>
                    </li>
                    <c:if test="${role.name == 'admin'}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
                               role="button"
                               aria-haspopup="true" aria-expanded="false">
                                <fmt:message bundle="${loc}" key="language.control"/>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="userDropdown">
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/hotel?command=addApartment"><fmt:message bundle="${loc}" key="language.addApartment"/></a>
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/hotel?command=viewOrders"><fmt:message bundle="${loc}" key="language.viewUserOrders"/></a>
                            </div>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav">
                    <c:choose>
                        <c:when test="${sessionScope.language=='en'}">

                            <li class="nav-item">
                                <a class="nav-link active"
                                   href="${pageContext.request.contextPath}/online-shop?${pageContext.request.queryString}&language=en">
                                    EN
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="navbar-brand">
                                    <img src="static/images/flags/EN.png" width="30" height="20"/>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="${pageContext.request.contextPath}/online-shop?${pageContext.request.queryString}&language=ru">
                                    RU
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="navbar-brand">
                                    <img src="static/images/flags/RU.png" width="30" height="20"/>
                                </a>
                            </li>
                        </c:when>
                        <c:when test="${sessionScope.language=='ru'}">
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="${pageContext.request.contextPath}/online-shop?${pageContext.request.queryString}&language=en">
                                    EN
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="navbar-brand">
                                    <img src="static/images/flags/EN.png" width="30" height="20"/>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active"
                                   href="${pageContext.request.contextPath}/online-shop?${pageContext.request.queryString}&language=ru">
                                    RU
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="navbar-brand">
                                    <img src="static/images/flags/RU.png" width="30" height="20"/>
                                </a>
                            </li>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${sessionScope.user == null}">
                            <li class="nav-item">
                                <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="command"
                                        value="logIn">
                                    <fmt:message bundle="${loc}" key="language.logIn"/>
                                </button>
                            </li>
                        </c:when>




                        <c:when test="${sessionScope.user != null}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="userDropdown" data-bs-toggle="dropdown" href="#"
                                   role="button"
                                   aria-haspopup="true" aria-expanded="false">
                                        ${sessionScope.user.email}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="userDropdown">
                                    <a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/hotel?command=profile">
                                        <fmt:message bundle="${loc}" key="language.profile"/></a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/hotel?command=myOrders"><fmt:message bundle="${loc}"
                                                                                                                                                 key="language.myOrders"/></a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/hotel?command=logOut">
                                        <fmt:message bundle="${loc}" key="language.logOut"/></a>
                                </div>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</header>