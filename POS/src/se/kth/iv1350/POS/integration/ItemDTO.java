package se.kth.iv1350.POS.integration;

public class ItemDTO {
    private int itemIdentifier;
    private double itemVATRate;
    private double itemPrice;
    private String itemDescription;
    private String itemName;

    /**
     * Creates a new item data transfer object instance. Used to send data
     * between different layers
     * @param identifier        identifier of the item
     * @param VATRate           VAT rate for the item
     * @param price             priceing of the item
     * @param itemDescription   description of the item
     * @param itemName          name of the item
     */
    ItemDTO(int identifier, double VATRate, double price, String itemDescription, String itemName) {
        this.itemIdentifier = identifier;
        this.itemVATRate = VATRate;
        this.itemPrice = price;
        this.itemDescription = itemDescription;
        this.itemName = itemName;
    }

    public int getItemIdentifier() {
        return itemIdentifier;
    }

    public double getItemVATRate() {
        return itemVATRate;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }
}
