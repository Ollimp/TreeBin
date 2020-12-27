package university;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    private static String[] action = new String[]{
            "Добавить элемент",
            "Удалить элемент",
            "Cимметричный",
            "Прямой",
            "Обратный",
            "Вывести все элементы",
            "Выйти"
    };
    public static void main(String[] args) {
	// write your code here
        Tree myTree=new Tree();
        Scanner scanner=new Scanner(System.in);
        int y=0;
        System.out.println("---------------------");
        boolean exit = false;
        while (!exit) {
            showChoices();
            int choice = scanner.nextInt() - 1;
            switch (choice) {
                case 0:
                    out.println("Введите длину набора");
                     y=scanner.nextInt();
                    for(int i=0;i<y;i++) {
                        out.println("Введите элемент");
                        try {
                            myTree.add(scanner.nextInt(), i);
                            out.println("Элемент добавлен");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    out.println("Введите элемент, который нужно удалить");
                    myTree.decRenat(0,scanner.nextInt());
                    break;
                case 2:
                    out.println("Cимметричный");
                    myTree.decRenat(1,0);
                    break;
                case 3:
                    out.println("Прямой");
                    myTree.decRenat(2,0);
                    break;
                case 4:
                    out.println("Обратный");
                    myTree.decRenat(3,0);
                    break;
                case 5:
                    out.println("Вывести все элементы");
                    System.out.println(myTree.getRoot());
                    System.out.println(myTree.checkKey(0));
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    break;
            }

        }

        System.out.println("---------------------");
    }
    private static void showChoices() {
        out.println("Что вы хотите сделать?");
        for (int i = 0; i < action.length; i++)
            out.println(" " + (i + 1) + ". " + action[i]);
    }
}
