import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FormOrder extends JFrame {
    JTextField tfIdCustomer = new JTextField();
    JTextField tfTanggal = new JTextField();
    JButton btnSimpan = new JButton("Simpan");

    public FormOrder() {
        setTitle("Form Order");
        setSize(300, 200);
        setLayout(null);

        JLabel l1 = new JLabel("ID Customer");
        JLabel l2 = new JLabel("Tanggal (YYYY-MM-DD)");

        l1.setBounds(20, 20, 120, 20);
        l2.setBounds(20, 60, 150, 20);

        tfIdCustomer.setBounds(170, 20, 100, 20);
        tfTanggal.setBounds(170, 60, 100, 20);
        btnSimpan.setBounds(100, 100, 100, 30);

        add(l1); add(tfIdCustomer); add(l2); add(tfTanggal); add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            try (Connection conn = KoneksiTest.getConnection()) {
                String sql = "INSERT INTO `Order`(id_customer, tanggal_pesan) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tfIdCustomer.getText()));
                ps.setDate(2, Date.valueOf(tfTanggal.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Order berhasil disimpan");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
