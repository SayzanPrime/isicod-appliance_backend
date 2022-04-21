package net.isicod.appliance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.isicod.appliance.api.model.Appliance;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

}
