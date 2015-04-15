package controllers;

import models.Cupom;
import models.GenericDAO;
import models.Loja;
import models.Usuario;

import java.util.List;

/**
 * Created by Caio on 15/04/2015.
 */
public class Sistema {

    private static GenericDAO dao = new GenericDAO();

    /*
    Aqui fica tudo relacionado a Usuario
     */

    public static boolean addUsuario(Usuario u){
        if(u!=null && u.getNome()!="" && u.getSenha()!=""){
            dao.persist(u);
            dao.flush();
            return true;
        }
        return false;
    }

    public static boolean removeUsuario(Long id){
        Usuario u = dao.findByEntityId(Usuario.class,id);
        if(u!=null){
            dao.remove(u);
            dao.flush();
            return true;
        }
        return false;
    }

    public static Usuario getUsuario(String email){
        List<Usuario> l = dao.findByAttributeName(Usuario.class.getName(),"email",email);
        if(l.size()>0){
            return l.get(0);
        }
        return null;
    }

    public static List<Usuario> getTodosUsuarios(){
        return dao.findAllByClassName(Usuario.class.getName());
    }

    /*
    Finish tudo relacionado a Usuario
     */


    /*
    Aqui fica tudo relacionado a Cupom
     */

    public static boolean addCupom(Cupom c){
        if(c!=null && c.getTag()!=""){
            dao.persist(c);
            dao.flush();
            return true;
        }
        return false;
    }

    public static boolean removeCupom(Long id){
        Cupom c = dao.findByEntityId(Cupom.class,id);
        if(c!=null){
            dao.remove(c);
            dao.flush();
            return true;
        }
        return false;
    }

    public static Cupom getCupom(String tag){
        List<Cupom> l = dao.findByAttributeName(Cupom.class.getName(),"tag",tag);
        if(l.size()>0){
            return l.get(0);
        }
        return null;
    }

    public static Cupom getCupom(Long id){
        Cupom c = dao.findByEntityId(Cupom.class, id);
        if(c!=null){
            return c;
        }
        return null;
    }

    public static List<Cupom> getTodosCupons(){
        return dao.findAllByClassName(Cupom.class.getName());
    }

    public static List<Cupom> getTodosCuponsDaLoja(Long lojaid){
        return dao.findByAttributeName(Cupom.class.getName(),"lojaId", String.valueOf(lojaid));
    }
    /*
    Finish tudo relacionado a Cupom
     */

    /*
    Aqui fica tudo relacionado a Loja
     */
    public static boolean addLoja(Loja l){
        if(l!=null && l.getNome()!=""){
            dao.persist(l);
            dao.flush();
            return true;
        }
        return false;
    }

    public static boolean removeLoja(Long id){
        Loja l = dao.findByEntityId(Loja.class,id);
        if(l!=null){
            dao.remove(l);
            dao.flush();
            return true;
        }
        return false;
    }

    public static Loja getLoja(Long id){
        List<Loja> l = dao.findByAttributeName(Loja.class.getName(),"id",String.valueOf(id));
        if(l.size()>0){
            return l.get(0);
        }
        return null;
    }

    public static Loja getLoja(String nome){
        List<Loja> l = dao.findByAttributeName(Loja.class.getName(),"nome",nome);
        if(l.size()>0){
            return l.get(0);
        }
        return null;
    }

    /*
    Finish tudo relacionado a Loja
     */
}
