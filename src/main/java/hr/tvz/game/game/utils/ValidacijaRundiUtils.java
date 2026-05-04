package hr.tvz.game.game.utils;

import hr.tvz.game.game.model.SlotTip;
import hr.tvz.game.game.AerodromRunda;
import hr.tvz.game.game.UpravljackaPloca;

public class ValidacijaRundiUtils{

    private ValidacijaRundiUtils() {
    }

    public static boolean validirajRundu(UpravljackaPloca ploca, AerodromRunda uvjeti){
        if (!validirajMotor(ploca, uvjeti)) return false;
        if (!validirajApproach(ploca, uvjeti)) return false;
        if (!validirajBrzinu(ploca, uvjeti)) return false;
        if (!validirajFlaps(ploca, uvjeti)) return false;
        if (!validirajLandingGear(ploca, uvjeti)) return false;
        if (!validirajAxis(ploca, uvjeti)) return false;
        return validirajRadio(ploca, uvjeti);
    }

    private static boolean validirajMotor(UpravljackaPloca ploca, AerodromRunda uvjeti) {
        Integer motor = ploca.getVrijednost(SlotTip.MOTOR);
        return motor != null && motor >= uvjeti.getMinMotor();
    }

    private static boolean validirajApproach(UpravljackaPloca ploca, AerodromRunda uvjeti) {
        Integer approach = ploca.getVrijednost(SlotTip.APPROACH);
        return approach != null && approach >= uvjeti.getMinApproach();
    }

    private static boolean validirajBrzinu(UpravljackaPloca ploca, AerodromRunda uvjeti){
        Integer gas = ploca.getVrijednost(SlotTip.GAS);
        Integer brake = ploca.getVrijednost(SlotTip.BRAKE);
        if (gas == null || brake == null) return false;
        return gas - brake <= uvjeti.getMaxBrzina();
    }

    private static boolean validirajFlaps(UpravljackaPloca ploca, AerodromRunda uvjeti){
        if (uvjeti.getMinFlaps() == 0) return true;
        Integer flaps = ploca.getVrijednost(SlotTip.FLAPS);
        return flaps != null && flaps >= uvjeti.getMinFlaps();
    }

    private static boolean validirajLandingGear(UpravljackaPloca ploca, AerodromRunda uvjeti){
        if (uvjeti.getMinLandingGear() == 0) return true;
        Integer landingGear = ploca.getVrijednost(SlotTip.LANDING_GEAR);
        return landingGear != null && landingGear >= uvjeti.getMinLandingGear();
    }

    private static boolean validirajAxis(UpravljackaPloca ploca, AerodromRunda uvjeti){
        Integer axis = ploca.getVrijednost(SlotTip.AXIS);
        if (axis == null) return false;
        int razlika = Math.abs (axis - 3);
        return razlika <= uvjeti.getMaxAxisRazlika();
    }

    private static boolean validirajRadio(UpravljackaPloca ploca, AerodromRunda uvjeti) {
        Integer radio = ploca.getVrijednost(SlotTip.RADIO);
        if (radio == null) return false;
        boolean jeParan = radio % 2 == 0;
        return jeParan == uvjeti.isRadioParan();
    }

}
