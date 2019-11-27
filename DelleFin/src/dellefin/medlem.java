
package dellefin;

public class medlem {
    String stamOpl;
    //Ændre alder til fødselsdato, hvis der er tid og lyst
    int alder;
    boolean passivAktiv;
    boolean MotionKonkurant;

    public medlem(String stamOpl, int alder, boolean passivAktiv, boolean MotionKonkurant) {
        this.stamOpl = stamOpl;
        this.alder = alder;
        this.passivAktiv = passivAktiv;
        this.MotionKonkurant = MotionKonkurant;
    }
    public String getStamOpl() {
        return stamOpl;
    }

    public void setStamOpl(String stamOpl) {
        this.stamOpl = stamOpl;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public boolean isPassivAktiv() {
        return passivAktiv;
    }
//hej
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
