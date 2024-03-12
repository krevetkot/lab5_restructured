package objects.forms;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.Console;
import managers.IDManager;
import managers.Validator;
import objects.Coordinates;
import objects.Dragon;
import objects.DragonType;
import objects.Person;

import java.time.LocalDate;
import java.util.Scanner;

public class DragonForm extends Form<Dragon> {
    //visibility true, когда мы работаем с консольным вводом
    //visibility false, когда мы работаем с файловым вводом
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
        if (hasKiller){PersonForm personForm = new PersonForm();
            killer = personForm.build(scanner, fileMode);
        }

        Dragon newDragon = new Dragon(IDManager.generateID(), name, coords, LocalDate.now(), age, weight, speaking, type, killer);
        if (!Validator.dragonValidation(newDragon)){
            throw new FailedBuildingException("Недопустимое значение в поле!", Dragon.class);
        }
        return newDragon;
    }
}
