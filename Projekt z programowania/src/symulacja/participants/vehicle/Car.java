package symulacja.participants.vehicle;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;


public class Car extends Vehicle {

    public Car(int maxSpeed, int speed) {
        super(maxSpeed, speed);
    }

    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY(int coordinateX) {
        return super.coordinateY(coordinateX);
    }

    //    private int speedSlowerCar;
//    private int speedSlowerBicycle;


    @Override
    public void slowDown(int speed1, int speed2) {
        super.slowDown(speed1, speed2);
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY, MapSimple position) {
        return super.seeObstacle(coordinateX, coordinateY, position);
    }

    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }


    public void move(int speed, int coordinateX, int coordinateY, MapSimple position) {

 position.mapa[coordinateX][coordinateY] = PositionOccupation.EMPTY;

        if (coordinateY == 4) {
            coordinateX -= speed / 10;
            if (coordinateX >= 0) {
                switch (seeObstacle(coordinateX, coordinateY, position)) {
                    case HUMAN:
                    case DOG:
                    case RED:
                        slowDown(maxSpeed, 0);
                        break;
                    case COP:
                        slowDown(maxSpeed, PERMISSIBLE_SPEED);
                        break;
                    default:
                        accelerate(speed, maxSpeed);
                }
                position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
            } else System.gc();
        } else {

            coordinateX += speed / 10;
            if (coordinateX < 32 ) {
                switch (seeObstacle(coordinateX, coordinateY, position)) {
                    case HUMAN:
                    case DOG:
                    case RED:
                        slowDown(maxSpeed, 0);
                        break;
                    case CAR:
                        slowDown(maxSpeed, PERMISSIBLE_SPEED);
                        break;
                    default:
                        accelerate(speed, maxSpeed);
                }
                position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
            } else System.gc();
        }
    }
}
