<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <head>
      <title></title>
   </head>

   <body>

      <!-- Include _menu.html -->
          <jsp:include page="menu.jsp"/>

      <h2>Message : <span th:utext="${message}"></span></h2>

   </body>
</html>