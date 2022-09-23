public class Product {
    private int proId;
    private double mrp;
    private int qty;
    private String name;
    Product(int proId, double mrp, int qty, String name){
        this.proId=proId;
        this.mrp=mrp;
        this.qty=qty;
        this.name=name;
    }
    Product(){}
    public void setProId(int proId) {
        this.proId = proId;
    }
    public void setMrp(double mrp) {
        this.mrp = mrp+(mrp*0.18);
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMrp() {
        return mrp;
    }
    public int getQty() {
        return qty;
    }
    public String getName() {
        return name;
    }
    public int getProId() {
        return proId;
    }
    public int sell(int qty){
        this.qty = this.qty-qty;
        return this.qty;
    }
}

