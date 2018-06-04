package br.com.marketplace.configuration.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@FacesConverter(value = "dateTimeConverter")
public class FacesConvertLocalDateTime implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDateTime dateValue = (LocalDateTime) value;
		return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

	}

}
