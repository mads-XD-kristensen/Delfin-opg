package formand;



public class Konkurrent extends medlem {

    String træner;

    public Konkurrent(String stamOpl, int årgang, boolean passivAktiv, String træner) {
        super(stamOpl, årgang, passivAktiv);
        this.træner = træner;
    }

}
