package fr.ecole3il.rodez2023.perlin.terrain.visualisation;


public enum TemperatureAffichee {

    FROID,
    DOUX,
    CHAUD;

    public static TemperatureAffichee determinerTemperature(double temperature) {
        if (temperature < 0.33) {
            return FROID;
        } else if (temperature < 0.66) {
            return DOUX;
        } else {
            return CHAUD;
        }
    }
}
