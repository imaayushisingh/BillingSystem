import java.util.Scanner;
public class Inventory {
    Product[] arrOfPro = new Product[0];
    Product[] newProductArr = {
            new Product(123,40.0,10,"Plate"),
            new Product(456,20.0,15,"Spoon"),
            new Product(789,2000.0,8,"Cooker"),
            new Product(321,30.0,25,"glass"),
            new Product(654,20.0,20,"fork")
    };
    public  void addProduct(){
        Product temPr = new Product();
        Scanner input = new Scanner(System.in);
        System.out.print("enter product id: ");
        int productId = input.nextInt();
        temPr.setProId(productId);
        System.out.print("enter name of product: ");
        String name = input.next();
        temPr.setName(name);
        System.out.print("enter mrp: ");
        double mrp = input.nextDouble();
        temPr.setMrp(mrp);
        System.out.print("enter quantity: ");
        int qty = input.nextInt();
        temPr.setQty(qty);
        Product[] tempArr = new Product[arrOfPro.length+1];
        for(int i = 0; i< arrOfPro.length; i++){
            tempArr[i] = arrOfPro[i];
        }
        tempArr[arrOfPro.length] = temPr;
        arrOfPro = tempArr;
        System.out.println("Product added successfully!");
    }
    public void getDetails(int productId){
        for(int i = 0; i< arrOfPro.length; i++){
            if(arrOfPro[i].getProId()==productId){
                System.out.println("---------------------------------------------------------------");
                System.out.printf("%4s %5s %15s %5s %4s %5s %15s","Id","|","Name","|","Qty","|","Mrp");
                System.out.println();
                System.out.println("---------------------------------------------------------------");
                System.out.printf("%4d %5s %15s %5s %4d %5s %15f",arrOfPro[i].getProId(),"|",arrOfPro[i].getMrp(),"|",arrOfPro[i].getQty(),"|",arrOfPro[i].getMrp());
                System.out.println();
            }
        }
        System.out.println();
    }
    public void getOutOfStock(){
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%4s %5s %15s %5s %4s %5s %15s","Id","|","Name","|","Qty","|","Mrp");
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        for(int i = 0; i< arrOfPro.length; i++){
            if(arrOfPro[i].getQty()==0){
                System.out.printf("%4d %5s %15s %5s %4d %5s %15f",arrOfPro[i].getProId(),"|",arrOfPro[i].getMrp(),"|",arrOfPro[i].getQty(),"|",arrOfPro[i].getMrp());
                System.out.println();
            }
            System.out.println();
        }
    }
    public Product getProduct(int proId,int qty){
       for(int i=0;i< newProductArr.length;i++){
           if(newProductArr[i].getProId()==proId){
               if(qty<=newProductArr[i].getQty()){
                   saleTracker(qty,i);
                   return newProductArr[i];
               }
               else{
                   System.out.println("Insufficient Quantity!");
                   return null;
               }


           }
//           else{
//               return null;  //had to remove this because function terminates as soon as it encounters return statement
//           }
        }
        return null;
    }
    public void saleTracker(int quantity,int index){
       int finalQty = newProductArr[index].getQty()-quantity;
       newProductArr[index].setQty(finalQty);
    }
}



