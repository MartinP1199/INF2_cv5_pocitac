package sk.uniza.fri.inf.pc.hardver.zariadenia;

import sk.uniza.fri.inf.pc.hardver.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardver.UsbPort;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class Klavesnica implements IUsbZariadenie, IKlavesnica {
    private String nazov;
    private String vyrobca;
    private UsbPort port;
    private boolean maNumerickuCast;

    public Klavesnica(String nazov, String vyrobca, boolean maNumerickuCast) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.maNumerickuCast = maNumerickuCast;
    }

    @Override
    public String getNazov() {
        String numerickaCast;
        if (this.maNumerickuCast) {
            numerickaCast = "ano";
        } else {
            numerickaCast = "nie";
        }
        return this.nazov + " (ma numericku cast: " + numerickaCast + ")";
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    public boolean isMaNumerickuCast() {
        return this.maNumerickuCast;
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
        String numerickaCast;
        if (this.maNumerickuCast) {
            numerickaCast = "ano";
        } else {
            numerickaCast = "nie";
        }
        return this.getClass().getSimpleName() + " " + this.vyrobca + " " + this.nazov + " (ma numericka cast: " + numerickaCast + ")";
    }
}
