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

import net.isicod.appliance.api.dto.ApplianceDto;
import net.isicod.appliance.api.service.ApplianceService;

@RestController
@RequestMapping("apis/appliance")
public class ApplianceController {

	@Autowired
	ApplianceService applianceService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ApplianceDto> findAllAppliance() {

		return applianceService.findAllAppliance();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ApplianceDto findApplianceById(@PathVariable Long id) {

		return applianceService.findApplianceById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveAppliance(@RequestBody ApplianceDto applianceDto) {

		applianceService.saveAppliance(applianceDto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateAppliance(@RequestBody ApplianceDto applianceDto) {

		applianceService.updateAppliance(applianceDto);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAppliance(@PathVariable Long id) {

		applianceService.deleteAppliance(id);
	}

}
