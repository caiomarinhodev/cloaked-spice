import controllers.Sistema;
import models.*;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.Date;
import java.util.List;

/**
 * Created by Caio.
 */
public class CupomTest extends AbstractTest {


    @Test
    public void deveAdicionarUmCupom(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(), "Americanas",
                "www");
        Assert.assertTrue(Sistema.addCupom(c));
    }
    @Test
    public void deveRemoverUmCupom(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        Long id = c.getId();
        Assert.assertTrue(Sistema.removeCupom(id));
    }
    @Test
    public void deveRecuperarCupomPorId(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        Long id = c.getId();
        Assert.assertNotNull(Sistema.getCupom(id));
    }
    @Test
    public void deveRecuperarCupomPorTag(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        String tag = "tag";
        Assert.assertNotNull(Sistema.getCupom(tag));
    }
    @Test
    public void deveVerificarSeDoisCuponsSaoIguais(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        Cupom c2 = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c2);
        Assert.assertTrue(c.equals(c2));
    }
    @Test
    public void deveVerificarSeDoisCuponsSaoDiferentes(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        Usuario autor2 = Sistema.getUsuario("u2");
        Cupom c2 = new Cupom("title", "desc", "huhu",0,new Date(), new Date(2015,3,18),autor2.getId(),"Americanas",
                "www");
        Sistema.addCupom(c2);
        Assert.assertFalse(c.equals(c2));
    }

    @Test
    public void deveRetornarTodosOsCupons(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        List<Cupom> l = Sistema.getTodosCupons();
        System.out.println("TOTAL: "+l.size());
        Assert.assertEquals(l.size(),1);
    }

    @Test
    public void deveRetornarApenasOsCuponsDaLoja(){
        Usuario autor = Sistema.getUsuario("u");
        Cupom c = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Americanas",
                "www");
        Sistema.addCupom(c);
        Cupom c2 = new Cupom("title", "desc", "tag",0,new Date(), new Date(2015,3,18),autor.getId(),"Mamute",
                "www");
        Sistema.addCupom(c2);
        Cupom c3 = new Cupom("title2", "desc2", "huag",0,new Date(), new Date(2015,3,18),autor.getId(),"Mamute",
                "www");
        Sistema.addCupom(c3);
        List<Cupom> l = Sistema.getTodosCuponsDaLoja("Mamute");
        System.out.println("TOTAL Loja: "+l.size());
        Assert.assertEquals(l.size(),2);
    }

}