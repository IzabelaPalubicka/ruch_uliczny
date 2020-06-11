package symulacja.participants.vehicle;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;
import symulacja.participants.RandomPositionOccupation;

public interface VehicleFunction extends RandomPositionOccupation {


    void accelerate(int speed, int maxSpeed);

    void slowDown(int speed, int safeSpeed);

    PositionOccupation seeObstacle(int coordinateX, int coordinateY, PositionOccupation[][] mapa);

    int move(int maxSpeed, int coordinateX, int coordinateY, PositionOccupation[][] mapa);

    int speed(int n,  int speed,int coordinateX, int coordinateY, MapSimple position);

}
