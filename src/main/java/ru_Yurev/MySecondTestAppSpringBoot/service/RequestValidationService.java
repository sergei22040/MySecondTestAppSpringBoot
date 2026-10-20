package ru_Yurev.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru_Yurev.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru_Yurev.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.getTarget() instanceof ru_Yurev.MySecondTestAppSpringBoot.model.Request) {
            ru_Yurev.MySecondTestAppSpringBoot.model.Request request =
                    (ru_Yurev.MySecondTestAppSpringBoot.model.Request) bindingResult.getTarget();

            if ("123".equals(request.getUid())) {
                throw new UnsupportedCodeException("UID '123' не поддерживается информационной системой");
            }
        }

        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}