/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Horaire;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jo
 */
public class HoraireDAO {

    public static List<Horaire> selectHoraire(Connection pcnx) {
        List<Horaire> listeHoraire = new ArrayList();
        Horaire horaire;

        try {
            String lsSQL = "SELECT horaires_projection FROM projeter";
            try (PreparedStatement lpst = pcnx.prepareStatement(lsSQL); ResultSet lrs = lpst.executeQuery()) {
                while (lrs.next()) {
                    horaire = new Horaire(lrs.getString(1));
                    listeHoraire.add(horaire);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeHoraire;
    }
}
