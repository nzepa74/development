package com.sonam.chophel.helper;

import com.sonam.chophel.enumeration.SystemDataInt;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by N-Zepa on 17-Jun-18.
 */
@Component
public class BeanValidator {
    @Deprecated
    public Map<String, List<String>> Validate(Object entity) {
        Map<String, List<String>> beanValidationMessageCodes = new HashMap<String, List<String>>();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(entity);

        for (final ConstraintViolation<?> violation : violations) {
            List<String> messageArgs = new ArrayList<String>();
            beanValidationMessageCodes.put(violation.getMessageTemplate(), messageArgs);
        }
        return beanValidationMessageCodes;
    }

    public ResponseMessage Validate(Object entity, ResponseMessage responseMessage) {
        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(entity);

        for (final ConstraintViolation<?> violation : violations) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText(violation.getMessageTemplate());
        }
        return responseMessage;
    }
}
