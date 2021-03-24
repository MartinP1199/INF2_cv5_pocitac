package sk.uniza.fri.inf.pc.hardver;

/**
 * 17. 3. 2021 - 16:54
 *
 * @author pasto
 */
public interface IUsbZariadenie {
    String getNazov();
    String getVyrobca();
    void pripojDoUsbPortu(UsbPort usbPort);
    void odpojZUsbPortu();
}
