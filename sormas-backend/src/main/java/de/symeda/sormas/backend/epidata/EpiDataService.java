package de.symeda.sormas.backend.epidata;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

import de.symeda.sormas.backend.common.AbstractAdoService;
import de.symeda.sormas.backend.user.User;

@Stateless
@LocalBean
public class EpiDataService extends AbstractAdoService<EpiData> {
	
	public EpiDataService() {
		super(EpiData.class);
	}

	@Override
	protected Predicate createUserFilter(CriteriaBuilder cb, From<EpiData, EpiData> from, User user) {
		// A user should not directly query for this
		throw new UnsupportedOperationException();
	}
}
