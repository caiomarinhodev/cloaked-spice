import models.Cupom;
import models.GenericDAO;
import models.Loja;
import models.Usuario;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

import java.util.Date;
import java.util.List;

/**
 * Created by caio on 24/03/15.
 */

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    @Override
    public void onStart(Application app) {
        Logger.info("inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {

            public void invoke() throws Throwable {

                List<Usuario> lis = dao.findAllByClassName(Usuario.class.getName());
                if (lis.size() == 0) {
                    Usuario usuario = new Usuario("u", "u", "Teste1",1);
                    dao.persist(usuario);

                    Loja l1 = new Loja("Americanas", "http://cdn.cuponomize.com/wp-content/uploads/2014/01/desconto-americanas-logo.jpg",
                            "http://www.americanas.com.br/");
                    Loja l2 = new Loja("Submarino","http://cdn.cuponomize.com/wp-content/uploads/2014/01/desconto-submarino-logo.jpg",
                            "http://www.submarino.com.br/");

                    dao.persist(l1);
                    dao.persist(l2);

                    for(int i=1; i<12; i++){
                        Cupom c = new Cupom("Cupom "+i,"descripition here now, se lig%","HURTVF5T6",0,new Date(),
                                new Date(205,05,14),usuario.getId(),l1.getId(),"http://www.americanas.com.br/");
                        dao.persist(c);
                    }
//
//                    for(int i=1; i<=31; i++){
//                        Cliente cli = new Cliente("cliente"+(i*31),"(83) 9999-9999","","","","","","","","","");
//                        dao.persist(cli);
//                        Calendar calendar = Calendar.getInstance();
//                        java.util.Date d = calendar.getTime();
//                        Date date = new Date(d.getYear(),(d.getMonth()-1),i);
//                        Chamada cha = new Chamada(cli,"","","",0,t2,date,"","");
//                        dao.persist(cha);
//                    }


                    dao.flush();
                    Logger.info("Inserindo dados no BD.");
                }
            }
        });
    }

    public void onStop(Application app) {
        Logger.info("desligada...");
    }

}