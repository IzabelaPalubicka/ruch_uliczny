package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;

import java.util.Random;

public class Car extends Vehicle {

    public Car(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY(int coordinateX) {
        return super.coordinateY(coordinateX);
    }

    private int speedSlowerCar;
    private int speedSlowerBicycle;

    public int speed(int maxSpeed){
        super.speed(maxSpeed);
        return speed;
    }

    @Override
    public void slowDown(int speed1, int speed2) {
        super.slowDown(speed1, speed2);
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY) {
        return super.seeObstacle(coordinateX, coordinateY);
    }


    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }


    public void move(int speed, int coordinateX, int coordinateY) {
        Map[coordinateX][coordinateY] = PositionOccupation.EMPTY;
        if (coordinateY == 0) {
            coordinateX += (speed / 10);
            switch (seeObstacle(coordinateX, coordinateY)) {
                case HUMAN:
                case DOG:
                case RED:
                    slowDown(maxSpeed, 0);
                    break;
                case BICYCLE:
                    slowDown(speed, speedSlowerBicycle);
                    break;
                case CAR:
                    slowDown(speed, speedSlowerCar);
                    break;
                case COP:
                    slowDown(maxSpeed, PERMISSIBLE_SPEED);
                default:
                    accelerate(speed, maxSpeed);

            }
        } else {
            coordinateX -= (speed / 10);
            switch (seeObstacle(coordinateX, coordinateY)) {
                case HUMAN:
                case DOG:
                case RED:
                    slowDown(maxSpeed, 0);
                    break;
                case COP:
                    slowDown(maxSpeed, PERMISSIBLE_SPEED);
                    break;
                case BICYCLE:
                    slowDown(speed, speedSlowerBicycle);
                    break;
                case CAR:
                    slowDown(speed, speedSlowerCar);
                    break;
                default:
                    accelerate(speed, maxSpeed);
            }
        }
        Map[coordinateX][coordinateY] = PositionOccupation.CAR;
    }
}
