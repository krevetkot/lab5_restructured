package exceptions;


/**
 * Исключение, которое пробрасывается при возникновении ошибки во время сборки объекта класса.
 * Используется, когда заполнены не все поля, которые должны.
 * @author Kseniya
 */
public class FailedBuildingException extends Exception{
    private Class<?> problemClass;
    public FailedBuildingException(String message, Class<?> problemClass) {
        super(message + " Проблема в классе: " + problemClass);
        this.problemClass = problemClass;
    }
}
