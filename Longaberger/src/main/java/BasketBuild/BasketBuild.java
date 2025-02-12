package BasketBuild;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasketBuild {

    private static final char[] BASKET_TYPES = {'C', 'W', 'K', 'M', 'U'};
    private static final String[] BASKET_LITERALS = {"Cracker", "Wildflower", "Key", "Magazine", "Umbrella"};
    private static final double[] BASKET_COSTS = {15.00, 53.25, 23.15, 34.20, 112.77};

    private static final String[] ACCESSORY_CODES = {"A1", "A2", "A3", "A4"};
    private static final String[] ACCESSORY_LITERALS = {"Protector", "Liner", "Combo", "None"};
    private static final double[] ACCESSORY_COSTS = {4.75, 8.00, 10.55, 0.00};

    private static final String[] CUSTOMER_TYPE_LITERALS = {"Dealer", "Walk-in", "Bus"};
    private static final double[] DISCOUNT_PERCENTAGES = {0.50, 0.00, 0.10};

    private char basketType;
    private String accessoryType;
    private int customerType;
    private String state;

    private double basketCost;
    private double accessoryCost;
    private double discount;
    private double tax;
    private double totalCost;
    private String basketLiteral;
    private String accessoryLiteral;
    private String customerLiteral;

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

    public void calculate() {
        int basketIndex = -1;
        for (int i = 0; i < BASKET_TYPES.length; i++) {
            if (BASKET_TYPES[i] == basketType) {
                basketIndex = i;
                break;
            }
        }
        if (basketIndex != -1) {
            basketCost = BASKET_COSTS[basketIndex];
            basketLiteral = BASKET_LITERALS[basketIndex];
        }

        int accessoryIndex = -1;
        for (int i = 0; i < ACCESSORY_CODES.length; i++) {
            if (ACCESSORY_CODES[i].equals(accessoryType)) {
                accessoryIndex = i;
                break;
            }
        }
        if (accessoryIndex != -1) {
            accessoryCost = ACCESSORY_COSTS[accessoryIndex];
            accessoryLiteral = ACCESSORY_LITERALS[accessoryIndex];
        }

        int customerIndex = customerType - 1;
        if (customerIndex >= 0 && customerIndex < CUSTOMER_TYPE_LITERALS.length) {
            customerLiteral = CUSTOMER_TYPE_LITERALS[customerIndex];
            discount = (basketCost + accessoryCost) * DISCOUNT_PERCENTAGES[customerIndex];
        }

        double subtotal = (basketCost + accessoryCost) - discount;

        double taxRate = switch (state) {
            case "IA" -> 0.06;
            case "IL" -> 0.0625;
            case "MO" -> 0.04225;
            default -> 0.06;
        };
        tax = (customerType == 1) ? 0 : subtotal * taxRate;
        totalCost = subtotal + tax;
    }

    public String generateReceipt() {
        DecimalFormat df = new DecimalFormat("#.00");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = sdf.format(new Date());

        return "Date: " + date +
                "\nBasket Type: " + basketLiteral +
                "\nAccessory Type: " + accessoryLiteral +
                "\nCustomer Type: " + customerLiteral +
                "\nState: " + state +
                "\nBasket Cost: $" + df.format(basketCost) +
                "\nAccessory Cost: $" + df.format(accessoryCost) +
                "\nDiscount: $" + df.format(discount) +
                "\nTax: $" + df.format(tax) +
                "\nTotal Cost: $" + df.format(totalCost);
    }
}
