package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;

import java.util.List;

public abstract class APedestrian implements Pedestrian {

    protected int coordinateX;
    protected int coordinateY;
    protected int firstCoordinateY;
    protected PositionOccupation positionOccupation;
    protected PositionOccupation mapa[][];

    public APedestrian() {
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();
        this.firstCoordinateY = coordinateY;
        this.positionOccupation = positionOccupation;
       
    }

    @Override
    public void crossing(int firstCoordinateY, int coordinateY, int coordinateX) {
        if (firstCoordinateY == 0)
            rightPavementCrossing(coordinateY, coordinateX);
        else if (firstCoordinateY == 5)
            leftPavementCrossing(coordinateY, coordinateX);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX) {
        if (coordinateY == 5)
            System.gc();
        else {
            mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            mapa[coordinateX][coordinateY++] = positionOccupation.HUMAN;
        }
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX) {
        if (coordinateY == 0)
            System.gc();
        else {
            mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            mapa[coordinateX][coordinateY--] = positionOccupation.DOG;
        }
    }


    @Override
    public int coordinateX() {
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        return coordinateY;
    }

}
