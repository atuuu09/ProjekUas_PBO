import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FormDetailOrder extends JFrame {
    JTextField tfIdOrder = new JTextField();
    JTextField tfIdProduk = new JTextField();
    JTextField tfJumlah = new JTextField();
    JTextField tfSubtotal = new JTextField();
    JButton btnSimpan = new JButton("Simpan");

    public FormDetailOrder() {
        setTitle("Form Detail Order");
        setSize(350, 250);
        setLayout(null);

        JLabel l1 = new JLabel("ID Order");
        JLabel l2 = new JLabel("ID Produk");
        JLabel l3 = new JLabel("Jumlah");
        JLabel l4 = new JLabel("Subtotal");

        l1.setBounds(20, 20, 100, 20);
        l2.setBounds(20, 60, 100, 20);
        l3.setBounds(20, 100, 100, 20);
        l4.setBounds(20, 140, 100, 20);

        tfIdOrder.setBounds(130, 20, 150, 20);
        tfIdProduk.setBounds(130, 60, 150, 20);
        tfJumlah.setBounds(130, 100, 150, 20);
        tfSubtotal.setBounds(130, 140, 150, 20);
        btnSimpan.setBounds(130, 180, 100, 30);

        add(l1); add(tfIdOrder); add(l2); add(tfIdProduk); add(l3); add(tfJumlah); add(l4); add(tfSubtotal); add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            try (Connection conn = KoneksiTest.getConnection()) {
                String sql = "INSERT INTO OrderDetail(id_order, id_product, jumlah, subtotal) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tfIdOrder.getText()));
                ps.setInt(2, Integer.parseInt(tfIdProduk.getText()));
                ps.setInt(3, Integer.parseInt(tfJumlah.getText()));
                ps.setDouble(4, Double.parseDouble(tfSubtotal.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Detail order berhasil disimpan");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
