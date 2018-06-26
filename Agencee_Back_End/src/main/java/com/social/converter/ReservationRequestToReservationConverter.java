package com.social.converter;

import org.springframework.core.convert.converter.Converter;

import com.social.entities.Reservation;
import com.social.request.ReservationRequest;

public class ReservationRequestToReservationConverter implements Converter<ReservationRequest, Reservation> {

	@Override
	public Reservation convert(ReservationRequest source) {
		Reservation reservation = new Reservation();

		if (null != source.getId())
			reservation.setIdR(source.getId());
			//reservation.setVoyage(source.getVoyageId());

		return reservation;
	}

}
