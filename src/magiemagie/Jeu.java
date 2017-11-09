/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class Jeu {

    protected ArrayList<Joueur> joueurs = new ArrayList<>();
    protected Joueur joueurEnCours;

    public void afficherMenuPrincipal() {

        boolean quitter = false;
        while (quitter == false) //        Afficher menu
        {
            System.out.println("Menu");
            System.out.println("----");
            System.out.println("1: Nouveau joueur");
            System.out.println("2: demarrer partie");
            System.out.println("L: Liste des joueurs");
            System.out.println("3: Quitter");

//        Saisie clavier
//            String choix = new Scanner(System.in).nextLine();
//        (soit l'une ou l'autre des frases)
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();

            switch (choix) {
                case "L":
                    System.out.println(this.joueurs);
                    break;
                case "1":
                    afficherMenuNouveauJoueur();
                    break;
                case "2":
                    demarrerPartie();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Commande inconnue");
                    break;
            }
        }
    }

    public void afficherMenuNouveauJoueur() {
        // 1.saisi nom joueur
        System.out.print("Entrer nouveau joueur : ");
        Scanner nj = new Scanner(System.in);
        String nomJoueur = nj.nextLine();

        // 2. créer un joueur et lui set le nom
        Joueur joueur = new Joueur();
        joueur.setNom(nomJoueur);

        // 3. Ajouter et enregistrer dans liste joueur
        this.joueurs.add(joueur);
    }

    public void demarrerPartie() {

        //1. Distribuer 7 cartes par joueur
        for (Joueur joueur : joueurs) {
            for (int i = 0; i < 7; i++) {

                Carte carte = new Carte();

                // Distribuer 7 cartes pour le joueur actuel
                Random random = new Random();
                int nb = random.nextInt(5);
                switch (nb) {
                    case 0:
                        carte.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
                        break;
                    case 1:
                        carte.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
                        break;
                    case 2:
                        carte.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
                        break;
                    case 3:
                        carte.setType(Carte.TypeCarte.LAPIS_LAZULI);
                        break;
                    case 4:
                        carte.setType(Carte.TypeCarte.MANDRAGORE);
                        break;
                    default:
                        break;
                }
                // Distribue 7 cartes aux joueurs.noteperso
                joueur.getCartes().add(carte);
            }
        }

        //2. Donner la main au premier joueur avec .get
        this.joueurEnCours = this.joueurs.get(0);

        //3. Afficher le menu action
        this.menuAction();
    }

    public ArrayList getJoueur() {
        return joueurs;
    }

    public void setJoueur(ArrayList Joueur) {
        this.joueurs = Joueur;
    }

    public void menuAction() {

        //1. Afficher le menu
        System.out.println("A vous de joueur : " + this.joueurEnCours.getNom());
        System.out.println("Vos cartes : " + this.joueurEnCours.getCartes());

        System.out.println("2: Passer son tour");
        System.out.println("1: Lancer sort");

        // Saisie clavier
        // String choix = new Scanner(System.in).nextLine();
        // (soit l'une ou l'autre des phrases)
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();

        //2. Passer sort ou passer tour
        switch (choix) {
            case "1":
                this.lancerSort();
                break;
            case "2":
                this.passerTour();
                break;
            default:
                break;
        }
    }

    public void passerTour() {

    }

    public void lancerSort() {

    }
}
