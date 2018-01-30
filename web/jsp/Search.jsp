<%-- 
    Document   : Search
    Created on : 16 oct. 2017, 16:28:13
    Author     : rayanakel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="col-md-4 col-md-offset-4 monHeader">
    <form class="form-inline" method="GET" action="/Cinescope2017Web/ResultatRecherchePrincipale">
        <div class="form-group">
            <label class="">Recherche (film ou acteur) : </label>
        </div>
        <div class="form-group">
            <input type="text" name="recherche" id="recherche" class="form-control" placeholder="taper votre recherche ici!" />
        </div> 
        <div class="form-group">
            <button type="submit" id="btSubmit" class="btn btn-primary">Valider</button>
        </div>
    </form>
</div>

