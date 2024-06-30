/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokobukupbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DIVAUL
 */

public class TokoBukuApp extends JFrame {
    private JTextField judulField, namaPengarangField, penerbitField, tahunCetakField, searchField;
    private JComboBox<String> kategoriComboBox;
    private JTextArea Tampilan;
    private PenyimpananData Penyimpanan;

    public TokoBukuApp() {
        setTitle("TOKO BUKU");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Penyimpanan = new PenyimpananData(3);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(new JLabel("Judul:"), gbc);
        gbc.gridx++;
        judulField = new JTextField(20);
        inputPanel.add(judulField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Nama Pengarang:"), gbc);
        gbc.gridx++;
        namaPengarangField = new JTextField(20);
        inputPanel.add(namaPengarangField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Penerbit:"), gbc);
        gbc.gridx++;
        penerbitField = new JTextField(20);
        inputPanel.add(penerbitField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Tahun Cetak:"), gbc);
        gbc.gridx++;
        tahunCetakField = new JTextField(20);
        inputPanel.add(tahunCetakField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Kategori:"), gbc);
        gbc.gridx++;
        String[] categories = {"su (semua usia)", "r (remaja)", "d (dewasa)", "a (anak-anak)"};
        kategoriComboBox = new JComboBox<>(categories);
        inputPanel.add(kategoriComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton addButton = new JButton("Tambah Buku");
        inputPanel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(new JLabel("Cari Buku:"), gbc);
        gbc.gridx++;
        searchField = new JTextField(20);
        inputPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton searchButton = new JButton("Cari Buku");
        inputPanel.add(searchButton, gbc);

        Tampilan = new JTextArea(10, 40);
        Tampilan.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(Tampilan);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Penyimpanan.getCount() < 3) {
                    String judul = judulField.getText();
                    String namaPengarang = namaPengarangField.getText();
                    String penerbit = penerbitField.getText();
                    int tahunCetak = Integer.parseInt(tahunCetakField.getText());
                    String kategori = (String) kategoriComboBox.getSelectedItem();

                    Buku book = new Buku(judul, namaPengarang, penerbit, tahunCetak, kategori);
                    Penyimpanan.addItem(book);
                    displayItems();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(TokoBukuApp.this, "Kamu hanya bisa memasukkan 3 data buku");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = searchField.getText();
                Item item = Penyimpanan.searchItem(title);
                if (item != null) {
                    Tampilan.setText("Buku ada:\n" + item.toString());
                } else {
                    Tampilan.setText("Buku tidak ada.");
                }
            }
        });
    }

    private void displayItems() {
        Tampilan.setText("");
        Item[] items = Penyimpanan.getAllItems();
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            Tampilan.append("buku  " + (i + 1) + ":\n");
            Tampilan.append(item.toString() + "\n\n");
        }
    }

    private void clearFields() {
        judulField.setText("");
        namaPengarangField.setText("");
        penerbitField.setText("");
        tahunCetakField.setText("");
        kategoriComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TokoBukuApp().setVisible(true);
            }
        });
    }
}
