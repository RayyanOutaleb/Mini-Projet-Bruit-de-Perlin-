package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.exceptions.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

// Classe représentant les caractéristiques d'un terrain
public class Terrain {

    private final double altitude; // Altitude du terrain
    private final double temperature; // Température du terrain
    private final double hydrometrie; // Hydrométrie du terrain

    // Constructeur pour initialiser les caractéristiques du terrain
    public Terrain(double altitude, double temperature, double hydrometrie) throws MauvaiseValeurException {
        // Assure que les valeurs sont dans les plages valides
        hydrometrie = Math.abs(hydrometrie); // L'hydrométrie doit être positive
        temperature = Math.abs(temperature); // La température doit être positive
        if (altitude < -1 || altitude > 1) throw new MauvaiseValeurException("L'altitude doit être entre 0 et 1: " + altitude);
        if (temperature < 0 || temperature > 1) throw new MauvaiseValeurException("La température doit être entre 0 et 1: " + temperature);
        if (hydrometrie < 0 || hydrometrie > 1) throw new MauvaiseValeurException("L'hydrométrie doit être entre 0 et 1: " + hydrometrie);
        this.altitude = altitude;
        this.temperature = temperature;
        this.hydrometrie = hydrometrie;
    }

    // Méthode pour obtenir le type de terrain en utilisant un détermineur de terrain
    public TypeTerrain getTypeTerrain(DetermineurTerrain determineurTerrain) {
        return determineurTerrain.determinerTerrain(this.altitude, this.hydrometrie, this.temperature);
    }

    // Getters pour obtenir les caractéristiques du terrain
    public double getAltitude() {
        return altitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHydrometrie() {
        return hydrometrie;
    }
}
