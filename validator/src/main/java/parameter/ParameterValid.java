package parameter;

import bean.Car;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.internal.cdi.ValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ParameterValid {

    public void getFullName(@NotBlank String firstName,
                            @NotBlank String lastName) {

    }

    public static void main(String[] args) {
        Car car = new Car("写个啥", null, 123);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Car>> set = validator.validate(car);
        String message = set.iterator().next().getMessage();
        System.out.println(message);
    }

}
