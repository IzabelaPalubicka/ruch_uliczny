package symulacja.participants.pedestrian;

import java.util.Random;

public class Human extends APedestrian {

    public Human() {
    }

    @Override
    public void crossing(int firstCoordinateY,int coordinateY, int coordinateX) {
    }


    public int coordinateX() {
        int x = 0;
        Random random = new Random();
        while (x != 2 && x != 8 && x != 11 && x != 12 && x != 13 && x != 18 && x != 19 && x != 20 && x != 25 && x != 30) {
            x = random.nextInt() % 32;
        }
        return x;
    }

    public int coordinateY() {
        int coordinateY = 1;
        Random random = new Random();
        while (coordinateY != 0 && coordinateY != 5) {
            coordinateY = random.nextInt() % 6;
        }
        return coordinateY;
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX) {
    }

    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX) {
    }
}
