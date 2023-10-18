/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author hp
 */
@Entity
@Table(name = "Produit")
public class Produit  {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "marque")
private String marque;

@Column(name = "reference")
private String reference;

@Temporal(TemporalType.DATE)
private Date dateAchat;

@Column(name = "prix")
private double prix;
        
@Column(name = "desig")
private String desig;

    public Produit(int id, String marque, String reference, Date dateAchat, double prix, String desig) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.desig = desig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", marque=" + marque + ", reference=" + reference + ", dateAchat=" + dateAchat + ", prix=" + prix + ", desig=" + desig + '}';
    }



}

