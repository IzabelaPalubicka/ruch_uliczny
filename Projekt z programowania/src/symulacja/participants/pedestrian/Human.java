package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;

import java.util.Random;

public class Human extends APedestrian {

    public Human() {
    }

    @Override
    public void crossing(int firstCoordinateY, int coordinateY, int coordinateX, MapSimple position) {
    }


//    public int coordinateX() {
//      //  Random random = new Random();
////        while (coordinateX != 2 && coordinateX != 8 && coordinateX != 11 && coordinateX != 12 && coordinateX != 13 && coordinateX != 18
////                && coordinateX != 19 && coordinateX != 20 && coordinateX != 25 && coordinateX != 30) {
////            coordinateX = random.nextInt() % 32;
////        }
//        return coordinateX;
//    }

//    public int coordinateY() {
//
//        return coordinateY;
//    }


    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY() {
        return super.coordinateY();
    }

    @Override
    public void leftPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
    }


    @Override
    public void rightPavementCrossing(int coordinateY, int coordinateX, MapSimple position) {
    }


}

