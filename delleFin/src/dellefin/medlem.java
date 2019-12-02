package dellefin;

public class medlem {

    String stamOpl;

    int årgang;
    boolean passivAktiv;
    boolean MotionKonkurant;

    public medlem(String stamOpl, int årgang, boolean passivAktiv, boolean MotionKonkurant) {
        this.stamOpl = stamOpl;
        this.årgang = årgang;
        this.passivAktiv = passivAktiv;
        this.MotionKonkurant = MotionKonkurant;
    }

    public String getStamOpl() {
        return stamOpl;
    }

    public void setStamOpl(String stamOpl) {
        this.stamOpl = stamOpl;
    }

    public int getÅrgang() {
        return årgang;
    }

    public void setÅrgang(int årgang) {
        this.årgang = årgang;
    }

    public boolean isPassivAktiv() {
        return passivAktiv;
    }

    public void setPassivAktiv(boolean passivAktiv) {
        this.passivAktiv = passivAktiv;
    }

    public boolean isMotionKonkurant() {
        return MotionKonkurant;
    }

    public void setMotionKonkurant(boolean MotionKonkurant) {
        this.MotionKonkurant = MotionKonkurant;
    }

}
