import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println("wordle");
        String parola = parolaCasuale("dictionaries/dictionaryIT.txt");
        System.out.println(parola);
        Wordle partita = new Wordle(parola);

        for (int i = 0; i < 6; i++) {
            String tentativo = JOptionPane.showInputDialog("Tentativo " + (i + 1) + ":");
            partita.setTentativo(tentativo);
            if (!partita.controlloTentativo()) {
                i--;
                continue;
            }
            System.out.println(tentativo);
            System.out.println(partita.controlloColori());
            if (partita.controlloVittoria()) {
                System.out.println("Hai vinto");
                return;
            }
        }
        System.out.println("Hai perso");
    }

    public static String parolaCasuale(String fileName) {
        try (BufferedReader bw = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            int lines = Files.readAllLines(Paths.get(fileName)).size();
            int randomLine = (int) (Math.random() * lines);
            int i = 0;
            while ((line = bw.readLine()) != null)
                if (i++ == randomLine)
                    break;
            bw.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}