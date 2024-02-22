package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe BruitAleatoire étend la classe Bruit2D et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe Random de Java pour générer des valeurs aléatoires.
 */
public class BruitAleatoire extends Bruit2D {

    // Instance de Random pour générer des valeurs aléatoires
    private final Random random;

    /**
     * Constructeur pour initialiser le générateur de bruit aléatoire avec une graine et une résolution spécifiées.
     * @param graine La graine utilisée pour initialiser le générateur de nombres aléatoires.
     * @param resolution La résolution du bruit.
     */
    public BruitAleatoire(long graine, double resolution) {
        // Appelle le constructeur de la classe parent Bruit2D
        super(graine, resolution);
        // Initialise l'instance de Random avec la graine spécifiée
        this.random = new Random(graine);
    }

    /**
     * Méthode pour générer du bruit aléatoire en deux dimensions.
     * @param x La coordonnée x.
     * @param y La coordonnée y.
     * @return La valeur de bruit générée.
     */
    @Override
    public double bruit2D(double x, double y) {
        // Génère et retourne une valeur aléatoire dans l'intervalle [0, 1)
        return random.nextDouble();
    }

}
