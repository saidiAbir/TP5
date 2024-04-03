package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Bijoux;
public class BijouxModele {
    private String motCle;
    private List<Bijoux> Bijoux = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Bijoux> getBijoux() {
        return Bijoux;
    }

    public void setBijoux(List<Bijoux> Bijoux) {
        this.Bijoux = Bijoux;
    }
}
