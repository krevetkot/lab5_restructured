package objects.forms;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.Console;
import objects.DragonType;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class Form<T> {

    public abstract T build(Scanner scanner, boolean fileMode) throws IllegalValueException, FailedBuildingException;

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

    //параметр greaterthanzero означает, нужна ли нам проверка, что число больше нуля, или не нужна
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

    public static String askString(Scanner scanner, boolean fileMode, String name, boolean canBeEmpty) throws IllegalValueException{
        Console.print("Введите " + name + ":", fileMode);
        while(true){
            String str = scanner.nextLine().trim();
            if (name.isBlank() && !canBeEmpty){
                if (fileMode){
                    throw new IllegalValueException("Введено недопустимое значение.", str);
                }
                Console.print("Строка не может быть пустой! Попробуйте еще раз.", fileMode);
            }
            else if (name.isBlank()){
                return null;
            }
            else {
                return str;
            }
        }
    }
}
