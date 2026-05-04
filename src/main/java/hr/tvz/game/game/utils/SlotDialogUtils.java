package hr.tvz.game.game.utils;
import hr.tvz.game.game.SkyTeamEngine;
import hr.tvz.game.game.model.Igrac;
import hr.tvz.game.game.model.SlotTip;
import javafx.scene.control.ChoiceDialog;

import java.util.List;

public class SlotDialogUtils {
    private SlotDialogUtils() {
    }

    public static void postaviNaSlot( SkyTeamEngine engine, SlotTip slot,Igrac igrac){
        if (!engine.mozePostavitiPlocu()){
            return;
        }
        if (!IgracSlotUtils.smijePostaviti(igrac, slot)) {
            DialogUtils.prikaziPogresku("Zabranjen slot", igrac + " ne smije postaviti kocku na " + slot.name());
            return; // igrač ne smije na ovaj slot
        }
        if (engine.getPloca().isZauzet(slot)){
            return;
        }
        List<Integer> kocke = engine.getKockeTrenutnogIgraca();
        if(kocke.isEmpty()){
            return;
        }
        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(kocke.get(0), kocke);
        dialog.setTitle("Odaberite kocku");
        dialog.setHeaderText(engine.getTrenutniIgrac()+ "- odaberi kocku za " + slot);
        dialog.setContentText("Kocka:");
        dialog.showAndWait().ifPresent(vrijednost -> {
            boolean postavljen = engine.getPloca().postaviKocku(slot,vrijednost,igrac);
            if (postavljen){
                kocke.remove(vrijednost);

                if (!engine.getKockeDrugogIgraca().isEmpty()){
                    engine.zamijeniIgraca();
                }
            }
        });
    }
}
