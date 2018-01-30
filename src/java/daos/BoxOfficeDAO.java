/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/**
 *
 * @author Jo
 */
public class BoxOfficeDAO {

    public static String getBO() {

//        StringBuilder lsb = new StringBuilder();
        JSONArray objetArray = null;

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL xxx_box_office()");
            ResultSet lrs = lpst.executeQuery();

            List<Map<String, String>> listeJSON = new ArrayList();
            Map<String, String> map;

            while (lrs.next()) {
                map = new LinkedHashMap();
                map.put("titre", lrs.getString(1));
                map.put("entrees", lrs.getString(2));
                listeJSON.add(map);
            }

            objetArray = new JSONArray(listeJSON);

//            while (lrs.next()) {
//                lsb.append(lrs.getString(1));
//                lsb.append("....................");
//                lsb.append(lrs.getString(2));
//                lsb.append("\n");
//
//            }
        } catch (Exception e) {
//            lsb.append(e.getMessage());
            System.out.println(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

//        return lsb.toString();
        return objetArray.toString();
    }

    public static void main(String[] args) {
        System.out.println(getBO());
    }

}
