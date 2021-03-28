package sk.uniza.fri.inf.pc.hardver.zariadenia;

import sk.uniza.fri.inf.pc.hardver.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardver.UsbPort;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class Mys implements IUsbZariadenie, IMys {
    private String nazov;
    private String vyrobca;
    private UsbPort port;
    private boolean jeBezdrotova;
    private int pocetTlacidiel;

    public Mys(String nazov, String vyrobca, int pocetTlacidiel, boolean jeBezdrotova) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.jeBezdrotova = jeBezdrotova;
        this.pocetTlacidiel = pocetTlacidiel;
    }

    @Override
    public String getNazov() {
        String bezdrotova;
        if (this.jeBezdrotova) {
            bezdrotova = "áno";
        } else {
            bezdrotova = "nie";
        }
        return this.nazov + " (pocet tlacidiel: " + this.pocetTlacidiel + ", bezdrotova: " + bezdrotova + ")";
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    public int getPocetTlacidiel() {
        return this.pocetTlacidiel;
    }

    public boolean isJeBezdrotova() {
        return this.jeBezdrotova;
    }

    @Override
    public void pripojDoUsbPortu(UsbPort usbPort) {
        this.port = usbPort;
        this.port.setUsbZariadenie(this);
    }

    @Override
    public void odpojZUsbPortu() {
        this.port.setUsbZariadenie(null);
        this.port = null;
    }

    public String getPopisZariadenia(int odsadenie) {
        String bezdrotova;
        if (this.jeBezdrotova) {
            bezdrotova = "ano";
        } else {
            bezdrotova = "nie";
        }
        return this.getClass().getSimpleName() + " " + this.vyrobca + " " + this.nazov + " (pocet tlacidiel: " + this.pocetTlacidiel + ", bezdrotova: " + bezdrotova + ")";
    }

}
