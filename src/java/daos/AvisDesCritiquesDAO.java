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
public class AvisDesCritiquesDAO {

    public static String getADC() {

        StringBuilder lsb = new StringBuilder();

        Connection lcn = Connexion.seConnecter("172.26.55.55", "3306", "p", "b", "cinescope2014");

        try {
            PreparedStatement lpst = lcn.prepareStatement("CALL avis_des_critiques_tcd()");
            ResultSet lrs = lpst.executeQuery();

            //lsb.append("D.Denorme \n A.Gaillard \n PARISCOPE | Gerard \n Delorme \n PREMIERE| Bernard \n Achour \n VSD | Bruno \n Cras \n EUROPE 1 | Alain \n Spira \n PARIS MATCH | Pierre \n Murat \n TELERAMA\n");
            while (lrs.next()) {
                lsb.append(lrs.getString(1));
                lsb.append(";");
                lsb.append(lrs.getString(2));
                lsb.append(";");
                lsb.append(lrs.getString(3));
                lsb.append(";");
                lsb.append(lrs.getString(4));
                lsb.append(";");
                lsb.append(lrs.getString(5));
                lsb.append(";");
                lsb.append(lrs.getString(6));
                lsb.append("\n");

            }
        } catch (Exception e) {
            lsb.append(e.getMessage());
        }

        Connexion.seDeconnecter(lcn);

        return lsb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getADC());
    }

}
