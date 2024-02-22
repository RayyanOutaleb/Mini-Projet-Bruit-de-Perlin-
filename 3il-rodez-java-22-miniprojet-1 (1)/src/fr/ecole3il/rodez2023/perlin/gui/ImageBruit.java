package fr.ecole3il.rodez2023.perlin.gui;

import java.awt.image.BufferedImage;

import fr.ecole3il.rodez2023.perlin.Utils;
import fr.ecole3il.rodez2023.perlin.math.Bruit2D;

/**
 * La classe ImageBruit génère une image représentant du bruit en utilisant un générateur de bruit 2D.
 * Elle crée une image en noir et blanc basée sur les valeurs de bruit générées.
 */
public class ImageBruit {

    /** Le temps utilisé pour animer le bruit */
    private double time;

    /** Le générateur de bruit utilisé pour créer l'image */
    private final Bruit2D generateurBruit;

    /**
     * Constructeur de la classe ImageBruit.
     * @param generateurBruit Le générateur de bruit 2D à utiliser pour la génération d'image.
     */
    public ImageBruit(Bruit2D generateurBruit) {
        this.time = 0;
        this.generateurBruit = generateurBruit;
    }

    /**
     * Génère une image de bruit en noir et blanc avec les dimensions spécifiées.
     * @param width La largeur de l'image à générer.
     * @param height La hauteur de l'image à générer.
     * @return Une instance de BufferedImage représentant l'image de bruit générée.
     */
    public BufferedImage getNoiseImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Incrémente le temps pour animer le bruit
        time += 0.01;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double dx = (double) x / Utils.min(width, height);
                double dy = (double) y / Utils.min(width, height);
                int frequence = 6;
                // Obtient la valeur de bruit pour les coordonnées actuelles
                double bruit = fonctionDeBruit((dx * frequence) + time, (dy * frequence) + time);
                // Normalise la valeur de bruit à l'échelle de 0 à 1
                bruit = (bruit - 1) / 2;
                // Convertit la valeur de bruit en valeur RGB
                int b = (int) (bruit * 0xFF);
                int g = b * 0x100;
                int r = b * 0x10000;
                int finalValue = r;
                // Définit la couleur de pixel dans l'image
                image.setRGB(x, y, finalValue);
            }
        }
        return image;
    }

    /**
     * Méthode interne utilisée pour obtenir la valeur de bruit à une position spécifique.
     * @param d Coordonnée x pour laquelle obtenir le bruit.
     * @param e Coordonnée y pour laquelle obtenir le bruit.
     * @return La valeur de bruit en 2D pour les coordonnées fournies.
     */
    private double fonctionDeBruit(double d, double e) {
        return generateurBruit.bruit2D(d, e);
    }
}
