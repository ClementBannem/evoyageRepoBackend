package com.social.request;

public class ReservationRequest {

	private Long id;
	private Long voyageId;
	private Long clientId;


	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Long voyageId, Long clientId) {
		super();
		this.voyageId = voyageId;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVoyageId() {
		return voyageId;
	}

	public void setVoyageId(Long voyageId) {
		this.voyageId = voyageId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

}
