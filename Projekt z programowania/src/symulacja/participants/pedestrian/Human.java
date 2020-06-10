package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;

import java.util.Random;

public class Human extends APedestrian {

    public Human() {
    }
    
@Override
    public int crossing(int firstCoordinateY, int coordinateY, int coordinateX, PositionOccupation[][] mapa) {
        if (firstCoordinateY == 0) {
            coordinateY = coordinateY + 1;
        } else if (firstCoordinateY == 5) {

            coordinateY = coordinateY - 1;
        }
        return coordinateY;
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

