package net.isicod.appliance.api.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.isicod.appliance.api.dto.ApplianceDto;
import net.isicod.appliance.api.model.Appliance;

@Component
public class ApplianceMapper {

	@Autowired
	DozerBeanMapper mapper;

	@Autowired
	TypeApplianceMapper typeApplianceMapper;

	// Entity to dto

	public ApplianceDto applianceToApplianceDto(Appliance appliance) {

		if (appliance == null) {
			return null;
		}

		ApplianceDto applianceDto = mapper.map(appliance, ApplianceDto.class);

		if (appliance.getTypeAppliance() != null) {
			applianceDto.setTypeApplianceDto(
					typeApplianceMapper.typeApplianceToTypeApplianceDto(appliance.getTypeAppliance()));
		}

		return applianceDto;
	}

	public List<ApplianceDto> applianceToApplianceDto(List<Appliance> appliances) {

		if (CollectionUtils.isEmpty(appliances)) {
			return Collections.emptyList();
		}

		List<ApplianceDto> applianceDtos = new ArrayList<ApplianceDto>();

		for (Appliance appliance : appliances) {
			applianceDtos.add(applianceToApplianceDto(appliance));
		}
		return applianceDtos;
	}

	// Dto to entity
	public Appliance applianceDtoToAppliance(ApplianceDto applianceDto) {

		if (applianceDto == null) {
			return null;
		}

		Appliance appliance = mapper.map(applianceDto, Appliance.class);

		if (applianceDto.getTypeApplianceDto() != null) {
			appliance.setTypeAppliance(
					typeApplianceMapper.typeApplianceDtoToTypeAppliance(applianceDto.getTypeApplianceDto()));
		}

		return appliance;
	}

	public List<Appliance> applianceDtoToAppliance(List<ApplianceDto> applianceDtos) {

		if (CollectionUtils.isEmpty(applianceDtos)) {
			return Collections.emptyList();
		}

		List<Appliance> appliances = new ArrayList<Appliance>();

		for (ApplianceDto applianceDto : applianceDtos) {
			appliances.add(applianceDtoToAppliance(applianceDto));
		}

		return appliances;
	}
}
