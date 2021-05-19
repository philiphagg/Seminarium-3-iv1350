package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.ItemDTO;

import java.util.*;


/**
 * Class that handles instances of sale processes.
 */
public class Sale {
    ArrayList<ItemDTO> itemListInSale;
    List<Integer> itemQuantityListInSale;
    double totalPriceForSale;
    double totalVatPrice;
    int totalItemQuantityInSale;

    /**
     * Creates a new sale instance.
     */
    public Sale() {
        this.itemListInSale = new ArrayList<>();
        this.itemQuantityListInSale = new ArrayList<>();
        this.totalPriceForSale = 0;
        this.totalVatPrice = 0;
        this.totalItemQuantityInSale = 0;
    }

    /**
     * adds an item to the sale. One arraylist for the item itself and one arraylist
     * for the quantity. Will be positioned on the same index. If item is not found
     * it will update the value in the quantity list instead of adding duplicate DTO
     * Also updates attributes for:
     *
     * Total price of the sale
     * total vat price of the sale
     * total items in current sale
     *
     * @param itemDTO
     * @param quantity
     */
    public void addItem(ItemDTO itemDTO, int quantity) throws InvalidIdentifierException {
        if(itemDTO.getItemName() == "invalid"){
            throw new InvalidIdentifierException("identifier is invalid: " +itemDTO.getItemIdentifier());
        }
        if(!itemAlreadyScanned(itemDTO)) {
            itemListInSale.add(itemDTO);
            itemQuantityListInSale.add(quantity);
        }
        else {
            updateAlreadyScannedItem(itemDTO, quantity);
        }
        this.totalPriceForSale += itemDTO.getItemPrice() * quantity;
        this.totalVatPrice += itemVATPrice(itemDTO) * quantity;
        this.totalItemQuantityInSale += quantity;
    }

    private void updateAlreadyScannedItem(ItemDTO itemDTO, int quantity) {
        for(int index = 0; index < itemListInSale.size(); index++){
            if(itemFound(itemDTO, index)){
                updateQuantityList(quantity, index);
            }
        }


    }


    private boolean itemFound(ItemDTO itemDTO, int index) {
        return itemListInSale.get(index).getItemIdentifier() == itemDTO.getItemIdentifier();
    }

    private void updateQuantityList(int quantity, int index) {
        int previous = itemQuantityListInSale.get(index);
        int newValue = previous + quantity;
        this.itemQuantityListInSale.set(index, newValue);
    }

    private boolean itemAlreadyScanned(ItemDTO itemDTO){

        return itemListInSale.contains(itemDTO);
    }

    private double itemVATPrice(ItemDTO itemDTO) {
        return itemDTO.getItemVATRate() * itemDTO.getItemPrice();
    }


    /**
     * Extracts attributes of sale object
     *
     * @return list of items in current sale
     */
    public ArrayList<ItemDTO> getItemListInSale() {
        return itemListInSale;
    }

    /**
     * Extracts attributes of sale object
     *
     * @return list of quantitys connected to the current sale and items
     */
    public List<Integer> getItemQuantityListInSale() {
        return itemQuantityListInSale;
    }

    /**
     * Extracts attributes of sale object
     *
     * @return total price for the entire sale ex vat
     */
    public double getTotalPriceForSale() {
        return totalPriceForSale;
    }

    /**
     * Extracts attributes of sale object
     *
     * @return total vat price for the entire sale
     */
    public double getTotalVatPrice() {
        return totalVatPrice;
    }

    /**
     * Extracts attributes of sale object
     *
     * @return total price including vat
     */
    public double getTotalPriceIncVat(){
        return getTotalPriceForSale() + getTotalVatPrice();
    }

    /**
     * sets a value to an attribute in sales object
     *
     * @param totalPriceForSale sets total price for entire sale
     */
    public void setTotalPriceForSale(double totalPriceForSale) {
        this.totalPriceForSale = totalPriceForSale;
    }


    /**
     * sets a value to an attribute in sales object
     *
     * @param totalVatPrice sets total vat price for entire sale
     */
    public void setTotalVatPrice(double totalVatPrice) {
        this.totalVatPrice = totalVatPrice;
    }

    /**
     * Extracts attributes of sale object
     *
     * @return total of items in current sale
     */
    public int getTotalItemQuantityInSale() {
        return totalItemQuantityInSale;
    }
}
