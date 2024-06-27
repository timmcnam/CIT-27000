package Lab02;

import java.util.Scanner;

public class Lab02Task02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("What is the number of shares bought and sold?");
        int Number_of_shares = scanner.nextInt();
        // chose to do int for the the number of shares since you realistically
        // wouldn't sell 0.1 of a share.

        System.out.println("What is the purchase price per share?");
        double Purchase_price = scanner.nextDouble();

        System.out.println("What is the purchase commission?");
        double Purchase_commission = scanner.nextDouble();

        System.out.println("What is the sale price per share?");
        double Sale_price = scanner.nextDouble();

        System.out.println("What is the sale commission?");
        double Sale_commission = scanner.nextDouble();
        
        double sharePrice = ((double)Number_of_shares * Purchase_price ) 
        				      - ((double)Number_of_shares * Sale_price );
        
        double commissionTotal = ((double)Number_of_shares * Purchase_price * Purchase_commission )
        						+ ((double)Number_of_shares * Sale_price * Sale_commission );
        
        double net_Price = commissionTotal + sharePrice ;
        
        System.out.println("The net loss is " + net_Price);
	}

}
