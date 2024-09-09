package com.crudgestion.demo.interfacesService;

import java.util.List;
import java.util.Optional;
import com.crudgestion.demo.model.Buyer;

interface IBuyerService {
	public List<Buyer>list();
	public Optional<Buyer>listById(int id);
	public int save(Buyer p);
	public void delete(int id);
}
