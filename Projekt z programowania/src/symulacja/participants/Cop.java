package symulacja.participants;

import java.util.Random;

public class Cop implements RandomPositionOccupation {
    public boolean fine;
    public int coordinateX;
    public int coordinateY;

    public Cop() {

        this.fine = false;
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY();

    }

    public boolean speedingPenalty(int speed, int vehicleCoordinateX, int copCoordinateX) {

        if (copCoordinateX == vehicleCoordinateX) {
            if (speed > 50) fine = true;
            else fine = false;
        }
        return fine;
    }


    @Override
    public int coordinateX() {
        Random random = new Random();
        coordinateX = 0;

        while (coordinateX != 4 && coordinateX != 9 && coordinateX != 22 && coordinateX != 26) {
            coordinateX = random.nextInt() % 32;
        }
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        Random random = new Random();
        coordinateY = 1;

        while (coordinateY != 0 && coordinateY != 5) {
            coordinateY = random.nextInt() % 6;
        }
        return coordinateY;
    }
}
