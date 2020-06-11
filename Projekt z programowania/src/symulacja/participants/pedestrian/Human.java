package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;

import java.util.Random;

public class Human extends APedestrian {

    public Human() {
    }

    @Override
    public int crossing(int n, int firstCoordinateY, int coordinateY, int coordinateX) {
        return 0;
    }


    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY() {
        return super.coordinateY();
    }

}

