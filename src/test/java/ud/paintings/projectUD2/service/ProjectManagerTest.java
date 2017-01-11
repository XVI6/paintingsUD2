package ud.paintings.projectUD2.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ud.paintings.projectud2.domain.Painting;
import ud.paintings.projectud2.domain.Reproductor;
import ud.paintings.projectud2.service.ProjectManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", 
						defaultRollback = false)
@Transactional
public class ProjectManagerTest {
	
	@Autowired
	ProjectManager projectManager;
		
	private final static String PName_1 = "Painting1";
	private final static String PName_2 = "Painting2";
	
	private final static int YOC_1 = 1997;
	private final static int YOC_2 = 1999;
	
	private final static int COST_1 = 100;
	private final static int COST_2 = 197;
	
	private final static String OAName_1 = "Old Artist1";
	private final static String OAName_2 = "Old Artist2";
	
	
	private final static String AName_1 = "New Artist1";
	private final static String AName_2 = "New Artist2";
	
	
	private final static String Country_1 = "Poland";
	private final static String Country_2 = "Poland";
	
	private final static String CITY_1 = "Gdansk";
	private final static String CITY_2 = "Poznan";
	
	private final static String ADRESS_1 = "unknown";
	private final static String ADRESS_2 = "unknown";
	
	private final static String HOUSE_NUMBER_1 = "12a";
	private final static String HOUSE_NUMBER_2 = "47/2";
	
	private final static String TELEPHONE_1 = "+48275546731";
	private final static String TELEPHONE_2 = "+48298533563";
	
	private final static String E_MAIL_1 = "mail@mail.com";
	private final static String E_MAIL_2 = "new@mail.com";

	@Test
	public void checkAddReproductor() {
		
		List<Reproductor> reproductors = projectManager.getAllReproductors();
		
		for (Reproductor reproductor : reproductors) {
			if (reproductor.getName().equals(AName_1) || reproductor.getName().equals(AName_2)) {
				projectManager.deleteReproductor(reproductor);
			}
		}
		
		Reproductor r1 = new Reproductor();
		Reproductor r2 = new Reproductor();
		
		r1.setName(AName_1);
		r2.setName(AName_2);
		
		r1.setCountry(Country_1);
		r2.setCountry(Country_2);
		
		r1.setCity(CITY_1);
		r2.setAdress(CITY_2);
		
		r1.setAdress(ADRESS_1);
		r2.setAdress(ADRESS_2);
		
		r1.setHouse_number(HOUSE_NUMBER_1);
		r2.setHouse_number(HOUSE_NUMBER_2);
		
		r1.setTelephone(TELEPHONE_1);
		r2.setTelephone(TELEPHONE_2);
		
		r1.setEmail(E_MAIL_1);
		r2.setEmail(E_MAIL_2);
		
		projectManager.addReproductor(r1);
		projectManager.addReproductor(r2);
		
		Reproductor retrievedR1 = projectManager.findReproductorByName(AName_1);
		Reproductor retrievedR2 = projectManager.findReproductorByName(AName_2);
		
		assertEquals(AName_1, retrievedR1.getName());
		assertEquals(AName_2, retrievedR2.getName());
		
		projectManager.deleteReproductor(r1);
		projectManager.deleteReproductor(r2);
		
	}
	
	@Test
	public void checkAddPainting(){
		
		Painting p1 = new Painting();
		Painting p2 = new Painting();
		
		p1.setName(PName_1);
		p2.setName(PName_2);
		
		p1.setYoc(YOC_1);
		p2.setYoc(YOC_2);
		
		p1.setCost(COST_1);
		p2.setCost(COST_2);
		
		p1.setArtist(AName_1);
		p2.setArtist(ADRESS_2);
		
		p1.setOriginArtist(OAName_1);
		p2.setOriginArtist(OAName_2);
		
		projectManager.addPainting(p1);
		projectManager.addPainting(p2);
		
		Painting retrievedP1 = projectManager.findPaintingByName(PName_1);
		Painting retrievedP2 = projectManager.findPaintingByName(PName_2);
		
		assertEquals(PName_1, retrievedP1.getName());
		assertEquals(PName_2, retrievedP2.getName());
		
		projectManager.deletePainting(p1);
		projectManager.deletePainting(p2);
	}
	
	@Test
	public void checkAddConstraint() {

		Reproductor r1 = new Reproductor();
		
		r1.setName(AName_1);
		r1.setCountry(Country_1);
		r1.setCity(CITY_1);
		r1.setAdress(ADRESS_1);
		r1.setHouse_number(HOUSE_NUMBER_1);
		r1.setTelephone(TELEPHONE_1);
		r1.setEmail(E_MAIL_1);
		
		projectManager.addReproductor(r1);
		
		r1 = projectManager.findReproductorByName(AName_1);
		
		
		Painting p1 = new Painting();
		p1.setName(PName_1);
		p1.setYoc(YOC_1);
		p1.setCost(COST_1);
		p1.setArtist(AName_1);
		p1.setOriginArtist(OAName_1);
		
		projectManager.addPainting(p1);
		p1 = projectManager.findPaintingByName(PName_1);
		
		projectManager.constraintAddPainting(r1.getId(), p1.getId());
		
		List<Painting> paintings = projectManager.findPaintingsByReproductor(r1);

		assertEquals(1, paintings.size());
		
		projectManager.deleteReproductor(r1);
		projectManager.deletePainting(p1);
	}
	
////	@Test  //wczesniej
//	public void checkFindPaintingsByReproductor(){
//		
//		Reproductor r = new Reproductor();
//		
//		r.setName(AName_1);
//		
//		r.setCountry(Country_1);
//		
//		r.setCity(CITY_1);
//		
//		r.setAdress(ADRESS_1);
//		
//		r.setHouse_number(HOUSE_NUMBER_1);
//		
//		r.setTelephone(TELEPHONE_1);
//		
//		r.setEmail(E_MAIL_1);
//		
//		projectManager.findPaintingsByReproductor(r);
//		
//	}
	
	@Test
	public void checkUpdateReproductor(){
		
		Reproductor r = new Reproductor();
		
		r.setName(AName_1);
		
		r.setCountry(Country_1);
		
		r.setCity(CITY_1);
		
		r.setAdress(ADRESS_1);
		
		r.setHouse_number(HOUSE_NUMBER_1);
		
		r.setTelephone(TELEPHONE_1);
		
		r.setEmail(E_MAIL_1);
		
		projectManager.addReproductor(r);
		
		r.setName("New Name");
		
		projectManager.updateReproductor(r);
		
		projectManager.deleteReproductor(r);
		
	}
	
	@Test
	public void checkUpdatePainting(){
		
		Painting p = new Painting();

		p.setName(PName_1);
		
		p.setYoc(YOC_1);
		
		p.setCost(COST_1);
		
		p.setArtist(AName_1);
		
		p.setOriginArtist(OAName_1);
		
		projectManager.addPainting(p);
		
		p.setName("New Painting");
	
		projectManager.updatePainting(p);
		
		projectManager.deletePainting(p);
	}

	@Test
	public void checkDeleteReproductor(){
		
		Long rId;
		
		Reproductor r1 = new Reproductor();
		Reproductor r2 = new Reproductor();
		
		r1.setName(AName_1);
		r2.setName(AName_2);
		
		r1.setCountry(Country_1);
		r2.setCountry(Country_2);
		
		r1.setCity(CITY_1);
		r2.setAdress(CITY_2);
		
		r1.setAdress(ADRESS_1);
		r2.setAdress(ADRESS_2);
		
		r1.setHouse_number(HOUSE_NUMBER_1);
		r2.setHouse_number(HOUSE_NUMBER_2);
		
		r1.setTelephone(TELEPHONE_1);
		r2.setTelephone(TELEPHONE_2);
		
		r1.setEmail(E_MAIL_1);
		r2.setEmail(E_MAIL_2);
		
		projectManager.addReproductor(r1);
		projectManager.addReproductor(r2);
		
		rId = projectManager.findReproductorByName(AName_1).getId();
		
		List <Reproductor> reproductors = projectManager.getAllReproductors();
		
		for (Reproductor reproductor : reproductors) {
			if (reproductor.getName().equals(AName_1)) {
				projectManager.deleteReproductor(reproductor);
			}
		}		
		
		assertEquals(null, projectManager.findReproductorById(rId));
		
		projectManager.deleteReproductor(r2);
		
	}
	
	@Test
	public void checkDeletePainting(){
		
		Long pId;
		
		Painting p1 = new Painting();
		Painting p2 = new Painting();
		
		p1.setName(PName_1);
		p2.setName(PName_2);
		
		p1.setYoc(YOC_1);
		p2.setYoc(YOC_2);
		
		p1.setCost(COST_1);
		p2.setCost(COST_2);
		
		p1.setArtist(AName_1);
		p2.setArtist(ADRESS_2);
		
		p1.setOriginArtist(OAName_1);
		p2.setOriginArtist(OAName_2);
		
		projectManager.addPainting(p1);
		projectManager.addPainting(p2);
		
		pId = projectManager.findPaintingByName(PName_1).getId();
		
		List <Painting> paintings = projectManager.getAllPaintings();
		
		for (Painting painting : paintings) {
			if (painting.getName().equals(PName_1)) {
				projectManager.deletePainting(painting);
			}
		}		
		
		assertEquals(null, projectManager.findPaintingById(pId));
		
		projectManager.deletePainting(p2);
		
	}
	
}