package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.ItemDTO;

import java.util.*;

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
        this.itemQuantityListInSale = new ArrayList<Integer>();
        this.totalPriceForSale = 0;
        this.totalVatPrice = 0;
        this.totalItemQuantityInSale = 0;
    }

    /**
     * adds an item to the sale. One arraylist for the item itself and one arraylist
     * for the quantity. Will be positioned on the same index.
     * @param itemDTO
     * @param quantity
     */
    public void addItem(ItemDTO itemDTO, int quantity){
        itemListInSale.add(itemDTO);
        itemQuantityListInSale.add(quantity);
        this.totalPriceForSale += itemDTO.getItemPrice() * quantity;
        this.totalVatPrice += itemVATPrice(itemDTO) * quantity;
        this.totalItemQuantityInSale += quantity;
    }

    private double itemVATPrice(ItemDTO itemDTO) {
        return itemDTO.getItemVATRate() * itemDTO.getItemPrice();
    }

    public ArrayList<ItemDTO> getItemListInSale() {
        return itemListInSale;
    }

    public List<Integer> getItemQuantityListInSale() {
        return itemQuantityListInSale;
    }

    public double getTotalPriceForSale() {
        return totalPriceForSale;
    }

    public double getTotalVatPrice() {
        return totalVatPrice;
    }

    public double getTotalPriceIncVat(){
        return getTotalPriceForSale() + getTotalVatPrice();
    }

    public void setItemListInSale(ArrayList<ItemDTO> itemListInSale) {
        this.itemListInSale = itemListInSale;
    }

    public void setItemQuantityListInSale(List<Integer> itemQuantityListInSale) {
        this.itemQuantityListInSale = itemQuantityListInSale;
    }

    public void setTotalPriceForSale(double totalPriceForSale) {
        this.totalPriceForSale = totalPriceForSale;
    }

    public void setTotalVatPrice(double totalVatPrice) {
        this.totalVatPrice = totalVatPrice;
    }

    public int getTotalItemQuantityInSale() {
        return totalItemQuantityInSale;
    }
}
