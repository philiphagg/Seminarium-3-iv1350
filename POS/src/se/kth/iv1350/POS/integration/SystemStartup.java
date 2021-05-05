package se.kth.iv1350.POS.integration;

public class SystemStartup {
    InventorySystem inventorySystem;
    AccountingSystem accountingSystem;
    Register register;
    Printer printer;




    public SystemStartup(){
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
        this.register = new Register();
        this.printer = new Printer();
    }

    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    public Register getRegister() {
        return register;
    }

    public Printer getPrinter() {
        return printer;
    }
}
