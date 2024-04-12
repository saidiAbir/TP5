package metier.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BIJOUX")
public class Bijoux implements Serializable{
	@Id
	@Column (name="ID_BIJOUX")
private Long id_Bijoux;
	@Column (name="NOM_BIJOUX")

private String nom_Bijoux;
	@Column (name="PRIX")

private double prix;
	
	private Marque Marque;
	 public Bijoux(String nomBijoux, double prix,Marque Mar) {
	super();
	this.nom_Bijoux = nomBijoux;
	this.prix = prix;
	this.setMarque(Mar);
	}
	public Marque getMarque() {
	return Marque;
	}
	public void setMarque(Marque Marque) {
	this.Marque = Marque;
	}
public Bijoux() {
super();
}
public Bijoux(String nom_Bijoux, double prix) {
super();
this.nom_Bijoux = nom_Bijoux;
this.prix = prix;
}
public Long getIdBijoux() {
return id_Bijoux;
}
public void setIdBijoux(Long id_Bijoux) {
this.id_Bijoux = id_Bijoux;
}
public String getNomBijoux() {
return nom_Bijoux;
}
public void setNomBijoux(String nom_Bijoux) {
this.nom_Bijoux = nom_Bijoux;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
@Override
public String toString() {
return "Bijoux [id_Bijoux=" + id_Bijoux + ", nom_Bijoux=" +
nom_Bijoux + ", prix=" + prix + "]";
}
}