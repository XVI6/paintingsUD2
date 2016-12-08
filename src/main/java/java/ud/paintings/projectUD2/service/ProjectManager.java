package java.ud.paintings.projectUD2.service;

import java.ud.paintings.projectUD2.domain.Painting;
import java.ud.paintings.projectUD2.domain.Reproductor;
import java.util.List;

public interface ProjectManager {
	
	void addReproductor(Reproductor r);
	void addPainting(Painting p);
	
	List<Reproductor> getAllReproductors();
	List<Painting> getAllPaintings();
	
	void updateReproductor(Reproductor r_new);
	void updatePainting(Painting p_new);
	
	void deleteReproductor(Reproductor r);
	void deletePainting(Painting p);

	Reproductor findReproductorById(Long id);
	Painting findPaintingById(Long id);
	
	Reproductor findReproductorByName(String name);
	Painting findPaintingByName(String name);
	
	List<Painting> findPaintingsByReproductor(Reproductor r);
	
}
