/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import daos.ArrondissementDAO;
import daos.CinemaDAO;
import daos.GenreDAO;
import daos.HoraireDAO;
import daos.VilleDAO;
import entities.Arrondissement;
import entities.Cinema;
import entities.Genre;
import entities.Horaire;
import entities.Ville;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jo
 */
@WebServlet(name = "RechercheAvancee", urlPatterns = {"/RechercheAvancee"})
public class RechercheAvanceeCTRL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String lsMessage;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            try (Connection lcn = DriverManager.getConnection("jdbc:mysql://localhost:8889/cinescope2017", "root", "root")) {
                List<Cinema> listeCinema = CinemaDAO.selectCinema(lcn);
                request.setAttribute("listeCinema", listeCinema);

                List<Genre> listeGenre = GenreDAO.selectGenre(lcn);
                request.setAttribute("listeGenre", listeGenre);

                List<Ville> listeVille = VilleDAO.selectVille(lcn);
                request.setAttribute("listeVille", listeVille);

                List<Horaire> listeHoraire = HoraireDAO.selectHoraire(lcn);
                request.setAttribute("listeHoraire", listeHoraire);

                List<Arrondissement> listeArrondissement = ArrondissementDAO.selectArrondissement(lcn);
                request.setAttribute("listeArrondissement", listeArrondissement);
                lsMessage = "OK";
            }
        } catch (ClassNotFoundException | SQLException e) {
            lsMessage = e.getMessage();
        }
        request.setAttribute("message", lsMessage);
        getServletContext().getRequestDispatcher("/jsp/RechercheAvancee.jsp").forward(request, response);
    }
}
