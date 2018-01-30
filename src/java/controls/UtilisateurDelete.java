/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jo
 */
@WebServlet(name = "UtilisateurDelete", urlPatterns = {"/UtilisateurDelete"})
public class UtilisateurDelete extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset = UTF-8");
        PrintWriter out = response.getWriter();

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("DELETE FROM utilisateur WHERE id = ?");
            lpst.setString(1, request.getParameter("id"));
            int liAffecte = lpst.executeUpdate();
            out.print(liAffecte);

            lcn.commit();

        } catch (SQLException e) {
            out.print(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

    }

}
