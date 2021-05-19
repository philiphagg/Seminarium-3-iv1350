package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.controller.Controller;

import java.util.ArrayList;

/**
 * class that handles the external inventorysystem. for this excercise
 * a hardcoded list is created for test purposes.
 */

public class InventorySystem {
    ItemDTO itemDTO;
    ArrayList<ItemDTO> inventoryItemList;
    ArrayList<Integer> inventoryQuantityList;

    InventorySystem() {
        inventoryItemList = new ArrayList<>();
        inventoryQuantityList = new ArrayList<>();
        inventoryItemList.add(new ItemDTO(1,0.25, 10,"Fantastiskt god mjölk", "mjölk"));
        inventoryItemList.add(new ItemDTO(2,0.06, 20,"underbara bullar", "bulle"));
        inventoryItemList.add(new ItemDTO(3,0.12, 30,"nybakat bröd", "bröd"));
        inventoryItemList.add(new ItemDTO(4,0.25, 40,"innovativt kaffefilter med superfunktioner", "kaffefilter"));
        inventoryItemList.add(new ItemDTO(5,0.25, 10,"Item generates DB error", "RandomItem"));
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
    public ItemDTO getDetails(int identifier) throws DBFailureException {

        return findItem(identifier);
    }
    private ItemDTO findItem(int identifier) throws DBFailureException {
        if(identifier == 5)
            throw new DBFailureException("error code: 125454213");
        for (int index = 0; index < inventoryItemList.size(); index++){
            itemDTO = inventoryItemList.get(index);
                if (itemFound(identifier))
                    return itemDTO;

        }

        return new ItemDTO(identifier,0,0,"invalid", "invalid");
    }
    private boolean itemFound(int identifier){
        return itemDTO.getItemIdentifier() == identifier;
    }


}
