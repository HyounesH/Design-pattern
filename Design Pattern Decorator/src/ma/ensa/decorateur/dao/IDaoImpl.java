package ma.ensa.decorateur.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ensa.decorateur.entities.Assurance;
@Component(value="dao")
public class IDaoImpl  implements IDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void addAssurance(Assurance assurance) {
    Session s=sessionFactory.openSession();
    s.save(assurance);
	}
	
	
}
