/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Arrondissement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jo
 */
public class ArrondissementDAO {

    public static List<Arrondissement> selectArrondissement(Connection pcnx) {
        List<Arrondissement> listeArrondissement = new ArrayList();
        Arrondissement arrondissement;

        try {
            String lsSQL = "SELECT code_arrondissement, nom_arrondissement FROM arrondissement";
            try (PreparedStatement lpst = pcnx.prepareStatement(lsSQL); ResultSet lrs = lpst.executeQuery()) {
                while (lrs.next()) {
                    arrondissement = new Arrondissement(lrs.getString(1), lrs.getString(2));
                    listeArrondissement.add(arrondissement);
                    System.out.println(arrondissement);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeArrondissement;
    }

}
