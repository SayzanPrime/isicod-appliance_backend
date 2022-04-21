package net.isicod.appliance.api.service;

import java.util.List;

import net.isicod.appliance.api.dto.TypeApplianceDto;

public interface TypeApplianceService {
	
	List<TypeApplianceDto> findAllTypeAppliance();
	
	TypeApplianceDto findTypeApplianceById(Long id);
	
	void saveTypeAppliance(TypeApplianceDto typeApplianceDto);
	
	void updateTypeAppliance(TypeApplianceDto typeApplianceDto);
	
	void deleteTypeAppliance(Long id);
}
