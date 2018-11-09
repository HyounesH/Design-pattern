package ma.ensa.decorateur.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.ensa.decorateur.conf.AppConf;
import ma.ensa.decorateur.entities.Assurance;
import ma.ensa.decorateur.entities.DommageCollision;
import ma.ensa.decorateur.entities.Inondation;
import ma.ensa.decorateur.entities.RespoCivil;

public class Test {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
	
   ma.ensa.decorateur.dao.IDao dao=(ma.ensa.decorateur.dao.IDao)ctx.getBean("dao");
	
	
	Assurance assur=new RespoCivil();
	System.out.println(assur.cout());
	assur=new Inondation(assur);
	System.out.println(assur.cout());
	assur=new DommageCollision(assur);
	System.out.println(assur.cout());
	dao.addAssurance(assur);
	
}

}
