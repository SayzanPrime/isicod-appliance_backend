package net.isicod.appliance.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.isicod.appliance.api.dto.TypeApplianceDto;
import net.isicod.appliance.api.exceptions.ResourceNotFoundException;
import net.isicod.appliance.api.mapper.TypeApplianceMapper;
import net.isicod.appliance.api.model.TypeAppliance;
import net.isicod.appliance.api.repository.TypeApplianceRepository;
import net.isicod.appliance.api.service.TypeApplianceService;

@Service
public class TypeApplianceServiceImpl implements TypeApplianceService {

	@Autowired
	TypeApplianceRepository typeApplianceRepository;

	@Autowired
	TypeApplianceMapper typeApplianceMapper;

	@Override
	public List<TypeApplianceDto> findAllTypeAppliance() {

		return typeApplianceMapper.typeApplianceToTypeApplianceDto(typeApplianceRepository.findAll());
	}

	@Override
	public TypeApplianceDto findTypeApplianceById(Long id) {

		TypeAppliance typeAppliance = typeApplianceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type Appliance Introuvable - id : " + id));

		return typeApplianceMapper.typeApplianceToTypeApplianceDto(typeAppliance);
	}

	@Override
	public void saveTypeAppliance(TypeApplianceDto typeApplianceDto) {

		typeApplianceRepository.save(typeApplianceMapper.typeApplianceDtoToTypeAppliance(typeApplianceDto));
	}

	@Override
	public void updateTypeAppliance(TypeApplianceDto typeApplianceDto) {

		if (typeApplianceDto == null) {
			return;
		}

		typeApplianceRepository.findById(typeApplianceDto.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Type Appliance Introuvable - id : " + typeApplianceDto.getId()));

		typeApplianceRepository.save(typeApplianceMapper.typeApplianceDtoToTypeAppliance(typeApplianceDto));
	}

	@Override
	public void deleteTypeAppliance(Long id) {

		typeApplianceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type Appliance Introuvable - id : " + id));

		typeApplianceRepository.deleteById(id);
	}

}
