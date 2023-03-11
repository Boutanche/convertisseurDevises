package convertisseur.poo;

/**
 * Devise class.
 * Un objet Devise qui représente une devise monétaire.
 * @author BBE
 * @version 1.0
 */
public class Devise {
    /**
     * Le nom de la devise.
     */
    private final String nom;
    /**
     * Le symbole de la devise.
     */
    private final String symbole;
    /**
     * La valeur de la devise en euro.
     */
    private final Float valeurEnEuro;

    /**
     * Constructor.
     * @param nom le nom de la devise
     * @param symbole le symbole de la devise
     * @param valeurEnEuro la valeur de la devise en euro
     */
    public Devise(String nom, String symbole, Float valeurEnEuro) {
        this.nom = nom;
        this.symbole = symbole;
        this.valeurEnEuro = valeurEnEuro;
    }

    /**
     * toString method.
     * Permet d'afficher les informations d'une devise.
     * @return String contenant les informations d'une devise.
     */
    @Override
    public String toString() {
        return "Devise{" + "nom=" + nom + ", symbole=" + symbole + ", valeurEnEuro=" + valeurEnEuro + '}';
    }

    /**
     * getNom method.
     * Permet de récupérer le nom de la devise.
     * @return String contenant le nom de la devise.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * getSymbole method.
     * Permet de récupérer le symbole de la devise.
     * @return String contenant le symbole de la devise.
     */
    public String getSymbole() {
        return this.symbole;
    }

    /**
     * getValeurEnEuro method.
     * Permet de récupérer la valeur de la devise en euro.
     * @return Float contenant la valeur de la devise en euro.
     */
    public Float getValeurEnEuro() {
        return this.valeurEnEuro;
    }

    /**
     * equals method.
     * Permet de comparer deux devises.
     * @param o l'objet à comparer
     * @return boolean true si les deux devises sont égales, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Devise devise)) {
            return false;
        }
        return nom.equals(devise.nom) && symbole.equals(devise.symbole) && valeurEnEuro.equals(devise.valeurEnEuro);
    }

    /**
     * hashCode method.
     * Permet de générer un hashcode pour une devise.
     * @return int contenant le hashcode de la devise.
     */
    @Override
    public int hashCode() {
        return 31 * nom.hashCode() + symbole.hashCode() + valeurEnEuro.hashCode();
    }
}
