package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.SaqueAniversario;

@Repository
public interface SaqueAniversarioRepository extends JpaRepository<SaqueAniversario, Long> {

    List<SaqueAniversario> findAllByOrderByIdDesc();
}
