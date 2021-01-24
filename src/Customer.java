public class Customer {
    private Menu[] order;
    private boolean served;
    private int total;

    public Customer(Menu[] order, boolean served){
        this.order = order;
        this.served = served;
        this.total = 0;
    }

    public Menu[] getOrder(){ return this.order; }

    public boolean isServed(){ return this.served; }


    public void setServed(boolean served){ this.served = served; }

    public void setTotal(int total){ this.total = total; }
}
