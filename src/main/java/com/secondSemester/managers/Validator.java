package com.secondSemester.managers;

import com.secondSemester.objects.Coordinates;
import com.secondSemester.objects.Dragon;
import com.secondSemester.objects.Person;

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
        if (dragon.getKiller() == null){
            return !dragon.getName().isBlank() && dragon.getCoordinates() != null
                    && dragon.getAge() != null
                    && dragon.getWeight() != null
                    && coordValidation(dragon.getCoordinates());
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
