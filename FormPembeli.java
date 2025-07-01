import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FormPembeli extends JFrame {
    JTextField tfNama = new JTextField();
    JTextField tfAlamat = new JTextField();
    JTextField tfTelepon = new JTextField();
    JButton btnSimpan = new JButton("Simpan");

    public FormPembeli() {
        setTitle("Form Pelanggan");
        setSize(300, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Nama");
        JLabel l2 = new JLabel("Alamat");
        JLabel l3 = new JLabel("Telepon");

        l1.setBounds(20, 20, 80, 20);
        l2.setBounds(20, 60, 80, 20);
        l3.setBounds(20, 100, 80, 20);

        tfNama.setBounds(100, 20, 150, 20);
        tfAlamat.setBounds(100, 60, 150, 20);
        tfTelepon.setBounds(100, 100, 150, 20);
        btnSimpan.setBounds(100, 140, 100, 30);

        add(l1); add(tfNama); add(l2); add(tfAlamat); add(l3); add(tfTelepon); add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            try (Connection conn = KoneksiTest.getConnection()) {
                String sql = "INSERT INTO Customer(nama, alamat, no_telepon) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tfNama.getText());
                ps.setString(2, tfAlamat.getText());
                ps.setString(3, tfTelepon.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
