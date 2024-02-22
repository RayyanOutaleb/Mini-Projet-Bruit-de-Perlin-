package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.carte.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

/**
 * La classe abstraite VisualiseurTerrain fournit des méthodes pour visualiser les différents aspects d'une carte.
 * Elle permet de déterminer le type de terrain, l'altitude affichée, l'hydrométrie affichée et la température affichée à une position donnée sur la carte.
 */
public abstract class VisualiseurTerrain {

    private Carte carte;
    private DetermineurTerrain determineurTerrain;

    /**
     * Constructeur de la classe VisualiseurTerrain.
     *
     * @param determineurTerrain le détermineur de terrain utilisé pour la visualisation
     * @param carte la carte à visualiser
     */
    public VisualiseurTerrain(DetermineurTerrain determineurTerrain, Carte carte) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    /**
     * Retourne le type de terrain à une position spécifiée sur la carte.
     *
     * @param x la position horizontale sur la carte
     * @param y la position verticale sur la carte
     * @return le type de terrain à la position spécifiée
     */
    public TypeTerrain getTypeTerrain(int x, int y)  {
        try{
            Terrain terrain = carte.getTerrain(x, y);
            return determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature());
        } catch (TerrainInexistant terrainInexistant) {
            terrainInexistant.printStackTrace();
        }
        return null;
    }

    /**
     * Retourne l'altitude affichée à une position spécifiée sur la carte.
     *
     * @param x la position horizontale sur la carte
     * @param y la position verticale sur la carte
     * @return l'altitude affichée à la position spécifiée
     */
    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        try{
            Terrain terrain = carte.getTerrain(x, y);
            return AltitudeAffichee.determinerAltitude(terrain.getAltitude());
        } catch (TerrainInexistant terrainInexistant) {
            terrainInexistant.printStackTrace();
        }
        return null;
    }

    /**
     * Retourne l'hydrométrie affichée à une position spécifiée sur la carte.
     *
     * @param x la position horizontale sur la carte
     * @param y la position verticale sur la carte
     * @return l'hydrométrie affichée à la position spécifiée
     */
    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        try{
            Terrain terrain = carte.getTerrain(x, y);
            return HydrometrieAffichee.determinerHydrometrie(terrain.getHydrometrie());
        } catch (TerrainInexistant terrainInexistant) {
            terrainInexistant.printStackTrace();
        }
        return null;
    }

    /**
     * Retourne la température affichée à une position spécifiée sur la carte.
     *
     * @param x la position horizontale sur la carte
     * @param y la position verticale sur la carte
     * @return la température affichée à la position spécifiée
     */
    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        try{
            Terrain terrain = carte.getTerrain(x, y);
            return TemperatureAffichee.determinerTemperature(terrain.getTemperature());
        } catch (TerrainInexistant terrainInexistant) {
            terrainInexistant.printStackTrace();
        }
        return null;
    }

}
