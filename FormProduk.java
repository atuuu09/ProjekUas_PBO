import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FormProduk extends JFrame {
    JTextField tfNama = new JTextField();
    JTextField tfHarga = new JTextField();
    JTextField tfStok = new JTextField();
    JButton btnSimpan = new JButton("Simpan");

    public FormProduk() {
        setTitle("Form Produk");
        setSize(300, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Nama Produk");
        JLabel l2 = new JLabel("Harga");
        JLabel l3 = new JLabel("Stok");

        l1.setBounds(20, 20, 100, 20);
        l2.setBounds(20, 60, 100, 20);
        l3.setBounds(20, 100, 100, 20);

        tfNama.setBounds(130, 20, 130, 20);
        tfHarga.setBounds(130, 60, 130, 20);
        tfStok.setBounds(130, 100, 130, 20);
        btnSimpan.setBounds(130, 140, 100, 30);

        add(l1); add(tfNama); add(l2); add(tfHarga); add(l3); add(tfStok); add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            try (Connection conn = KoneksiTest.getConnection()) {
                String sql = "INSERT INTO Product(nama, harga, stok) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfNama.getText());
                ps.setDouble(2, Double.parseDouble(tfHarga.getText()));
                ps.setInt(3, Integer.parseInt(tfStok.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Produk berhasil disimpan");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}