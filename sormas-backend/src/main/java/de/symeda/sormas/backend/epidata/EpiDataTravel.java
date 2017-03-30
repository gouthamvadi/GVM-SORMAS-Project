package de.symeda.sormas.backend.epidata;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.symeda.sormas.api.epidata.TravelType;
import de.symeda.sormas.backend.common.AbstractDomainObject;

@Entity
public class EpiDataTravel extends AbstractDomainObject {

	private static final long serialVersionUID = -4280455878066233175L;
	
	public static final String TRAVEL_TYPE = "travelType";
	public static final String TRAVEL_DESTINATION = "travelDestination";
	public static final String TRAVEL_DATE_FROM = "travelDateFrom";
	public static final String TRAVEL_DATE_TO = "travelDateTo";
	public static final String EPI_DATA = "epiData";
	
	private EpiData epiData;
	private TravelType travelType;
	private String travelDestination;
	private Date travelDateFrom;
	private Date travelDateTo;

	@ManyToOne(cascade = {})
	@JoinColumn(nullable = false)
	public EpiData getEpiData() {
		return epiData;
	}
	public void setEpiData(EpiData epiData) {
		this.epiData = epiData;
	}
	
	@Enumerated(EnumType.STRING)
	public TravelType getTravelType() {
		return travelType;
	}
	public void setTravelType(TravelType travelType) {
		this.travelType = travelType;
	}

	@Column(length=512)
	public String getTravelDestination() {
		return travelDestination;
	}
	public void setTravelDestination(String travelDestination) {
		this.travelDestination = travelDestination;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTravelDateFrom() {
		return travelDateFrom;
	}
	public void setTravelDateFrom(Date travelDateFrom) {
		this.travelDateFrom = travelDateFrom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTravelDateTo() {
		return travelDateTo;
	}
	public void setTravelDateTo(Date travelDateTo) {
		this.travelDateTo = travelDateTo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EpiDataTravel other = (EpiDataTravel) obj;
		if (epiData == null) {
			if (other.epiData != null)
				return false;
		} else if (!epiData.equals(other.epiData))
			return false;
		if (travelDateFrom == null) {
			if (other.travelDateFrom != null)
				return false;
		} else if (!travelDateFrom.equals(other.travelDateFrom))
			return false;
		if (travelDateTo == null) {
			if (other.travelDateTo != null)
				return false;
		} else if (!travelDateTo.equals(other.travelDateTo))
			return false;
		if (travelDestination == null) {
			if (other.travelDestination != null)
				return false;
		} else if (!travelDestination.equals(other.travelDestination))
			return false;
		if (travelType != other.travelType)
			return false;
		return true;
	}
	
}
