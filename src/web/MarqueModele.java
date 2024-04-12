package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Marque;
public class MarqueModele {
List<Marque> Marques = new ArrayList<>();
public List<Marque> getMarques() {
return Marques;
}
public void setMarques(List<Marque> Marques) {
this.Marques = Marques;
}
}