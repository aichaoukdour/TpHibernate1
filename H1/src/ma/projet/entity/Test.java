/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Test {
    private static Object dateFormat;
    
     public static void main(String[] args) {
       ProduitService ps = new ProduitService();
       ps.create(new Produit(1, "toyota","rty", new Date(), 4734, "red"));
        ps.create(new Produit(2, "toyota","rty", new Date(), 4734, "red"));
         ps.create(new Produit(3, "toyota","rty", new Date(), 4734, "red"));
          ps.create(new Produit(3, "toyota","rty", new Date(), 4734, "red"));
           ps.create(new Produit(1, "toyota","rty", new Date(), 4734, "red"));
           
           
           List<Produit> produits = ProduitService.lister();
           for(Produit p : produits){
               System.out.println("Produit"+p.getReference());
           }
    Produit p = ps.findById(3);
         System.out.println(p);
    
    ps.delete(ps.findById(3));
    Produit p1 = ps.findById(1);
    p.setPrix(789);
    ps.update(p);
    
    
        for( Produit p2 : ps.findAll()) {
            if(p2.getPrix()>100){
                System.out.println("le prodyuit"+p2);
            }
        }
          
    //
//Scanner scanner = new Scanner(System.in);

//System.out.print("Veuillez entrer la date de début (au format yyyy-MM-dd): ");
//String dateStringDebut = scanner.nextLine();
//Date dateDebut = dateFormat.parse(dateDebut);

//System.out.print("Veuillez entrer la date de fin (au format yyyy-MM-dd): ");
//String dateStringFin = scanner.nextLine();
//Date dateFin = dateFormat.parse(dateFin);

// Appelez la méthode pour obtenir la liste des produits par dates
////List<Produit> produitsParDates = ProduitService.obtenirProduitsParDates(dateDebut, dateFin);

//System.out.println("Liste des produits commandés entre " + dateDebut + " et " + dateFin + ":");
//for (Produit produit : produitsParDates) {
    //System.out.println(produit.toString());
}

    
     }

