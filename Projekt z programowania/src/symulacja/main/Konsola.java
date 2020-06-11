package symulacja.main;

import java.util.Scanner;

/**Klasa ta odpowiada za wprowadzenie do symulacji parametrow takich jak predkosci poruszajacych sie obiektow i ich ilosc */
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
        System.out.println("Proszę wprowadzić maksymalną prędkość AUT na drodze:");
        Scanner scanner = new Scanner(System.in);
        maxSpeedCar = scanner.nextInt();
        return maxSpeedCar;
    }

    public int setMaxSpeedBicycle() {

        System.out.println("Proszę wprowadzić maksymalną prędkość ROWERÓW na drodze:");
        Scanner scanner = new Scanner(System.in);
        maxSpeedBicycle = scanner.nextInt();
        return maxSpeedBicycle;
    }

    public int setSafeSpeedCar() {
        do {
            System.out.println("Proszę wprowadzić bezpieczną prędkość AUT na drodze:");
            Scanner scanner = new Scanner(System.in);
            safeSpeedCar = scanner.nextInt();
        }while(safeSpeedCar > maxSpeedCar);
        return safeSpeedCar;
    }

    public int setSafeSpeedBicycle() {
        do {
            System.out.println("Proszę wprowadzić bezpieczną prędkość ROWERÓW na drodze:");
            Scanner scanner = new Scanner(System.in);
            safeSpeedBicycle = scanner.nextInt();
        }while(safeSpeedBicycle > maxSpeedBicycle);
        return safeSpeedBicycle;
    }

    public int setNumberCar() {
        System.out.println("Proszę wprowadzię ilość AUT, które przejadą po drodze");
        Scanner scanner = new Scanner(System.in);
        numberCar = scanner.nextInt();
        return numberCar;
    }

    public int setNumberBicycle() {
        System.out.println("Proszę wprowadzię ilość ROWERÓW, które przejadą po drodze");
        Scanner scanner = new Scanner(System.in);
        numberBicycle = scanner.nextInt();
        return numberBicycle;
    }

    public int setNumberHuman() {
        System.out.println("Proszę wprowadzię ilość LUDZI, które przejadą po drodze");
        Scanner scanner = new Scanner(System.in);
        numberHuman = scanner.nextInt();
        return numberHuman;
    }

    public int setNumberDog() {
        System.out.println("Proszę wprowadzię ilość PSÓW, które przejadą po drodze");
        Scanner scanner = new Scanner(System.in);
        numberDog = scanner.nextInt();
        return numberDog;
    }
}


