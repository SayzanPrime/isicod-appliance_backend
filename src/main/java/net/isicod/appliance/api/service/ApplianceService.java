package net.isicod.appliance.api.service;

import java.util.List;

import net.isicod.appliance.api.dto.ApplianceDto;

public interface ApplianceService {

	List<ApplianceDto> findAllAppliance();

	ApplianceDto findApplianceById(Long id);

	void saveAppliance(ApplianceDto applianceDto);

	void updateAppliance(ApplianceDto applianceDto);

	void deleteAppliance(Long id);
}
