package hr.tvz.game.game;

import hr.tvz.game.game.model.FazaIgre;
import hr.tvz.game.game.model.Igrac;
import hr.tvz.game.game.model.SlotTip;
import hr.tvz.game.game.utils.AerodromFactoryUtils;
import hr.tvz.game.game.utils.ValidacijaRundiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serial;
import java.io.Serializable;

public class SkyTeamEngine implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Avion avion;
    private Aerodrom aerodrom;
    private UpravljackaPloca ploca;
    private int trenutnaRunda;
    private FazaIgre trenutnaFaza;
    private Igrac trenutniIgrac = Igrac.PILOT;
    private List <Integer> kockaPilota = new ArrayList<>();
    private List <Integer> kockaKopilota = new ArrayList<>();
    private transient Random random = new Random(); //kada se serializira, random se ne serializira

    public SkyTeamEngine() {
        this.avion = new Avion();
        this.aerodrom = AerodromFactoryUtils.kreirajMontreal();
        this.ploca = new UpravljackaPloca();
        this.trenutnaRunda = 1;
        this.trenutnaFaza = FazaIgre.BACANJE;
    }
//ovo su samo gettteri

    public Avion getAvion() {
        return avion;
    }
    public Aerodrom getAerodrom() {
        return aerodrom;
    }
    public int getTrenutnaRunda() {
        return trenutnaRunda;
    }
    public FazaIgre getTrenutnaFaza() {
        return trenutnaFaza;
    }
    public boolean mozePostavitiPlocu() {
        return trenutnaFaza == FazaIgre.POSTAVLJANJE;
    }
    public List<Integer> getKockaPilota() {return kockaPilota;}
    public List<Integer> getKockaKopilota() {return kockaKopilota;}
    public Igrac getTrenutniIgrac() {return trenutniIgrac;}
    public List<Integer> getKockeTrenutnogIgraca() {
        if (trenutniIgrac == Igrac.PILOT) {
            return kockaPilota;
        } else {
            return kockaKopilota;
        }
    }

    public List<Integer> getKockeDrugogIgraca() {
        if (trenutniIgrac == Igrac.PILOT) {
            return kockaKopilota;
        } else {
            return kockaPilota;
        }
    }

    public void zamijeniIgraca(){
        if (trenutniIgrac == Igrac.PILOT){
            trenutniIgrac = Igrac.KOPILOT;
        } else {
            trenutniIgrac = Igrac.PILOT;
        }
    }

    public void postaviAerodrom(Aerodrom aerodrom) {
        this.aerodrom = aerodrom;
    }

    public void zavrsiRundu(){
        if (trenutnaFaza == FazaIgre.POSTAVLJANJE){
            trenutnaFaza = FazaIgre.PROVJERA;
        }
    }
    public void sljedecaRunda(){
        if (trenutnaFaza == FazaIgre.PROVJERA){
            ploca.resetiraj();
            trenutnaRunda++;
            trenutnaFaza = FazaIgre.BACANJE;
        }
    }
    public void baciKocke() {
        kockaPilota = new ArrayList<>();
        kockaKopilota = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            kockaPilota.add(random.nextInt(6) + 1);
        }
        for (int i = 0; i < 4; i++) {
            kockaKopilota.add(random.nextInt(6) + 1);
        }
        trenutnaFaza = FazaIgre.POSTAVLJANJE;
    }

    public void azurirajStanjeAviona(){
        avion.setZakrilca(false);
        avion.setPodvozje(false);

        Integer gas = ploca.getVrijednost(SlotTip.GAS);
        Integer brake = ploca.getVrijednost(SlotTip.BRAKE);
        Integer motor = ploca.getVrijednost(SlotTip.MOTOR);
        Integer axis = ploca.getVrijednost(SlotTip.AXIS);
        Integer flaps = ploca.getVrijednost(SlotTip.FLAPS);
        Integer landingGear = ploca.getVrijednost(SlotTip.LANDING_GEAR);

        if (gas != null){
            avion.setBrzina(Math.min(6, avion.getBrzina() + gas/3));
        }
        if (brake != null){
            avion.setBrzina(Math.max(1, avion.getBrzina() - brake/2));
        }
        if (motor != null && motor < 2) {
            avion.setMotor(false);
        }
        if (axis != null) {
            avion.setOs(avion.getOs()+(axis - 3));
        }
        if (flaps != null && flaps >= 3){
            avion.setZakrilca(true);
        }
        if (landingGear != null && landingGear >= 4){
            avion.setPodvozje(true);
        }
        avion.setVisina(10 - trenutnaRunda);

    }

    //Provjerava se da li je avion siguran
    public boolean provjeriSigurnost() {
        if (!avion.isMotor()) return false;
        if (avion.getBrzina() <1 || avion.getBrzina() > 6) return false;
        return Math.abs(avion.getOs()) <= 2;

    }

    public boolean validirajRundu(){
        AerodromRunda uvjeti = aerodrom.getRunda(trenutnaRunda - 1);
        return ValidacijaRundiUtils.validirajRundu(ploca, uvjeti);
    }

    public UpravljackaPloca getPloca() {
        return ploca;
    }

    public void resetirajIgru() {
        this.avion = new Avion();
        this.ploca.resetiraj();
        this.trenutnaRunda = 1;
        this.trenutnaFaza = FazaIgre.BACANJE;
        this.kockaPilota = new ArrayList<>();
        this.kockaKopilota = new ArrayList<>();
    }

    public void transientPolja(){
        this.random = new Random(); //: nakon što učitaš igru iz datoteke, random polje je null (jer je transient → nije serijaliziran). Zovemo ovu metodu da napravimo svjež Random() objekt. Ovo se koristi za load
    }

    public boolean provjeriKrajIgre() {
        if (trenutnaRunda > aerodrom.getBrojRundi()) {
            return avion.isPodvozje() && avion.isZakrilca();
        }
        return false;
        }
}


