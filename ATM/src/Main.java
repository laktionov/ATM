/**
 * Created by Сергей on 06.09.2017.
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean C;
    static ArrayList<Integer> NominalValues;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n;
        int Note;
        for (;;) {
            try {
                System.out.print("Количество номиналов в банкомате: ");
                n = in.nextInt();
                if (n < 1) {
                    System.out.println("Некорректные входные данные - ");
                    System.out.println("Пожалуйста, попробуйте еще раз!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректные входные данные - " + e.getMessage());
                System.out.println("Пожалуйста, попробуйте еще раз!");
                in.nextLine();
            }
        }
        for (;;) {
            try {
                System.out.print("Купюра: ");
                 Note = in.nextInt();
                if (Note < 1) {
                    System.out.println("Фальшивая купюра!!!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректные входные данные - " + e.getMessage());
                System.out.println("Пожалуйста, попробуйте еще раз!");
                in.nextLine();
            }
        }
        NominalValues = new ArrayList<>(n);
        int k = 0;
        System.out.print("Номиналы в банкомате: ");
        while (k < n) {
            try {
                int v = in.nextInt();
                if (v < 1) {
                    continue;
                }
                NominalValues.add(v);
                k++;
            } catch (InputMismatchException e) {
                System.out.println("Некорректныее входные данные - " + e.getMessage());
                System.out.println("Пожалуйста, попробуйтей еще раз!");
                in.nextLine();
            }
        }
        String Result = "";
        C = false;
        int pos = 0;
        exchange(Note, pos, Result);
        if (!C) {
            System.out.println("Размен невозможен!");
        }
    }

    public static void exchange(int Note, int pos, String Result) {
            if (Note == 0) {
                System.out.println(Result);
                C = true;
            } else {
                if (pos < NominalValues.size()) {
                    for (int i = Note / NominalValues.get(pos); i > 0; i--) {
                        String Temp = Result;
                        for (int k = 0; k < i; k++) {
                            Temp += NominalValues.get(pos).toString() + " ";
                        }
                        exchange(Note - i*NominalValues.get(pos),pos+1, Temp);
                    }
                    exchange(Note, pos+1, Result + "");
                }
            }
    }
}
