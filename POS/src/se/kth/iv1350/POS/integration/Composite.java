package se.kth.iv1350.POS.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * implements the Composite design pattern. Responsible for
 * adding tasks and performing tasks, in this case, logging to
 * external systems.
 */
public class Composite implements UpdateExternalSystems{
    List<UpdateExternalSystems> updateSystems;

    /**
     * Creates a new instance of the composite and defines
     * the list.
     */
    public Composite() {
        this.updateSystems = new ArrayList<>();
    }

    /**
     * Performs the tasks that are collected in the list <code>updateSystems</code>
     *
     * @param receiptDTO    Receipt to be logged in external systems
     */
    @Override
    public void updateSystem(ReceiptDTO receiptDTO) {
        for(UpdateExternalSystems updateExternalSystems : updateSystems){
            updateExternalSystems.updateSystem(receiptDTO);
        }
    }

    /**
     * Add tasks to the <code>updateSystems</code> list
     *
     * @param UIS   UpdateInventorySystem object
     * @param UAS   UpdateAccoungSystem object
     */
    void addTask(UpdateInventorySystem UIS, UpdateAccountingSystem UAS){
        updateSystems.add(UIS);
        updateSystems.add(UAS);

    }

}
