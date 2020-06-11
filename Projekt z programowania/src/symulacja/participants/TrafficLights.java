package symulacja.participants;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;

/**Klasa ta za pomoaca enumow GREEN i RED, znajdujacych sie na mapie o wybrancyh wspolrzednych, pozwala pojazdom okreslic
 * czy powinny zwolnic czy przyspeczyc*/
public class TrafficLights {
    public int coordinateX;
    public int coordinateY;
    public boolean light;
    private PositionOccupation[][] mapa;
    private PositionOccupation color;

    public TrafficLights(int coordinateX, int coordinateY, boolean light) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.light = light;
    }

    public void changeColour(int coordinateX, int coordinateY, MapSimple mapa, boolean light) {
        if(light == true) {
            light = false;
            mapa.mapa[coordinateY][coordinateY] = color.RED;
        }
        if (light == false) {
            light = true;
            mapa.mapa[coordinateX][coordinateY] = color.GREEN;

        }
    }
}
