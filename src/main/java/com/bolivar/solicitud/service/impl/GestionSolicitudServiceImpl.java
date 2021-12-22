package com.bolivar.solicitud.service.impl;

import com.bolivar.error.handling.constants.TipoErrorEnum;
import com.bolivar.error.handling.exception.BolivarBusinessException;
import com.bolivar.error.handling.model.ExceptionDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.solicitud.model.Solicitud;
import com.bolivar.solicitud.repository.GestionSolicitudRepository;
import com.bolivar.solicitud.service.GestionSolicitudService;

import java.util.Arrays;
import java.util.Optional;

@Service
public class GestionSolicitudServiceImpl implements GestionSolicitudService {

	@Autowired
	private GestionSolicitudRepository gestionSolicitudRepository;

	@Override
	public Solicitud crearSolicitud(Solicitud solicitud) throws Exception{
		return gestionSolicitudRepository.save(solicitud);
	}

	@Override
	public void actualizarSolicitud(Solicitud solicitud) throws Exception {
		Optional<Solicitud> solicitudUpdate = gestionSolicitudRepository.findById(solicitud.getId());
		if (solicitudUpdate.isEmpty()){
			throw BolivarBusinessException.builder().categoria(TipoErrorEnum.NEGOCIO)
					.codigo("EN01")
					.mensaje("Error no esperado procesando la solicitud")
					.errores(Arrays.asList(ExceptionDetailModel.builder().descripcion("La solicitud con ID: "+solicitud.getId()+", NO existe").build())).build();
		}
		gestionSolicitudRepository.save(solicitud);
	}
}
