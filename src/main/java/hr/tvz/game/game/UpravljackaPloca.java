package hr.tvz.game.game;
import hr.tvz.game.game.model.Igrac;
import hr.tvz.game.game.model.SlotTip;
import java.util.EnumMap;
import java.util.Map;

//Upravljacka ploca pamti koje kocke su postavljene na koja mjesta na ploci

public class UpravljackaPloca {

    private Map<SlotTip, Integer> slotovi;
    private Map<SlotTip, Igrac> igraci;

    public UpravljackaPloca() {

        this.slotovi = new EnumMap<>(SlotTip.class);
        this.igraci = new EnumMap<>(SlotTip.class);
    }

public boolean postaviKocku(SlotTip slot, int vrijednost, Igrac igrac) {
        if (slotovi.containsKey(slot)) {
            return false; //ovo znaci da je slot vec postavljen
        }
        if (vrijednost < 1 || vrijednost > 6) {
            return false; //vrijednost je ne vazeca

        }
        slotovi.put(slot, vrijednost);
        igraci.put(slot,igrac);
        return true;
    }
    public Integer getVrijednost(SlotTip slot) {
        return slotovi.get(slot); //metoda cita što je postavljeno na slot
    }
    public Igrac getIgrac(SlotTip slot) {
        return igraci.get(slot);
    }
    public boolean isZauzet(SlotTip slot) {
        return slotovi.containsKey(slot); //metoda provjerava da li je slot zauzet
    }
    public void resetiraj() {
        slotovi.clear();
        igraci.clear();//metoda resetira plocu
    }
    public int getBrojPopunjenih() {return slotovi.size();}
}
