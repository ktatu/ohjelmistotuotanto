package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author Tatu
 */
public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka logiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, logiikka);
    }

    @Override
    public void suorita() {
        edeltavaTulos = haeTulos();
        logiikka.nollaa();
        asetaTulos(logiikka.tulos());
    }
    
}
