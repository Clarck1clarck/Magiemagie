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

    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private Joueur joueurEnCours;

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

        boolean termine = false;
        do {

            //1. Afficher le menu
            System.out.println("A vous de joueur : " + this.joueurEnCours.getNom());
            System.out.println("Vos cartes : " + this.joueurEnCours.getCartes());

            System.out.println("1: Lancer sort");
            System.out.println("2: Passer son tour");

            // Saisie clavier
            // String choix = new Scanner(System.in).nextLine();
            // (soit l'une ou l'autre des phrases)
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();

            //2. Passer sort ou passer tour
            switch (choix) {
                case "1":
                    this.lancerSort();
                    termine = true;
                    break;
                case "2":
                    this.passerTour();
                    termine = true;
                    break;
                default:
                    break;
            }
        } while (termine == false);
    }

    public void passerTour() {

    }

    public void lancerSort() {

        boolean termine = false;
        while (termine == false) {
            //1. Afficher les différent sorts possibles que le joueur peut lancer
            Carte carteCorneLicorne = new Carte();
            Carte carteBaveCrapaud = new Carte();
            Carte carteMandragore = new Carte();
            Carte carteAilesCSS = new Carte();
            Carte carteLapisLazuli = new Carte();

            carteCorneLicorne.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
            carteBaveCrapaud.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
            carteMandragore.setType(Carte.TypeCarte.MANDRAGORE);
            carteAilesCSS.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
            carteLapisLazuli.setType(Carte.TypeCarte.LAPIS_LAZULI);

            if (this.joueurEnCours.getCartes().contains(carteCorneLicorne)
                    && this.joueurEnCours.getCartes().contains(carteBaveCrapaud)) {
                System.out.println("[1] Invisbilité");
            }
            if (this.joueurEnCours.getCartes().contains(carteCorneLicorne)
                    && this.joueurEnCours.getCartes().contains(carteMandragore)) {
                System.out.println("[2] Philtre d'amour");
            }
            if (this.joueurEnCours.getCartes().contains(carteBaveCrapaud)
                    && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {
                System.out.println("[3] Hypnose");
            }
            if (this.joueurEnCours.getCartes().contains(carteLapisLazuli)
                    && this.joueurEnCours.getCartes().contains(carteAilesCSS)) {
                System.out.println("[4] Divinité");
            }
            if (this.joueurEnCours.getCartes().contains(carteMandragore)
                    && this.joueurEnCours.getCartes().contains(carteBaveCrapaud)) {
                System.out.println("[5] Sommeil profond");
            }

            //2. Saisi sort à lancer
            //Saisie clavier
            //String choix = new Scanner(System.in).nextLine();
            //(soit l'une ou l'autre des frases)
            Scanner scanner = new Scanner(System.in);
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
              sortIvisibilite();
                    break;
                case "2":
                  sortPhiltreAmour();
                    break;
                case "3":
                   sortHypnose();
                    break;
                case "4":
                    sortDivination();
                    break;
                case "5":
                     sortSommeilProfond();
                    break;
                default:
                    System.out.println("Ce sort n'existe pas");
                    break;
            }
        }

        //3. Lancement du sort
        //4. Supprime les 2 cartes ayant permis de lancer sort
    }

    private void sortSommeilProfond() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortDivination() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortHypnose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortPhiltreAmour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortIvisibilite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
