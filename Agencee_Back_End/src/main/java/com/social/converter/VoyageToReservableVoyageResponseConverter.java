package com.social.converter;

import org.springframework.core.convert.converter.Converter;

import com.social.controller.ResourceConstants;
import com.social.entities.Voyage;
import com.social.model.Links;
import com.social.model.Self;
import com.social.response.ReservableVoyageResponse;

public class VoyageToReservableVoyageResponseConverter implements Converter<Voyage, ReservableVoyageResponse> {

	@Override
	public ReservableVoyageResponse convert(Voyage source) {
		// TODO Auto-generated method stub
		ReservableVoyageResponse reservationResponse = new ReservableVoyageResponse();
		reservationResponse.setCompagnie(source.getCompagnie());
		reservationResponse.setLibelle(source.getLibelle());
		reservationResponse.setPrix(source.getPrix());
		reservationResponse.setId(source.getId());
		reservationResponse.setDate_Depart(source.getDate_Depart());
		reservationResponse.setDate_Arrive(source.getDate_Arrive());
		reservationResponse.setVilleDepart(source.getVilleDepart());
		reservationResponse.setPaysArrive(source.getPaysArrive());
		reservationResponse.setHeure_Depart(source.getHeure_Depart());
		reservationResponse.setHeure_Arrive(source.getHeure_Arrive());
		
		Links links = new Links();
		Self self = new Self();
		
		self.setRef(ResourceConstants.VOYAGE_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		return reservationResponse;
	}

}
