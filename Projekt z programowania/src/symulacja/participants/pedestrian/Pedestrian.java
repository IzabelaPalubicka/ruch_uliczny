package symulacja.participants.pedestrian;

import symulacja.mapa.PositionOccupation;
import symulacja.participants.RandomPositionOccupation;

public interface Pedestrian extends RandomPositionOccupation {

    int crossing(int firstCoordinateY, int coordinateY, int coordinateX, PositionOccupation[][] mapa);
}
