package net.isicod.appliance.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.isicod.appliance.api.dto.ApplianceDto;
import net.isicod.appliance.api.exceptions.ResourceNotFoundException;
import net.isicod.appliance.api.mapper.ApplianceMapper;
import net.isicod.appliance.api.model.Appliance;
import net.isicod.appliance.api.repository.ApplianceRepository;
import net.isicod.appliance.api.service.ApplianceService;

@Service
public class ApplianceServiceImpl implements ApplianceService {

	@Autowired
	ApplianceRepository applianceRepository;

	@Autowired
	ApplianceMapper applianceMapper;

	@Override
	public List<ApplianceDto> findAllAppliance() {

		return applianceMapper.applianceToApplianceDto(applianceRepository.findAll());
	}

	@Override
	public ApplianceDto findApplianceById(Long id) {

		Appliance appliance = applianceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appliance Introuvable - id : " + id));

		return applianceMapper.applianceToApplianceDto(appliance);
	}

	@Override
	public void saveAppliance(ApplianceDto applianceDto) {

		applianceRepository.save(applianceMapper.applianceDtoToAppliance(applianceDto));
	}

	@Override
	public void updateAppliance(ApplianceDto applianceDto) {

		if (applianceDto == null) {
			return;
		}

		applianceRepository.findById(applianceDto.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Appliance Introuvable - id : " + applianceDto.getId()));

		applianceRepository.save(applianceMapper.applianceDtoToAppliance(applianceDto));
	}

	@Override
	public void deleteAppliance(Long id) {
		
		applianceRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Appliance Introuvable - id : " + id));
		
		applianceRepository.deleteById(id);
	}
}
