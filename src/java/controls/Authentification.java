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
import org.json.JSONObject;

/**
 *
 * @author Jo
 */
@WebServlet(name = "Authentification", urlPatterns = {"/Authentification"})
public class Authentification extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");
        JSONObject ut;

        try {
            PreparedStatement lpst = lcn.prepareStatement("SELECT * FROM utilisateur WHERE nom = ? AND mdp = ?");
            lpst.setString(1, request.getParameter("nom"));
            lpst.setString(2, request.getParameter("mdp"));
            ResultSet lrs = lpst.executeQuery();
            ut = new JSONObject();
            if (lrs.next()) {
                ut.put("id", lrs.getString(1));
                ut.put("nom", lrs.getString(2));
                ut.put("mdp", lrs.getString(3));
                ut.put("email", lrs.getString(4));
            } else {
                ut.put("id", "0");
                ut.put("nom", "inconnu");
                ut.put("mdp", "");
                ut.put("email", "");
            }
            out.print(ut.toString());
        } catch (Exception e) {
            out.println(e.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
