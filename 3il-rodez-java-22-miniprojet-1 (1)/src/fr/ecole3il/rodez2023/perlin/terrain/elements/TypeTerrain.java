package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

// Énumération représentant différents types de terrain
public enum TypeTerrain {

    // Différents types de terrain avec leur nom de fichier d'image associé
    FORET_FEUILLUS("deciduous_forest.png"),
    FORET_CONIFÈRES("coniferous_forest.png"),
    DESERT("desert.png"),
    MONTAGNE("mountain.png"),
    MARAIS("marsh.png"),
    COLLINES("hills.png"),
    OCEAN("ocean.png"),
    PLAINE("plain.png"),
    TOUNDRA("tundra.png");

    private final String fileName; // Nom du fichier de l'image associée à chaque type de terrain

    // Constructeur pour associer un nom de fichier à chaque type de terrain
    TypeTerrain(String fileName) {
        this.fileName = fileName;
    }

    // Méthode pour charger l'image correspondant au type de terrain
    public BufferedImage getImage() {
        return Utils.chargerTuile(this.fileName);
    }
}
