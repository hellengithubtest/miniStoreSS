<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-default bg-light">
  <a class="navbar-brand" href="/welcome">Mini Market</a>
  <div>
    <ul class="navbar-nav">
      <li class="active">
        <a class="nav-link" href="/products">Products</a>
      </li>
      <sec:authorize access="isAuthenticated()">
      <li>
        <a class="nav-link" href="/admin">Admin</a>
      </li>
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
        <li>
            <a class="nav-link" href="/logout">Logout</a>
        </li>
      </sec:authorize>
      <li>
        <a class="nav-link" href="/login">Login</a>
      </li>
      <li>
        <a class="nav-link" href="/about">About</a>
      </li>
    </ul>
  </div>
</nav>