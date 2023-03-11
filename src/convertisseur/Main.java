package convertisseur;

import convertisseur.poo.Convertisseur;
import convertisseur.poo.Devise;
import convertisseur.poo.Montant;

/**
 * Main class of the application.
 * "Convertisseur de devises" is a simple application that converts a given amount of money from one currency to another.
 * TP_02 : Programmation Fonctionnelle en Java
 * PEI Millau, CAI-SI 03 : (2022-2023)
 * CNAM, NFP101 : Programmation Fonctionnelle en Java
 * @author BBE
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! Convertisseur de devises :");
        System.out.println("---------------------------------------");
        System.out.println("        En utilisant la POO :");
        System.out.println("---------------------------------------");
        System.out.println("1.00 Dollar US = 0.94 Euro");
        Devise dollar = new Devise("Dollar US", "$", 0.94F);
        Devise euro = new Devise("Euro", "€", 1.00F);
        Montant dixDollar = new Montant(10.00F, dollar);
        Montant converti1 = Convertisseur.convertir(dixDollar, euro);
        System.out.println("10.00 Dollar US = " + converti1.getNombreDevise() + " " + converti1.getDevise().getSymbole());
        Montant dixEuro = new Montant(10.00F, euro);
        Montant converti2 = Convertisseur.convertir(dixEuro, dollar);
        System.out.println("10.00 Euro = " + converti2.getNombreDevise() + " " + converti2.getDevise().getSymbole());
    }
}