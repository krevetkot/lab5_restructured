package managers;

import objects.Dragon;

import java.util.ArrayList;

/**
 * Класс, работающий с идентификаторами.
 *
 * @author Kseniya
 */
public abstract class IDManager {

    /**
     * Генерирует восьмизначный идентификатор для дракона.
     */
    public static int generateID() {
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        boolean flag = true;

        while (true) {
            int res = (int) (Math.random() * 89999999 + 10000000);
            for (Dragon element : collection) {
                if (element.getId() == res) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return res;
            }
        }
    }

    /**
     * Проверяет паспортные данные человека на уникальность.
     *
     * @param passportID - паспортные данные человека
     * @return - уникальность
     */
    public static boolean passportIDisUnique(String passportID) {
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        boolean flag = true;
        for (Dragon element : collection) {
            if (element.getKiller().getPassportID().equals(passportID)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Проверяет идентификатор дракона на уникальность.
     *
     * @param dragonID - идентификатор дракона
     * @return - уникальность
     */
    public static boolean dragonIDisUnique(int dragonID, ArrayList<Dragon> collection) {
//        ArrayList<Dragon> collection = CollectionManager.getCollection();
        boolean flag = true;
        for (Dragon element : collection) {
            if (element.getId() == dragonID) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
