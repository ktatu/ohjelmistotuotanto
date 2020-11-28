package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 * tuloskentta, syotekentta,  nollaa, undo, sovellus
 * TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo
 * @author Tatu
 */
public abstract class Komento {
    
    Sovelluslogiikka logiikka;
    
    protected TextField tuloskentta;
    protected TextField syotekentta;
    
    protected int edeltavaTulos;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka logiikka) {
        this.logiikka = logiikka;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edeltavaTulos = 0;
    }
    
    public abstract void suorita();
    
    public void peru() {
        asetaTulos(edeltavaTulos);
        logiikka.setTulos(edeltavaTulos);
        edeltavaTulos = 0;
    }
    
    protected void asetaTulos(int uusiArvo) {
        this.tuloskentta.setText(String.valueOf(uusiArvo));
    }
    
    protected int haeTulos() {
        return Integer.valueOf(tuloskentta.getText());
    }
    
    protected int haeSyote() {
        return Integer.valueOf(syotekentta.getText());
    }
}
