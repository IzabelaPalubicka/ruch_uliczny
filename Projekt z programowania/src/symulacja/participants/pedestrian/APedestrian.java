package symulacja.participants.pedestrian;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;

import java.util.Random;

/**Jest to klasa abstrakycjna, po ktorej dziedziczy klasa Human i Dog, zawiera takie metody jak losowanie wspolrzednych i zmiane pozycji
 * (zmiane wspolrzednej Y), klasy po niej dziedziczace sa ruchomo przeszkoda dla pojazdow*/
public abstract class APedestrian implements Pedestrian {

    public int coordinateX;
    public int coordinateY;
    /**zmienna firstCoordinateY ulatwia okreslenie czy wartosci wspolrzednej Y powinny rosnąc czy malec*/
    public int firstCoordinateY;
    protected PositionOccupation positionOccupation;

    public APedestrian() {
        this.coordinateX = coordinateX();
        this.coordinateY = coordinateY;
        this.firstCoordinateY = coordinateY();
    }


    public int crossing(int n,int firstCoordinateY, int coordinateY, int coordinateX, MapSimple position) {
        if (firstCoordinateY == 0) {
            if(coordinateY==5){
                position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            }else{
                position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
                coordinateY = coordinateY + 1;
                position.mapa[coordinateX][coordinateY] = positionOccupation.HUMAN;
            }
        } else if (firstCoordinateY == 5) {
            if(coordinateY==0){
                position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
            }else{
                position.mapa[coordinateX][coordinateY] = positionOccupation.EMPTY;
                coordinateY = coordinateY - 1;
                position.mapa[coordinateX][coordinateY] = positionOccupation.HUMAN;
            }
        }
        return coordinateY;
    }


    @Override
    public int coordinateX() {
        Random random = new Random();
        do {
            coordinateX = random.nextInt() % 32;
        }while(coordinateX < 0);
        return coordinateX;
    }

    @Override
    public int coordinateY() {
        Random random = new Random();
        do {
            coordinateY = random.nextInt() % 6;
        }while (coordinateY != 0 && coordinateY != 5);
        return coordinateY;
    }

}
