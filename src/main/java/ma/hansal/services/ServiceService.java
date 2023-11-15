package ma.hansal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hansal.dao.IDao;
import ma.hansal.entities.Service1;
import ma.hansal.repository.ServiceRepository;

@Service
public class ServiceService implements IDao<Service1>{
	
	@Autowired
	private ServiceRepository ServiceRepository;
	
	@Override
	public Service1 create(Service1 o) {
		return ServiceRepository.save(o);
	}
	
	@Override
	public boolean delete(Service1 o) {
		try {
			ServiceRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public Service1 update(Service1 o) {
		return ServiceRepository.save(o);
	}
	
	@Override 
	public List<Service1> findAll(){
		return ServiceRepository.findAll();
	}
	
	@Override
	public Service1 findById(Long id) {
		return ServiceRepository.findById(id).orElse(null);
	}
	
	
	

}
