package ma.hansal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hansal.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

}
