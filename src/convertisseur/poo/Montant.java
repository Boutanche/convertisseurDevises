package convertisseur.poo;

/**
 * Montant class.
 * Un objet Montant qui représente un montant d'argent dans une devise donnée.
 * @author BBE
 * @version 1.0
 */
public class Montant {

    private final Float nombreDevise;
    private final Devise devise;

    /**
     * Constructor.
     * @param nombreDevise le nombre de la devise
     * @param devise la devise
     */
    public Montant(Float nombreDevise, Devise devise) {
        this.nombreDevise = nombreDevise;
        this.devise = devise;
    }

    /**
     * toString method.
     * Permet d'afficher les informations d'un montant.
     * @return String contenant les informations d'un montant.
     */
    @Override
    public String toString() {
        return "Montant{" + "nombreDevise=" + nombreDevise + ", devise=" + devise + '}';
    }

    /**
     * getNombreDevise method.
     * Permet de récupérer le nombre de la devise.
     * @return Float contenant le nombre de la devise.
     */
    public Float getNombreDevise() {
        return this.nombreDevise;
    }

    /**
     * getDevise method.
     * Permet de récupérer la devise.
     * @return Devise contenant la devise.
     */
    public Devise getDevise() {
        return this.devise;
    }
}
