package wordle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class WordleModel {
    
    private String parola;
    public int mosse = 0;


    public WordleModel() {
        parolaCasuale();
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
    
    public boolean isConsentito() {
        //mettere dizionario per vedere se la parola è consentita o no
        return true;
    }
    
    public boolean controlloParola(String tentativo) {
        return tentativo.length() == 5 && isConsentito();
    }

    public String getColori(String tentativo) {
        String s = "NNNNN";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tentativo.charAt(i) == parola.charAt(j))
                    if (i == j) {
                        s = s.substring(0, i) + "G" + s.substring(i + 1);
                        break;
                    }
                    else
                        s = s.substring(0, i) + "Y" + s.substring(i + 1);  
            }
        }        
        return s;
    }

    public void parolaCasuale() {
        try (BufferedReader bw = new BufferedReader(new FileReader("src/dictionaries/dictionaryIT.txt"))) {
            String line;
            int lines = Files.readAllLines(Paths.get("src/dictionaries/dictionaryIT.txt")).size();
            int randomLine = (int) (Math.random() * lines);
            int i = 0;
            while ((line = bw.readLine()) != null)
                if (i++ == randomLine)
                    break;
            bw.close();
            setParola(line);
            System.out.println(line);
            
        } catch (IOException e) {
            System.out.println("Errore file");
        }
    }
    
}
