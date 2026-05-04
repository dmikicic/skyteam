package hr.tvz.game.game;

import java.util.List;

public class Aerodrom {
    private String naziv;
    private String kod; // skraćenica od naziva aeordroma
    private List <AerodromRunda> runde;

    public Aerodrom(String naziv, String kod,List <AerodromRunda> runde) {
        this.naziv = naziv;
        this.kod = kod;
        this.runde = runde;
    }
    public String getNaziv() {
        return naziv;
    }
    public String getKod() {
        return kod;
    }
    public List <AerodromRunda> getRunde() {
        return runde;
    }
    public int getBrojRundi() {
        return runde.size();
    }
    public AerodromRunda getRunda(int index) {
        return runde.get(index);
    }

}
