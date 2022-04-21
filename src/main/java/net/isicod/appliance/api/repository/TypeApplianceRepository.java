package net.isicod.appliance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.isicod.appliance.api.model.TypeAppliance;

@Repository
public interface TypeApplianceRepository extends JpaRepository<TypeAppliance, Long> {

}
