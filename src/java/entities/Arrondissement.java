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
public class Arrondissement {
    
    public String codeArrondissement;
    public String nomArrondissement;

    public Arrondissement() {
    }

    public Arrondissement(String codeArrondissement, String nomArrondissement) {
        this.codeArrondissement = codeArrondissement;
        this.nomArrondissement = nomArrondissement;
    }

    public Arrondissement(String codeArrondissement) {
        this.codeArrondissement = codeArrondissement;
    }

    public String getCodeArrondissement() {
        return codeArrondissement;
    }

    public void setCodeArrondissement(String codeArrondissement) {
        this.codeArrondissement = codeArrondissement;
    }

    public String getNomArrondissement() {
        return nomArrondissement;
    }

    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }
    
    
}
