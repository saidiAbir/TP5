package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Bijoux;
import util.JPAutil;
public class BijouxDaoImpl implements IBijouxDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE_B");
@Override
public Bijoux save(Bijoux b) {

EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(b);
tx.commit();
return b;
}

public List<Bijoux> BijouxsParMC(String mc) {
List<Bijoux> bjix =entityManager.createQuery("select b from Bijoux b where b.nom_Bijoux like :mc").setParameter("mc", "%"+mc+"%").getResultList();

return bjix;
}
@Override
public Bijoux getBijoux(Long id) {
return entityManager.find(Bijoux.class, id);
}
@Override
public Bijoux updateBijoux(Bijoux b) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(b);
tx.commit();
return b;
}
@Override
public void deleteBijoux(Long id) {
Bijoux Bijoux = entityManager.find(Bijoux.class, id);
entityManager.getTransaction().begin();
entityManager.remove(Bijoux);
entityManager.getTransaction().commit();
}
@Override
public List<Bijoux> BijouxParMC(String mc) {
	// TODO Auto-generated method stub
	return null;
}
}