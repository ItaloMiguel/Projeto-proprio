package br.com.estudo.pratica.repository;

import br.com.estudo.pratica.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, UUID> {
}
