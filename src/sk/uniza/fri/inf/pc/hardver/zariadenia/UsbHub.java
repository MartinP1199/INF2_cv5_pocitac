package sk.uniza.fri.inf.pc.hardver.zariadenia;
import sk.uniza.fri.inf.pc.hardver.IUsbZariadenie;
import sk.uniza.fri.inf.pc.hardver.UsbPort;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class UsbHub implements IUsbZariadenie {

    private final String nazov;
    private final String vyrobca;
    private final UsbPort[] usbPorty;

    public UsbHub(String nazov, String vyrobca, int pocetUsbPortov) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.usbPorty = new UsbPort[pocetUsbPortov];
        for (int i = 0; i < this.usbPorty.length; i++) {
            this.usbPorty[i] = new UsbPort();
        }
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    public int getPocetUsbPortov() {
        return this.usbPorty.length;
    }

    public UsbPort getUsbPort(int index) {
        if (index < this.usbPorty.length) {
            return this.usbPorty[index];
        }
        return null;
    }

    public UsbPort getVolnyUsbPort() {
        for (UsbPort port : this.usbPorty) {
            if (!port.jeObsadeny()) {
                return port;
            }
        }
        return null;
    }

    @Override
    public void pripojDoUsbPortu(UsbPort usbPort) {
        usbPort.setUsbZariadenie(this);
    }

    @Override
    public void odpojZUsbPortu() {
        IUsbZariadenie usb = this;
        this.odpojZUsbPortu();
    }

    public void vypisVsetkyMysky() {
        for (int i = 0; i < this.usbPorty.length; i++) {
            if (this.usbPorty[i].jeObsadeny() && this.usbPorty[i].getUsbZariadenie() instanceof IMys) {
                System.out.println(usbPorty[i].getUsbZariadenie().getPopisZariadenia(0));
            } else if (this.usbPorty[i].getUsbZariadenie() instanceof UsbHub) {
                ((UsbHub)this.usbPorty[i].getUsbZariadenie()).vypisVsetkyMysky();
            }
        }
    }

    public void vypisVsetkyKlavesnice() {
        for (int i = 0; i < this.usbPorty.length; i++) {
            if (this.usbPorty[i].jeObsadeny() && this.usbPorty[i].getUsbZariadenie() instanceof IKlavesnica) {
                System.out.println(usbPorty[i].getUsbZariadenie().getPopisZariadenia(0));
            } else if (this.usbPorty[i].getUsbZariadenie() instanceof UsbHub) {
                ((UsbHub)this.usbPorty[i].getUsbZariadenie()).vypisVsetkyKlavesnice();
            }
        }
    }

    public String getPopisZariadenia(int odsadenie) {
        String line = "";
        String format = this.getClass().getSimpleName() + " " + this.getVyrobca() + " " + this.getNazov() + " (pocet portov: " + this.getPocetUsbPortov() + ")\n";
        for (int i = 0; i < this.usbPorty.length; i++) {

            format += line;
            line = "\n";
            for (int j = 0; j < odsadenie; j++) {
                format += "  ";
            }
            format += "  [" + i + "] ";
            if (this.usbPorty[i].jeObsadeny()) {
                format += usbPorty[i].getUsbZariadenie().getPopisZariadenia(odsadenie + 1);
            } else {
                format += "(volny)";
            }
        }
        return format;
    }

}
