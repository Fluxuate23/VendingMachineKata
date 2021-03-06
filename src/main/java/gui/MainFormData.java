package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFormData {
    protected static final String VENDING_MACHINE_LABEL_KEY = "VendingMachineLabelKey";
    protected static final String COIN_RETURN_LABEL_KEY = "CoinReturnLabelKey";
    protected static final String DISPENSED_ITEM_LABEL_KEY = "DispensedItemLabelKey";

    private PropertyChangeSupport propertyChangeSupport;
    private String oldFormattedCoinReturnText = "";
    private String oldDispensedItemName = "";

    public MainFormData() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void updateVendingDisplayLabel(String formattedVendingDisplayText) {
        propertyChangeSupport.firePropertyChange(VENDING_MACHINE_LABEL_KEY, "", formattedVendingDisplayText);
    }

    public void updateCoinReturnLabel(String formattedCoinReturnText) {
        propertyChangeSupport.firePropertyChange(COIN_RETURN_LABEL_KEY, oldFormattedCoinReturnText, formattedCoinReturnText);
        oldFormattedCoinReturnText = formattedCoinReturnText;
    }

    public void updateDispensedItemLabel(String dispensedItemName) {
        propertyChangeSupport.firePropertyChange(DISPENSED_ITEM_LABEL_KEY, oldDispensedItemName, dispensedItemName);
        oldDispensedItemName = dispensedItemName;
    }

    public void addUpdateVendingDisplayLabelListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(VENDING_MACHINE_LABEL_KEY, propertyChangeListener);
    }

    public void addUpdateCoinReturnDisplayLabelListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(COIN_RETURN_LABEL_KEY, propertyChangeListener);
    }

    public void addUpdateDispensedItemLabelListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(DISPENSED_ITEM_LABEL_KEY, propertyChangeListener);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }
}
