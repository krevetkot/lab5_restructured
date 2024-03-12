package objects.forms;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.Console;
import objects.Coordinates;
import objects.DragonType;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Абстрактный класс для формирования объектов.
 * @param <T> Класс формируемого объекта
 * @author Kseniya
 */
public abstract class Form<T> {

    /**
     * Собирает объект класса.
     * @throws IllegalValueException - при недопустимом значении в одном из полей
     * @throws FailedBuildingException - при ошибке сборки
     * @return новый объект класса T
     */
    public abstract T build(Scanner scanner, boolean fileMode) throws IllegalValueException, FailedBuildingException;

    /**
     * Формирует объект класса Enum.
     * @param scanner - используемый сканер
     * @param fileMode - режим ввода: если true, значит данные принимаются из файла,
     *                 если false, данные принимаются интерактивно из консоли
     * @param values - массив значений перечисления
     * @param enumName - название класса Enum
     * @param canBeNull - может ли сформированный объект быть null
     * @throws IllegalValueException - пробрасывается при недопустимом значении
     * @return сформированный объект класса Enum
     */
    public static Enum askEnum(Scanner scanner, boolean fileMode, Enum[] values, String enumName, boolean canBeNull)
            throws IllegalValueException{
        Console.print("Введите " + enumName + ". Возможные варианты: ", fileMode);
        String enumValues = "";
        for (Enum value: values){
            enumValues = enumValues + value + " ";
        }
        enumValues += "null(пустая строка)";
        Console.print(enumValues, fileMode);

        while (true) {
            String str = scanner.nextLine().trim();
            for (Enum value : values) {
                if (value.toString().equals(str)) {
                    return value;
                } else if (str.isEmpty()&&canBeNull) {
                    return null;
                }
            }
            if (fileMode){
                throw new IllegalValueException("Введено недопустимое значение.", str);
            }
            Console.print("Такого значения нет, попробуйте еще раз.", fileMode);
        }
    }

    /**
     * Формирует число типа Long.
     * @param scanner - используемый сканер
     * @param fileMode - режим ввода: если true, значит данные принимаются из файла,
     *                 если false, данные принимаются интерактивно из консоли
     * @param name - название класса Enum
     * @param greaterThanZero - должно ли сформированное число быть больше нуля
     * @throws IllegalValueException - пробрасывается при недопустимом значении
     * @return сформированное число типа Long
     */
    public static Long askLong(Scanner scanner, boolean fileMode, String name, Boolean greaterThanZero)
            throws IllegalValueException{
        Console.print("Введите " + name + ":", fileMode);
        Long res = null;
        while (true) {
            String str = scanner.nextLine().trim();
            try {
                res = Long.parseLong(str);
                if (greaterThanZero){
                    if (res > 0) {
                        return res;
                    }
                    if (fileMode){
                        throw new IllegalValueException("Введено недопустимое значение.", str);
                    }
                    Console.print("Значение должно быть больше нуля! Попробуйте еще раз.", fileMode);
                }
                else {
                    return res;
                }
            } catch (NumberFormatException e) {
                if (fileMode){
                    throw new IllegalValueException("Значение должно быть числом типа Long.", str);
                }
                Console.print("Значение должно быть числом типа Long! Попробуйте еще раз.", fileMode);
            }
        }
    }

    /**
     * Формирует значение типа Boolean.
     * @param scanner - используемый сканер
     * @param fileMode - режим ввода: если true, значит данные принимаются из файла,
     *                 если false, данные принимаются интерактивно из консоли
     * @param name - название класса Enum
     * @throws IllegalValueException - пробрасывается при недопустимом значении
     * @return сформированное значение типа Boolean
     */
    public static Boolean askBoolean(Scanner scanner, boolean fileMode, String name) throws IllegalValueException{
        Console.print("Введите " + name + ":", fileMode);
        String str = null;
        while (true) {
            str = scanner.nextLine().trim();
            if (str.equals("true") || str.equals("false")){
                return Boolean.parseBoolean(str);
            }
            if (fileMode){
                throw new IllegalValueException("Введено недопустимое значение.", str);
            }
            Console.print("Можно ввести только true или false! Попробуйте еще раз.", fileMode);
        }
    }

    /**
     * Формирует число типа float.
     * @param scanner - используемый сканер
     * @param fileMode - режим ввода: если true, значит данные принимаются из файла,
     *                 если false, данные принимаются интерактивно из консоли
     * @param name - название класса Enum
     * @throws IllegalValueException - пробрасывается при недопустимом значении
     * @return сформированное число типа float
     */
    public static float askFloat(Scanner scanner, boolean fileMode, String name) throws IllegalValueException{
        Console.print("Введите " + name + ":", fileMode);
        while (true) {
            String str = scanner.nextLine().trim();
            float res;
            try {
                res = Float.parseFloat(str);
                return res;
            } catch (NumberFormatException e) {
                if (fileMode){
                    throw new IllegalValueException("Введено недопустимое значение.", str);
                }
                Console.print("Значение должно быть числом типа float! Попробуйте еще раз.", fileMode);
            }
        }
    }

    /**
     * Формирует строку.
     * @param scanner - используемый сканер
     * @param fileMode - режим ввода: если true, значит данные принимаются из файла,
     *                 если false, данные принимаются интерактивно из консоли
     * @param name - название класса Enum
     * @param canBeEmpty - может ли строка быть пустой
     * @throws IllegalValueException - пробрасывается при недопустимом значении
     * @return сформированная строка
     */
    public static String askString(Scanner scanner, boolean fileMode, String name, boolean canBeEmpty) throws IllegalValueException{
        Console.print("Введите " + name + ":", fileMode);
        while(true){
            String str = scanner.nextLine().trim();
            if (str.isBlank() && !canBeEmpty){
                if (fileMode){
                    throw new IllegalValueException("Введено недопустимое значение.", str);
                }
                Console.print("Строка не может быть пустой! Попробуйте еще раз.", fileMode);
            }
            else if (str.isBlank()){
                return null;
            }
            else {
                return str;
            }
        }
    }
}
