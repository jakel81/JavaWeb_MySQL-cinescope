/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jo
 */
public class MySQL2JSON {

    public static String table2Json(String psTable) {

        String chaineJSON;
        JSONArray tableauJSON = new JSONArray();
        JSONObject objetJSON;

        try {
            Connection lcn = Connexion.seConnecter("172.26.55.55", "cinescope2014", "3306", "p", "b");

            Statement lst = lcn.createStatement();
            ResultSet lrs = lst.executeQuery("SELECT * FROM " + psTable);
            ResultSetMetaData lrsmd = lrs.getMetaData();

            int liCols = lrsmd.getColumnCount();

            while (lrs.next()) {
                objetJSON = new JSONObject();
                for (int i = 1; i <= liCols; i++) {
                    objetJSON.put(lrsmd.getColumnName(i), lrs.getString(i));
                }
                tableauJSON.put(objetJSON);
            }
            lcn.close();
        } catch (Exception e) {
            tableauJSON = new JSONArray();
            objetJSON = new JSONObject();
            try {
                objetJSON.put("Erreur", e.getMessage());
            } catch (JSONException ex) {
            }
            tableauJSON.put(objetJSON);
        }
        chaineJSON = tableauJSON.toString();
        return chaineJSON;

    }

    /*
     TEST
     */
    public static void main(String[] args) {
        System.out.println(table2Json("pays"));
    }
}
