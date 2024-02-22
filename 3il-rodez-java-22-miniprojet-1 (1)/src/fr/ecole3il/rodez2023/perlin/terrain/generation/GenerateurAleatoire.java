package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

// Classe pour générer aléatoirement une carte de terrain
public class GenerateurAleatoire extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte aléatoire.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
    }

    // Méthode pour générer aléatoirement un terrain à une position donnée dans la carte
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        try {
            // Création d'un terrain avec des valeurs aléatoires pour l'altitude, l'hydrométrie et la température
            return new Terrain(new Random().nextFloat(-1, 1), new Random().nextFloat(0, 1), new Random().nextFloat(0, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
