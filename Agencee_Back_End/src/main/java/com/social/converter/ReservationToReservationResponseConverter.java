package com.social.converter;

import org.springframework.core.convert.converter.Converter;

import com.social.entities.Reservation;
import com.social.response.ReservationResponse;

public class ReservationToReservationResponseConverter implements Converter<Reservation, ReservationResponse> {

	@Override
	public ReservationResponse convert(Reservation source) {
		
		ReservationResponse reservationResponse = new ReservationResponse();
		if(null != source.getVoyage())
			reservationResponse.setId(source.getVoyage().getId());
		
		return reservationResponse;
	}

}
