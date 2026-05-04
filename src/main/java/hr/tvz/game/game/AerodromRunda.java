package hr.tvz.game.game;

public class AerodromRunda {

    private int brojRunde;
    private int minMotor;
    private int minApproach;
    private int maxBrzina;
    private int minFlaps;
    private int minLandingGear;
    private int maxAxisRazlika;
    private boolean radioParan;

    public AerodromRunda(int brojRunde, int minMotor, int minApproach, int maxBrzina, int minFlaps, int minLandingGear, int maxAxisRazlika, boolean radioParan) {
        this.brojRunde = brojRunde;
        this.minMotor = minMotor;
        this.minApproach = minApproach;
        this.maxBrzina = maxBrzina;
        this.minFlaps = minFlaps;
        this.minLandingGear = minLandingGear;
        this.maxAxisRazlika = maxAxisRazlika;
        this.radioParan = radioParan;
    }

    public int getBrojRunde() {
        return brojRunde;
    }
    public int getMinMotor() {
        return minMotor;
    }
    public int getMinApproach() {
        return minApproach;
    }
    public int getMaxBrzina() {
        return maxBrzina;
    }
    public int getMinFlaps() {
        return minFlaps;
    }
    public int getMinLandingGear() {
        return minLandingGear;
    }
    public int getMaxAxisRazlika() {return maxAxisRazlika;}
    public boolean isRadioParan() {
        return radioParan;
    }


}
