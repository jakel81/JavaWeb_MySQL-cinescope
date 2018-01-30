/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.FilmRecherche;
import java.util.List;

/**
 *
 * @author Jo
 */
public class FilmDAOTests {
    
    public static void main(String[] args) {
        List<FilmRecherche> liste = FilmDAO.getFilmsRecherche("titanic%");
        for (int i = 0; i < liste.size(); i++) {
            FilmRecherche filmRecherche = liste.get(i);
            System.out.println(filmRecherche.getTitreFilm());
        }
    }
}
