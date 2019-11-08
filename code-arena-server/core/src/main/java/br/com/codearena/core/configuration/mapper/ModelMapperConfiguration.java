package br.com.codearena.core.configuration.mapper;

import br.com.codearena.core.configuration.mapper.converter.DayMonthYearStringToLocalDateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper dozerMapperBean() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(String.class, LocalDate.class);
        modelMapper.addConverter(new DayMonthYearStringToLocalDateConverter());
        return modelMapper;
    }

}
