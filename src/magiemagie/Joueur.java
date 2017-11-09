/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Joueur {
    
    protected String nom;
    protected ArrayList<Carte> cartes = new ArrayList<>();

    @Override
    public String toString() {
        return "Nom" + this.nom + "cartes:" + this.cartes;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }


    
    
    
}
