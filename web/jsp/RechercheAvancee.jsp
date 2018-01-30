<%-- 
    Document   : Recherche
    Created on : 17 oct. 2017, 14:26:21
    Author     : rayanakel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" crossorigin="anonymous">
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
                <article id="articleAccueil">
                    <label class="messageOrange">
                        ${message}
                    </label>

                    <form method='GET'>

                        <fieldset>
                            <legend>Recherche Avancée</legend>
                            <p>Veuillez renseigner au moins un champ de recherche.</p>

                            <p>
                                <label for="titre">Titre</label>
                                <input type="text" name="titre" placeholder="Veuillez rentrer le titre d'un film" size="35" maxlength="60" value="<c:out value="${param.titre}"/>" autofocus/>
                            </p>

                            <p>
                                <label for="acteur">Acteur</label>
                                <input type="text" name="acteur" placeholder="Veuillez rentrer le nom d'un acteur" size="35" maxlength="60" value="<c:out value="${param.acteur}"/>"/>
                            </p>

                            <p>
                                <label for="realisateur">Réalisateur</label>
                                <input type="text" name="realisateur" placeholder="Veuillez rentrer le nom d'un réalisateur" size="35" maxlength="60" value="<c:out value="${param.realisateur}"/>"/>
                            </p>

                            <p>
                                <label for="horaire">Horaires</label>
                                <select name="horaire">
                                    <!--On recupere les horaires de la table projeter-->
                                    <option></option>
                                    <c:forEach var="horaire" items="${listeHoraire}">                                       
                                        <option>${horaire.horairesProjection}</option>
                                    </c:forEach>
                                </select>
                            </p>

                            <p>
                                <label for="ville">Ville</label>
                                <select name="ville">
                                    <!--On recupere les villes de la table ville-->
                                    <option></option>
                                    <c:forEach var="ville" items="${listeVille}">                                        
                                        <option>${ville.nomVille}</option>
                                    </c:forEach>
                                </select>
                            </p>                         

                            <p>
                                <label for="arrondissement">Arrondissement</label>
                                <select name="arrondissement">
                                    <!--On recupere les arrondissements de la table arrondissement-->
                                    <option></option>
                                    <c:forEach var="arrondissement" items="${listeArrondissement}">                                    
                                        <option>${arrondissement.codeArrondissement} ${arrondissement.nomArrondissement}</option>
                                    </c:forEach>
                                </select>
                            </p>

                            <p>
                                <label for="cinema">Cinéma</label>
                                <select name="cinema">
                                    <!--On recupere les cinemas de la table cinema-->
                                    <option></option>
                                    <c:forEach var="cinema" items="${listeCinema}">
                                        <option>${cinema.nomCinema}</option>
                                    </c:forEach>
                                </select>
                            </p>

                            <p>
                                <label for="genre">Genre</label>
                                <select name="genre">
                                    <!--On recupere les genres de la table genre-->
                                    <option></option>
                                    <c:forEach var="genre" items="${listeGenre}">
                                        <option>${genre.libelleGenre}</option>
                                    </c:forEach>

                                </select>
                            </p>                           
                        </fieldset><br>

                        <input type="submit" id='valider' value="Valider" class="sansLabel">
                        <input type="reset" id='effacer' value="Effacer" class="sansLabel">

                    </form>
                    ${message}

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
    </body>
</html>
