package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;

import java.util.Random;

public class Dog extends APedestrian {

    public Dog() {
    }



    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY() {
        return super.coordinateY();
    }

    @Override
    public void crossing(int firstCoordinateY, int coordinateY, int coordinateX, MapSimple position) {
        super.crossing(firstCoordinateY, coordinateY, coordinateX, position);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
    }


    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
    }


}
