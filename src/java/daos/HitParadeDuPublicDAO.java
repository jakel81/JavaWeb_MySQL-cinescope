/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import connexion.Connexion;
import java.sql.*;

/**
 *
 * @author Jo
 */
public class HitParadeDuPublicDAO {

    public static String getHPP() {

        StringBuilder lsb = new StringBuilder();

        // eConnecter(String psIP, String psPort, String psUT, String psMDP, String psBD) {
        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL xxx_hit_parade_du_public()");
            ResultSet lrs = lpst.executeQuery();

            lsb.append("Titres ; Entrées semaine ; Nombres semaines ; Total entrées\n");

            while (lrs.next()) {
                lsb.append(lrs.getString(1));
                lsb.append(";");
                lsb.append(lrs.getString(2));
                lsb.append(";");
                lsb.append(lrs.getString(3));
                lsb.append(";");
                lsb.append(lrs.getString(4));
                lsb.append("\n");

            }
        } catch (Exception e) {
            lsb.append(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return lsb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHPP());
    }

}
