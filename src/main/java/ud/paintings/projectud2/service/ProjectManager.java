package ud.paintings.projectud2.service;

import java.util.List;

import ud.paintings.projectud2.domain.Painting;
import ud.paintings.projectud2.domain.Reproductor;

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
