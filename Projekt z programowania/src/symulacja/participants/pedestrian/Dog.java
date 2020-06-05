package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;

import java.util.List;
import java.util.Random;

public class Dog extends APedestrian {

    public Dog() {
    }

    @Override
    public int coordinateX() {
        int coordinateX = 32;
        Random random = new Random();
        coordinateX = random.nextInt() % 32;
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        int coordinateY = 6;
        Random random = new Random();
        coordinateY = random.nextInt() % 6;
        return coordinateY;
    }

    @Override
    public void crossing(int firstCoordinateY,int coordinateY, int coordinateX) {
        super.crossing(firstCoordinateY, coordinateY, coordinateX);
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX) {
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX){
    }

}
