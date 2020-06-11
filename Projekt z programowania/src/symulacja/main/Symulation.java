package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.Mapa;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;
import symulacja.participants.TrafficLights;
import symulacja.participants.vehicle.*;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.Cop;

import java.util.List;
import java.util.Random;

/**Jest to glowna klasa zawierajaca metode main.*/
public class Symulation {

    Konsola konsola;
    Mapa map;
    MapSimple mapa;
    PedestrianCreatorList pedestrianCreator;
    VehicleCreatorList vehicleCreator;

    public Symulation(Mapa map, PedestrianCreatorList pedestrianCreator, VehicleCreatorList vehicleCreator) {
        this.mapa = new MapSimple();
        this.pedestrianCreator = pedestrianCreator;
        this.vehicleCreator = vehicleCreator;
    }

    public static void main(String[] args)  {

        MapSimple mapa = new MapSimple();
        Konsola konsola = new Konsola();
        VehicleCreatorList vehicleCreator = new VehicleCreatorList(konsola.numberCar, konsola.numberBicycle);
        PedestrianCreatorList pedestrianCreator = new PedestrianCreatorList(konsola.numberHuman, konsola.numberDog);
        Symulation symulation = new Symulation(mapa, pedestrianCreator, vehicleCreator);

        List<Car> carList;
        List<Bicycle> bicycleList;
        List<Human> humanList;
        List<Dog> dogList;

        carList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedCar, konsola.safeSpeedCar);
        bicycleList = vehicleCreator.creatorBicycles(mapa, konsola.maxSpeedBicycle, konsola.safeSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();

        TrafficLights traffic_light1 = new TrafficLights(15, 1, true);
        TrafficLights traffic_light2 = new TrafficLights(19, 4, false);
        mapa.settleTrafficLight(traffic_light1, mapa.mapa);
        mapa.settleTrafficLight(traffic_light2, mapa.mapa);

        Cop cop = new Cop();

        int indexBicycle = 0;
        int indexCar = 0;
        int indexHuman = 0;
        int indexDog = 0;
        int[] kolej = new int[1000];
        int mandat = 0;

        for (int i = 0; (indexCar + indexBicycle) <= (konsola.numberCar + konsola.numberBicycle); i++) {
            traffic_light1.changeColour(traffic_light1.coordinateX,traffic_light1.coordinateY, mapa, traffic_light1.light);
            traffic_light2.changeColour(traffic_light2.coordinateX,traffic_light2.coordinateY, mapa, traffic_light2.light);
            int x;
            Random random = new Random();
            x = random.nextInt() % 2;
            kolej[i] = x;
            if (x == 1 && indexCar < konsola.numberCar) {
                Car car = new Car(konsola.maxSpeedCar, konsola.safeSpeedCar);
                carList.add(car);
                carList.get(indexCar).coordinateX();
                carList.get(indexCar).coordinateY(carList.get(indexCar).coordinateX);
                System.out.println("AUTO nr " + (indexCar + 1) + " znajduje się na mapie na pozycji x = " + carList.get(indexCar).coordinateX +
                        " i pozycji y = " + carList.get(indexCar).coordinateY);
                indexCar++;
            }
            if (x == 0 && indexBicycle < konsola.numberBicycle) {
                Bicycle bicycle = new Bicycle(konsola.maxSpeedBicycle, konsola.safeSpeedBicycle);
                bicycleList.add(bicycle);
                bicycleList.get(indexBicycle).coordinateX();
                bicycleList.get(indexBicycle).coordinateY(bicycleList.get(indexBicycle).coordinateX);
                System.out.println("ROWER nr " + (indexBicycle + 1) + " znajduje się na mapie na pozycji x = " +
                        bicycleList.get(indexBicycle).coordinateX + " i pozycji y = " + bicycleList.get(indexBicycle).coordinateY);
                indexBicycle++;
            }
            if (x == 1 && indexHuman < konsola.numberHuman) {
                Human human = new Human();
                humanList.add(human);
                System.out.println("PIESZY nr " + (indexHuman + 1) + " jest  w tej chwili w puncie " + humanList.get(indexHuman).coordinateX +
                        " x i " + humanList.get(indexHuman).coordinateY + "y");
                indexHuman++;
            }
            if (x == 0 && indexDog < konsola.numberDog) {
                Dog dog = new Dog();
                dogList.add(dog);
                System.out.println("PIES nr " + (indexDog + 1) + " znajduje sie właśnie na pozycji " +
                        dogList.get(indexDog).coordinateX + " x i " + dogList.get(indexDog).coordinateY + " y");
                indexDog++;
            }

            int z = 0;
            int w = 0;
            int t = 0;
            int s = 0;


            for (int j = 0; j <= i; j++) {
                if (kolej[j] == 1 && w < indexCar) {
                    carList.get(w).speed = carList.get(w).speed(w, konsola.maxSpeedCar, carList.get(w).coordinateX,
                            carList.get(w).coordinateY, mapa);
                    if (carList.get(w).speed != 0) {
                        carList.get(w).coordinateX = carList.get(w).move(konsola.maxSpeedCar, carList.get(w).coordinateX,
                                carList.get(w).coordinateY, mapa);
                        System.out.println("AUTO nr " + (w + 1) + " znajduje się na mapie na pozycji x = " + carList.get(w).coordinateX +
                                " i pozycji y = " + carList.get(w).coordinateY);
                    }
                    if (cop.speedingPenalty(carList.get(w).speed, carList.get(w).coordinateX, cop.coordinateX)) {
                        mandat++;
                    }
                    w++;
                }
                if (kolej[j] == 0 && z < indexBicycle) {
                    bicycleList.get(z).speed = bicycleList.get(z).speed(z, konsola.maxSpeedBicycle,
                            bicycleList.get(z).coordinateX, bicycleList.get(z).coordinateY, mapa);
                    if (bicycleList.get(z).speed != 0) {
                        bicycleList.get(z).coordinateX = bicycleList.get(z).move(konsola.maxSpeedBicycle,
                                bicycleList.get(z).coordinateX, bicycleList.get(z).coordinateY, mapa);
                        System.out.println("ROWER nr " + (z + 1) + " znajduje się na mapie na pozycji x = " +
                                bicycleList.get(z).coordinateX + " i pozycji y = " + bicycleList.get(z).coordinateY);
                    }
                    z++;
                }
                if (kolej[j] == 1 && t < indexHuman) {
                    humanList.get(t).coordinateY = humanList.get(t).crossing(t, humanList.get(t).firstCoordinateY,
                            humanList.get(t).coordinateY, humanList.get(t).coordinateX, mapa);
                    if ((humanList.get(t).firstCoordinateY== 5 &&humanList.get(t).coordinateY==0) ||
                            (humanList.get(t).firstCoordinateY ==0 && humanList.get(t).coordinateY==5)) {
                        System.out.println("PIESZY nr " + (t + 1) + " wyszedł poza obręb mapy");
                    } else {
                        System.out.println("PIESZY nr " + (t + 1) + " jest  w tej chwili w puncie " + humanList.get(t).coordinateX +
                                " x i " + humanList.get(t).coordinateY + "y");
                    }
                    t++;
                }
                if (kolej[j] == 0 && s < indexDog) {
                    dogList.get(s).coordinateY = dogList.get(s).crossing(s, dogList.get(s).firstCoordinateY,
                            dogList.get(s).coordinateY, dogList.get(s).coordinateX, mapa);
                    if ((dogList.get(s).firstCoordinateY== 5 &&dogList.get(s).coordinateY==0) ||
                            (dogList.get(s).firstCoordinateY ==0 && dogList.get(s).coordinateY==5)) {
                        System.out.println("PIES nr " + (s + 1) + " wyszedł poza obręb mapy");
                    } else {
                        System.out.println("PIES nr " + (s + 1) + " znajduje sie właśnie na pozycji " +
                                dogList.get(s).coordinateX + " x i " + dogList.get(s).coordinateY + " y");
                        s++;
                    }

                    for (int y = 0; y != indexCar; y++) {
                        for (int m = 0; m != indexBicycle; m++) {
                            if ((bicycleList.get(m).coordinateX == carList.get(y).coordinateX &&
                                    bicycleList.get(m).coordinateY == carList.get(y).coordinateY) ||
                                    (carList.get(y).coordinateX == carList.get(indexCar - y).coordinateX &&
                                            carList.get(y).coordinateY == carList.get(indexCar - y).coordinateX)) {
                                System.out.println("NASTAPILA STLUCZKA! DROGA NIE JEST BEZPIECZNA");
                                System.exit(0);
                            }
                        }
                        for (int n = 0; n != indexHuman; n++) {
                            if ((carList.get(y).coordinateX == humanList.get(n).coordinateX &&
                                    carList.get(y).coordinateY == humanList.get(n).coordinateY)) {
                                System.out.println("MIAL MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
                                System.exit(0);
                            }
                        }
                        for (int o = 0; o != indexDog; o++) {
                            if ((carList.get(y).coordinateX == dogList.get(o).coordinateX && carList.get(y).coordinateY == dogList.get(o).coordinateY));
                        }
                    }
                }

            }
        }
        System.out.println("Liczba mandatów wynosi " + (mandat));
    }
}
