/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jo
 */
public class Genre {

    public String libelleGenre;

    public Genre(String libelleGenre) {
        this.libelleGenre = libelleGenre;
    }

    public Genre() {
    }

    public String getLibelleGenre() {
        return libelleGenre;
    }

    public void setLibelleGenre(String libelleGenre) {
        this.libelleGenre = libelleGenre;
    }

}
