package towerdefence;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Spawns enemies.
 * 
 * @author pmh20
 *
 */
public class SpawnEnemies {

    /**
     * Spawns enemies.
     */
    public static void addEnemies() {
        final int urukMin = 3;
        final int urukMax = 5;
        final int orcMin = 3;
        final int orcMax = 8;
        final int eleMin = 4;
        final int eleMax = 5;
        final int ratMin = 8;
        final int ratMax = 10;
        final double scaler = 10;

        int urukNo = (int) Math.round((ThreadLocalRandom.current().nextInt(urukMin, urukMax + 1)) * (((Game.waveCounter)) / scaler));
        int orcNo = (int) Math.round((ThreadLocalRandom.current().nextInt(orcMin, orcMax + 1)) * (((Game.waveCounter)) / scaler));
        int eleNo = (int) Math.round((ThreadLocalRandom.current().nextInt(eleMin, eleMax + 1)) * (((Game.waveCounter)) / scaler));
        int ratNo = (int) Math.round((ThreadLocalRandom.current().nextInt(ratMin, ratMax + 1)) * (((Game.waveCounter)) / scaler));

        for (int i = 0; i < urukNo; i++) {
            Game.enemies.add(new UrukHai());
        }

        for (int i = 0; i < orcNo; i++) {
            Game.enemies.add(new Orc());
        }

        for (int i = 0; i < eleNo; i++) {
            Game.enemies.add(new Elephant());
        }

        for (int i = 0; i < ratNo; i++) {
            Game.enemies.add(new Rat());
        }
    }
}
