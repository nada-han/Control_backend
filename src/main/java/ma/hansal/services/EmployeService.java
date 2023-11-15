package ma.hansal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hansal.dao.IDao;
import ma.hansal.entities.Employe;
import ma.hansal.repository.EmployeRepository;

@Service
public class EmployeService implements IDao<Employe>{
	
	@Autowired
	private EmployeRepository EmployeRepository;
	
	@Override
	public Employe create(Employe o) {
		return EmployeRepository.save(o);
	}
	
	@Override
	public boolean delete(Employe o) {
		try {
			EmployeRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public Employe update(Employe o) {
		return EmployeRepository.save(o);
	}
	
	@Override 
	public List<Employe> findAll(){
		return EmployeRepository.findAll();
	}
	
	@Override
	public Employe findById(Long id) {
		return EmployeRepository.findById(id).orElse(null);
	}
	
	
	

}
