import java.util.Scanner;

public class Bill {
    static Inventory inventory = new Inventory();
    static void newBill(){
        Scanner input_2 = new Scanner(System.in);
        System.out.print("enter your address: ");
        String address = input_2.nextLine();
        System.out.print("Enter your name: ");
        String name = input_2.nextLine();
        System.out.print("enter your phone num: ");
        long phnNum = input_2.nextLong();
        int billNum = 1234;
        boolean flag = true;
        Product[] productList = new Product[0];
        int[] qtyArr = new int[0];
        System.out.println("Enter product Id to add product,'exit' for not entering any further products!");
        while(flag){
            String proId = input_2.next();
            int qty=0;
            boolean flag_2=true;
            for(int i=0;i<proId.length();i++){
                if(!(Character.isDigit(proId.charAt(i)))){
                    flag_2=false;
                }
            }
            if(flag_2){
                    System.out.print("Enter Quantity: ");
                    qty = input_2.nextInt();
                Product[] tempArr = new Product[productList.length+1];
                int[] tempArr_2 = new int[qtyArr.length+1];
                for(int i=0; i<productList.length;i++){
                    tempArr[i]=productList[i];
                    tempArr_2[i]=qtyArr[i];
                }
                tempArr[productList.length]=inventory.getProduct(Integer.parseInt(proId),qty);
                tempArr_2[qtyArr.length]=qty;
                productList=tempArr;
                qtyArr=tempArr_2;
                }
            else{
                if(proId.equals("exit")||proId.equals("EXIT")||proId.equals("Exit")){
                    flag=false;
                }
                else{
                    System.out.println("Invalid Input!");
                }
            }
        }
//            switch (choice_2){
//                case 1:
//                    System.out.print("enter ID of desired product and it's qty: ");
//                    int proID = input_2.nextInt();
//                    int qty = input_2.nextInt();
//                    Product[] tempArr = new Product[productList.length+1];
//                    int[] tempArr_2 = new int[qtyArr.length+1];
//                    for(int i=0; i<productList.length;i++){
//                        tempArr[i]=productList[i];
//                        tempArr_2[i]=qtyArr[i];
//                    }
//                    tempArr[productList.length]=inventory.getProduct(proID);
//                    tempArr_2[qtyArr.length]=qty;
//                    productList=tempArr;
//                    qtyArr=tempArr_2;
//                    break;
//                case 2:
//                    flag=false;
//                    break;
//                default:
//                    System.out.println("Invalid Choice!");
//            }
//        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%46s %n","Himalayan Crockery");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%6s %-10s","Name:",name);
        System.out.printf("%44s %4s %n","Bill No:",billNum);
        System.out.printf("%7s %10d %n","Phone:",phnNum);
        System.out.printf("%9s %-60s %n","Address:",address);
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%5s %2s %15s %6s %5s %2s %5s %2s %7s %n"," SNo.","|","     Particular","|","  Qty","|","  MRP","|","  Price");
        System.out.println("-------------------------------------------------------------------------");
        double total = 0;
        for(int i=0;i<productList.length;i++){
            if(productList[i]!=null){
                System.out.printf("%5s %2s %15s %6s %5s %2s %5s %2s %7s %n",i+1,"|",productList[i].getName(),"|",qtyArr[i],"|",productList[i].getMrp(),"|",(qtyArr[i]*productList[i].getMrp()));
                total=total+(qtyArr[i]*productList[i].getMrp());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%6s %55f %n","Total:",total);
        double taxSum = (total*0.18);
        System.out.printf("%11s %50f %n","Taxes(18%):",taxSum);
        double finalSum = total+taxSum;
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%12s %49f %n","Net Payable:",finalSum);
        System.out.println("-------------------------------------------------------------------------");
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("enter 1.New Bill 2.Get Bill 3.Exit");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    newBill();
                    break;
                case 2:
                    break;
                case 3:
                    flag =false;
                default:
                    System.out.println("Invalid Choice!");

            }

        }
    }

}
