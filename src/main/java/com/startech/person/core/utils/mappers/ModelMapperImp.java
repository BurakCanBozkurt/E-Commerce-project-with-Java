package com.startech.person.core.utils.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@AllArgsConstructor
public class ModelMapperImp implements ModelMapperService {
	private final ModelMapper mapper;

	@Override
	public ModelMapper forResponse() {
		mapper.getConfiguration()
				.setAmbiguityIgnored(true)
				.setMatchingStrategy(MatchingStrategies.LOOSE);

		return mapper;
	}

	@Override
	public ModelMapper forRequest() {
		mapper.getConfiguration()
				.setAmbiguityIgnored(true)
				.setMatchingStrategy(MatchingStrategies.STANDARD);

		return mapper;
	}
}