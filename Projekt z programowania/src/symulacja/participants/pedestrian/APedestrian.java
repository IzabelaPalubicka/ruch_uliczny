package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;

import java.util.Random;


public abstract class APedestrian implements Pedestrian {

    public int coordinateX;
    public int coordinateY;
    public int firstCoordinateY;
    protected PositionOccupation positionOccupation;
   // protected PositionOccupation mapa[][];
    //Random random = new Random();
    public APedestrian() {
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();
        this.firstCoordinateY = coordinateY;
   //     this.positionOccupation = positionOccupation;
    }

    @Override
    public void crossing(int firstCoordinateY, int coordinateY, int coordinateX, MapSimple position) {
        if (firstCoordinateY == 0)
            rightPavementCrossing(coordinateY, coordinateX, position);
        else if (firstCoordinateY == 5)
            leftPavementCrossing(coordinateY, coordinateX, position);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
        if (coordinateY == 5)
            System.gc();
        else {
            position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            position.mapa[coordinateX][++coordinateY] = positionOccupation.HUMAN;
        }
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
        if (coordinateY == 0)
            System.gc();
        else {
            position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            position.mapa[coordinateX][--coordinateY] = positionOccupation.DOG;
        }
    }


    @Override
    public int coordinateX() {
        Random random = new Random();
        do {
            coordinateX = random.nextInt() % 32;
        }while(coordinateX < 0);
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        Random random = new Random();
         do {
            coordinateY = random.nextInt() % 6;
        }while (coordinateY != 0 && coordinateY != 5);
        return coordinateY;
    }

}
