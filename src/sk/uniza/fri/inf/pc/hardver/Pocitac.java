package sk.uniza.fri.inf.pc.hardver;

import sk.uniza.fri.inf.pc.hardver.zariadenia.IKlavesnica;
import sk.uniza.fri.inf.pc.hardver.zariadenia.IMys;
import sk.uniza.fri.inf.pc.hardver.zariadenia.UsbHub;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class Pocitac {
    private int pocetUsbPortov;
    private UsbPort[] porty;

    public Pocitac(int pocetUsbPortov) {
        this.pocetUsbPortov = pocetUsbPortov;
        this.porty = new UsbPort[this.pocetUsbPortov];
        this.vytvorUsbPorty();
    }

    public UsbPort getUsbPort(int index) {
        return this.porty[index];
    }

    public UsbPort getVolnyUsbPort() {
        for (UsbPort port : this.porty) {
            if (!port.jeObsadeny()) {
                return port;
            }
        }
        return null;
    }

    public void vypisVsetkyZariadenia() {
        System.out.println("Zariadenia: ");
        for (int i = 0; i < this.pocetUsbPortov; i++) {
            if (this.porty[i].jeObsadeny()) {
                System.out.println("[" + i + "] " + porty[i].getUsbZariadenie().getPopisZariadenia(0));
            } else {
                System.out.println("[" + i + "] (volny)");
            }
        }
    }

    public void vypisVsetkyMysky() {
        for (int i = 0; i < this.pocetUsbPortov; i++) {
            if (this.porty[i].getUsbZariadenie() instanceof IMys) {
                System.out.println(porty[i].getUsbZariadenie().getPopisZariadenia(0));
            } else if (this.porty[i].getUsbZariadenie() instanceof UsbHub) {
                ((UsbHub)this.porty[i].getUsbZariadenie()).vypisVsetkyMysky();
            }
        }
    }

    public void vypisVsetkyKlavesnice() {
        for (int i = 0; i < this.pocetUsbPortov; i++) {
            if (this.porty[i].jeObsadeny() && this.porty[i].getUsbZariadenie() instanceof IKlavesnica) {
                System.out.println(porty[i].getUsbZariadenie().getPopisZariadenia(0));
            } else if (this.porty[i].getUsbZariadenie() instanceof UsbHub) {
                ((UsbHub)this.porty[i].getUsbZariadenie()).vypisVsetkyKlavesnice();
            }
        }
    }

    private void vytvorUsbPorty() {
        for (int i = 0; i < this.pocetUsbPortov; i++) {
            this.porty[i] = new UsbPort();
        }
    }
}
