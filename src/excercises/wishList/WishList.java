package excercises.wishList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {

    public static void main(String[] args) throws IOException {

        // Creo una lista
        ArrayList<String> christmasGifts = new ArrayList<>();

        // Prendo il file
        File file = new File("./resources/data.txt");

        // Inizializzo gli scanner
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(file);


        while (fileScanner.hasNextLine()) {

            String gift = fileScanner.nextLine();
            christmasGifts.add(gift);
        }

        if (christmasGifts.isEmpty()) {
            System.out.println("La tua lista è vuota");
        } else {
            // Mostra cosa ho nella lista
            System.out.print("La tua lista contiene: ");
            for (int i = 0; i < christmasGifts.size(); i++) {
                if (i == christmasGifts.size() - 1) {
                    System.out.print(christmasGifts.get(i) + ".");
                } else {
                    System.out.print(christmasGifts.get(i) + ", ");
                }
            }
            System.out.println();
        }

        boolean play = true;

        while (play) {
            System.out.println("Inserisci il regalo che vuoi aggiungere alla lista: ");
            String gift = scanner.nextLine();
            christmasGifts.add(gift);
            if (christmasGifts.size() == 1) {
                System.out.println("La tua lista contiene " + christmasGifts.size() + " regalo");
            } else {
                System.out.println("La tua lista contiene " + christmasGifts.size() + " regali");
            }
            System.out.println("--------------------------");
            System.out.println("Vuoi aggiungere un regalo? s/n");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("s")) {
                play = false;
            }
        }

        // Ordino la lista
        Collections.sort(christmasGifts);

        // Scrivo nel file txt
        FileWriter fileWriter = new FileWriter(file);

        System.out.print("Questa è la tua lista dei regali: ");
        // Mostro elementi lista
        for (int i = 0; i < christmasGifts.size(); i++) {
            fileWriter.write(christmasGifts.get(i) + "\n");
            if (i == christmasGifts.size() - 1) {
                System.out.print(christmasGifts.get(i) + ".");
            } else {
                System.out.print(christmasGifts.get(i) + ", ");
            }
        }
        fileWriter.close();
        scanner.close();
        fileScanner.close();
    }
}