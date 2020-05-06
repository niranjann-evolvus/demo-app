package com.evolvus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvus.domain.Lookup;
import com.evolvus.repository.LookupRepository;

@Service
public class LookupService {

	private static final Logger LOG = LoggerFactory.getLogger(LookupService.class);
	@Autowired
	private LookupRepository lookUpRepository;

	/***
	 * This method is used for getting students
	 *
	 * @param lookupType
	 * @return
	 */
	public List<Lookup> getByType(final String lookupType) {

		List<Lookup> result = null;

		try {

			result = lookUpRepository.getByType(lookupType);
		} catch (final Exception e) {
			LookupService.LOG.error("Exception getting lookupvalues", e);

		}

		return result;

	}
}
