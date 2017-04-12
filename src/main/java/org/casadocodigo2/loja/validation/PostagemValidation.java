package org.casadocodigo2.loja.validation;

import org.casadocodigo2.loja.models.Postagem;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PostagemValidation implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {
		return Postagem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		Postagem postagem = (Postagem) target;
		if (postagem.getPaginas() <= 0){
			errors.rejectValue("paginas", "field.required");
		}
	}
}
