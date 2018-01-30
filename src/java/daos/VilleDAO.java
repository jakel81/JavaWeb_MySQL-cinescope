/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Ville;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jo
 */
public class VilleDAO {

    public static List<Ville> selectVille(Connection pcnx) {
        List<Ville> listeVille = new ArrayList();
        Ville ville;

        try {
            String lsSQL = "SELECT nom_ville FROM ville";
            try (PreparedStatement lpst = pcnx.prepareStatement(lsSQL); ResultSet lrs = lpst.executeQuery()) {
                while (lrs.next()) {
                    ville = new Ville(lrs.getString(1));
                    listeVille.add(ville);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeVille;
    }
}
