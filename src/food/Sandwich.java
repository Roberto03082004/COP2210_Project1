package food;

public class Sandwich {
    String bread;
    private boolean meat;
    private boolean cheese;
    private boolean veggies;
    private double price;

    public Sandwich(boolean meat, boolean cheese, boolean veggies){
        bread = "White";

        // if else for all combinations of the sandwichs
        // set the price of each conbination
        // see project document for prices
        // YOUR CODE HERE

        //ALL 3 Toppings = $7.99
        //Meat & Cheese without veggies = $7.59
        //Meat without Cheese and with veggies = $7.09
        //Only Meat = $6.89
        //Without meat with cheese and veggies = $5.99
        //Only veggies = $5.09
        //Just bread = 4.99


        //Bread cost $4.99
        //Meat cost $1.90
        //Cheese cost $1.00
        //Veggies cost $0.10
        this.meat=meat;
        this.cheese=cheese;
        this.veggies=veggies;


        if ( meat && cheese && veggies) {
            price = 7.99;
        } else if (meat && cheese && !veggies) {
            price = 7.59;
        } else if (meat && !cheese && veggies) {
            price = 7.09;
        } else if (meat && !cheese && !veggies) {
            price = 6.89;
        } else if (!meat && cheese && veggies) {
            price = 5.99;
        } else if(!meat && cheese && !veggies) {
            price = 5.59;
        } else if (!meat && !cheese && veggies) {
            price = 5.09;
        } else if (!meat && !cheese && !veggies) {
            price = 4.99;
        } else {
            System.out.println("Error");
            return;  // Exit the code if no valid combination is found
        }


        //this.meat = hasMeat;
        //this.cheese = cheese;
        //this.veggies= veggies;

    }
    public Sandwich(String bread, boolean meat, boolean cheese, boolean veggies){
        this(meat, cheese, veggies);
        this.bread = bread;

        if (meat && cheese && veggies) {
            price = 7.99;
        } else if (meat && cheese && !veggies) {
            price = 7.59;
        } else if (meat && !cheese && veggies) {
            price = 7.09;
        } else if (meat && !cheese && !veggies) {
            price = 6.89;
        } else if (!meat && cheese && veggies) {
            price = 5.99;
        } else if(!meat && cheese && !veggies) {
            price = 5.59;
        } else if (!meat && !cheese && veggies) {
            price = 5.09;
        } else if (!meat && !cheese && !veggies) {
            price = 4.99;
        } else {
            System.out.println("Error");
            return;  // Exit the code if no valid combination is found
        }

    }
    String getBread(){
        return bread;
    }
    public void setBread(String bread){
        this.bread = bread;
    }
    public boolean isMeat(){
        return meat;
    }
    public void setMeat(boolean meat){
        this.meat = meat;
    }
    public boolean isCheese(){
        return cheese;
    }
    public void setCheese(boolean cheese){
        this.cheese = cheese;
    }
    public boolean isVeggies(){
        return veggies;
    }
    public void setVeggies(boolean veggies){
        this.veggies = veggies;
    }
    public double price(){
        return price;
    }
    public void displayInfo(){
        System.out.println("==========================================");
        System.out.println("Sandwich Info");
        System.out.println("==========================================");
        System.out.printf("Bread:\t\t\t\t\t %-15s\n", bread);
        System.out.printf("Meat:\t\t\t\t\t %-15b \n", meat);
        System.out.printf("Cheese:\t\t\t\t\t %-15s\n", cheese);
        System.out.printf("Veggies:\t\t\t\t %-15b \n", veggies);
        System.out.printf("Price:\t\t\t\t\t $%-15.2f\n", price);



    }

}//end of Sandwich




