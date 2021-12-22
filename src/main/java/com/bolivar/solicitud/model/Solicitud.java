package com.bolivar.solicitud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "SolicitudType")
@Table(name = "SOLICITUD")
@Schema(name = "Solicitud")
@Entity
public class Solicitud {
	
	@Schema(name = "idSolicitud", accessMode = Schema.AccessMode.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Schema(name = "canonArrendamiento", required = true, description = "Valor del Canon de Arrendamiento")
	@NotNull(message = "El Valor del Canon de Arrendamiento no puede ser nulo")
	private Long valorCanonArrendamiento;
	
	@Schema(name = "idInmobiliaria", required = true, description = "Identificador de la inmobiliaria asociada a la solicitud")
	@NotNull(message = "El Identificador de la inmobiliaria no puede ser nulo")
	private Long idInmobiliaria;
}
