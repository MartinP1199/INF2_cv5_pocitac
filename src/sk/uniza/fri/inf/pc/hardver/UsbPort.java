package sk.uniza.fri.inf.pc.hardver;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public class UsbPort {
    private IUsbZariadenie usbZariadenie;
    private boolean jeObsadeny;

    public UsbPort() {
        jeObsadeny = false;
    }

    public IUsbZariadenie getUsbZariadenie() {
        return this.usbZariadenie;
    }

    public boolean jeObsadeny() {
        return this.usbZariadenie != null;
    }

    public void setUsbZariadenie(IUsbZariadenie usbZariadenie) {
        this.usbZariadenie = usbZariadenie;
    }

}
