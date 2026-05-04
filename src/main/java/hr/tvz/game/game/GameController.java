package hr.tvz.game.game;

import hr.tvz.game.game.model.SlotTip;
import hr.tvz.game.game.utils.AerodromFactoryUtils;
import hr.tvz.game.game.utils.DialogUtils;
import hr.tvz.game.game.utils.PragoviUtils;
import hr.tvz.game.game.utils.SlotDialogUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class GameController {
    @FXML private Label rundaLabel;
    @FXML private Label statusLabel;
    @FXML private Label pragoviLabel;
    @FXML private GameBoardCanvas avijonCanvas;
    @FXML private Button baciKockeBtn;
    @FXML private Button zavrsiRunduBtn;
    @FXML private Button sljedecaRundaBtn;
    @FXML private Label gasLabel;
    @FXML private Label brakeLabel;
    @FXML private Label flapsLabel;
    @FXML private Label gearLabel;
    @FXML private Label radioLabel;
    @FXML private Label motorLabel;
    @FXML private Label axisLabel;
    @FXML private Label approachLabel;
    @FXML private ComboBox<String> aerodromComboBox;

    private SkyTeamEngine engine;

    @FXML
    public void initialize() {
         engine = new SkyTeamEngine();
         aerodromComboBox.getItems().addAll("Montreal", "Zagreb", "Tokyo", "Reykjavik");
         aerodromComboBox.setValue("Montreal");

         azurirajUI();
    }

    @FXML
    private void baciKockuAction() {
        engine.baciKocke();
        DialogUtils.prikaziKocke( "Kocke Pilota", "Pilot", engine.getKockaPilota());
        DialogUtils.prikaziKocke("Kocke Kopilota","Kopilot", engine.getKockaKopilota());
        azurirajUI();
    }
    @FXML
    private void onPostaviAerodromKlik(){
        String naziv = aerodromComboBox.getValue();
        Aerodrom aerodrom = AerodromFactoryUtils.dohvatiAerodrom(naziv);
        engine.postaviAerodrom(aerodrom);
        engine.resetirajIgru();
        azurirajUI();
    }
    @FXML
    private void onZavrsiRunduKlik() {
        if (engine.getPloca().getBrojPopunjenih() < 8){
            statusLabel.setText("Postavite sve kocke prije završetka runde!");
            return;
        }
        engine.azurirajStanjeAviona();

        if (!engine.validirajRundu()) {
            engine.resetirajIgru();
            azurirajUI();
            statusLabel.setText("GAME OVER! Pragovi nisu ispunjeni!");
            return;
        }
        if (!engine.provjeriSigurnost()) {
            engine.resetirajIgru();
            azurirajUI();
            statusLabel.setText("GAME OVER! Avion nije siguran!");
            return;
        }
        engine.zavrsiRundu();
        azurirajUI();
        statusLabel.setText("Runda uspješna! Klikni 'Sljedeća runda'.");

    }

    @FXML
    private void onSljedecaRundaKlik() {
        engine.sljedecaRunda();
        azurirajUI();
        if (engine.provjeriKrajIgre()) {
            statusLabel.setText("POBJEDA!");
            baciKockeBtn.setDisable(true);
            zavrsiRunduBtn.setDisable(true);
            sljedecaRundaBtn.setDisable(true);
        } else if (engine.getTrenutnaRunda() > engine.getAerodrom().getBrojRundi()) {
            statusLabel.setText("CRASH!");
            baciKockeBtn.setDisable(true);
            zavrsiRunduBtn.setDisable(true);
            sljedecaRundaBtn.setDisable(true);
            
        }

    }


    private void azurirajUI() {
        rundaLabel.setText("Runda: " + engine.getTrenutnaRunda());
        statusLabel.setText("Faza: " + engine.getTrenutnaFaza());
        AerodromRunda uvjeti = engine.getAerodrom().getRunda(engine.getTrenutnaRunda()-1);
        pragoviLabel.setText(PragoviUtils.prikaziPragove(uvjeti));

        azurirajSlot(gasLabel, SlotTip.GAS);
        azurirajSlot(brakeLabel, SlotTip.BRAKE);
        azurirajSlot(flapsLabel, SlotTip.FLAPS);
        azurirajSlot(gearLabel, SlotTip.LANDING_GEAR);
        azurirajSlot(radioLabel, SlotTip.RADIO);
        azurirajSlot(motorLabel, SlotTip.MOTOR);
        azurirajSlot(axisLabel, SlotTip.AXIS);
        azurirajSlot(approachLabel, SlotTip.APPROACH);

        avijonCanvas.azuriraj(engine.getTrenutnaRunda(), engine.getAerodrom().getBrojRundi());


    }
    private void azurirajSlot(Label label, SlotTip tip){
        Integer vrijednost = engine.getPloca().getVrijednost (tip);
        label.setText(vrijednost != null ? vrijednost.toString() : "-");
    }

    @FXML private void onGasKlik() {postaviNaSlot(SlotTip.GAS);}
    @FXML private void onBrakeKlik() {postaviNaSlot(SlotTip.BRAKE);}
    @FXML private void onFlapsKlik() {postaviNaSlot(SlotTip.FLAPS);}
    @FXML private void onGearKlik() {postaviNaSlot(SlotTip.LANDING_GEAR);}
    @FXML private void onRadioKlik() {postaviNaSlot(SlotTip.RADIO);}
    @FXML private void onMotorKlik() {postaviNaSlot(SlotTip.MOTOR);}
    @FXML private void onAxisKlik() {postaviNaSlot(SlotTip.AXIS);}
    @FXML private void onApproachKlik() {postaviNaSlot(SlotTip.APPROACH);}

    private void postaviNaSlot(SlotTip slot) {
        SlotDialogUtils.postaviNaSlot(engine, slot, engine.getTrenutniIgrac());
        azurirajUI();
    }


}
