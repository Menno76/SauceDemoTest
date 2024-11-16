package Default;

public class checkoutSummary {
	
	class CheckoutSummary {
	    public static void main( String args[] ) {
		
		String first = "Payment Information";
		String second =  "SauceCard #31337"; 
		String third = "Shipping Information:";
		String fourth = "Free Pony Express Delivery!";
		String fifth = "Price Total";
        String sixth = "Item total: $31.98";
        String seventh = "Tax: $2.56";
        String eight = "Total: $34.54";
        
        String ninth = first + second + third + fourth + fifth + sixth + seventh + eight;
        
		//Log the checkout summary:
		System.out.println(ninth);


		}
	}

}
