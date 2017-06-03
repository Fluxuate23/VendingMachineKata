package gui;

import brain.VendingMachineBrain;
import enums.ECoin;
import gui.forms.MainForm;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainFormWrapper {

    private MainForm mainForm;
    private VendingMachineBrain vendingMachineBrain;
    private MainFormData mainFormData;

    public MainFormWrapper() {
        mainFormData = new MainFormData();
        vendingMachineBrain = new VendingMachineBrain(mainFormData);
        mainForm = new MainForm();
    }

    public void launchForm() {
        mainForm.setContentPane(mainForm.getHomePanel());
        mainForm.setVisible(true);
        mainForm.pack();

        mainForm.getInsertPennyButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.PENNY));
        mainForm.getInsertNickleButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.NICKLE));
        mainForm.getInsertDimeButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.DIME));
        mainForm.getInsertQuarterButton().addActionListener(e -> vendingMachineBrain.insertCoin(ECoin.QUARTER));

        mainFormData.addUpdateVendingDisplayLabelListener(this::updateVendingDisplayLabel);

    }

    protected void updateVendingDisplayLabel(PropertyChangeEvent propertyChangeEvent) {
        String updatedVendingDisplayLabelText = propertyChangeEvent.getNewValue().toString();
        mainForm.getVendingDisplayLabel().setText(updatedVendingDisplayLabelText);
    }

    public JButton retrieveInsertPennyButton() {
        return mainForm.getInsertPennyButton();
    }

    public JButton retrieveInsertNickleButton() {
        return mainForm.getInsertNickleButton();
    }

    public JButton retrieveInsertDimeButton() {
        return mainForm.getInsertDimeButton();
    }

    public JButton retrieveInsertQuarterButton() {
        return mainForm.getInsertQuarterButton();
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public JButton retrievePurchaseColaButton() {
        return mainForm.getPurchaseColaButton();
    }

    public JButton retrievePurchaseChipsButton() {
        return mainForm.getPurchaseChipsButton();
    }

    public JButton retrievePurchaseCandyButton() {
        return mainForm.getPurchaseCandyButton();
    }

    public JButton retrieveRefundButton() {
        return mainForm.getRefundButton();
    }

    public JLabel retrieveVendingDisplayLabel() {
        return mainForm.getVendingDisplayLabel();
    }

    public VendingMachineBrain getVendingMachineBrain() {
        return vendingMachineBrain;
    }

    public void setVendingMachineBrain(VendingMachineBrain vendingMachineBrain) {
        this.vendingMachineBrain = vendingMachineBrain;
    }

    public void setMainFormData(MainFormData mainFormData) {
        this.mainFormData = mainFormData;
    }
}
