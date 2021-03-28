package sk.uniza.fri.inf.pc.hardver.zariadenia;

import sk.uniza.fri.inf.pc.hardver.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardver.UsbPort;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class KlavesnicaSMysou implements IUsbZariadenie, IKlavesnica, IMys {
    private String nazov;
    private String vyrobca;
    private UsbPort port;
    private boolean maNumerickuCast;

    public KlavesnicaSMysou(String nazov, String vyrobca, boolean maNumerickuCast) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.maNumerickuCast = maNumerickuCast;
    }

    @Override
    public String getNazov() {
        return this.nazov;
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

    @Override
    public String getPopisZariadenia(int index) {
        String numerickaCast;
        if (this.maNumerickuCast) {
            numerickaCast = "ano";
        } else {
            numerickaCast = "nie";
        }
        return "Klavesnica " + this.vyrobca + " " + this.nazov + " (numericka cast: " + numerickaCast + ")";
    }
}
