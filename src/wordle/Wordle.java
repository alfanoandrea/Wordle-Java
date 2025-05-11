package wordle;


public class Wordle {

  
    public static void main(String[] args) {
        WordleController controller = new WordleController(new GUI(), new WordleModel());
    }
    
}
