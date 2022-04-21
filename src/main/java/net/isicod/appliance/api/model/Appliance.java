package net.isicod.appliance.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "APPLIANCE_TB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appliance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@Column(name = "DBID")
	private String dbid;
	
	@Column(name = "DISPONIBILITE")
	private String disponibilite;
	
	@Column(name = "REF")
	private String ref;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_APPLIANCE_ID", foreignKey = @ForeignKey(name="FK_Appliance_typeAppliance"))
	private TypeAppliance typeAppliance;

}
