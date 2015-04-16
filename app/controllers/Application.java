package controllers;

import models.Usuario;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    @Transactional
    public static Result index() {
        Usuario u = Sistema.getUsuario(session().get("email"));
        return ok(index.render(u,Sistema.getTodosCupons(),"Geral"));
    }

    public static Result insertCupom(){
        return ok(insert.render());
    }

    public static Result listCupom(){
        return ok(list.render());
    }

}
