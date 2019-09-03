<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-default bg-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">Mini Market</a>
  <div>
    <ul class="navbar-nav">
      <li class="active">
        <a class="nav-link" href="${pageContext.request.contextPath}/products">Products</a>
      </li>
      <sec:authorize access="isAuthenticated()">
      <li>
        <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin</a>
      </li>
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
        <li>
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </li>
      </sec:authorize>
      <sec:authorize access="!isAuthenticated()">
      <li>
        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
      </li>
      </sec:authorize>
      <li>
        <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
      </li>
    </ul>
  </div>
</nav>