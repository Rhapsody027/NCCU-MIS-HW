import java.util.Scanner;

public class Final {
    public static void main(String[] args) throws Exception {
        AVL_Tree avl = new AVL_Tree();

        try (Scanner sc = new Scanner(System.in)) {
            // 輸入格式:
            // a 1，代表新增資料為1的節點
            // d 1，代表移除資料為1的節點
            // q，代表結束輸入

            System.out.println(
                    "('a' for 'add' and 'd' for 'del', separate data with space)\nPlease enter some commands: ");
            String input = "";

            while (!input.equalsIgnoreCase("q")) {
                input = sc.nextLine();
                String[] arr = input.split(" ");

                try {
                    if (arr[0].equals("a") && arr.length == 2) {
                        avl.add(Integer.parseInt(arr[1]));
                    } else if (arr[0].equals("d") && arr.length == 2) {
                        avl.del(Integer.parseInt(arr[1]));
                    } else if (!input.equalsIgnoreCase("q")) {
                        System.out.println("Invalid input. Please Enter again!!\n");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please Enter again!!\n");
                }
            }
        }

        System.out.println("\nFinal Result:\n" + avl.getInfo());
        System.out.print("All data: ");
        avl.inOrder(avl.getRoot());
    }
}
