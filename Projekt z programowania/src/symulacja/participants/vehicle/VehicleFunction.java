package symulacja.participants.vehicle;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;
import symulacja.participants.RandomPositionOccupation;

public interface VehicleFunction extends RandomPositionOccupation {


    void accelerate(int speed, int maxSpeed);

    void slowDown(int speed, int safeSpeed);

    PositionOccupation seeObstacle(int coordinateX, int coordinateY, PositionOccupation[][] mapa);

    void move(int maxSpeed, int coordinateX, int coordinateY, PositionOccupation[][] mapa);


}
