package com.bolivar.solicitud.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolivar.solicitud.model.Solicitud;

public interface GestionSolicitudRepository extends CrudRepository<Solicitud, Long> {}
