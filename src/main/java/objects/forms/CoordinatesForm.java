package objects.forms;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.IDManager;
import managers.Validator;
import objects.Coordinates;
import objects.Dragon;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

/**
 * Класс для формирования объектов типа {@link Coordinates}.
 * @author Kseniya
 */
public class CoordinatesForm extends Form<Coordinates>{

    /**
     * Собирает объект класса {@link Coordinates}.
     * @throws IllegalValueException - при недопустимом значении в одном из полей
     * @throws FailedBuildingException - при ошибке сборки
     * @return новый объект класса {@link Coordinates}.
     */
    @Override
    public Coordinates build(Scanner scanner, boolean fileMode) throws IllegalValueException, FailedBuildingException {
        Long x = askLong(scanner, fileMode, "координату х", false);
        float y = askFloat(scanner, fileMode, "координату y");

        Coordinates newCoords = new Coordinates(x, y);
        if (!Validator.coordValidation(newCoords)){
            throw new FailedBuildingException("Недопустимое значение в поле!", Coordinates.class);
        }
        return newCoords;
    }

}
