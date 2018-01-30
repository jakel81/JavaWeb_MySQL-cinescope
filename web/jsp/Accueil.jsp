<%-- 
    Document   : Accueil
    Created on : 16 oct. 2017, 16:27:57
    Author     : rayanakel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" crossorigin="anonymous">
        <title>Accueil FO</title>
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
                    <br><br>
                    <img src="/Cinescope2017Web/images/cinema.jpg" alt="Photo" title="Photo" width="400" height="330"/>
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
