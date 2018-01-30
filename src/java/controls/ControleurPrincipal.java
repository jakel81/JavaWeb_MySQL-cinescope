/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import connexion.Connexion;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rayanakel
 */
@WebServlet(name = "ControleurPrincipal", urlPatterns = {"/ControleurPrincipal"})
public class ControleurPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection lcn = Connexion.seConnecter("localhost", "8889", "root", "root", "cinescope2017");

        //Récuperation de la session courante
        HttpSession session = request.getSession();

        //Mise en session de la connection a la BD
        session.setAttribute("gcnx", lcn);

        String lsURL = "Accueil.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);
    } /// doGet

}
