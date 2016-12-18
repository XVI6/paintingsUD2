package java.ud.paintings.projectUD2.service;

import java.ud.paintings.projectUD2.domain.Reproductor;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", 
						defaultRollback = true)
@Transactional
public class ProjectManagerTest {
	
	@Autowired
	ProjectManager projectManager;
	
	private final static String Name_1 = "";
	
	//@Test
	public void checkAddReproductor() {
		List<Reproductor> reproductors = projectManager.getAllReproductors();
	}
}
