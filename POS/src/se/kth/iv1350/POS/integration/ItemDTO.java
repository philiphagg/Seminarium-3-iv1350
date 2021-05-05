package se.kth.iv1350.POS.integration;

/**
 * Data transfor object thats purpose is to transfer data between layers
 * in the application.
 */
public class ItemDTO {
    private int itemIdentifier;
    private double itemVATRate;
    private double itemPrice;
    private String itemDescription;
    private String itemName;

    /**
     * Creates a new item data transfer object instance. Used to send data
     * between different layers
     *
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

    /**
     * extracts information from object ItemDTO
     *
     * @return  identifier of the item
     */
    public int getItemIdentifier() {
        return itemIdentifier;
    }
    /**
     * extracts information from object ItemDTO
     *
     * @return  Vat rate for the item
     */

    public double getItemVATRate() {
        return itemVATRate;
    }


    /**
     * extracts information from object ItemDTO
     *
     * @return  price of the item
     */

    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * extracts information from object ItemDTO
     *
     * @return  descripion of the item
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * extracts information from object ItemDTO
     *
     * @return  name of the item.
     */
    public String getItemName() {
        return itemName;
    }
}
