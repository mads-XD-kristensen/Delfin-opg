package dellefin;

public class medlem{

    String stamOpl;

    int årgang;
    boolean passivAktiv;

 
    
    public medlem(String stamOpl, int årgang, boolean passivAktiv) {
        this.stamOpl = stamOpl;
        this.årgang = årgang;
        this.passivAktiv = passivAktiv;
   
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



}
