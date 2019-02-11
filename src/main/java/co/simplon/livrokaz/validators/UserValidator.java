package co.simplon.livrokaz.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.simplon.livrokaz.model.User0ld;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User0ld.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User0ld user = (User0ld)o;
        if(user.getPassword().length() < 6){
            errors.rejectValue("password", "Length", "Le mot de passe doit contenir au moins 6 caracteres");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Match", "Les mots de passe ne correspondent pas");
        }
    }
}
