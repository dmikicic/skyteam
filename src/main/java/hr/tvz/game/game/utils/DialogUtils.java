package hr.tvz.game.game.utils;

import javafx.scene.control.Alert;

import java.util.List;

public class DialogUtils {
    private DialogUtils() {
        }

        public static void prikaziKocke(String naslov, String igrac, List<Integer> kocke) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle(naslov);
            dialog.setHeaderText(igrac + " ovo su tvoje kocke:");
            dialog.setContentText(kocke.toString());
            dialog.showAndWait();

        }
        public static void prikaziPogresku(String naslov, String poruka) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(naslov);
        alert.setHeaderText(null);
        alert.setContentText(poruka);
        alert.showAndWait();
        }
    public static void prikaziDialog(String naslov, String sadrzaj, String zaglavlje, Alert.AlertType tipAlerta) {
        Alert alert = new Alert(tipAlerta);
        alert.setTitle(naslov);
        alert.setHeaderText(zaglavlje);
        alert.setContentText(sadrzaj);
        alert.showAndWait();
    }

}
