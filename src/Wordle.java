class Wordle {
    private String parola, tentativo;


    public Wordle(String parola) {
        this.parola = parola;
        }

    public Wordle() {
        this.parola = "";
        this.tentativo = "";
    }


    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getTentativo() {
        return tentativo;
    }

    public void setTentativo(String tentativo) {
        this.tentativo = tentativo;
    }


    public boolean controlloVittoria() {
        return parola.toLowerCase().equals(tentativo.toLowerCase());
    }

    public boolean controlloTentativo() {
        return tentativo.length() == 5;
    }

    public String controlloColori() {
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



}
