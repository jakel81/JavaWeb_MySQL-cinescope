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
public class Utilisateur implements java.io.Serializable {

    private int idUtilisateur;
    private String nom;
    private String mdp;
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String nom, String mdp, String email) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.mdp = mdp;
        this.email = email;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
