public class Restaurant {

    private Chef chef;
    private Customer[] customers;
    private Menu[] menu;

    public Restaurant(Chef chef, Customer[] customers, Menu[] menu) {
        this.chef = chef;
        this.customers = customers;
        this.menu = menu;
    }

    public int nextCustomer(){
        for(int i = 0; i < customers.length; i++){
            if(!customers[i].isServed()){
                return i;
            }
        }
        return -1;
    }

    public void simulation(){
        Menu[] currentOrder = new Menu[]{};

        while(nextCustomer() != -1){
            // gets next customer, if any
            int nextCustomer = nextCustomer();


            // take order
            if(nextCustomer != -1 && !chef.getChefStatus()){
                currentOrder = customers[nextCustomer].getOrder();
                chef.setChefStatus(true);
                customers[nextCustomer].setServed(true);
                System.out.println("    New customer! \n    Current Order:");
                for(int i = 0; i < currentOrder.length; i++){
                    System.out.println(currentOrder[i].getName().toString());
                }
            }


            //prepare current order
            int total = 0;
            for(int i = 0; i < currentOrder.length; i++) {
                if( i == 0) {
                    System.out.println("*Preparing current order*");
                    chef.setChefStatus(false);
                }
                total += currentOrder[i].getPrice();
                // this is where i stopped :/
            }
            if(total > 0){ System.out.println("*Food Ready*\nCustomer's total: $" + total); }
        }

    }

    public static void main(String[] args) {
        // initialize menu
        Menu burger = new Menu(FoodType.Burger, 9, 5);
        Menu hotdog = new Menu(FoodType.HotDog, 3, 2);
        Menu taco = new Menu(FoodType.Tacos, 2, 2);

        // initialize an order for each customer
        Menu[] order1, order2;
        order1 = new Menu[]{burger, burger, hotdog};
        order2 = new Menu[]{taco, taco, burger};

        // initialize restaurant with 1 chef, 2 customers, 3 menu items
        Restaurant restaurantSim = new Restaurant(new Chef(false),
                new Customer[]{new Customer(order1, false), new Customer(order2, false)},
                new Menu[]{burger, hotdog, taco});


        // run process
        restaurantSim.simulation();
    }
}
