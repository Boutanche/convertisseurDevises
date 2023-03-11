package convertisseur.poo;

public class Convertisseur {

    public static Montant convertir(Montant montantOrigine, Devise deviseCible) {
        // TODO : Implémenter la méthode convertir
        return new Montant(montantOrigine.getNombreDevise() * deviseCible.getValeurEnEuro(), deviseCible);
    }
}
