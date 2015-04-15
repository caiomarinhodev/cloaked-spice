
import controllers.Sistema;
import models.Loja;
import models.Usuario;
import org.junit.After;
import org.junit.Before;
import play.GlobalSettings;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;
import play.test.Helpers;
import scala.Option;

import javax.persistence.EntityManager;

/**
 * Created by X on 17/03/2015.
 */
public abstract class AbstractTest {

    public EntityManager em;

    @Before
    public void setUp() {
        FakeApplication app = Helpers.fakeApplication(new GlobalSettings());
        Helpers.start(app);
        Option<JPAPlugin> jpaPlugin = app.getWrappedApplication().plugin(JPAPlugin.class);
        em = jpaPlugin.get().em("default");
        JPA.bindForCurrentThread(em);
        em.getTransaction().begin();
        iniciaInstancias();
    }

    @After
    public void tearDown() {
        em.getTransaction().commit();
        JPA.bindForCurrentThread(null);
        em.close();
    }

    private void iniciaInstancias(){
        Usuario usuario = new Usuario("u", "u", "Teste1",1);
        Usuario usuario2 = new Usuario("u2", "u2", "Teste2",1);
        Usuario usuario3 = new Usuario("u3", "u3", "Teste3",2);
        Sistema.addUsuario(usuario);
        Sistema.addUsuario(usuario2);
        Sistema.addUsuario(usuario3);

        Loja l1 = new Loja("Americanas", "http://cdn.cuponomize.com/wp-content/uploads/2014/01/desconto-americanas-logo.jpg",
                "http://www.americanas.com.br/");
        Loja l2 = new Loja("Submarino","http://cdn.cuponomize.com/wp-content/uploads/2014/01/desconto-submarino-logo.jpg",
                "http://www.submarino.com.br/");
        Sistema.addLoja(l1);
        Sistema.addLoja(l2);
    }
}