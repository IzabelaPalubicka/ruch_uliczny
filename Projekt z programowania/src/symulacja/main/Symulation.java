package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.Mapa;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;

import symulacja.participants.Cop;
import symulacja.participants.TrafficLights;
import symulacja.participants.vehicle.*;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.pedestrian.Dog;

import java.util.List;
import java.util.Random;


public class Symulation {

    static Konsola konsola;
    static Mapa map;
    static MapSimple position;
    static PedestrianCreatorList pedestrianCreator;
    static VehicleCreatorList vehicleCreator;
    static Moving movement;
    static SettleParticipants settle;
    static Accident accident;

    static List<Car> carList;
    static List<Bicycle> bicycleList;
    static List<Human> humanList;
    static List<Dog> dogList;

    static int[] kolej = new int[100];

    static int indexBicycle = 1;
    static int indexCar = 1;
    static int indexHuman = 1;
    static int indexDog = 1;

    static int x = -1;



    static int z = 0;
    static int w = 0;
    static int t = 0;
    static int s = 0;

    static int mandat = 0;

    public Symulation(Mapa map, PedestrianCreatorList pedestrianCreator, VehicleCreatorList vehicleCreator) {
        this.position = new MapSimple();
        this.pedestrianCreator = pedestrianCreator;
        this.vehicleCreator = vehicleCreator;
    }

    private void settleParticipants(int x, int indexCar, int numberCar, MapSimple position, List<Car> carList, int indexBicycle, int numberBicycle,
                                           List<Bicycle> bicycleList, int indexHuman, int numberHuman, List<Human> humanList, int indexDog, int numberDog, List<Dog> dogList) {

        settle.settleCarList(x, indexCar, numberCar, position, carList);
        settle.settleBicycleList(x, indexBicycle, numberBicycle, position, bicycleList);
        settle.settleHumanList(x, indexHuman, numberHuman, position, humanList);
        settle.settleDogList(x, indexDog, numberDog, position, dogList);
    }

    private void movingParticipants(int[] kolej, int w, int s, int z, int t, int indexCar, int indexBicycle, int indexHuman, int indexDog,
                                    List<Car> carList, List<Bicycle> bicycleList, List<Human> humanList, List<Dog> dogList, MapSimple position,
                                    Cop cop, int mandat) {
        for (int j = 0; j < 100; j++) {
            if (kolej[j] == 1 && w < indexCar) {
                movement.movingCars(w, carList, konsola.maxSpeedCar, position.mapa, cop, mandat);
                w++;
            }
            if (kolej[j] == 0 && z < indexBicycle) {
                movement.movingBicycles(z, bicycleList, konsola.maxSpeedBicycle, position.mapa);
                z++;
            }
            if (kolej[j] == 1 && t < indexHuman) {
                movement.movingPeople(t, humanList, position);
                t++;
            }
            if (kolej[j] == 0 && s < indexDog) {
                movement.movingDogs(s, dogList, position);
                s++;
            }
        }
    }

    private void collision(int indexBicycle, int indexCar, List<Bicycle> bicycleList, int indexHuman, int indexDog, List<Human> humanList, List<Car> carList, List<Dog> dogList) {
        for (int y = 0; y != indexBicycle; y++) {
            for (int m = 0; m != indexBicycle; m++) {
                accident.vehicleShunt(y, m, indexBicycle, indexCar, bicycleList, carList);
            }
            for (int n = 0; n != indexHuman && n != indexDog; n++) {
                accident.pedestrianBlindsiding(y, n, indexHuman, indexDog, humanList, carList, dogList);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MapSimple position = new MapSimple();
        Konsola konsola = new Konsola();
        VehicleCreatorList vehicleCreator = new VehicleCreatorList(konsola.numberCar, konsola.numberBicycle);
        PedestrianCreatorList pedestrianCreator = new PedestrianCreatorList(konsola.numberHuman, konsola.numberDog);
        Symulation symulation = new Symulation(position, pedestrianCreator, vehicleCreator);

        carList = vehicleCreator.creatorCars(position, konsola.maxSpeedCar, konsola.safeSpeedCar);
        bicycleList = vehicleCreator.creatorBicycles(position, konsola.maxSpeedBicycle, konsola.safeSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();

        TrafficLights traffic_light1 = new TrafficLights(10, 15, 0, true);
        TrafficLights traffic_light2 = new TrafficLights(10, 19, 5, false);
        position.settleTrafficLight(traffic_light1, position.mapa);
        position.settleTrafficLight(traffic_light2, position.mapa);

        Cop cop = new Cop(false);


        for (int i = 0; i < 100; i++) {
            if (indexCar + indexBicycle < konsola.numberCar + konsola.numberBicycle) {
                Random random = new Random();
                x = random.nextInt() % 2;
                kolej[i] = x;
//                settle.settleCarList(x, indexCar, konsola.numberCar, position, carList);
//                settle.settleBicycleList(x, indexBicycle, konsola.numberBicycle, position, bicycleList);
//                settle.settleHumanList(x, indexHuman, konsola.numberHuman, position, humanList);
//                settle.settleDogList(x, indexDog, konsola.numberDog, position, dogList);

                symulation.settleParticipants(x, indexCar, konsola.numberCar, position, carList, indexBicycle, konsola.numberBicycle,
                        bicycleList, indexHuman, konsola.numberHuman, humanList, indexDog, konsola.numberDog, dogList);

                symulation.movingParticipants(kolej, w, s, z, t, indexCar, indexBicycle, indexHuman, indexDog,
                        carList, bicycleList, humanList, dogList, position,
                        cop, mandat);


                symulation.collision(indexBicycle, indexCar, bicycleList, indexHuman, indexDog, humanList, carList, dogList);

            }
        }
//System.out.print("Droga jest bezpieczna!");
    }

}
