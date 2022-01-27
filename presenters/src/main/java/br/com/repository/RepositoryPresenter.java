package br.com.repository;

import br.com.domain.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPresenter extends JpaRepository<HospitalEntity, Long> {
}
