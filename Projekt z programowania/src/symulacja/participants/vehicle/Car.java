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

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY, PositionOccupation[][] mapa) {
        return null;
    }

    @Override
    public int move(int maxSpeed, int coordinateX, int coordinateY, PositionOccupation[][] mapa) {
        return 0;
    }

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


    public int speed(int n,  int speed,int coordinateX, int coordinateY, MapSimple position) {
        if (coordinateY == 4) {
            if (coordinateX <= 0) {
                position.mapa[0][4] = PositionOccupation.EMPTY;
                speed = 0;
                System.out.println("ROWER nr " + (n + 1) + "wyszedł poza obręb mapy");
            } else {
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
            }
        } else {
            if (coordinateX >= 31) {
                position.mapa[31][1] = PositionOccupation.EMPTY;
                speed = 0;
                System.out.println("ROWER nr " + (n + 1) + "wyszedł poza obręb mapy");
            } else {
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
            }
        }
        return speed;
    }

    public int move(int speed, int coordinateX, int coordinateY, MapSimple position){

        position.mapa[coordinateX][coordinateY] = PositionOccupation.EMPTY;

        if (coordinateY == 4) {
            if (coordinateX > 0) {
                position.mapa[coordinateX][coordinateY] = PositionOccupation.EMPTY;
                coordinateX -= (int) (speed / 10);
                if(coordinateX<=0){
                    coordinateX=0;
                    position.mapa[0][4] = PositionOccupation.EMPTY;
                }else{
                    position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
                }
            }
        } else {
            if (coordinateX < 31) {
                position.mapa[coordinateX][coordinateY] = PositionOccupation.EMPTY;
                coordinateX += (int) (speed / 10);
                if(coordinateX>=31){
                    coordinateX=31;
                    position.mapa[31][1] = PositionOccupation.EMPTY;
                }else {
                    position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
                }
            }
        }
        return coordinateX;
    }
}
