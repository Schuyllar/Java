package BasketBuild;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketBuild {

    // Instance variables
    private char basketType;
    private String accessoryType;
    private int customerType;
    private String state;

    private double basketCost;
    private double accessoryCost;
    private double discount;
    private double tax;
    private double totalCost;

    public BasketBuild() {
        this.basketType = 'U';
        this.accessoryType = "A4";
        this.customerType = 1;
        this.state = "IA";
    }

    public BasketBuild(char basketType, String accessoryType, int customerType, String state) {
        this.basketType = basketType;
        this.accessoryType = accessoryType;
        this.customerType = customerType;
        this.state = state;
    }

    public char getBasketType() {
        return basketType;
    }

    public void setBasketType(char basketType) {
        this.basketType = basketType;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Calc costs
    public void calculate() {
        // Basket Cost Calcs
        switch (basketType) {
            case 'C':
                basketCost = 15.00;
                break;
            case 'W':
                basketCost = 53.25;
                break;
            case 'K':
                basketCost = 23.15;
                break;
            case 'M':
                basketCost = 34.20;
                break;
            case 'U':
                basketCost = 112.77;
                break;
            default:
                basketCost = 112.77; // Default to umbrella basket
        }

        // Accessories
        switch (accessoryType) {
            case "A1":
                accessoryCost = 4.75;
                break;
            case "A2":
                accessoryCost = 8.00;
                break;
            case "A3":
                accessoryCost = 10.55;
                break;
            case "A4":
                accessoryCost = 0.00;
                break;
            default:
                accessoryCost = 0.00; // Default to none
        }

        // Basket Amount
        double basketAmount = basketCost + accessoryCost;

        // CustDiscount
        double discountRate = switch (customerType) {
            case 1 -> 0.50; // Dealer
            case 3 -> 0.10; // Bus
            default -> 0.00; // Walk-in or invalid input
        };
        discount = basketAmount * discountRate;

        // Subtotal
        double subtotal = basketAmount - discount;

        // State Tax
        double taxRate = switch (state) {
            case "IA" -> 0.06;
            case "IL" -> 0.0625;
            case "MO" -> 0.04225;
            default -> 0.06; // Default to IA tax rate
        };
        tax = (customerType == 1) ? 0 : subtotal * taxRate; // Dealers do not pay sales tax

        // Cost
        totalCost = subtotal + tax;
    }

    // Receipts
    public String generateReceipt() {
        DecimalFormat df = new DecimalFormat("#.00");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = sdf.format(new Date());

        return "Date: " + date +
                "\nBasket Type: " + basketType +
                "\nAccessory Type: " + accessoryType +
                "\nCustomer Type: " + customerType +
                "\nState: " + state +
                "\nBasket Cost: $" + df.format(basketCost) +
                "\nAccessory Cost: $" + df.format(accessoryCost) +
                "\nDiscount: $" + df.format(discount) +
                "\nTax: $" + df.format(tax) +
                "\nTotal Cost: $" + df.format(totalCost);
    }
}
