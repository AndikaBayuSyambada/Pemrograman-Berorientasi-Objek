package praktikum11;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class frmSelectBarang extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsBrg;
    Statement stm;
    public frmTransaksi fAB = null;
    public frmPembelian fAP = null;
    private Object[][] dataTable = null;
    private String[] header = {"Kode", "Nama Barang", "Satuan", "Harga", "Harga Beli", "Stok", "Stok Min"};

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmSelectBarang.class.getName());

    public frmSelectBarang() {
        initComponents();
        baca_data();
    }

    private void open_db() {
        try {
            KoneksiMysql kon = new KoneksiMysql("127.0.0.1", "root", "", "penjualan");
            Con = kon.getConnection();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private void baca_data() {
        open_db();
        try {
            // Using TYPE_SCROLL_INSENSITIVE so beforeFirst() works correctly
            stm = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            RsBrg = stm.executeQuery("select * from barang order by kd_brg");
            ResultSetMetaData meta = RsBrg.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsBrg.next()) {
                baris = RsBrg.getRow();
            }
            dataTable = new Object[baris][col];
            int x = 0;
            RsBrg.beforeFirst();
            while (RsBrg.next()) {
                dataTable[x][0] = RsBrg.getString("kd_brg");
                dataTable[x][1] = RsBrg.getString("nm_brg");
                dataTable[x][2] = RsBrg.getString("satuan");
                
                // Robust check for Column "harga" vs "harga_jual"
                double hargaVal = 0;
                try {
                    hargaVal = RsBrg.getDouble("harga_jual");
                } catch (SQLException e) {
                    try {
                        hargaVal = RsBrg.getDouble("harga");
                    } catch (SQLException ex) {
                        hargaVal = RsBrg.getDouble(4);
                    }
                }
                dataTable[x][3] = hargaVal;
                
                dataTable[x][4] = RsBrg.getDouble("harga_beli");
                dataTable[x][5] = RsBrg.getInt("stok");
                dataTable[x][6] = RsBrg.getInt("stok_min");
                x++;
            }
            tblBrg.setModel(new DefaultTableModel(dataTable, header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (RsBrg != null) RsBrg.close();
                if (stm != null) stm.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrg = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Barang");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DAFTAR BARANG");

        tblBrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Barang", "Satuan", "Harga", "Harga Beli", "Stok", "Stok Min"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrg);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jLabel2.setText("* Click pada baris untuk produk yang dipilih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrgMouseClicked
        int tabelBarang = tblBrg.getSelectedRow();
        if (tabelBarang != -1) {
            if (fAB != null) {
                fAB.idBrg = tblBrg.getValueAt(tabelBarang, 0).toString();
                fAB.namaBrg = tblBrg.getValueAt(tabelBarang, 1).toString();
                fAB.hargaBrg = tblBrg.getValueAt(tabelBarang, 3).toString();
                fAB.itemTerpilih();
            } else if (fAP != null) {
                fAP.idBrg = tblBrg.getValueAt(tabelBarang, 0).toString();
                fAP.namaBrg = tblBrg.getValueAt(tabelBarang, 1).toString();
                fAP.hargaBrg = tblBrg.getValueAt(tabelBarang, 4).toString(); // Harga Beli
                fAP.itemTerpilih();
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblBrgMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new frmSelectBarang().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrg;
    // End of variables declaration//GEN-END:variables
}
