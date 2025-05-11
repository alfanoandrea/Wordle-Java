package wordle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordleController implements ActionListener{
    
    private WordleModel model;
    private GUI view;
    
    
    public WordleController(GUI view, WordleModel model) {
        this.view = view;
        this.model = model;
        bindItems();
    }
    
    private void bindItems() {
        view.getTxtParola().addActionListener(this);
        
        
    }
    
  
    private void updateLabels(String colori, String tentativo) {
        
        for(int i=0; i<5; i++) {
            view.getGriglia()[model.mosse][i].setText(String.valueOf(tentativo.charAt(i)));
            
            switch(colori.charAt(i)) {
                case 'G' -> view.getGriglia()[model.mosse][i].setBackground(Color.GREEN);
                case 'Y' -> view.getGriglia()[model.mosse][i].setBackground(Color.YELLOW);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("parola")) {
            String tentativo = view.getTxtParola().getText();
            
            if(model.controlloParola(tentativo) && model.mosse < 6) {
                System.out.println("parola consentita");
                String colori = model.getColori(tentativo);
                updateLabels(colori, tentativo);
                model.mosse++;
            } else System.out.println("parola non consentita");
            view.getTxtParola().setText("");
        }
       
    }
    
}
