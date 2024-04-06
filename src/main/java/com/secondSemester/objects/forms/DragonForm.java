package com.secondSemester.objects.forms;

import com.secondSemester.exceptions.FailedBuildingException;
import com.secondSemester.exceptions.IllegalValueException;
import com.secondSemester.managers.Console;
import com.secondSemester.managers.IDManager;
import com.secondSemester.managers.Validator;
import com.secondSemester.objects.Coordinates;
import com.secondSemester.objects.Dragon;
import com.secondSemester.objects.DragonType;
import com.secondSemester.objects.Person;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс для формирования объектов типа {@link Dragon}.
 *
 * @author Kseniya
 */
public class DragonForm extends Form<Dragon> {
    /**
     * Собирает объект класса {@link Dragon}.
     *
     * @return новый объект класса {@link Dragon}.
     * @throws IllegalValueException   - при недопустимом значении в одном из полей
     * @throws FailedBuildingException - при ошибке сборки
     */
    @Override
    public Dragon build(Scanner scanner, boolean fileMode) throws IllegalValueException, FailedBuildingException {
        Console.print("Введите данные о драконе.", fileMode);
        String name = askString(scanner, fileMode, "имя", false);

        CoordinatesForm coordinatesForm = new CoordinatesForm();
        Coordinates coords = coordinatesForm.build(scanner, fileMode);

        Long age = askLong(scanner, fileMode, "возраст", true);
        Long weight = askLong(scanner, fileMode, "вес", true);
        boolean speaking = askBoolean(scanner, fileMode, "умеет ли говорить дракон (true/false)");
        DragonType type = (DragonType) askEnum(scanner, fileMode, DragonType.values(), "тип дракона", true);

        boolean hasKiller = askBoolean(scanner, fileMode, "есть ли у дракона убийца (true/false)");
        Person killer = null;
        if (hasKiller) {
            PersonForm personForm = new PersonForm();
            killer = personForm.build(scanner, fileMode);
        }

        Dragon newDragon = new Dragon(IDManager.generateID(), name, coords, LocalDate.now(), age, weight, speaking, type, killer);
        if (!Validator.dragonValidation(newDragon)) {
            throw new FailedBuildingException("Недопустимое значение в поле!", Dragon.class);
        }
        return newDragon;
    }
}
