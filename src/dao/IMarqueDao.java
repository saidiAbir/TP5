package dao;
import java.util.List;
import metier.entities.Marque;
public interface IMarqueDao {
public Marque save(Marque Mar);
public Marque getMarque(Long id);
public Marque updateMarque(Marque Mar);
public void deleteMarque(Long id);
public List<Marque> getAllMarques();
}
