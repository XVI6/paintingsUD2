package java.ud.paintings.projectUD2.service;

import java.ud.paintings.projectUD2.domain.Painting;
import java.ud.paintings.projectUD2.domain.Reproductor;
import java.util.List;

public interface PaintingManager {
	
	//CRUD
	void addPainting(Painting p);
	List<Painting> getAllPaintings();
	void updatePainting(Painting p_old, Painting p_new);
	void deletePainting(Painting p);
	
	
	Painting findPaintingById(Long id);
	Painting findPaintingByName(String name);
	
	
	//CRUD
	void addReproductor(Reproductor r);
	List<Reproductor> getAllReproductors();
	void updateReproductor(Reproductor r_old, Reproductor r_new);
	void deleteReproductor(Reproductor r);
	
	Reproductor findReproductorById(Long id);
	Reproductor findReproductorByName(String name);
	
	List<Reproductor> findReproductorByReproductor(Reproductor r);
}
