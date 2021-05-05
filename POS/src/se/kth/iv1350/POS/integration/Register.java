package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.Sale;

public class Register {
    private double amountInRegister;

    Register(){
        this.amountInRegister = 100;
    }

    /**
     * updates the register after sale has been paid
     *
     * @param amountPaid    amount paid by the customer
     * @param saleDetails   the object holding all information about current sale
     * @return              amount change
     */
    public double updateRegister(double amountPaid, Sale saleDetails){

        setAmountInRegister(amountInRegisterAfterPayment(saleDetails));

        return amountChange(amountPaid, saleDetails);
    }

    private double amountInRegisterAfterPayment(Sale saleDetails) {
        return getAmountInRegister() + saleDetails.getTotalPriceIncVat();
    }

    private double amountChange(double amountPaid, Sale saleDetails) {
        return amountPaid - saleDetails.getTotalPriceIncVat();
    }

    private double getAmountInRegister() {
        return amountInRegister;
    }

    private void setAmountInRegister(double amountInRegister) {
        this.amountInRegister = amountInRegister;
    }
}
