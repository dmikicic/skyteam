package hr.tvz.game.game.utils;

import hr.tvz.game.game.AerodromRunda;

public class PragoviUtils {
    private PragoviUtils(){
    }
    public static String prikaziPragove (AerodromRunda uvjeti){
        return String.format("Pragovi: motor≥%d, approach≥%d, brzina≤%d, flaps≥%d, gear≥%d, axis razlika≤%d, radio %s",
                uvjeti.getMinMotor(),
                uvjeti.getMinApproach(),
                uvjeti.getMaxBrzina(),
                uvjeti.getMinFlaps(),
                uvjeti.getMinLandingGear(),
                uvjeti.getMaxAxisRazlika(),
                uvjeti.isRadioParan() ? "paran" : "neparan"
        );
    }
}
