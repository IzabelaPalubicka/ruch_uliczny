package symulacja.main;

import java.util.Scanner;

public class Konsola implements Consola {

    public int maxSpeedCar;
    public int maxSpeedBicycle;
    public int safeSpeedCar;
    public int safeSpeedBicycle;
    public int numberCar;
    public int numberBicycle;
    public int numberHuman;
    public int numberDog;

    public Konsola() {
        this.maxSpeedCar = setMaxSpeedCar();
        this.maxSpeedBicycle = setMaxSpeedBicycle();
        this.safeSpeedCar = setSafeSpeedCar();
        this.safeSpeedBicycle = setSafeSpeedBicycle();
        this.numberCar =  setNumberCar();
        this.numberBicycle =  setNumberBicycle();
        this.numberHuman =  setNumberHuman();
        this.numberDog =  setNumberDog();

    }

    public int setMaxSpeedCar() {
        System.out.println("Prosze wporwadzic maxymalna predkosc auta na drodze");
        Scanner scanner = new Scanner(System.in);
        int maxSpeedCar = scanner.nextInt();
        return maxSpeedCar;
    }

    public int setMaxSpeedBicycle() {

            System.out.println("Prosze wporwadzic maksymalna predkosc roweru na drodze");
            Scanner scanner = new Scanner(System.in);
            int maxSpeedBicycle = scanner.nextInt();
        return maxSpeedBicycle;
    }

    public int setSafeSpeedCar() {
        do {
            System.out.println("Prosze wporwadzic bezpieczna predkosc auta na drodze");
            Scanner scanner = new Scanner(System.in);
            int safeSpeedCar = scanner.nextInt();
        }while(safeSpeedCar > maxSpeedBicycle);
        return safeSpeedCar;
    }

    public int setSafeSpeedBicycle() {
        do {
            System.out.println("Prosze wporwadzic bezpieczna predkosc roweru na drodze");
            Scanner scanner = new Scanner(System.in);
            int safeSpeedBicycle = scanner.nextInt();
        }while(safeSpeedBicycle >maxSpeedBicycle);
        return safeSpeedBicycle;
    }

    public int setNumberCar() {
        System.out.println("Prosze wporwadzic ilosc SAMOCHODÓW, ktore przejada po drodze");
        Scanner scanner = new Scanner(System.in);
        int numberCar = scanner.nextInt();
        return numberCar;
    }

    public int setNumberBicycle() {
        System.out.println("Prosze wporwadzic ilosc ROWERÓW, ktore przejada po drodze");
        Scanner scanner = new Scanner(System.in);
        int numberBicycle = scanner.nextInt();
        return numberBicycle;
    }

    public int setNumberHuman() {
        System.out.println("Prosze wporwadzic ilosc LUDZI, ktore przejda przez ulice");
        Scanner scanner = new Scanner(System.in);
        int numberHuman = scanner.nextInt();
        return numberHuman;
    }

    public int setNumberDog() {
        System.out.println("Prosze wporwadzic ilosc PSÓW, ktore przejda przez ulice");
        Scanner scanner = new Scanner(System.in);
        int numberDog = scanner.nextInt();
        return numberDog;
    }
}

