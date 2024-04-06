package managers;

import objects.Coordinates;
import objects.Dragon;
import objects.Person;

/**
 * Класс, проверяющий объекты на валидность, согласно предоставленным условиям.
 *
 * @author Kseniya
 */
public class Validator {
    /**
     * Проверяет, что все необходимые поля экземпляра класса {@link Dragon} не равны null.
     *
     * @param dragon - проверяемый дракон
     * @return результат проверки
     */
    public static boolean dragonValidation(Dragon dragon) {
        if (dragon == null) {
            return false;
        }
        return !dragon.getName().isBlank() && dragon.getCoordinates() != null
                && dragon.getAge() != null
                && dragon.getWeight() != null
                && personValidation(dragon.getKiller())
                && coordValidation(dragon.getCoordinates());
    }

    /**
     * Проверяет, что все необходимые поля экземпляра класса {@link Person} не равны null.
     *
     * @param person - проверяемый дракон
     * @return результат проверки
     */
    public static boolean personValidation(Person person) {
        if (person == null) {
            return true;
        }
        return !person.getName().isBlank() && person.getEyeColor() != null
                && person.getNationality() != null;
    }

    /**
     * Проверяет, что все необходимые поля экземпляра класса {@link Coordinates} не равны null.
     *
     * @param coords - проверяемый дракон
     * @return результат проверки
     */
    public static boolean coordValidation(Coordinates coords) {
        if (coords == null) {
            return false;
        }
        return coords.getX() != null;
    }
}
