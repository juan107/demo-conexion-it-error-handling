package com.bolivar.solicitud.service;

import com.bolivar.solicitud.model.Solicitud;

public interface GestionSolicitudService {
	
	Solicitud crearSolicitud (Solicitud solicitud)  throws Exception;
	void actualizarSolicitud (Solicitud solicitud)  throws Exception;
}
