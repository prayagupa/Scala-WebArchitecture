package com.pseudononymous;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import java.util.List;

import static java.util.Arrays.*;

@FacesConverter("com.pseudononymous.LicenseConverter")
public class LicenseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String valueToValidate) {


		if(!validate(valueToValidate)){
			
			FacesMessage msg = 
				new FacesMessage("License validation error.",
						"Invalid License format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}

		return valueToValidate;
	}

	private boolean validate(String valueToValidate) {
		List<String> comps = asList(valueToValidate.split("-"));
		boolean matches = comps.size() == 3 &&
						  comps.get(0).matches("[A-Z]{2}") &&
						  comps.get(1).matches("[0-9]{2}") &&
						  comps.get(2).matches("[A-Z]{2}");

		return matches;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}
}