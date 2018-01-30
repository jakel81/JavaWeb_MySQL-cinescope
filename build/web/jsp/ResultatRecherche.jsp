<%-- 
    Document   : ResultatRecherche
    Created on : 14 nov. 2017, 20:55:21
    Author     : Jo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/jquery/jquery-ui.css" />
        <script src="/Cinescope2017Web/jquery/jquery.js"></script>
        <script src="/Cinescope2017Web/jquery/jquery-ui.js"></script>
        <script src="/Cinescope2017Web/jquery/bootstrap.min.js"></script>
        <title>Recherche avancée</title>
    </head>
    <body>

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <header>
                    <%@ include file="Header.jsp" %>
                </header>
            </div>
            <div class="col-md-1"></div>
        </div>

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <search>
                    <%@ include file="Search.jsp" %>
                </search>
            </div>
            <div class="col-md-1"></div>
        </div>

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-3">
                <nav>
                    <%@ include file="Nav.jsp" %>
                </nav>
            </div>

            <div class="col-md-7">
                <article id="articleResultatRecherche">
                    <h3>Résultat de la recherche "<strong>${saisieDeRecherche}</strong>" : 
                        <c:choose>
                            <c:when test="${fn:length(ListFilmResultat)=='0'}">
                                Aucun résultat<%-- zéro film dans  ListFilmResultat --%>
                                <br />
                            </c:when>
                            <c:when test="${fn:length(ListFilmResultat)=='1'}">
                                <c:out value="${fn:length(ListFilmResultat)}" />  résultat trouvé<%-- nombre de films dans  ListFilmResultat --%>
                                <br />
                            </c:when> 
                            <c:otherwise>
                                <c:out value="${fn:length(ListFilmResultat)}" />  résultats trouvés<%-- nombre de films dans  ListFilmResultat --%>
                                <br />
                            </c:otherwise>
                        </c:choose>
                    </h3>
                    <br>
                    <br>
                    <div class="row">
                        <c:forEach var="film" items="${ListFilmResultat}"><!--forEach de la liste des films-->
                            <div class="col-md-6"><!--6/12 pour un affichage des résultats en 2 blocs responsives-->
                                <ul class="list-group">
                                    <li class="list-group-item list-group-item-success"> Titre du film : ${film.titreFilm}</li><!--pour chaque film  on affiche le titre,etc...-->
                                    <li class="list-group-item"> Année de sortie : ${film.annee}</li>
                                    <li class="list-group-item"> En ${film.couleur}</li>
                                    <li class="list-group-item"> Genre : ${film.genre}</li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                </article>
            </div>
            <div class="col-md-1"></div>
        </div>

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <footer>
                    <%@ include file="Footer.jsp" %>
                </footer>
            </div>
            <div class="col-md-1"></div>
        </div>

        <script src="/Cinescope2017Web/js/bootstrap.min.js"></script>
        <script src="/Cinescope2017Web/js/main.js"></script>      
    </body>
</html>
