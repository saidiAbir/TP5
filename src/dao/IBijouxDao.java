package dao;
import java.util.List;
import metier.entities.Bijoux;
public interface IBijouxDao {
public Bijoux save(Bijoux b);
public List<Bijoux> BijouxParMC(String mc);
public Bijoux getBijoux(Long id);
public Bijoux updateBijoux(Bijoux b);
public void deleteBijoux(Long id);
}
