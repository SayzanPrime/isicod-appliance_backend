package net.isicod.appliance.api.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.isicod.appliance.api.dto.TypeApplianceDto;
import net.isicod.appliance.api.model.TypeAppliance;

@Component
public class TypeApplianceMapper {

	@Autowired
	DozerBeanMapper mapper;

	// Entity to dto

	public TypeApplianceDto typeApplianceToTypeApplianceDto(TypeAppliance typeAppliance) {

		if (typeAppliance == null) {
			return null;
		}

		return mapper.map(typeAppliance, TypeApplianceDto.class);
	}

	public List<TypeApplianceDto> typeApplianceToTypeApplianceDto(List<TypeAppliance> typeAppliances) {

		if (CollectionUtils.isEmpty(typeAppliances)) {
			return Collections.emptyList();
		}

		List<TypeApplianceDto> typeApplianceDtos = new ArrayList<TypeApplianceDto>();

		for (TypeAppliance typeAppliance : typeAppliances) {
			typeApplianceDtos.add(typeApplianceToTypeApplianceDto(typeAppliance));
		}
		return typeApplianceDtos;
	}

	// Dto to entity
	public TypeAppliance typeApplianceDtoToTypeAppliance(TypeApplianceDto typeApplianceDto) {

		if (typeApplianceDto == null) {
			return null;
		}

		return mapper.map(typeApplianceDto, TypeAppliance.class);
	}

	public List<TypeAppliance> typeApplianceDtoToTypeAppliance(List<TypeApplianceDto> typeApplianceDtos) {

		if (CollectionUtils.isEmpty(typeApplianceDtos)) {
			return Collections.emptyList();
		}

		List<TypeAppliance> typeAppliances = new ArrayList<TypeAppliance>();

		for (TypeApplianceDto typeApplianceDto : typeApplianceDtos) {
			typeAppliances.add(typeApplianceDtoToTypeAppliance(typeApplianceDto));
		}
		return typeAppliances;
	}
}
