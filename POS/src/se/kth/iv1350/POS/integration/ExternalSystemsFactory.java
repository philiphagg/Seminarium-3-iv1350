package se.kth.iv1350.POS.integration;

/**
 * Class creates and bundles tasks inside a composite
 *
 */
public class ExternalSystemsFactory {
    Composite composite;

    /**
     * Creates a new instance of this class. Bundles the composite
     */
    public ExternalSystemsFactory() {
        this.composite = new Composite();
        composite.addTask( new UpdateInventorySystem(), new UpdateAccountingSystem());
    }

    /**
     * Returns the bundled composite
     *
     * @return specific composite
     */
    public Composite getComposite() {
        return composite;
    }
}
