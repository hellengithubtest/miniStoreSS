<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
<body>
<nav aria-label="...">
<ul class="pagination">
    <%-- Show Prev as link if not on first page --%>
    <c:choose>
    <c:when test="${(number) == 0}">
        <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1">Previous</a>
            </li>
    </c:when>
    <c:otherwise>
        <li class="page-item">
              <a class="page-link" href="/products?page=${(number) - 1}&filter=${filter}&size=${size}">Previous</a>
        </li>
    </c:otherwise>
    </c:choose>

<c:forEach begin="1" end="${totalPages}" step="1" varStatus="tagStatus" >
        <c:choose>
         <c:when test="${(number) == (tagStatus.index) - 1}">
            <li class="page-item active">
                  <a class="page-link" href="/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}">${tagStatus.index}<span class="sr-only">(current)</span></a>
            </li>
         </c:when>
         <c:otherwise>
            <c:set var="current" value="${(number)}"/>
            <c:set var="next" value="${(number) + 1}"/>
            <c:set var="nextNext" value="${(number) + 2}"/>
            <c:set var="nextNextnext" value="${(number) + 3}"/>
            <c:set var="prev" value="${(number) - 1}"/>
            <c:set var="prevPrev" value="${(number) - 2}"/>
            <c:choose>
                <c:when test="${(tagStatus.index) == (current)}">
                           <li class="page-item"><a class="page-link" href='/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}'>${tagStatus.index}</a>
                           </li>
                </c:when>
                <c:when test="${(tagStatus.index) == (next)}">
                            <li class="page-item"><a class="page-link" href='/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}'>${tagStatus.index}</a>
                            </li>
                </c:when>
                <c:when test="${(tagStatus.index) == (nextNext)}">
                            <li class="page-item"><a class="page-link" href='/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}'>${tagStatus.index}</a>
                            </li>
                </c:when>
                <c:when test="${(tagStatus.index) == (nextNextnext)}">
                            <li class="page-item"><a class="page-link" href='/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}'>${tagStatus.index}</a>
                            </li>
                </c:when>

                <c:when test="${(tagStatus.index) == (prev)}">
                            <li class="page-item"><a class="page-link" href='/products?page=${(tagStatus.index) - 1}&filter=${filter}&size=${size}'>${tagStatus.index}</a>
                            </li>
                </c:when>
            </c:choose>
         </c:otherwise>
         </c:choose>
</c:forEach>
<c:choose>
    <%-- Show Next as link if not on last page --%>
    <c:when test="${(number) == ((totalPages) - 1)}">
        <li class="page-item disabled">
             <span class="page-link" value="#">Next</span>
        </li>
    </c:when>
    <c:otherwise>
        <li class="page-item">
             <a class="page-link" href="/products?page=${(number) + 1}&filter=${filter}&size=${size}">Next</a>
        </li>
    </c:otherwise>
</c:choose>
</ul>
</nav>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>