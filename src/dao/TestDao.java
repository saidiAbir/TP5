package dao;
import java.util.List;
import metier.entities.Bijoux;
public class TestDao {
public static void main(String[] args) {
BijouxDaoImpl bdao= new BijouxDaoImpl();
Bijoux bji= bdao.save(new Bijoux("boucle",2800));
System.out.println(bji);
List<Bijoux> bjix =bdao.BijouxParMC("AI");
for (Bijoux b : bjix)
System.out.println(b);
}
}