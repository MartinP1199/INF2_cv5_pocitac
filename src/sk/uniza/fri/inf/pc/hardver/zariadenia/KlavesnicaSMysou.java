package sk.uniza.fri.inf.pc.hardver.zariadenia;

import sk.uniza.fri.inf.pc.hardver.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardver.UsbPort;

public class KlavesnicaSMysou implements IUsbZariadenie, IMys, IKlavesnica {
    private String nazov;
    private String vyrobca;
    private boolean maNumerickuCast;
    private UsbPort port;

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

    @Override
    public void pripojDoUsbPortu(UsbPort usbPort) {
        if (usbPort == null) {
            System.out.println("Port je null");
        }
        this.port = usbPort;
        this.port.setUsbZariadenie(this);
    }

    @Override
    public void odpojZUsbPortu() {
        if (this.port != null) {
            this.port.setUsbZariadenie(null);
            this.port = null;
        }
    }

    public boolean isMaNumerickuCast() {
        return this.maNumerickuCast;
    }

    @Override
    public String getPopisZariadenia(int index) {
        String podmienka = "nie";
        if (this.maNumerickuCast) {
            podmienka = "áno";
        }
        return this.vyrobca + " " + this.nazov +
                " (má numerickú časť: " + podmienka + ").";
    }
}
