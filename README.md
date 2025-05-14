# Wordle-Java

Progetto scolastico che simula e cerca di riprodurre il gioco Wordle

---

## Caratteristiche principali

- **Interfaccia grafica moderna** (Swing) con tema scuro e componenti custom.
- **Selezione lingua** all’avvio (italiano/inglese) tramite bandiere.
- **Dizionari separati** per ogni lingua.
- **Feedback visivo** con colori Wordle (verde, giallo, grigio).
- **Crediti autori** integrati nella schermata di avvio.
- **Reset partita** senza riavvio dell’applicazione.

---

## Struttura del progetto

```
Wordle-Java/
│
├── src/
│   └── wordle/
│       ├── GUI.java                # Interfaccia grafica principale
│       ├── WordleModel.java        # Logica di gioco e gestione dizionario
│       ├── WordleController.java   # Controller (gestione eventi e logica)
│       ├── StartScreen.java        # (opzionale) Schermata di selezione lingua standalone
│       └── Wordle.java             # Main launcher
│
├── src/
│   └── img/
│       ├── it.png                  # Bandiera Italia
│       ├── gb.png                  # Bandiera UK
│       └── icon.png                # Icona applicazione
│
├── src/
│   └── dictionaries/
│       ├── dictionaryIT.txt        # Dizionario italiano (parole di 5 lettere)
│       └── dictionaryEN.txt        # Dizionario inglese (parole di 5 lettere)
│
└── README.md                       # Questo file
```

---

## Requisiti

- **Java 8** o superiore
- Nessuna dipendenza esterna (solo librerie standard Java)

---

## Avvio del gioco

1. **Compila il progetto**:
    ```sh
    javac -d bin src/wordle/*.java
    ```

2. **Esegui il gioco**:
    ```sh
    java -cp bin wordle.Wordle
    ```

3. **Seleziona la lingua** tramite la schermata iniziale.

4. **Gioca**: inserisci una parola di 5 lettere e premi Invio.

---

## Funzionamento

- Hai 6 tentativi per indovinare la parola segreta.
- I colori delle celle indicano:
    - **Verde**: lettera giusta al posto giusto
    - **Giallo**: lettera presente ma posizione sbagliata
    - **Grigio**: lettera assente
- Il dizionario cambia in base alla lingua scelta.
- Puoi resettare la partita in qualsiasi momento con il pulsante dedicato.

---

## Autori

- Alfano Andrea
- Spina Mattia
- Venturi Bruno

---