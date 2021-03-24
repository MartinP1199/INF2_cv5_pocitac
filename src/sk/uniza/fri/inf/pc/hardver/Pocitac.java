package sk.uniza.fri.inf.pc.hardver;

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
                System.out.println("[" + i + "] " + porty[i].getUsbZariadenie().toString());
            } else {
                System.out.println("[" + i + "] (volny)");
            }
        }
    }

    private void vytvorUsbPorty() {
        for (int i = 0; i < this.pocetUsbPortov; i++) {
            this.porty[i] = new UsbPort();
        }
    }
}
