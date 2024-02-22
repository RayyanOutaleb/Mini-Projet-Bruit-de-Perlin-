package fr.ecole3il.rodez2023.perlin.terrain.visualisation;


public enum     AltitudeAffichee {

    FOND_MARIN, BASSE,MOYENNE, ELEVEE;


    public static AltitudeAffichee determinerAltitude(double altitude) {
        if (altitude < 0) {
            return FOND_MARIN;
        } else if (altitude < 0.5) {
            return BASSE;
        } else if (altitude < 0.8) {
            return MOYENNE;
        } else {
            return ELEVEE;
        }
    }
}
