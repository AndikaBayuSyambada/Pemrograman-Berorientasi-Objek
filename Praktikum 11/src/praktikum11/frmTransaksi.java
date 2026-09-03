/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package praktikum11;

import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Calendar;

public class frmTransaksi extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsBrg;
    ResultSet RsKons;
    Statement stm;
    double total = 0;
    String tanggal;
    Boolean edit = false;
    public String idBrg;
    public String namaBrg;
    public String hargaBrg;
    private javax.swing.JTextField txtId;
    DefaultTableModel tableModel = new DefaultTableModel(
        new Object [][] {},
        new String [] {"Kd Barang", "Nama Barang", "Harga Barang", "Jumlah", "Total"}
    );

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmTransaksi.class.getName());

    /**
     * Creates new form frmTransaksi
     */
    public frmTransaksi() {
        initComponents();
        txtId = txtKd_Brg_Search;
        open_db();
        inisialisasi_tabel();
        aktif(false);
        setTombol(true);
        txtTgl.setEditor(new JSpinner.DateEditor(txtTgl, "yyyy/MM/dd"));
        baca_barang();
        baca_konsumen();
        tampil_data_awal();
    }

    private class PrintingTask extends SwingWorker<Object, Object> {
        private final MessageFormat headerFormat;
        private final MessageFormat footerFormat;
        private final boolean interactive;
        private volatile boolean complete = false;
        private volatile String message;

        public PrintingTask(MessageFormat header, MessageFormat footer, boolean interactive) {
            this.headerFormat = header;
            this.footerFormat = footer;
            this.interactive = interactive;
        }

        @Override
        protected Object doInBackground() {
            try {
                complete = text.print(headerFormat, footerFormat, true, null, null, interactive);
                message = "Printing " + (complete ? "complete" : "canceled");
            } catch (PrinterException ex) {
                message = "Sorry, a printer error occurred";
            } catch (SecurityException ex) {
                message = "Sorry, cannot access the printer due to security reasons";
            }
            return null;
        }

        @Override
        protected void done() {
            message(!complete, message);
        }
    }

    private MessageFormat createFormat(String source) {
        if (source != null && source.length() > 0) {
            try {
                return new MessageFormat(source);
            } catch (IllegalArgumentException iae) {
                // handle error
            }
        }
        return null;
    }

    private void message(boolean error, String msg) {
        int type = error ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(this, msg, "Printing", type);
    }

    private String formatDouble(double value) {
        return String.format("%.0f", value);
    }

    private void hitung_jual() {
        try {
            double xtot, xhrg;
            int xjml;
            xhrg = Double.parseDouble(txtHarga.getText());
            xjml = Integer.parseInt(txtJml.getText());
            xtot = xhrg * xjml;
            String xtotal = formatDouble(xtot);
            txtTot.setText(xtotal);
            total = total + xtot;
            txtTotal.setText(formatDouble(total));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e);
        }
    }
    
    private void open_db() {
        try {
            KoneksiMysql kon = new KoneksiMysql("localhost", "root", "", "penjualan");
            Con = kon.getConnection();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void baca_konsumen() {
        try {
            cmbKd_Kons.removeAllItems();
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select kd_kons, nm_kons from konsumen");
            while (rs.next()) {
                cmbKd_Kons.addItem(rs.getString(1).trim());
            }
            rs.close();
            if (cmbKd_Kons.getItemCount() > 0) {
                cmbKd_Kons.setSelectedIndex(0);
                detail_konsumen(cmbKd_Kons.getSelectedItem().toString());
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void baca_barang() {
        try {
            cmbKd_Brg.removeAllItems();
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select kd_brg from barang");
            while (rs.next()) {
                cmbKd_Brg.addItem(rs.getString(1).trim());
            }
            rs.close();
            if (cmbKd_Brg.getItemCount() > 0) {
                cmbKd_Brg.setSelectedIndex(0);
                detail_barang(cmbKd_Brg.getSelectedItem().toString());
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    private void tampil_data_awal() {
        try {
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select * from barang");
            if (rs.next()) {
                String kdb = rs.getString(1).trim();
                String nmb = rs.getString(2).trim();
                double hrg = rs.getDouble(4);
                int jml = 1;
                double tot = hrg * jml;
                
                tableModel.addRow(new Object[]{kdb, nmb, formatDouble(hrg), jml, formatDouble(tot)});
                total = tot;
                txtTotal.setText(formatDouble(total));
                txtBayar.setText(formatDouble(total + 50000));
                txtKembali.setText("50000");
                
                format_tanggal();
                String ctk = "Nota Penjualan\nNo :1\nTanggal : " + tanggal;
                ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
                ctk = ctk + "\n" + "Kode\tNama Barang\tHarga\tJml\tTotal";
                ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
                ctk = ctk + "\n" + kdb + "\t" + nmb + "\t" + formatDouble(hrg) + "\t" + jml + "\t" + formatDouble(tot);
                ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
                text.setText(ctk);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error tampil data awal: " + e);
        }
    }
        
    private void detail_barang(String xkode) {
        try {
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select * from barang where kd_brg='" + xkode + "'");
            if (rs.next()) {
                txtNm_Brg.setText(rs.getString(2).trim());
                txtHarga.setText(formatDouble(rs.getDouble(4))); // Mengambil harga jual
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    private void detail_konsumen(String xkode) {
        try {
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select * from konsumen where kd_kons='" + xkode + "'");
            if (rs.next()) {
                txtNama.setText(rs.getString(2).trim());
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    public void inisialisasi_tabel() {
        tblJual.setModel(tableModel);
    }

    public void itemTerpilih() {
        frmSelectBarang fDB = new frmSelectBarang();
        fDB.fAB = this;
        txtId.setText(idBrg);
        txtNm_Brg.setText(namaBrg);
        txtHarga.setText(hargaBrg);
        for (int i = 0; i < cmbKd_Brg.getItemCount(); i++) {
            if (cmbKd_Brg.getItemAt(i).equalsIgnoreCase(idBrg)) {
                cmbKd_Brg.setSelectedIndex(i);
                break;
            }
        }
    }

    private void kosong() {
        txtNoJual.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtTotal.setText("");
        txtBayar.setText("");
        txtKembali.setText("");
        txtKd_Brg_Search.setText("");
        text.setText("");
    }

    private void kosong_detail() {
        txtNm_Brg.setText("");
        txtHarga.setText("");
        txtJml.setText("");
        txtTot.setText("");
    }

    private void aktif(boolean x) {
        cmbKd_Kons.setEnabled(x);
        cmbKd_Brg.setEnabled(x);
        txtTgl.setEnabled(x);
        txtJml.setEditable(x);
        txtKd_Brg_Search.setEditable(x);
        cmdPilih.setEnabled(x);
        txtBayar.setEditable(x);
    }

    private void setTombol(boolean t) {
        cmdTambah.setEnabled(t);
        cmdSimpan.setEnabled(!t);
        cmdBatal.setEnabled(!t);
        cmdKeluar.setEnabled(t);
        cmdHapusItem.setEnabled(!t);
    }

    private void nomor_jual() {
        try {
            Statement stm = Con.createStatement();
            ResultSet rs = stm.executeQuery("select no_jual from jual");
            int brs = 0;
            while (rs.next()) {
                brs = rs.getRow();
            }
            if (brs == 0) {
                txtNoJual.setText("1");
            } else {
                int nom = brs + 1;
                txtNoJual.setText(Integer.toString(nom));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    private void simpan_ditabel() {
        try {
            String tKode = cmbKd_Brg.getSelectedItem().toString();
            String tNama = txtNm_Brg.getText();
            double hrg = Double.parseDouble(txtHarga.getText());
            int jml = Integer.parseInt(txtJml.getText());
            double tot = Double.parseDouble(txtTot.getText());
            tableModel.addRow(new Object[]{tKode, tNama, formatDouble(hrg), jml, formatDouble(tot)});
            inisialisasi_tabel();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private void simpan_transaksi() {
        try {
            String xnojual = txtNoJual.getText();
            format_tanggal();
            String xkode = cmbKd_Kons.getSelectedItem().toString();
            String msql = "insert into jual values('" + xnojual + "','" + xkode + "','" + tanggal + "')";
            Statement stm = Con.createStatement();
            stm.executeUpdate(msql);
            for (int i = 0; i < tblJual.getRowCount(); i++) {
                String xkd = tblJual.getValueAt(i, 0).toString();
                double xhrg = Double.parseDouble(tblJual.getValueAt(i, 2).toString());
                int xjml = Integer.parseInt(tblJual.getValueAt(i, 3).toString());
                String zsql = "insert into djual values('" + xnojual + "','" + xkd + "'," + xhrg + "," + xjml + ")";
                stm.executeUpdate(zsql);
            }
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil Disimpan!");
        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }

    private void format_tanggal() {
        String DATE_FORMAT = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        tanggal = sdf.format(txtTgl.getValue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNoJual = new javax.swing.JTextField();
        txtTgl = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cmbKd_Kons = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        cmbKd_Brg = new javax.swing.JComboBox<>();
        txtNm_Brg = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJml = new javax.swing.JTextField();
        txtTot = new javax.swing.JTextField();
        cmdHapusItem = new javax.swing.JButton();
        cmdPilih = new javax.swing.JButton();
        txtKd_Brg_Search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJual = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKembali = new javax.swing.JTextField();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdCetak = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi Penjualan Barang");

        jLabel1.setText("No Jual");

        jLabel2.setText("Tgl Jual");

        txtTgl.setModel(new javax.swing.SpinnerDateModel());

        jLabel3.setText("Kode Konsumen");

        cmbKd_Kons.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKd_Kons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKd_KonsActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Konsumen");

        cmbKd_Brg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKd_Brg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKd_BrgActionPerformed(evt);
            }
        });

        txtJml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlActionPerformed(evt);
            }
        });

        cmdHapusItem.setText("Hapus Item");
        cmdHapusItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusItemActionPerformed(evt);
            }
        });

        cmdPilih.setText("Pilih Barang");
        cmdPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPilihActionPerformed(evt);
            }
        });

        tblJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblJual);

        text.setColumns(20);
        text.setRows(5);
        jScrollPane2.setViewportView(text);

        jLabel5.setText("Total");

        jLabel6.setText("Bayar");

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel7.setText("Kembali");

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdCetak.setText("Cetak");
        cmdCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCetakActionPerformed(evt);
            }
        });

        cmdKeluar.setText("Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoJual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbKd_Kons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdTambah)
                                .addGap(18, 18, 18)
                                .addComponent(cmdSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(cmdBatal)
                                .addGap(18, 18, 18)
                                .addComponent(cmdCetak)
                                .addGap(18, 18, 18)
                                .addComponent(cmdKeluar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmbKd_Brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNm_Brg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmdHapusItem)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmdPilih)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtKd_Brg_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(51, 51, 51)
                                    .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtBayar)
                                        .addComponent(txtKembali)))))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbKd_Kons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKd_Brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNm_Brg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdHapusItem)
                    .addComponent(cmdPilih)
                    .addComponent(txtKd_Brg_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdBatal)
                    .addComponent(cmdCetak)
                    .addComponent(cmdKeluar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKd_KonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKd_KonsActionPerformed
        if (cmbKd_Kons.getSelectedItem() != null) {
            detail_konsumen(cmbKd_Kons.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbKd_KonsActionPerformed

    private void cmbKd_BrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKd_BrgActionPerformed
        if (cmbKd_Brg.getSelectedItem() != null) {
            detail_barang(cmbKd_Brg.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbKd_BrgActionPerformed

    private void txtJmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlActionPerformed
        hitung_jual();
        simpan_ditabel();
        kosong_detail();
    }//GEN-LAST:event_txtJmlActionPerformed

    private void cmdHapusItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblJual.getModel();
        int row = tblJual.getSelectedRow();
        if (row != -1) {
            double totItem = Double.parseDouble(model.getValueAt(row, 4).toString());
            total -= totItem;
            txtTotal.setText(formatDouble(total));
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris pada tabel terlebih dahulu!");
        }
    }//GEN-LAST:event_cmdHapusItemActionPerformed

    private void cmdPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPilihActionPerformed
        frmSelectBarang fDB = new frmSelectBarang();
        fDB.fAB = this;
        fDB.setVisible(true);
        fDB.setResizable(false);
    }//GEN-LAST:event_cmdPilihActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        try {
            double bayar = Double.parseDouble(txtBayar.getText());
            double kembali = bayar - total;
            txtKembali.setText(formatDouble(kembali));
        } catch (NumberFormatException e) {
            txtKembali.setText("0");
        }
    }//GEN-LAST:event_txtBayarActionPerformed

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        aktif(true);
        setTombol(false);
        kosong();
        kosong_detail();
        nomor_jual();
        if (cmbKd_Kons.getSelectedItem() != null) {
            detail_konsumen(cmbKd_Kons.getSelectedItem().toString());
        }
        if (cmbKd_Brg.getSelectedItem() != null) {
            detail_barang(cmbKd_Brg.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
        simpan_transaksi();
        aktif(false);
        setTombol(true);
        kosong();
        kosong_detail();
        
        // Clear table after save
        DefaultTableModel model = (DefaultTableModel) tblJual.getModel();
        model.setRowCount(0);
        total = 0;
        txtTotal.setText("0");
    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        aktif(false);
        setTombol(true);
        kosong();
        kosong_detail();
        
        // Clear table
        DefaultTableModel model = (DefaultTableModel) tblJual.getModel();
        model.setRowCount(0);
        total = 0;
        txtTotal.setText("0");
    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCetakActionPerformed
        format_tanggal();
        String ctk = "Nota Penjualan\nNo :" + txtNoJual.getText() + "\nTanggal : " + tanggal;
        ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
        ctk = ctk + "\n" + "Kode\tNama Barang\tHarga\tJml\tTotal";
        ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
        for (int i = 0; i < tblJual.getRowCount(); i++) {
            String xkd = tblJual.getValueAt(i, 0).toString();
            String xnama = tblJual.getValueAt(i, 1).toString();
            double xhrg = Double.parseDouble(tblJual.getValueAt(i, 2).toString());
            int xjml = Integer.parseInt(tblJual.getValueAt(i, 3).toString());
            double xtot = Double.parseDouble(tblJual.getValueAt(i, 4).toString());
            ctk = ctk + "\n" + xkd + "\t" + xnama + "\t" + formatDouble(xhrg) + "\t" + xjml + "\t" + formatDouble(xtot);
        }
        ctk = ctk + "\n" + "---------------------------------------------------------------------------------";
        text.setText(ctk);
        String headerField = "";
        String footerField = "";
        MessageFormat header = createFormat(headerField);
        MessageFormat footer = createFormat(footerField);
        boolean interactive = true;
        boolean background = true;
        PrintingTask task = new PrintingTask(header, footer, interactive);
        if (background) {
            task.execute();
        } else {
            task.run();
        }
    }//GEN-LAST:event_cmdCetakActionPerformed

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_cmdKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmTransaksi().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbKd_Brg;
    private javax.swing.JComboBox<String> cmbKd_Kons;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdCetak;
    private javax.swing.JButton cmdHapusItem;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdPilih;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblJual;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJml;
    private javax.swing.JTextField txtKd_Brg_Search;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNm_Brg;
    private javax.swing.JTextField txtNoJual;
    private javax.swing.JSpinner txtTgl;
    private javax.swing.JTextField txtTot;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
