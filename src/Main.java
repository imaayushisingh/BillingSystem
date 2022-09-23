import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean flag = true;
        while (flag) {
            System.out.println("enter 1 for adding the product");
            System.out.println("enter 2 for getting details according to the entered product id");
            System.out.println("enter 3 for getting details of products out of stock");
            System.out.println("enter 4 for exit: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    System.out.print("enter product id: ");
                    int proId = input.nextInt();
                    inventory.getDetails(proId);
                    break;
                case 3:
                    inventory.getOutOfStock();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
