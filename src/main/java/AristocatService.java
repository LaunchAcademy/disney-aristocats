import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

// our service, or Data Access Object
public class AristocatService {
  private EntityManager em;

  public AristocatService(EntityManager em) {
    this.em = em;
  }

  public List<Aristocat> findAll() {
    TypedQuery<Aristocat> query = em.createQuery("SELECT a FROM Aristocat a", Aristocat.class);
    return query.getResultList();
  }

  public boolean save(Aristocat aristocatToBeSaved) {
    try {
      em.getTransaction().begin();
      em.persist(aristocatToBeSaved);
      em.getTransaction().commit();
      return true;
    }
    catch(Exception err) {
      em.getTransaction().rollback();
      return false;
    }
  }
}
