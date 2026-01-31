package crud_simulador_fgts_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crud_simulador_fgts_backend.model.SaqueAniversario;

public interface SaqueAniversarioRepository extends JpaRepository<SaqueAniversario, Long> {

    List<SaqueAniversario> findAllByOrderByIdDesc();
}
