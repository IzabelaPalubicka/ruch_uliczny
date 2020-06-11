package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;

import java.util.Random;

public class Dog extends APedestrian {

    public Dog() {
    }


    @Override
    public int coordinateX() {
        super.coordinateX();
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        super.coordinateY();
        return coordinateY;
    }

    @Override
    public int crossing(int n, int firstCoordinateY, int coordinateY, int coordinateX) {
        return 0;
    }

}
