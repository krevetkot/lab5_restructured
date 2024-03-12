package managers;

import objects.Dragon;

import java.util.ArrayList;

public abstract class IDManager {

    public static int generateID(){
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        boolean flag = true;

        while (true) {
            int res = (int) (Math.random() * 89999999 + 10000000);
            for (Dragon element : collection) {
                if (element.getId() == res) {
                    flag = false;
                }
            }
            if (flag) {
                return res;
            }
        }

    }

    public static boolean passportIDisUnique(String passportID){
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

    public static boolean dragonIDisUnique(int dragonID){
        ArrayList<Dragon> collection = CollectionManager.getCollection();
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
