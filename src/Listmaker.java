import java.util.ArrayList;
import java.util.Scanner;
public class Listmaker
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String menu;
        boolean done = false;

        do
        {
            menu = display(in, list);
            switch(menu.toLowerCase())
            {
                case "q":
                    if(quit())
                    {
                        done = true;
                    }
                    break;
                case "a":
                    add(in, list);
                    break;
                case "i":
                    add(in, list);
                    break;
                case "d":
                    if (list.size() ==0)
                    {
                        System.out.println("You do not have anything in your list anymore");
                        break;
                    }
                    delete(in, list);
                    break;
                case "p":
                    print(list);
                    break;
            }
        }while(!done);
    }
    private static boolean quit()
    {

        Scanner in = new Scanner(System.in);
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N?)");

    }
    public static void add(Scanner in, ArrayList list) {
        String item = SafeInput.getNonZeroLenString(in, "What item do you want to add?");
        list.add(item);
    }

    public static void insert(Scanner in, ArrayList list) {
        String item = SafeInput.getNonZeroLenString(in,"What item do you want to insert?");
        list.add(item);
    }
    public static void delete(Scanner in, ArrayList list)

    {
        int high = list.size();
        int num = SafeInput.getRangedInt(in, "What number of item you want to delete?", 1, high);
        list.remove(num-1);
    }
    public static void print(ArrayList list)
    {

        for (int i=0; i<list.size();i++)
        {
            System.out.println((i+1) + " " + list.get(i));
        }


        System.out.println();

    }
    private static String display(Scanner in, ArrayList list)
    {

        System.out.println("A – Add");
        System.out.println("D – Delete");
        System.out.println("I- Insert");
        System.out.println("P – Print");
        System.out.println("Q – Quit");
        for (int i=0; i<list.size();i++)
        {
            System.out.println((i+1) + ". " + list.get(i));

        }
        System.out.println();
        return SafeInput.getRegExString(in,"What do you choose? (Enter a,d,i,p, or q?","[AaDdIiPpQq]");
    }
}