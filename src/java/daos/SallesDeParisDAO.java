/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import entities.Metro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jo
 */
public class SallesDeParisDAO {

    public static List<Metro> selectAll(Connection con) throws ClassNotFoundException {
        List<Metro> liste = new ArrayList();
        Metro SallesDeParis = null;
        try {
            String query = "select * from cinema_general_view";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SallesDeParis = new Metro(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                liste.add(SallesDeParis);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    } //selectAll

    public static JSONArray selectCinemaByArrondissement(String psChaine) {
        JSONArray tableauJSON = new JSONArray();
        JSONObject ObjetJSON;

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("SELECT nom_cinema, adresse_cinema, arrondissement.id_arrondissement, nom_arrondissement, code_arrondissement "
                    + "FROM arrondissement "
                    + "JOIN cinema "
                    + "ON arrondissement.id_arrondissement = cinema.id_arrondissement "
                    + "WHERE code_arrondissement = ? ");
            lpst.setString(1, psChaine);
            ResultSet lrs = lpst.executeQuery();

            while (lrs.next()) {
                ObjetJSON = new JSONObject();
                ObjetJSON.put("nom_cinema", lrs.getString(1));
                ObjetJSON.put("adresse_cinema", lrs.getString(2));
                ObjetJSON.put("nom_arrondissement", lrs.getString(4));
                ObjetJSON.put("code_arrondissement", lrs.getString(5));
                tableauJSON.put(ObjetJSON);
            }

        } catch (SQLException e) {

        }

        Connexion.seDeconnecter(lcn);

        return tableauJSON;

    }

}
