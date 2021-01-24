public class Menu {
    private FoodType name;
    private int price;
    private int timeToPrepare;

    public Menu(FoodType name, int price, int timeToPrepare){
        this.name = name;
        this.price = price;
        this.timeToPrepare = timeToPrepare;
    }

    public int getPrice(){ return this.price;    }

    public FoodType getName(){ return this.name;}

    public int getTimeToPrepare(){ return this.timeToPrepare; }
}
