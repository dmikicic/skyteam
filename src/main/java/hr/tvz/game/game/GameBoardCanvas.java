package hr.tvz.game.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameBoardCanvas extends Canvas {

    private final GraphicsContext gc;
    private int trenutnaRunda = 1;
    private int ukupnoRundi = 7;
    private double nagib = 0;

    public GameBoardCanvas() {
        super(200, 400);
        this.gc = getGraphicsContext2D();
        crtaj();
    }

    public GameBoardCanvas(double width, double height) {
        super(width, height);
        this.gc = getGraphicsContext2D();
        crtaj();
    }

    public void azuriraj(int runda, int ukupno) {
        this.trenutnaRunda = runda;
        this.ukupnoRundi = ukupno;
        crtaj();
    }

    public void postaviNagib(double nagib) {
        this.nagib = nagib;
        crtaj();
    }

    private void crtaj() {
        crtajPozadinu();
        crtajSlojeve();
        crtajAvion();
    }

    private void crtajPozadinu() {
        gc.setFill(Color.rgb(5, 10, 30));
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

    private void crtajSlojeve() {
        gc.setStroke(Color.rgb(50, 80, 120));
        gc.setLineWidth(0.5);
        gc.setFill(Color.rgb(100, 180, 255));

        for (int i = 0; i <= 10; i++) {
            double y = getHeight() * (1.0 - i / 10.0) * 0.85 + 20;
            gc.strokeLine(0, y, getWidth(), y);
            gc.fillText("FL" + (i * 10), 5, y - 2);
        }
    }

    private void crtajAvion() {
        double x = getWidth() / 2;
        double y = izracunajPozicijuAviona();

        gc.save();
        gc.translate(x, y);
        gc.rotate(nagib);

        // Tijelo aviona (trokut)
        gc.setFill(Color.rgb(200, 220, 255));
        double[] xPts = {0, -15, 15};
        double[] yPts = {-20, 8, 8};
        gc.fillPolygon(xPts, yPts, 3);

        // Krila
        gc.setFill(Color.rgb(150, 180, 220));
        gc.fillRect(-25, 0, 50, 5);

        // Motori
        gc.setFill(Color.rgb(100, 100, 120));
        gc.fillRect(-22, 4, 9, 6);
        gc.fillRect(13, 4, 9, 6);

        gc.restore();
    }

    private double izracunajPozicijuAviona() {
        double napredak = (double) (trenutnaRunda - 1) / ukupnoRundi;
        return getHeight() * (0.1 + napredak * 0.75);
    }
}