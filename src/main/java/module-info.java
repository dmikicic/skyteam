module hr.tvz.game.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens hr.tvz.game.game to javafx.fxml;
    exports hr.tvz.game.game;
}