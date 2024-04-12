package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Marque;
import util.JPAutil;
public class MarqueDaoImpl implements IMarqueDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE_B");
@Override
public Marque save(Marque Mar ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(Mar);
tx.commit();
return Mar;
}
@Override
public Marque getMarque(Long id) {
 return entityManager.find(Marque.class, id);
}
@Override
public Marque updateMarque(Marque Mar) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(Mar);
tx.commit();
return Mar;
}
@Override
public void deleteMarque(Long id) {
Marque Marque = entityManager.find(Marque.class, id);
entityManager.getTransaction().begin();
entityManager.remove(Marque);
entityManager.getTransaction().commit();
}
@Override
public List<Marque> getAllMarques() {
List<Marque> Mars =
entityManager.createQuery("select m from Marque m").getResultList();
return Mars;
}
}