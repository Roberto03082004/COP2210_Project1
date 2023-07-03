package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Register {

    private static int registerCounter = 0;
    private static final String REGISTERCODE = "US_FL_032020-";
    private static final double DOLLARVALUE = 1.00;
    private static final double QUATERVALUE = 0.25;
    private static final double DIMEVALUE = 0.10;
    private static final double NICKELVALUE = 0.05;
    private static final double PENNYVALUE = 0.01;
    private String registerID;
    private int numberOfOneDollarBills;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;
    private double currentTotal;


    public Register(int numberOfOneDollarBills, int numberOfQuarters, int numberOfDimes, int numberOfNickels, int numberOfPennies){
        registerCounter++;
        registerID = REGISTERCODE + registerCounter;
        currentTotal = 0.0;
        this.numberOfOneDollarBills = numberOfOneDollarBills;
        this.numberOfQuarters = numberOfQuarters;
        this.numberOfDimes = numberOfDimes;
        this.numberOfNickels = numberOfNickels;
        this.numberOfPennies = numberOfPennies;
    }
    private double cashValue(){
        return (numberOfOneDollarBills * DOLLARVALUE) +
                (numberOfQuarters * QUATERVALUE) +
                (numberOfDimes * DIMEVALUE) +
                (numberOfNickels * NICKELVALUE) +
                (numberOfPennies * PENNYVALUE);
    }
    public void cashInfo(String personal){

        if (personal.equals("Manager")) {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Valid");
            System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
            System.out.printf("Dollars:\t\t\t\t %-15d\n", numberOfOneDollarBills);
            System.out.printf("Quarters:\t\t\t\t %-15d\n", numberOfQuarters);
            System.out.printf("Dimes:\t\t\t\t\t %-15d\n", numberOfDimes);
            System.out.printf("Nickels:\t\t\t\t %-15d\n", numberOfNickels);
            System.out.printf("Pennies:\t\t\t\t %-15d\n", numberOfPennies);
            System.out.println();
        }else{
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Not Valid by " + personal);
            System.out.println();
        }

    }
    public void buyApple(Apple apple, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Apple");
        System.out.println("==========================================");
        System.out.printf("Apple Price:\t\t\t $%-15.2f\n" , apple.price());
        System.out.printf("Payment:\t\t\t\t $%-15.2f\n", payment.paymentValue());


        double shortAmount = apple.price() - payment.paymentValue();
        if(payment.paymentValue() < apple.price()){
            System.out.printf("You need:\t\t\t\t $%-15.2f\n",shortAmount );
            System.out.println("Sorry but you do not have enough money to buy the Apple");
            System.out.println("==========================================");
            System.out.println("\n");
        }else if(payment.paymentValue() >= apple.price()) {
            // hence call the giveChange method with the apple price and payment
            //System.out.printf("Apple Price:\t $-15.2f\n", apple.price());
            //System.out.printf("Payment:\t $-15.2f\n", payment.paymentValue());
            giveChange(apple.price(), payment);
            //System.out.printf("Dollars:\t\t\t\t %-15d\n" , numberOfOneDollarBills);
            //System.out.printf("Quarters:\t\t\t\t %-15d\n" , numberOfQuarters);
            //System.out.printf("Dimes:\t\t\t\t\t %-15d\n" , numberOfDimes);
            //System.out.printf("Nickels:\t\t\t\t %-15d\n" , numberOfNickels);
            //System.out.printf("Pennies:\t\t\t\t %-15d\n" , numberOfPennies);
        }

    }
    public void buySandwich(Sandwich sandwich, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Sandwich");
        System.out.println("==========================================");

        double shortAmount = sandwich.price() - payment.paymentValue();

        if(payment.paymentValue() < sandwich.price()) {
            System.out.printf("Sandwich Price:\t\t\t $%-15.2f\n", sandwich.price());
            System.out.printf("Payment:\t\t\t\t $%-15.2f\n", payment.paymentValue());
            System.out.printf("You need:\t\t\t\t $%-15.2f\n", shortAmount);
            System.out.println();
            System.out.println("Sorry but you do not have enough money to buy the Sandwich");
            System.out.println("==========================================");
            System.out.println("\n");
        }else if(payment.paymentValue() >= sandwich.price()){
            // hence call the giveChange method with the sandwich price and payment
            System.out.printf("Sandwich Price:\t\t\t $%-15.2f\n", sandwich.price());
            System.out.printf("Payment:\t\t\t\t $%-15.2f\n", payment.paymentValue());
            giveChange(sandwich.price(), payment);
        }

    }
    private void giveChange(double price, Payment payment){
        numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
        numberOfQuarters += payment.getNumberOfQuarters();
        numberOfDimes += payment.getNumberOfDimes();
        numberOfNickels += payment.getNumberOfNickels();
        numberOfPennies += payment.getNumberOfPennies();

        double neededChange = payment.paymentValue() - price;

        // Round to whole number to use the % operator for the change
        int neededChangeWhole = (int) Math.round(neededChange * 100);
        System.out.printf("Change:\t\t\t\t\t $%-15.2f\n", neededChange);

        // Calculate the dollars to give back
        int changeDollars = neededChangeWhole / 100;
        neededChangeWhole -= changeDollars * 100;

        // Calculate the quarters to give back
        int changeQuarters = neededChangeWhole / 25;
        neededChangeWhole -= changeQuarters * 25;

        // Calculate the dimes to give back
        int changeDimes = neededChangeWhole / 10;
        neededChangeWhole -= changeDimes * 10;

        // Calculate the nickels to give back
        int changeNickels = neededChangeWhole / 5;
        neededChangeWhole -= changeNickels * 5;

        // Calculate the pennies to give back
        int changePennies = neededChangeWhole;

        // Give the change back by removing the corresponding bills/coins from the register
        numberOfOneDollarBills -= changeDollars;
        numberOfQuarters -= changeQuarters;
        numberOfDimes -= changeDimes;
        numberOfNickels -= changeNickels;
        numberOfPennies -= changePennies;
        // Update other registers as needed

        // Output the change to the console
        System.out.printf("Dollars:\t\t\t\t %-15d\n", changeDollars);
        System.out.printf("Quarters:\t\t\t\t %-15d\n", changeQuarters);
        System.out.printf("Dimes:\t\t\t\t\t %-15d\n", changeDimes);
        System.out.printf("Nickels:\t\t\t\t %-15d\n", changeNickels);
        System.out.printf("Pennies:\t\t\t\t %-15d\n", changePennies);

        /*int neededChangeWhole = (int)Math.round(neededChange * 100);

        System.out.printf("Change: \t\t\t\t $%-15.2f\n", neededChange);

        numberOfOneDollarBills = neededChangeWhole;
        neededChange = neededChange - numberOfOneDollarBills * 100;

        numberOfQuarters = (int) (neededChange / 25);
        neededChange = neededChange - numberOfQuarters*25;

        numberOfDimes = (int) (neededChange /10);
        neededChange = neededChange - numberOfDimes*10;

        numberOfNickels = (int) (neededChange / 5);
        neededChange = neededChange - numberOfNickels*5;

        numberOfPennies = (int) (neededChange / 1);
        neededChange = neededChange - numberOfPennies*1;

        int changeDollars = 0;
        int changeQuarters = 0;
        int changeDimes = 0;
        int changeNickels = 0;
        int changePennies = 0;

        numberOfOneDollarBills -= changeDollars;
        numberOfQuarters -= changeQuarters;
        numberOfDimes -= changeDimes;
        numberOfNickels -= changeNickels;
        numberOfPennies -= changePennies;



        System.out.printf("Dollars1:\t\t\t\t %-15d\n", changeDollars);
        System.out.printf("Quarters1:\t\t\t\t %-15d\n", changeQuarters);
        System.out.printf("Dimes1:\t\t\t\t\t %-15d\n", changeDimes);
        System.out.printf("Nickels1:\t\t\t\t %-15d\n", changeNickels);
        System.out.printf("Pennies1:\t\t\t\t %-15d\n", changePennies);

         */






    }




}//end of Register
