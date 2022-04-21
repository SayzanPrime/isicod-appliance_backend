package net.isicod.appliance.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceDto {
	
    private Long id;

	private String libelle;

	private String dbid;

	private String disponibilite;

	private String ref;
	
	private TypeApplianceDto typeApplianceDto;
}
