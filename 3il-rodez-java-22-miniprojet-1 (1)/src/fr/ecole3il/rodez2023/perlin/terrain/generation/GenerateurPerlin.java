package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

// Classe pour générer une carte de terrain en utilisant le bruit de Perlin
public class GenerateurPerlin extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte de terrain avec le bruit de Perlin.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurPerlin(long graine) {
        super(graine);
    }

    // Méthode pour générer un terrain à une position donnée dans la carte en utilisant le bruit de Perlin
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        try {
            // Convertir les coordonnées de grille en valeurs normalisées entre 0 et 1
            double x = (double) i / (double) largeur;
            double y = (double) j / (double) hauteur;

            // Utiliser le bruit de Perlin pour générer les valeurs d'altitude, d'hydrométrie et de température
            double hydrometrie = new BruitPerlin2D(this.getGraine(), 1.0).bruit2D(x, y);
            double temperature = new BruitPerlin2D(this.getGraine() * 2, 1.0).bruit2D(x, y);
            double altitude = new BruitPerlin2D(this.getGraine() * 4, 1.0).bruit2D(x, y);

            // Retourner un terrain avec les valeurs générées
            return new Terrain(altitude, temperature, hydrometrie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
