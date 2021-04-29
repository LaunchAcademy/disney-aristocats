import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns={"/aristocats", "/aristocats/new"})
public class AristocatsController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    if(req.getServletPath().equals("/aristocats")) {
    // set up dispatcher and tell it our view
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/aristocats/index.jsp");

      // Set up EntityManager with emf
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();
      // Create DAO with EntityManager
      AristocatService service = new AristocatService(em);
      // get the data we need, and hand it to the view
      List<Aristocat> allCatsFromDatabase = service.findAll();
      req.setAttribute("aristocatsJspVariable", allCatsFromDatabase);
//    req.setAttribute("aristocatsJspVariable", service.findAll());
    // send a response to our user
      dispatcher.forward(req, resp);
      em.close();
    }
    else if (req.getServletPath().equals("/aristocats/new")) {
    // set up dispatcher and tell it our view
      // show the form page
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/aristocats/new.jsp");
    // send a response to our user
      dispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // create an empty Aristocat
    Aristocat newAristocatObject = new Aristocat();
    // grab the user's input to fill the `Aristocat`
    try {
      // automagically populate our user input into our `Aristocat` object
      // in order for this to work, our fields in our form need to match the fields in our Entity
      // e.g., `firstName` in entity matches `name="firstName"` on form
      BeanUtils.populate(newAristocatObject, req.getParameterMap());
    }
    catch(IllegalAccessException err) {
      err.printStackTrace();
    }
    catch(InvocationTargetException err) {
      err.printStackTrace();
    }
    // at this point, we have an aristocat object with our user input
    // we want to persist it to our database

    // connect to my database with my EMF and EntityManager
    EntityManagerFactory emf = getEmf();
    EntityManager em = emf.createEntityManager();
    // Create my DAO using my EntityManager
    AristocatService service = new AristocatService(em);
    // Use my DAO to try to save, or persist, that aristocat
    // we added a `save` method in our DAO
    // we can use it here and check if it worked
    // here, all in one line, we both try to save our new aristocat, and get back a boolean to tell us whether it worked or not
    if(!service.save(newAristocatObject)) {
      System.out.println("I couldn't save it! :(");
    } else {
      System.out.println("Yay! It saved!");
    }

    // redirect them back to the index page
    resp.sendRedirect("/aristocats");
    em.close();
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}
