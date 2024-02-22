package fr.ecole3il.rodez2023.perlin.terrain.visualisation;


public enum HydrometrieAffichee {

    SEC,
    MOYEN,
    HUMIDE;

    public static HydrometrieAffichee determinerHydrometrie(double hydrometrie) {
        if (hydrometrie < 0.33) {
            return SEC;
        } else if (hydrometrie < 0.66) {
            return MOYEN;
        } else {
            return HUMIDE;
        }
    }

}
