package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;

import java.util.Random;


public abstract class APedestrian implements Pedestrian {

    public int coordinateX;
    public int coordinateY;
    public int firstCoordinateY;
    protected PositionOccupation positionOccupation;

    public APedestrian() {
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();
        this.firstCoordinateY = coordinateY;
    }

    @Override
    public int crossing(int firstCoordinateY, int coordinateY, int coordinateX, PositionOccupation[][] mapa) {
        return coordinateY;
    }


    @Override
    public int coordinateX() {
        Random random = new Random();
        do {
            coordinateX = random.nextInt() % 32;
        } while (coordinateX < 0);
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        Random random = new Random();
        do {
            coordinateY = random.nextInt() % 6;
        } while (coordinateY != 0 && coordinateY != 5);
        return coordinateY;
    }


}
