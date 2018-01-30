/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import entities.Cinema;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jo
 */
public class CinemaDAO {

    public static List<Cinema> selectCinema(Connection pcnx) {
        List<Cinema> listeCinema = new ArrayList();
        Cinema cinema;

        try {
            String lsSQL = "SELECT nom_cinema FROM cinema";
            try (PreparedStatement lpst = pcnx.prepareStatement(lsSQL); ResultSet lrs = lpst.executeQuery()) {
                while (lrs.next()) {
                    cinema = new Cinema(lrs.getString(1));
                    listeCinema.add(cinema);
                    System.out.println(cinema);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeCinema;
    }

    public static JSONObject getAdLaLo(String psCodeCinema) {

        JSONObject objetJSON = null;

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("SELECT adresse_cinema, nom_ville FROM cinema INNER JOIN ville ON cinema.id_ville = ville.id_ville WHERE code_cinema = ?");
            lpst.setString(1, psCodeCinema);
            ResultSet lrs = lpst.executeQuery();

            if (lrs.next()) {
                objetJSON = new JSONObject();
                objetJSON.put("code", psCodeCinema);
                objetJSON.put("adresse", lrs.getString(1));
                objetJSON.put("ville", lrs.getString(2));
            } else {
                objetJSON.put("code", psCodeCinema);
                objetJSON.put("adresse", "introuvable");
                objetJSON.put("ville", "");
            }

            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return objetJSON;
    }

    public static JSONObject setAdLaLo(String psCodeCinema, double pdLat, double pdLng) {

        JSONObject objetJSON = null;

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("UPDATE cinema SET lat = ?, lng = ? WHERE code_cinema = ?");
            lpst.setDouble(1, pdLat);
            lpst.setDouble(2, pdLng);
            lpst.setString(3, psCodeCinema);

            int liAffecte = lpst.executeUpdate();

            objetJSON = new JSONObject();

            if (liAffecte == 1) {
                objetJSON.put("maj", "1");
                lcn.commit();
            } else {
                objetJSON.put("maj", "0");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return objetJSON;

    }

    public static JSONArray getAdCinema() {

        JSONArray tableauJSON = new JSONArray();
        JSONObject objetJSON;

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("SELECT code_cinema, adresse_cinema, nom_ville FROM cinema INNER JOIN ville ON cinema.id_ville = ville.id_ville");

            ResultSet lrs = lpst.executeQuery();

            while (lrs.next()) {
                objetJSON = new JSONObject();
                objetJSON.put("code", lrs.getString(1));
                objetJSON.put("adresse", lrs.getString(2));
                objetJSON.put("ville", lrs.getString(3));
                tableauJSON.put(objetJSON);
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return tableauJSON;
    }
}
