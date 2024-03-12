package objects.forms;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.Console;
import managers.IDManager;
import managers.Validator;
import objects.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс для формирования объектов типа {@link Person}.
 * @author Kseniya
 */
public class PersonForm extends Form<Person>{
    /**
     * Собирает объект класса {@link Person}.
     * @throws IllegalValueException - при недопустимом значении в одном из полей
     * @throws FailedBuildingException - при ошибке сборки
     * @return новый объект класса {@link Person}.
     */
    @Override
    public Person build(Scanner scanner, boolean fileMode) throws IllegalValueException, FailedBuildingException {
        Console.print("Введите данные об убийце дракона.", fileMode);

        String name = askString(scanner, fileMode, "имя", false);
        
        String passportID = null;
        while(true){
            passportID = askString(scanner, fileMode, "паспортные данные", true);
            if (IDManager.passportIDisUnique(passportID)){
                break;
            }
            else{
                if (fileMode){
                    throw new IllegalValueException("Введено недопустимое значение.", passportID);
                }
                Console.print("Кажется, убийца драконов с такими паспортными данными уже есть в коллекции. " +
                        "Пожалуйста, введите их заново.", fileMode);
            }
        }
        
        Color eyeColor = (Color)askEnum(scanner, fileMode, Color.values(), "цвет глаз", false);
        Color hairColor = (Color)askEnum(scanner, fileMode, Color.values(), "цвет волос", true);
        Country nationality = (Country)askEnum(scanner, fileMode, Country.values(), "национальность", false);

        long countKilledDragons = askLong(scanner, fileMode,"количество убитых драконов", true);

        Person newPerson = new Person(name, passportID, eyeColor, hairColor, nationality, countKilledDragons);

        if (!Validator.personValidation(newPerson)){
            throw new FailedBuildingException("Недопустимое значение в поле!", Person.class);
        }
        return newPerson;
    }
}
