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
public class Horaire {

    public String horairesProjection;

    public Horaire(String horairesProjection) {
        this.horairesProjection = horairesProjection;
    }

    public Horaire() {
    }

    public String getHorairesProjection() {
        return horairesProjection;
    }

    public void setHoraire(String horairesProjection) {
        this.horairesProjection = horairesProjection;
    }

}
