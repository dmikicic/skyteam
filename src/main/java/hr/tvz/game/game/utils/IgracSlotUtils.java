package hr.tvz.game.game.utils;

import hr.tvz.game.game.model.Igrac;
import hr.tvz.game.game.model.SlotTip;

public class IgracSlotUtils {
    private IgracSlotUtils() {
    }
    public static boolean smijePostaviti(Igrac igrac, SlotTip slot){
        if (igrac == Igrac.PILOT){
            return slot == SlotTip.GAS
                    || slot == SlotTip.MOTOR
                    || slot == SlotTip.FLAPS
                    || slot == SlotTip.AXIS
                    || slot == SlotTip.RADIO
                    || slot == SlotTip.APPROACH;
        } else {
            return slot == SlotTip.GAS
                    || slot == SlotTip.MOTOR
                    || slot == SlotTip.BRAKE
                    || slot == SlotTip.LANDING_GEAR
                    || slot == SlotTip.AXIS
                    || slot == SlotTip.RADIO
                    || slot == SlotTip.APPROACH;
        }
    }
}
