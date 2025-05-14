package wordle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleController implements ActionListener {

    private WordleModel model;
    private GUI view;
    private boolean giocoFinito = false;

    public WordleController(GUI view, WordleModel model) {
        this.view = view;
        this.model = model;
        bindItems();
    }

    private void bindItems() {
        view.getTxtParola().addActionListener(this);
        view.getBtnNuovaPartita().addActionListener(e -> resetGame());
    }

    private void resetGame() {
        model = new WordleModel();
        giocoFinito = false;
        view.getTxtParola().setEditable(true);
        view.getTxtParola().setText("");
        view.getLblConsentito().setText("");
        model.mosse = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 5; j++) {
                view.getGriglia()[i][j].setText("");
                view.getGriglia()[i][j].setBackground(new Color(58, 58, 60));
            }
    }

    private void updateLabels(String colori, String tentativo) {
        for (int i = 0; i < 5; i++) {
            view.getGriglia()[model.mosse][i].setText(String.valueOf(tentativo.charAt(i)).toUpperCase());
            switch (colori.charAt(i)) {
                case 'G':
                    view.getGriglia()[model.mosse][i].setBackground(new Color(83, 141, 78)); // verde
                    break;
                case 'Y':
                    view.getGriglia()[model.mosse][i].setBackground(new Color(181, 159, 59)); // giallo
                    break;
                default:
                    view.getGriglia()[model.mosse][i].setBackground(new Color(58, 58, 60)); // grigio
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (giocoFinito) return;

        String tentativo = view.getTxtParola().getText().trim().toLowerCase();

        if (!model.controlloParola(tentativo) || tentativo.length() != 5) {
            if (model.getLingua().equals("IT")) view.getLblConsentito().setText("Parola non valida!");
            else view.getLblConsentito().setText("Invalid word!");
            view.getTxtParola().setText("");
            return;
        }

        view.getLblConsentito().setText("");
        String colori = model.getColori(tentativo);
        updateLabels(colori, tentativo);

        if (model.controlloVittoria(tentativo)) {
            if (model.getLingua().equals("IT")) view.getLblConsentito().setText("Hai vinto!");
            else view.getLblConsentito().setText("You won!");
            giocoFinito = true;
            view.getTxtParola().setEditable(false);
        } else if (model.mosse == 5) { // 6 tentativi: 0..5
            if(model.getLingua().equals("IT")) view.getLblConsentito().setText("Hai perso! Parola: " + model.getParola().toUpperCase());
            else view.getLblConsentito().setText("You lost! Word: " + model.getParola().toUpperCase());
            giocoFinito = true;
            view.getTxtParola().setEditable(false);
        }

        model.mosse++;
        view.getTxtParola().setText("");
    }
}