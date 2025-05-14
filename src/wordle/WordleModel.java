package wordle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class    WordleModel {

    private String parola;
    public int mosse = 0;
    private Set<String> dizionario = new HashSet<>();
    private String lingua = "IT";

    public WordleModel() {
        this("IT");
        caricaDizionario();
        parolaCasuale();
    }

    public WordleModel(String lingua) {
        this.lingua = lingua;
        caricaDizionario();
        parolaCasuale();
    }

    private void caricaDizionario() {
        dizionario.clear();
        String file = lingua.equals("EN") ? "src/dictionaries/dictionaryEN.txt" : "src/dictionaries/dictionaryIT.txt";
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) 
                dizionario.add(line.trim().toLowerCase());
        } catch (IOException e) {
            System.out.println("Errore caricamento dizionario");
        }
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public boolean controlloVittoria(String tentativo) {
        return parola.toLowerCase().equals(tentativo.toLowerCase());
    }

    public boolean isConsentito(String parola) {
        return dizionario.contains(parola.toLowerCase());
    }

    public boolean controlloParola(String tentativo) {
        return tentativo.length() == 5 && isConsentito(tentativo);
    }

    // Logica corretta per lettere doppie
    public String getColori(String tentativo) {
        char[] colori = {'N', 'N', 'N', 'N', 'N'};
        boolean[] usata = new boolean[5];
        for (int i = 0; i < 5; i++)
            if (tentativo.charAt(i) == parola.charAt(i)) {
                colori[i] = 'G';
                usata[i] = true;
            }
        for (int i = 0; i < 5; i++) {
            if (colori[i] == 'G') continue;
            for (int j = 0; j < 5; j++)
                if (!usata[j] && tentativo.charAt(i) == parola.charAt(j)) {
                    colori[i] = 'Y';
                    usata[j] = true;
                    break;
                }
        }
        return new String(colori);
    }

    public void parolaCasuale() {
        String file = lingua.equals("EN") ? "src/dictionaries/dictionaryEN.txt" : "src/dictionaries/dictionaryIT.txt";
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            int lines = Files.readAllLines(Paths.get(file)).size();
            int randomLine = (int) (Math.random() * lines);
            String line = null;
            int i = 0;
            while ((line = bw.readLine()) != null)
                if (i++ == randomLine)
                    break;
            setParola(line);
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Errore file");
        }
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
}