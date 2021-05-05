package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.controller.Controller;

import java.util.ArrayList;

public class InventorySystem {
    Controller controller;
    ItemDTO itemDTO;
    //Item item;
    ArrayList<ItemDTO> inventoryItemList;
    ArrayList<Integer> inventoryQuantityList;
    ReceiptDTO receiptDTO;

    InventorySystem() {
        inventoryItemList = new ArrayList<>();
        inventoryQuantityList = new ArrayList<>();
        inventoryItemList.add(new ItemDTO(1,0.25, 10,"Fantastiskt god mjölk", "mjölk"));
        inventoryItemList.add(new ItemDTO(2,0.06, 20,"underbara bullar", "bulle"));
        inventoryItemList.add(new ItemDTO(3,0.12, 30,"nybakat bröd", "bröd"));
        inventoryItemList.add(new ItemDTO(4,0.25, 40,"innovativt kaffefilter med superfunktioner", "kaffefilter"));
    }


    /**
     * updates items in stock according to the receipt that was created.
     * this method sends information to external systems that we
     * have no further information about.
     *
     * @param receiptDTO    All available information about each sale
     */
    public void updateInventorySystem(ReceiptDTO receiptDTO){
        /**
         * this method sends information to external system.
         */

    }
    private void addItemToInventory(ItemDTO itemDTO,int quantity){
        inventoryItemList.add(itemDTO);
        inventoryQuantityList.add(quantity);
    }


    /**
     * Collects information about a specified item in the inventory system
     *
     * @param identifier    item identifier
     * @return              a newly creater itemdto with information found
     */
    public ItemDTO getDetails(int identifier){

        return findItem(identifier);
    }
    private ItemDTO findItem(int identifier){
        for (int index = 0; index < inventoryItemList.size(); index++){
            itemDTO = inventoryItemList.get(index);
                if (itemFound(identifier))
                    return itemDTO;
        }

        return itemDTO = null;
    }
    private boolean itemFound(int identifier){
        return itemDTO.getItemIdentifier() == identifier;
    }

    /*
    private ItemDTO createDTO(int identifier, int position){

        itemDTO = inventoryItemList.get(position);

        return this.itemDTO = new ItemDTO(identifier, itemDTO.getItemVATRate(), itemDTO.getItemPrice(), itemDTO.getItemDescription(), itemDTO.getItemName());

    }*/

/*
    private class Item{
        private double itemPrice;
        private String itemName;
        private int identifier;
        private int quantityInStock;

        private Item() {
            this.itemPrice = 0.0;
            this.itemName = null;
            this.identifier = 0;
        }

        private Item(double itemPrice, String itemName, int identifier) {
            this.itemPrice = itemPrice;
            this.itemName = itemName;
            this.identifier = identifier;
        }

        private int getQuantityInStock() {
            return quantityInStock;
        }

        private void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        private double getItemPrice() {
            return itemPrice;
        }

        private void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        private String getItemName() {
            return itemName;
        }

        private void setItemName(String itemName) {
            this.itemName = itemName;
        }

        private int getIdentifier() {
            return identifier;
        }

        private void setIdentifier(int identifier) {
            this.identifier = identifier;
        }
    }

 */
}
