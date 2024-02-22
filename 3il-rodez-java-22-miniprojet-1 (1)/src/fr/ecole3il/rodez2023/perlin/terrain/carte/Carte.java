package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.exceptions.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Scanner;

/**
 * La classe Carte représente une carte de terrain.
 */
public class Carte {

    // Attributs de la carte
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;

    /**
     * Constructeur pour créer une carte en utilisant un générateur de carte.
     * @param nom Le nom de la carte.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     * @param generateur Le générateur de carte à utiliser.
     */
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateur) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateur.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur pour créer une carte à partir de données de carte fournies sous forme de chaîne.
     * @param donneesCarte Les données de carte sous forme de chaîne.
     */
    public Carte(String donneesCarte){
        Scanner scanner = new Scanner(donneesCarte);
        this.nom = scanner.nextLine();
        this.largeur =  Integer.parseInt(scanner.nextLine());
        this.hauteur = Integer.parseInt(scanner.nextLine());

        this.terrains = new Terrain[largeur][hauteur];
        for(int i = 0; i < largeur; i++){
            for(int j = 0; j < hauteur; j++){
                try {
                    // Lire les données pour chaque terrain et créer un objet Terrain correspondant
                    String data = scanner.nextLine();
                    String alt = data.split(" ")[0];
                    String hydro = data.split(" ")[1];
                    String temp = data.split(" ")[2];
                    terrains[i][j] = new Terrain(Integer.parseInt(alt), Integer.parseInt(hydro), Integer.parseInt(temp));
                } catch (MauvaiseValeurException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Méthode pour obtenir le terrain à la position spécifiée.
     * @param x La position x du terrain.
     * @param y La position y du terrain.
     * @return Le terrain à la position spécifiée.
     * @throws TerrainInexistant Exception lancée si la position spécifiée est invalide.
     */
    public Terrain getTerrain(int x, int y) throws TerrainInexistant {
        if(x < 0 || x >= largeur || y < 0 || y >= hauteur)
            throw new TerrainInexistant("Le terrain demandé n'existe pas");
        return terrains[x][y];
    }

    // Getters et setters pour les attributs de la carte
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
