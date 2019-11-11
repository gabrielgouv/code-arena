package br.com.codearena.core.configuration.mapper.converter;

import org.modelmapper.AbstractConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayMonthYearStringToLocalDateConverter extends AbstractConverter<String, LocalDate> {

    @Override
    protected LocalDate convert(String s) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(s, format);
    }

}
