package ma.ensa.tp1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.ensa.tp1.dao.FabriqueAbstraite;
import ma.ensa.tp1.dao.FabriqueVehiculeEssence;
import ma.ensa.tp1.dao.FabriqueVehiculeGasoil;
import ma.ensa.tp1.entities.Catalogue;

public class Test {

	public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ma/ensa/tp1/conf/factoryConf.xml");
    Catalogue c=new Catalogue();
    FabriqueAbstraite fb=(FabriqueVehiculeEssence)ctx.getBean("vehiculeEssence");
    c.setFb(fb);
    c.creeMoto("103");
    c.creeVoiture("GOLF",123);
    fb=(FabriqueVehiculeGasoil)ctx.getBean("vehiculeGasoil");
    c.setFb(fb);
    c.creeMoto("TMax");
    c.creeVoiture("307",145);
	}

}
