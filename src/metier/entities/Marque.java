package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Marque implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idMar;
  private String nomMar;
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @OneToMany(mappedBy = "Marque")
  private List<Bijoux> Bijoux;

  public Marque() {
    super();
  }

  public Marque(String nomMar, Date dateCreation) {
    super();
    this.nomMar = nomMar;
    this.dateCreation = dateCreation;
  }

  public Long getidMar() {
    return idMar;
  }

  public void setidMar(Long idMar) {
    this.idMar = idMar;
  }

  public String getnomMar() {
    return nomMar;
  }

  public void setnomMar(String nomMar) {
    this.nomMar = nomMar;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }

  public List<Bijoux> getBijoux() {
    return Bijoux;
  }

  public void setBijouxs(List<Bijoux> Bijoux) {
    this.Bijoux = Bijoux;
  }
}