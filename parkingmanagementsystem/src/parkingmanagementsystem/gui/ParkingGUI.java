package parkingmanagementsystem.gui;

import entity.Vehicle;
import fileio.VehicleFileIO;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ParkingGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField idField;
    private JTextField ownerField;
    private JTextField numberField;
    private JTextField slotField;
    private JTextField timeField;
    private JTextField searchField;

    private JComboBox<String> districtBox;
    private JComboBox<String> seriesBox;
    private JComboBox<String> vehicleTypeBox;

    private JTable table;
    private DefaultTableModel tableModel;

    public ParkingGUI() {

        setTitle("Parking Management System");

        setSize(1100, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(new Color(18, 52, 59));

        // =====================================================
        // DISTRICT ARRAY
        // =====================================================

        String[] districts = {
                "DHAKA",
                "CHATTOGRAM",
                "KHULNA",
                "RAJSHAHI",
                "SYLHET",
                "BARISHAL",
                "RANGPUR",
                "MYMENSINGH",
                "GAZIPUR",
                "NARAYANGANJ",
                "COMILLA",
                "CUMILLA"
        };

        // =====================================================
        // SERIES ARRAY
        // =====================================================

        String[] series = {
                "A",
                "BHA",
                "CHA",
                "GA",
                "GHA",
                "HA",
                "KA",
                "KHA",
                "LA"
        };

        // =====================================================
        // VEHICLE TYPE ARRAY
        // =====================================================

        String[] vehicleTypes = {
                "Car",
                "Bike",
                "Bus",
                "Truck"
        };

        // =====================================================
        // INPUT PANEL
        // =====================================================

        JPanel inputPanel =
                new JPanel(new GridLayout(8, 2, 10, 10));

        inputPanel.setBackground(new Color(18, 52, 59));

        inputPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.WHITE),
                        "Vehicle Information",
                        0,
                        0,
                        new Font("Arial", Font.BOLD, 18),
                        Color.WHITE
                )
        );

        JLabel idLabel = createLabel("User ID");
        JLabel ownerLabel = createLabel("Owner Name");
        JLabel districtLabel = createLabel("District");
        JLabel seriesLabel = createLabel("Series");
        JLabel numberLabel = createLabel("Number");
        JLabel typeLabel = createLabel("Vehicle Type");
        JLabel slotLabel = createLabel("Parking Slot");
        JLabel timeLabel = createLabel("Entry Time");

        idField = createTextField();

        ownerField = createTextField();

        numberField = createTextField();

        slotField = createTextField();

        timeField = createTextField();

        districtBox = new JComboBox<>(districts);

        seriesBox = new JComboBox<>(series);

        vehicleTypeBox = new JComboBox<>(vehicleTypes);

        districtBox.setFont(new Font("Arial", Font.PLAIN, 16));

        seriesBox.setFont(new Font("Arial", Font.PLAIN, 16));

        vehicleTypeBox.setFont(new Font("Arial", Font.PLAIN, 16));

        inputPanel.add(idLabel);
        inputPanel.add(idField);

        inputPanel.add(ownerLabel);
        inputPanel.add(ownerField);

        inputPanel.add(districtLabel);
        inputPanel.add(districtBox);

        inputPanel.add(seriesLabel);
        inputPanel.add(seriesBox);

        inputPanel.add(numberLabel);
        inputPanel.add(numberField);

        inputPanel.add(typeLabel);
        inputPanel.add(vehicleTypeBox);

        inputPanel.add(slotLabel);
        inputPanel.add(slotField);

        inputPanel.add(timeLabel);
        inputPanel.add(timeField);

        // =====================================================
        // SEARCH PANEL
        // =====================================================

        JPanel searchPanel =
                new JPanel(new BorderLayout(10, 10));

        searchPanel.setBackground(new Color(18, 52, 59));

        searchField = createTextField();

        JButton searchBtn = createButton("Search");

        searchPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.WHITE),
                        "Search By ID or Owner Name",
                        0,
                        0,
                        new Font("Arial", Font.BOLD, 16),
                        Color.WHITE
                )
        );

        searchPanel.add(searchField, BorderLayout.CENTER);

        searchPanel.add(searchBtn, BorderLayout.EAST);

        // =====================================================
        // BUTTON PANEL
        // =====================================================

        JPanel buttonPanel =
                new JPanel(new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        10));

        buttonPanel.setBackground(new Color(18, 52, 59));

        JButton addBtn = createButton("Add");

        JButton updateBtn = createButton("Update");

        JButton deleteBtn = createButton("Delete");

        JButton clearBtn = createButton("Clear");

        JButton viewBtn = createButton("View All");

        buttonPanel.add(addBtn);

        buttonPanel.add(updateBtn);

        buttonPanel.add(deleteBtn);

        buttonPanel.add(viewBtn);

        buttonPanel.add(clearBtn);

        // =====================================================
        // NORTH PANEL
        // =====================================================

        JPanel northPanel =
                new JPanel(new BorderLayout(10, 10));

        northPanel.setBackground(new Color(18, 52, 59));

        northPanel.add(inputPanel, BorderLayout.CENTER);

        northPanel.add(searchPanel, BorderLayout.SOUTH);

        // =====================================================
        // TABLE
        // =====================================================

        String[] columns = {
                "User ID",
                "Owner Name",
                "Vehicle Number",
                "Vehicle Type",
                "Parking Slot",
                "Entry Time"
        };

        tableModel =
                new DefaultTableModel(columns, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        table = new JTable(tableModel);

        table.setRowHeight(28);

        table.setFont(new Font("Arial", Font.PLAIN, 15));

        table.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 15));

        JScrollPane scrollPane =
                new JScrollPane(table);

        // =====================================================
        // ADD TO FRAME
        // =====================================================

        add(northPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.SOUTH);

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        addBtn.addActionListener(e -> addVehicle());

        updateBtn.addActionListener(e -> updateVehicle());

        deleteBtn.addActionListener(e -> deleteVehicle());

        searchBtn.addActionListener(e -> searchVehicle());

        viewBtn.addActionListener(e -> {
            searchField.setText("");
            viewAll();
        });

        clearBtn.addActionListener(e -> clearFields());

        // =====================================================
        // TABLE SELECT
        // =====================================================

        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row = table.getSelectedRow();

                    if (row >= 0) {

                        idField.setText(
                                String.valueOf(
                                        tableModel.getValueAt(row, 0)));

                        ownerField.setText(
                                String.valueOf(
                                        tableModel.getValueAt(row, 1)));

                        setVehicleNumberFields(
                                String.valueOf(
                                        tableModel.getValueAt(row, 2)));

                        vehicleTypeBox.setSelectedItem(
                                String.valueOf(
                                        tableModel.getValueAt(row, 3)));

                        slotField.setText(
                                String.valueOf(
                                        tableModel.getValueAt(row, 4)));

                        timeField.setText(
                                String.valueOf(
                                        tableModel.getValueAt(row, 5)));
                    }
                });

        // =====================================================
        // FILE CREATE
        // =====================================================

        try {

            VehicleFileIO.createFileIfNotExists();

        } catch (IOException ex) {

            showError(ex.getMessage());
        }

        viewAll();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =====================================================
    // LABEL METHOD
    // =====================================================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("Arial", Font.BOLD, 16));

        return label;
    }

    // =====================================================
    // TEXT FIELD METHOD
    // =====================================================

    private JTextField createTextField() {

        JTextField field = new JTextField();

        field.setFont(new Font("Arial", Font.PLAIN, 16));

        return field;
    }

    // =====================================================
    // BUTTON METHOD
    // =====================================================

    private JButton createButton(String text) {

        JButton btn = new JButton(text);

        btn.setFont(new Font("Arial", Font.BOLD, 15));

        btn.setBackground(new Color(0, 153, 153));

        btn.setForeground(Color.WHITE);

        return btn;
    }

    // =====================================================
    // VALIDATION
    // =====================================================

    private boolean isValidId(String id) {

        if (!id.matches("\\d{8}")) {

            showError(
                    "User ID must be exactly 8 digits.");

            return false;
        }

        return true;
    }

    private boolean isValidVehicleNumber(
            String number) {

        if (!number.matches("\\d{2}-\\d{4}")) {

            showError(
                    "Vehicle number format must be: 11-1234");

            return false;
        }

        return true;
    }

    // =====================================================
    // ADD
    // =====================================================

    private void addVehicle() {

        String id =
                idField.getText().trim();

        String owner =
                ownerField.getText().trim();

        String number =
                numberField.getText().trim();

        String slot =
                slotField.getText().trim();

        String time =
                timeField.getText().trim();

        if (id.isEmpty()
                || owner.isEmpty()
                || number.isEmpty()
                || slot.isEmpty()
                || time.isEmpty()) {

            showError("All fields are required.");

            return;
        }

        if (!isValidId(id))
            return;

        if (!isValidVehicleNumber(number))
            return;

        if (VehicleFileIO.idExists(id)) {

            showError("Duplicate User ID.");

            return;
        }

        String vehicleNumber =
                districtBox.getSelectedItem()
                        + "-"
                        + seriesBox.getSelectedItem()
                        + "-"
                        + number;

        String vehicleType =
                String.valueOf(
                        vehicleTypeBox.getSelectedItem());

        Vehicle vehicle =
                new Vehicle(
                        id,
                        owner,
                        vehicleNumber,
                        vehicleType,
                        slot,
                        time);

        try {

            VehicleFileIO.addVehicle(vehicle);

            showInfo("Vehicle Added Successfully.");

            clearFields();

            viewAll();

        } catch (IOException ex) {

            showError(ex.getMessage());
        }
    }

    // =====================================================
    // UPDATE
    // =====================================================

    private void updateVehicle() {

        String id =
                idField.getText().trim();

        String owner =
                ownerField.getText().trim();

        String number =
                numberField.getText().trim();

        String slot =
                slotField.getText().trim();

        String time =
                timeField.getText().trim();

        if (id.isEmpty()
                || owner.isEmpty()
                || number.isEmpty()
                || slot.isEmpty()
                || time.isEmpty()) {

            showError("All fields are required.");

            return;
        }

        if (!isValidId(id))
            return;

        if (!isValidVehicleNumber(number))
            return;

        String vehicleNumber =
                districtBox.getSelectedItem()
                        + "-"
                        + seriesBox.getSelectedItem()
                        + "-"
                        + number;

        String vehicleType =
                String.valueOf(
                        vehicleTypeBox.getSelectedItem());

        Vehicle vehicle =
                new Vehicle(
                        id,
                        owner,
                        vehicleNumber,
                        vehicleType,
                        slot,
                        time);

        try {

            boolean updated =
                    VehicleFileIO.updateVehicle(vehicle);

            if (updated) {

                showInfo("Updated Successfully.");

                clearFields();

                viewAll();

            } else {

                showError("User ID not found.");
            }

        } catch (IOException ex) {

            showError(ex.getMessage());
        }
    }

    // =====================================================
    // DELETE
    // =====================================================

    private void deleteVehicle() {

        String id =
                idField.getText().trim();

        if (!isValidId(id))
            return;

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete this record?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;

        try {

            boolean deleted =
                    VehicleFileIO.deleteVehicle(id);

            if (deleted) {

                showInfo("Deleted Successfully.");

                clearFields();

                viewAll();

            } else {

                showError("User ID not found.");
            }

        } catch (IOException ex) {

            showError(ex.getMessage());
        }
    }

    // =====================================================
    // SEARCH
    // =====================================================

    private void searchVehicle() {

        String keyword =
                searchField.getText().trim();

        if (keyword.isEmpty()) {

            showError(
                    "Enter ID or Owner Name.");

            return;
        }

        Object[][] results =
                VehicleFileIO.searchVehicles(keyword);

        tableModel.setRowCount(0);

        for (int i = 0;
             i < results.length;
             i++) {

            tableModel.addRow(results[i]);
        }

        if (results.length == 0) {

            showInfo("No Record Found.");
        }
    }

    // =====================================================
    // VIEW ALL
    // =====================================================

    private void viewAll() {

        Object[][] rows =
                VehicleFileIO.getAllVehicles();

        tableModel.setRowCount(0);

        for (int i = 0;
             i < rows.length;
             i++) {

            if (rows[i][0] != null)
                tableModel.addRow(rows[i]);
        }
    }

    // =====================================================
    // CLEAR
    // =====================================================

    private void clearFields() {

        idField.setText("");

        ownerField.setText("");

        numberField.setText("");

        slotField.setText("");

        timeField.setText("");

        searchField.setText("");

        districtBox.setSelectedIndex(0);

        seriesBox.setSelectedIndex(0);

        vehicleTypeBox.setSelectedIndex(0);

        table.clearSelection();
    }

    private void setVehicleNumberFields(String vehicleNumber) {

        String[] parts = vehicleNumber.split("-", 3);

        if (parts.length == 3) {

            districtBox.setSelectedItem(parts[0]);

            seriesBox.setSelectedItem(parts[1]);

            numberField.setText(parts[2]);
        } else {

            numberField.setText(vehicleNumber);
        }
    }

    // =====================================================
    // MESSAGE
    // =====================================================

    private void showInfo(String msg) {

        JOptionPane.showMessageDialog(
                this,
                msg,
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String msg) {

        JOptionPane.showMessageDialog(
                this,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
