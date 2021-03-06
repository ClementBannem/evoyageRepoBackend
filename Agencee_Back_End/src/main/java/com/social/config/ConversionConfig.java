package com.social.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.social.converter.ReservationRequestToReservationConverter;
import com.social.converter.ReservationToReservationResponseConverter;
import com.social.converter.VoyageToReservableVoyageResponseConverter;

@Configuration
public class ConversionConfig {
	private Set<Converter> getConverters(){
		Set<Converter> converters = new HashSet <Converter>();
		converters.add(new VoyageToReservableVoyageResponseConverter());
		converters.add(new ReservationRequestToReservationConverter());
		converters.add(new ReservationToReservationResponseConverter());
		
		return converters;
		
	}
	@Bean public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
}

}
