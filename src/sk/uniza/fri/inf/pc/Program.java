package sk.uniza.fri.inf.pc;

import sk.uniza.fri.inf.pc.hardver.Pocitac;
import sk.uniza.fri.inf.pc.hardver.UsbPort;
import sk.uniza.fri.inf.pc.hardver.zariadenia.Klavesnica;
import sk.uniza.fri.inf.pc.hardver.zariadenia.Mys;
import sk.uniza.fri.inf.pc.hardver.zariadenia.UsbHub;

/**
 * Created by IntelliJ IDEA.
 * User: pasto
 * Date: 17. 3. 2021
 * Time: 16:54
 */
public class Program {

    public static void main(String[] args) {
        Pocitac mojNotebook = new Pocitac(4);
        UsbPort usbPort0 = mojNotebook.getVolnyUsbPort();
        Klavesnica klavesnica = new Klavesnica("G910 OrionSpectrum", "Logitech", true);
        klavesnica.pripojDoUsbPortu(usbPort0);
        UsbPort usbPort2 = mojNotebook.getUsbPort(2);
        Mys mys = new Mys("M705 MarathonMouse", "Logitech", 5, true);
        mys.pripojDoUsbPortu(usbPort2);
        UsbPort usbPort3 = mojNotebook.getUsbPort(3);
        UsbHub usbHub = new UsbHub("HUE-SA7BP", "AXAGON", 7);
        usbHub.pripojDoUsbPortu(usbPort3);
        klavesnica.odpojZUsbPortu();
        klavesnica.pripojDoUsbPortu(usbHub.getUsbPort(5));
        UsbHub usbHubMaly = new UsbHub("HUE-S2B USB 3.0", "AXAGON", 4);
        usbHubMaly.pripojDoUsbPortu(usbHub.getUsbPort(2));
        mojNotebook.vypisVsetkyZariadenia();
    }

}
