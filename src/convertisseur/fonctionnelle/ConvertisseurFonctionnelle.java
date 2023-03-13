/**
 * ConvertisseurFonctionnelle class.
 * @author BBE
 * @version 1.0
 * @see convertisseur.poo.Convertisseur
 */
package convertisseur.fonctionnelle;

import convertisseur.poo.Devise;
import convertisseur.poo.Montant;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * ConvertisseurFonctionnelle class.
 * @author BBE
 * @version 1.0
 */
public class ConvertisseurFonctionnelle {
    static final Devise EURO = new Devise("Euro", "€", 1.00F);
    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private ConvertisseurFonctionnelle() {
        // Constructeur privé pour empêcher l'instanciation de la classe.
    }

    /**
     * Version fonctionnelle de la méthode convertir qui va convertir en Euros
     * @return Montant converti.
     */
    public static UnaryOperator<Montant> convertirVersEuro() {
        return montantOrigine -> {
            UnaryOperator<Montant> convertirVersEuro = convertirVersDevise(EURO);
            return convertirVersEuro.apply(montantOrigine);
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
            Float roundMontantConverti = convertisseur.poo.Convertisseur.arrondirMontant(montantConverti);
            System.out.println("Montant converti : " + roundMontantConverti + " " + deviseCible.getSymbole());
            return new Montant(roundMontantConverti, deviseCible);
        };
    }

    /**
     * Version fonctionnelle de la méthode convertir vers Euro en mode Curryfication.
     * @return Fonction qui prend en paramètre une devise cible et qui retourne le montant converti.
     */
    public static UnaryOperator<Montant> convertirVersEuroCurryfie() {
        Devise euro = new Devise("Euro", "€", 1.00F);
        return montant -> new Montant(convertisseur.poo.Convertisseur.arrondirMontant(montant.getNombreDevise() * montant.getDevise().getValeurEnEuro()/ euro.getValeurEnEuro()), euro);
    }


    /**
     * Version Bifonctionnelle de la méthode convertir.
     * // @param deviseCible Devise cible.
     * @return Fonction qui prend en paramètre une devise cible et qui retourne le montant converti.
     */
    public static BiFunction<Montant, Devise, Montant> convertirVersDevise2() {
        return (montantOrigine, deviseCible) -> {
            float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
            Float roundMontantConverti = convertisseur.poo.Convertisseur.arrondirMontant(montantConverti);
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
            Float roundMontantConverti = convertisseur.poo.Convertisseur.arrondirMontant(montantConverti);
            System.out.println("Montant converti : " + roundMontantConverti + " " + deviseCible.getSymbole());
            return new Montant(roundMontantConverti, deviseCible);
        };
    }
}
