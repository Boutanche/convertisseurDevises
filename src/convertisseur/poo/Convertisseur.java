package convertisseur.poo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Convertisseur class.
 * @author BBE
 * @version 1.0
 */
public class Convertisseur {

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private Convertisseur() {
        // Constructeur privé pour empêcher l'instanciation de la classe.
    }

    /**
     * Partie 1 de l'exercice : POO
     * Convertir un montant d'une devise à une autre.
     * @param montantOrigine Montant à convertir.
     * @param deviseCible Devise cible.
     * @return Montant converti.
     */
    public static Montant convertir(Montant montantOrigine, Devise deviseCible) {
        float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
        System.out.println("Montant converti : " + montantConverti + " " + deviseCible.getSymbole());
        Float roundMontantConverti = arrondirMontant(montantConverti);
        return new Montant(roundMontantConverti, deviseCible);
    }

    /**
     * Arrondir un montant.
     */
    public static float arrondirMontant(float montant) {
        return (Math.round(montant * 100) / 100.0F);
    }

    /**
     * Version fonctionnelle de la méthode convertir qui va convertir en Euros
     * @return Montant converti.
     */
    public static UnaryOperator<Montant> convertirVersEuro() {
        return montantOrigine -> {
            Devise deviseCible = new Devise("Euro", "€", 1.00F);
            float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
            Float roundMontantConverti = arrondirMontant(montantConverti);
            Montant newMontant = new Montant(roundMontantConverti, deviseCible);
            System.out.println("Montant converti : " + newMontant.getNombreDevise() + " " + newMontant.getDevise().getSymbole());
            return newMontant;
        };
    }

    /**
     * Version fonctionnelle de la méthode convertir vers une devise donnée.
     * @param deviseCible Devise cible.
     * @return Fonction qui prend en paramètre une devise cible et qui retourne le montant converti.
     */
    public static UnaryOperator<Montant> convertirVersDevise(Devise deviseCible) {
        return montantOrigine -> {
            float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
            Float roundMontantConverti = arrondirMontant(montantConverti);
            System.out.println("Montant converti : " + roundMontantConverti + " " + deviseCible.getSymbole());
            return new Montant(roundMontantConverti, deviseCible);
        };
    }

    public static UnaryOperator<Montant> convertirVersEuroCurryfie() {
        Devise euro = new Devise("Euro", "€", 1.00F);
        return montant -> new Montant(arrondirMontant(montant.getNombreDevise() * montant.getDevise().getValeurEnEuro()/ euro.getValeurEnEuro()), euro);
    }


    /**
     * Version Bifonctionnelle de la méthode convertir.
     * // @param deviseCible Devise cible.
     * @return Fonction qui prend en paramètre une devise cible et qui retourne le montant converti.
     */
    public static BiFunction<Montant, Devise, Montant> convertirVersDevise2() {
        return (montantOrigine, deviseCible) -> {
            float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
            Float roundMontantConverti = arrondirMontant(montantConverti);
            System.out.println("Montant converti : " + roundMontantConverti + " " + deviseCible.getSymbole());
            return new Montant(roundMontantConverti, deviseCible);
        };
    }

    /**
     * Fonction FabriquerConvertisseur.
     * @param deviseCible Devise cible.
     * @param deviseOrigine Devise d'origine.
     */
    public static Function<Devise, UnaryOperator<Montant>> fabriquerConvertisseur(Devise deviseCible, Devise deviseOrigine) {
        return devise -> montant -> {
            float montantConverti = (montant.getNombreDevise() * deviseOrigine.getValeurEnEuro()) / deviseCible.getValeurEnEuro();
            Float roundMontantConverti = arrondirMontant(montantConverti);
            System.out.println("Montant converti : " + roundMontantConverti + " " + deviseCible.getSymbole());
            return new Montant(roundMontantConverti, deviseCible);
        };
    }
}
