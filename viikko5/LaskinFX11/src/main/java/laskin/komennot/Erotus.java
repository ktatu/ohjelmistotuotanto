package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 * @author Tatu
 */
public class Erotus extends Komento {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka logiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, logiikka);
    }

    @Override
    public void suorita() {
        edeltavaTulos = haeTulos();
        System.out.println("haetulos " + haeTulos());
        
        logiikka.miinus(haeSyote());
        System.out.println("haesyote" + haeSyote());
        
        this.asetaTulos(logiikka.tulos());
    }
    
}
