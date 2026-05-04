package hr.tvz.game.game.utils;

import hr.tvz.game.game.Aerodrom;
import hr.tvz.game.game.AerodromRunda;

import java.util.ArrayList;
import java.util.List;

public class AerodromFactoryUtils {

    private AerodromFactoryUtils() {
    }
//POČETNIČKI-Montreal
    public static Aerodrom kreirajMontreal() {
        List <AerodromRunda> runde = new ArrayList<>();
        runde.add(new AerodromRunda(1,2,2,6,0,0,3,false));
        runde.add(new AerodromRunda(2, 2, 2, 5, 0, 0, 3, true));
        runde.add(new AerodromRunda(3, 2, 3, 5, 0, 0, 3, false));
        runde.add(new AerodromRunda(4, 3, 3, 5, 3, 0, 3, true));
        runde.add(new AerodromRunda(5, 3, 4, 4, 3, 0, 3, false));
        runde.add(new AerodromRunda(6, 3, 4, 4, 4, 4, 2, true));
        runde.add(new AerodromRunda(7, 3, 4, 3, 4, 5, 2, false));
        return new Aerodrom("Montreal", "YUL", runde);

        
    }

    // SREDNJI — Zagreb
    public static Aerodrom kreirajZagreb() {
        List<AerodromRunda> runde = new ArrayList<>();
        runde.add(new AerodromRunda(1, 2, 2, 5, 0, 0, 3, true));
        runde.add(new AerodromRunda(2, 2, 3, 5, 0, 0, 3, false));
        runde.add(new AerodromRunda(3, 3, 3, 4, 3, 0, 2, true));
        runde.add(new AerodromRunda(4, 3, 4, 4, 3, 0, 2, false));
        runde.add(new AerodromRunda(5, 3, 4, 3, 3, 3, 2, true));
        runde.add(new AerodromRunda(6, 4, 5, 3, 4, 4, 2, false));
        runde.add(new AerodromRunda(7, 4, 5, 2, 5, 5, 1, true));
        return new Aerodrom("Zagreb", "ZAG", runde);
    }

    // TEŠKI — Tokyo
    public static Aerodrom kreirajTokyo() {
        List<AerodromRunda> runde = new ArrayList<>();
        runde.add(new AerodromRunda(1, 3, 3, 5, 0, 0, 2, true));
        runde.add(new AerodromRunda(2, 3, 4, 4, 0, 0, 2, false));
        runde.add(new AerodromRunda(3, 4, 4, 4, 3, 0, 2, true));
        runde.add(new AerodromRunda(4, 4, 5, 3, 3, 3, 1, false));
        runde.add(new AerodromRunda(5, 4, 5, 3, 4, 4, 1, true));
        runde.add(new AerodromRunda(6, 5, 5, 2, 5, 5, 1, false));
        runde.add(new AerodromRunda(7, 5, 6, 2, 5, 6, 1, true));
        return new Aerodrom("Tokyo Haneda", "HND", runde);
    }

    // EXPERT — Reykjavik
    public static Aerodrom kreirajReykjavik() {
        List<AerodromRunda> runde = new ArrayList<>();
        runde.add(new AerodromRunda(1, 3, 4, 4, 0, 0, 2, true));
        runde.add(new AerodromRunda(2, 4, 4, 4, 2, 0, 2, false));
        runde.add(new AerodromRunda(3, 4, 5, 3, 3, 0, 1, true));
        runde.add(new AerodromRunda(4, 5, 5, 3, 4, 3, 1, false));
        runde.add(new AerodromRunda(5, 5, 6, 2, 4, 4, 1, true));
        runde.add(new AerodromRunda(6, 5, 6, 2, 5, 5, 1, false));
        runde.add(new AerodromRunda(7, 6, 6, 2, 6, 6, 1, true));
        return new Aerodrom("Reykjavik", "KEF", runde);
    }
    public static Aerodrom dohvatiAerodrom(String naziv) {
        return switch (naziv) {
            case "Zagreb" -> kreirajZagreb();
            case "Tokyo" -> kreirajTokyo();
            case "Reykjavik" -> kreirajReykjavik();
            default -> kreirajMontreal();
        };
    }
}
