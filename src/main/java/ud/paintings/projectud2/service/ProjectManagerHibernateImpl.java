package ud.paintings.projectud2.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ud.paintings.projectud2.domain.Painting;
import ud.paintings.projectud2.domain.Reproductor;

@Component
@Transactional
public class ProjectManagerHibernateImpl implements ProjectManager{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addReproductor(Reproductor r) {
		// TODO Auto-generated method stub
		r.setId(null);
		sessionFactory.getCurrentSession().persist(r);
	}

	@Override
	public void addPainting(Painting p) {
		// TODO Auto-generated method stub
		p.setId(null);
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reproductor> getAllReproductors() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().
				getNamedQuery("reproduktor.select.all").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Painting> getAllPaintings() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().
				getNamedQuery("reproduktor.select.all").list();
	}

	@Override
	public void updateReproductor(Reproductor r) {
		// TODO Auto-generated method stub
		
		//System.out.println("+++++++++++++++++++++++r.id: " + r.getId());
		
		Reproductor updR = (Reproductor) sessionFactory.getCurrentSession().get(Reproductor.class, r.getId());

		sessionFactory.getCurrentSession().update(r);
	}

	@Override
	public void updatePainting(Painting p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public void deleteReproductor(Reproductor r) {
		// TODO Auto-generated method stub
		
//		Long rId = ((Reproductor) sessionFactory.getCurrentSession().getNamedQuery("reproduktor.select.byId").setString("name", r.getName()).uniqueResult()).getId();//findReproductorByName(r.getName()).getId();
//		r.setId(rId);
//		r = (Reproductor) sessionFactory.getCurrentSession().get(Reproductor.class, rId);
//		
//		System.out.println(rId +  "+++++++++++++++++++++++++++++++++");
//		
//		for (Painting p : r.getPaintings()) {
//			sessionFactory.getCurrentSession().update(p);
//		}
//	
		sessionFactory.getCurrentSession().delete(r);
		System.out.println("deleted");
	}

	@Override
	public void deletePainting(Painting p) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public Reproductor findReproductorById(Long id) {
		// TODO Auto-generated method stub
		return (Reproductor) sessionFactory.getCurrentSession().
				get(Reproductor.class, id);
	}

	@Override
	public Painting findPaintingById(Long id) {
		// TODO Auto-generated method stub
		return (Painting) sessionFactory.getCurrentSession().
				get(Painting.class, id);
	}

	@Override
	public Reproductor findReproductorByName(String name) {
		// TODO Auto-generated method stub
		return (Reproductor) sessionFactory.getCurrentSession().
				getNamedQuery("reproduktor.select.byName").
				setString("name", name).uniqueResult();
	}

	@Override
	public Painting findPaintingByName(String name) {
		// TODO Auto-generated method stub
		return (Painting) sessionFactory.getCurrentSession().
				getNamedQuery("painting.select.byName").
				setString("name", name).uniqueResult();
	}

	@Override
	public List<Painting> findPaintingsByReproductor(Reproductor r) {
		// TODO Auto-generated method stub
		r = (Reproductor) sessionFactory.getCurrentSession().
				get(Reproductor.class, r.getId());
		System.out.println("DDD");
		//new ArrayList<>(r.getPaintings()); -------------------
		List<Painting> p = new ArrayList<>(r.getPaintings());
		return r.getPaintings();
	}

	@Override
	public void constraintAddPainting(Long reproductorId, Long paintingId) {
		// TODO Auto-generated method stub
		
		Reproductor r = (Reproductor) sessionFactory.getCurrentSession().get(Reproductor.class, reproductorId);
		Painting p = (Painting) sessionFactory.getCurrentSession().get(Painting.class, paintingId);
		r.getPaintings().add(p);
	}
	
	
	
}
