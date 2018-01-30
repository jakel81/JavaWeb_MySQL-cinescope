/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jo
 */
public class GenreDAO {

    public static List<Genre> selectGenre(Connection pcnx) {
        List<Genre> listeGenre = new ArrayList();
        Genre genre;

        try {
            String lsSQL = "SELECT libelle_genre FROM genre";
            try (PreparedStatement lpst = pcnx.prepareStatement(lsSQL); ResultSet lrs = lpst.executeQuery()) {
                while (lrs.next()) {
                    genre = new Genre(lrs.getString(1));
                    listeGenre.add(genre);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeGenre;
    }
}
