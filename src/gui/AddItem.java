/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import backend.Inventory;
import backend.Item;
import backend.Manufacturer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author achcha
 */
public class AddItem extends javax.swing.JFrame {
    
    private static boolean isValidString(String check)
    {
//        System.out.println(check);
        check = check.strip();
        if(check.length() == 0)
            return false;
        boolean ok = true;
        for(int i = 0; i < check.length(); i++)
        {
            if(Character.isLetter(check.charAt(i)) || Character.isDigit(check.charAt(i)) || check.charAt(i) == ',' || check.charAt(i) == '.' ||
                    check.charAt(i) == '\'' || check.charAt(i) == '&' || check.charAt(i) == ' ')
                ok = true;
            else
                return false;
        }
        return ok;
    }
    
    private static boolean manufacturerPresent(String manufacturerName)
    {
        manufacturerName =  manufacturerName.strip();
        for (Map.Entry<String, Integer> e : Inventory.manufacturerIDList.entrySet()) {
            if(e.getKey().equalsIgnoreCase(manufacturerName))
                return true;
        }
        return false;
    }
    
    private static boolean isValidQuantity(String quantity)
    {
        quantity = quantity.strip();
        if(quantity.equals(""))
            return false;
        try {
            int quant = Integer.parseInt(quantity);
            if(quant > 0)
                return true;
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
    
    private static boolean isValidPrice(String price)
    {
        price = price.strip();
        if(price.equals(""))
            return false;
        try {
            float priceFloat = Float.parseFloat(price);
            if(priceFloat <= 0)
                return false;
            else
                return true;
        }
        catch(NumberFormatException e) {
            try {
                int priceInt = Integer.parseInt(price);
                if(priceInt > 0)
                    return true;
                else
                    return false;
            } catch(NumberFormatException e1){
                return false;
            }              
        }
    }

    /**
     * Creates new form AddItem
     */
    public AddItem() {
        initComponents();
        getContentPane().requestFocusInWindow();
        
        Set<String> itemTypeSet = new HashSet<String>();
        itemTypeSet = Inventory.searchMap.keySet();
        ArrayList<String> arrayItemType = new ArrayList<String>(itemTypeSet);
        arrayItemType.add(0, "None");
        arrayItemType.add(arrayItemType.size(), "Add new item type");
        String[] arrI = new String[arrayItemType.size()];
        arrI = arrayItemType.toArray(arrI);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(arrI));

        Set<String> manufacturerSet = new HashSet<String>();
        manufacturerSet = Inventory.manufacturerIDList.keySet();
        ArrayList<String> arrayManufacturer = new ArrayList<String>(manufacturerSet);
        arrayManufacturer.add(0, "None");
        arrayManufacturer.add(arrayManufacturer.size(), "Add a new manufacturer");
        String[] arrM = new String[arrayManufacturer.size()];
        arrM = arrayManufacturer.toArray(arrM);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(arrM));

        Set<String> vehicleSet = new HashSet<String>();
        for (Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
            vehicleSet.add(e.getValue().getVehicleType());
        }
        ArrayList<String> arrayVehicle = new ArrayList<String>(vehicleSet);
        arrayVehicle.add(0, "None");
        arrayVehicle.add(arrayVehicle.size(), "Add new vehicle type");
        String[] arrV = new String[arrayVehicle.size()];
        arrV = arrayVehicle.toArray(arrV);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(arrV));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        ItemTypeTextField = new javax.swing.JTextField();
        ManufacturerNameTextField = new javax.swing.JTextField();
        ManufacturerAddressTextField = new javax.swing.JTextField();
        VehicleTypeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        AddItemButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        PriceTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        QuantityTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 60, 60));

        jLabel5.setFont(new java.awt.Font("Yrsa Medium", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add a New Item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(65, 62, 59));

        jComboBox2.setBackground(java.awt.Color.white);
        jComboBox2.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        ItemTypeTextField.setBackground(java.awt.Color.white);
        ItemTypeTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        ItemTypeTextField.setForeground(new java.awt.Color(60, 60, 60));
        ItemTypeTextField.setText("Item Type");
        ItemTypeTextField.setEnabled(false);
        ItemTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTypeTextFieldActionPerformed(evt);
            }
        });

        ManufacturerNameTextField.setBackground(java.awt.Color.white);
        ManufacturerNameTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        ManufacturerNameTextField.setForeground(new java.awt.Color(60, 60, 60));
        ManufacturerNameTextField.setText("Manufacturer Name");
        ManufacturerNameTextField.setEnabled(false);

        ManufacturerAddressTextField.setBackground(java.awt.Color.white);
        ManufacturerAddressTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        ManufacturerAddressTextField.setForeground(new java.awt.Color(60, 60, 60));
        ManufacturerAddressTextField.setText("Manufacturer Address");
        ManufacturerAddressTextField.setEnabled(false);
        ManufacturerAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManufacturerAddressTextFieldActionPerformed(evt);
            }
        });

        VehicleTypeTextField.setBackground(java.awt.Color.white);
        VehicleTypeTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        VehicleTypeTextField.setForeground(new java.awt.Color(60, 60, 60));
        VehicleTypeTextField.setText("Vehicle Type");
        VehicleTypeTextField.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Yrsa Medium", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Item Type");

        jLabel2.setFont(new java.awt.Font("Yrsa Medium", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manufacturer");

        jLabel3.setFont(new java.awt.Font("Yrsa Medium", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vehicle Type");

        jLabel4.setFont(new java.awt.Font("Yrsa Medium", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");

        jComboBox1.setBackground(java.awt.Color.white);
        jComboBox1.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        AddItemButton.setBackground(java.awt.Color.white);
        AddItemButton.setFont(new java.awt.Font("Yrsa Medium", 0, 20)); // NOI18N
        AddItemButton.setText("Add Item");
        AddItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(java.awt.Color.white);
        BackButton.setFont(new java.awt.Font("Yrsa Medium", 0, 20)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(java.awt.Color.white);
        jComboBox3.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        PriceTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        PriceTextField.setText("Enter Price");
        PriceTextField.setPreferredSize(new java.awt.Dimension(110, 42));
        PriceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PriceTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PriceTextFieldFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yrsa Medium", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        QuantityTextField.setFont(new java.awt.Font("Yrsa Medium", 0, 18)); // NOI18N
        QuantityTextField.setText("Enter Quantity");
        QuantityTextField.setPreferredSize(new java.awt.Dimension(110, 42));
        QuantityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                QuantityTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                QuantityTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(AddItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuantityTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ManufacturerAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(ItemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(ManufacturerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addComponent(VehicleTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ItemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ManufacturerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(ManufacturerAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VehicleTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 123, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BackButton)
                            .addComponent(AddItemButton))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ItemTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTypeTextFieldActionPerformed

    private void ManufacturerAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManufacturerAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManufacturerAddressTextFieldActionPerformed

    private void AddItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemButtonActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem() == "None")
            JOptionPane.showMessageDialog(null, "Item Type is not selected", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox1.getSelectedItem() == "Add new Item Type" && !isValidString(ItemTypeTextField.getText()))
            JOptionPane.showMessageDialog(null, "Enter a valid Item Type", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox3.getSelectedItem() == "None")
            JOptionPane.showMessageDialog(null, "Vehicle Type is not selected", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox3.getSelectedItem() == "Add new Vehicle Type" && !isValidString(VehicleTypeTextField.getText()))
            JOptionPane.showMessageDialog(null, "Enter a valid Vehicle Type", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox2.getSelectedItem() == "None")
            JOptionPane.showMessageDialog(null, "Manufacturer is not selected", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox2.getSelectedItem() == "Add a new Manufacturer" && !isValidString(ManufacturerNameTextField.getText()))
            JOptionPane.showMessageDialog(null, "Enter a valid Manufacturer Name", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox2.getSelectedItem() == "Add a new Manufacturer" && manufacturerPresent(ManufacturerNameTextField.getText()))
            JOptionPane.showMessageDialog(null, "Manufacturer Already Present", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(jComboBox2.getSelectedItem() == "Add a new Manufacturer" && !isValidString(ManufacturerAddressTextField.getText()))
            JOptionPane.showMessageDialog(null, "Enter a valid Manufacturer Address", "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(!isValidQuantity(QuantityTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Enter a Valid Item Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
            QuantityTextField.setText("");
        }
        else if(!isValidPrice(PriceTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Enter a valid Item Price", "ERROR", JOptionPane.ERROR_MESSAGE);
            PriceTextField.setText("");
        }
        else {
            String ItemType = "";
            if(jComboBox1.getSelectedItem() != "Add new item type")
                ItemType = (String)jComboBox1.getSelectedItem();
            else {
                ItemType = ItemTypeTextField.getText();
                ItemTypeTextField.setText("");
            }
            ItemType = ItemType.strip();

            String ManufacturerName = "";
            int ManufacturerID = -1;
            if(jComboBox2.getSelectedItem() == "Add a new manufacturer") {
                ManufacturerName = ManufacturerNameTextField.getText();
                String ManufacturerAddress = ManufacturerAddressTextField.getText();
                
                ManufacturerName = ManufacturerName.strip();
                ManufacturerAddress = ManufacturerAddress.strip();
                
                addThisManufacturer(ManufacturerName, ManufacturerAddress);
                for (Map.Entry<String, Integer> e : Inventory.manufacturerIDList.entrySet()) {
                    if(e.getKey().toLowerCase().equals(ManufacturerName)) {
                        ManufacturerID = e.getValue();
                        break;
                    }
                }
                ManufacturerNameTextField.setText("");
                ManufacturerAddressTextField.setText("");
            }
            else {
                ManufacturerName = (String)jComboBox2.getSelectedItem();
                
                ManufacturerName = ManufacturerName.strip();
                for (Map.Entry<String, Integer> e : Inventory.manufacturerIDList.entrySet()) {
                    if(e.getKey().toLowerCase().equals(ManufacturerName)) {
                        ManufacturerID = e.getValue();
                        break;
                    }
                }
                Inventory.manufacturersList.get(ManufacturerID).incrementItemCount();
            }

            String VehicleType = "";
            if(jComboBox3.getSelectedItem() != "Add new vehicle type")
                VehicleType = (String)jComboBox3.getSelectedItem();
            else {
                VehicleType = VehicleTypeTextField.getText();
                VehicleTypeTextField.setText("");
            }
            VehicleType = VehicleType.strip();
            
            String q, p;
            q = QuantityTextField.getText();
            q = q.strip();
            p = PriceTextField.getText();
            p = p.strip();
            
            int quantity = Integer.parseInt(q);
            float price = Float.parseFloat(p);
            
            if(!addThisItem(ItemType, ManufacturerID, VehicleType, quantity, price))
                JOptionPane.showMessageDialog(null, "Item Already Present in the Inventory!", "ERROR", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Item Successfully Added to the Inventory!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            
            QuantityTextField.setText("Enter Quantity");
            PriceTextField.setText("Enter Price");
            ItemTypeTextField.setText("Item Type");
            ManufacturerNameTextField.setText("Manufacturer Name");
            ManufacturerAddressTextField.setText("Manufacturer Address");
            VehicleTypeTextField.setText("Vehicle Type");

            ItemTypeTextField.setEnabled(false);
            ManufacturerNameTextField.setEnabled(false);
            ManufacturerAddressTextField.setEnabled(false);
            VehicleTypeTextField.setEnabled(false);

            Set<String> itemTypeSet = new HashSet<String>();
            itemTypeSet = Inventory.searchMap.keySet();
            ArrayList<String> arrayItemType = new ArrayList<String>(itemTypeSet);
            arrayItemType.add(0, "None");
            arrayItemType.add((Integer) (arrayItemType.size()), "Add new item type");
            String[] arrI = new String[arrayItemType.size()];
            arrI = arrayItemType.toArray(arrI);
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(arrI));

            Set<String> manufacturerSet = new HashSet<String>();
            manufacturerSet = Inventory.manufacturerIDList.keySet();
            ArrayList<String> arrayManufacturer = new ArrayList<String>(manufacturerSet);
            arrayManufacturer.add(0, "None");
            arrayManufacturer.add((Integer) (arrayManufacturer.size()), "Add a new manufacturer");
            String[] arrM = new String[arrayManufacturer.size()];
            arrM = arrayManufacturer.toArray(arrM);
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(arrM));

            Set<String> vehicleSet = new HashSet<String>();
            for (Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
                vehicleSet.add(e.getValue().getVehicleType());
            }
            ArrayList<String> arrayVehicle = new ArrayList<String>(vehicleSet);
            arrayVehicle.add(0, "None");
            arrayVehicle.add((Integer) (arrayVehicle.size()), "Add new vehicle type");
            String[] arrV = new String[arrayVehicle.size()];
            arrV = arrayVehicle.toArray(arrV);
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(arrV));
        }
    }//GEN-LAST:event_AddItemButtonActionPerformed

    private static void addThisManufacturer(String ManufacturerName, String ManufacturerAddress) {
        Manufacturer newManufacturer = new Manufacturer(-1, ManufacturerName, ManufacturerAddress, 1);
        newManufacturer.save();
    }
    
    private static boolean addThisItem(String ItemType, int ManufacturerID, String VehicleType, int quantity, float price) {
        for (Map.Entry<Integer, Item> e : Inventory.itemsList.entrySet()) {
           if(e.getValue().getType().toLowerCase().equals(ItemType) && e.getValue().getManufacturerID() == ManufacturerID && e.getValue().getVehicleType().toLowerCase().equals(VehicleType))
               return false;
        }
        
        Item newItem = new Item(-1, ItemType, price, quantity, 0, 0, ManufacturerID, VehicleType, Inventory.currentDate);
        newItem.save();
        Inventory.itemsList.put(newItem.getUID(), newItem);
        if(Inventory.searchMap.containsKey(ItemType)) {
            if(Inventory.searchMap.get(ItemType).containsKey((ManufacturerID))) {
                Inventory.searchMap.get(ItemType).get(ManufacturerID).put(VehicleType, newItem);
            }
            else {
                HashMap<String, Item> temp1 = new HashMap<>();
                temp1.put(VehicleType, newItem);
                Inventory.searchMap.get(ItemType).put(ManufacturerID, temp1);
            }
        }
        else {
            HashMap<String, Item> temp1 = new HashMap<>();
            temp1.put(VehicleType, newItem);                
            HashMap<Integer, HashMap<String, Item>> temp2 = new HashMap<>();
            temp2.put(ManufacturerID, temp1);                
            Inventory.searchMap.put(ItemType, temp2);
        }
        return true;
    }
    
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        Dashboard dashboardScreen = new Dashboard();
        dashboardScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() == "Add new item type") {
            ItemTypeTextField.setEnabled(true);
            ItemTypeTextField.setText("");
        } else {
            ItemTypeTextField.setText("Item Type");
            ItemTypeTextField.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem() == "Add a new manufacturer") {
            ManufacturerNameTextField.setEnabled(true);
            ManufacturerAddressTextField.setEnabled(true);
            ManufacturerNameTextField.setText("");
            ManufacturerAddressTextField.setText("");
        } else {
            ManufacturerNameTextField.setText("Manufacturer Name");
            ManufacturerAddressTextField.setText("Manufacturer Address");
            ManufacturerNameTextField.setEnabled(false);
            ManufacturerAddressTextField.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if(jComboBox3.getSelectedItem() == "Add new vehicle type")
        {
            VehicleTypeTextField.setEnabled(true);
            VehicleTypeTextField.setText("");
        }
        else
        {
            VehicleTypeTextField.setText("Vehicle Type");
            VehicleTypeTextField.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void QuantityTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_QuantityTextFieldFocusGained
        // TODO add your handling code here
        if(QuantityTextField.getText().equals("Enter Quantity"))
            QuantityTextField.setText("");
    }//GEN-LAST:event_QuantityTextFieldFocusGained

    private void QuantityTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_QuantityTextFieldFocusLost
        // TODO add your handling code here:
        if(QuantityTextField.getText().equals(""))
            QuantityTextField.setText("Enter Quantity");
    }//GEN-LAST:event_QuantityTextFieldFocusLost

    private void PriceTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PriceTextFieldFocusGained
        // TODO add your handling code here:
        if(PriceTextField.getText().equals("Enter Price"))
            PriceTextField.setText("");
    }//GEN-LAST:event_PriceTextFieldFocusGained

    private void PriceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PriceTextFieldFocusLost
        // TODO add your handling code here:
        if(PriceTextField.getText().equals(""))
            PriceTextField.setText("Enter Price");
    }//GEN-LAST:event_PriceTextFieldFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.put("Button.focus", Color.white);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        Inventory.type().retrieveData();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField ItemTypeTextField;
    private javax.swing.JTextField ManufacturerAddressTextField;
    private javax.swing.JTextField ManufacturerNameTextField;
    private javax.swing.JTextField PriceTextField;
    private javax.swing.JTextField QuantityTextField;
    private javax.swing.JTextField VehicleTypeTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
