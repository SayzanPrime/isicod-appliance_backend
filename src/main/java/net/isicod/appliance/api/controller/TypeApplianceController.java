package net.isicod.appliance.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.isicod.appliance.api.dto.TypeApplianceDto;
import net.isicod.appliance.api.service.TypeApplianceService;

@RestController
@RequestMapping("apis/typeAppliance")
public class TypeApplianceController {

	@Autowired
	TypeApplianceService typeApplianceService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TypeApplianceDto> findAllTypeAppliance() {

		return typeApplianceService.findAllTypeAppliance();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public TypeApplianceDto findTypeApplianceById(@PathVariable Long id) {

		return typeApplianceService.findTypeApplianceById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveTypeAppliance(@RequestBody TypeApplianceDto typeApplianceDto) {

		typeApplianceService.saveTypeAppliance(typeApplianceDto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateTypeAppliance(@RequestBody TypeApplianceDto typeApplianceDto) {

		typeApplianceService.updateTypeAppliance(typeApplianceDto);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTypeAppliance(@PathVariable Long id) {

		typeApplianceService.deleteTypeAppliance(id);
	}

}
