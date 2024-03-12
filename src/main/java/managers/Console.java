package managers;



public class Console {

    public static void print(String output, boolean fileMode){
        if (fileMode){
            return;
        }
        else {
            System.out.println(output);
        }
    }
}
