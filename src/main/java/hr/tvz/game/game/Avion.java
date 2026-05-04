package hr.tvz.game.game;

public class Avion {

    private int visina;
    private int brzina;
    private int os;
    private boolean motor;
    private boolean zakrilca;
    private boolean podvozje;

    public Avion() {
        this.visina = 10;
        this.brzina = 3;
        this.os = 0;
        this.motor = true;
        this.zakrilca = false;
        this.podvozje = false;
    }
    //pišemo getttere i settere

    public int getVisina() {
        return visina;
    }
    public int getBrzina() {
        return brzina;
    }
    public int getOs() {
        return os;
    }
    public boolean isMotor() {
        return motor;
    }
    public boolean isZakrilca() {
        return zakrilca;
    }
    public boolean isPodvozje() {
        return podvozje;
    }

    public void setVisina(int visina) {this.visina = visina;}
    public void setBrzina(int brzina) {
        this.brzina = brzina;
    }
    public void setOs(int os) {
        this.os = os;
    }
    public void setMotor(boolean motor) {
        this.motor = motor;
    }
    public void setZakrilca(boolean zakrilca) {
        this.zakrilca = zakrilca;
    }
    public void setPodvozje(boolean podvozje) {
        this.podvozje = podvozje;
    }

}
