package praktikum11;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andika Bayu S
 */
public class LapPenjualan extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsJual;
    Statement stm;
    String tgl1, tgl2;
    private Object[][] dataTable = null;
    private String[] header = {"No Jual", "Tanggal", "Nama Konsumen", "Kode Barang", "Nama Barang", "Harga Satuan", "Jumlah", "Total"};
    DefaultTableModel tableModel = new DefaultTableModel(new Object [][] {}, header);

    /**
     * Creates new form LapPenjualan
     */
    public LapPenjualan() {
        initComponents();
        
        // Register events using lambdas (prevents NoClassDefFoundError for anonymous inner classes)
        cmdCari.addActionListener(evt -> baca_data());
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        dtAwal.setDateFormat(sdf);
        dtAkhir.setDateFormat(sdf);
        
        // Set tanggal awal default ke 1 bulan yang lalu, tanggal akhir hari ini
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        dtAwal.setSelectedDate(cal);
        
        open_db();
        baca_data(); // Otomatis tampilkan data saat program pertama kali dibuka
    }

    private void open_db() {
        try {
            KoneksiMysql kon = new KoneksiMysql("localhost", "root", "", "penjualan");
            Con = kon.getConnection();
            
            // Membuat ulang view v_penjualan secara otomatis menggunakan LEFT JOIN agar data tetap muncul walaupun relasi kd_brg kosong/tidak sama
            Statement st = Con.createStatement();
            st.executeUpdate("DROP VIEW IF EXISTS v_penjualan");
            String sql = "CREATE VIEW v_penjualan AS " +
                         "SELECT j.no_jual, j.tgl_jual, COALESCE(k.nm_kons, '') AS nm_kons, d.kd_brg, COALESCE(b.nm_brg, 'Barang Hilang') AS nm_brg, d.harga_jual, d.jml_jual, (d.harga_jual * d.jml_jual) AS totjual " +
                         "FROM jual j " +
                         "LEFT JOIN konsumen k ON j.kd_kons = k.kd_kons " +
                         "JOIN djual d ON j.no_jual = d.no_jual " +
                         "LEFT JOIN barang b ON d.kd_brg = b.kd_brg";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private void format_tanggal() {
        String DATE_FORMAT = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        int month = c1.get(Calendar.MONTH) + 1;
        int day = c1.get(Calendar.DAY_OF_MONTH);
        tgl1 = dtAwal.getText();
        tgl2 = dtAkhir.getText();
        System.out.println("Tanggal : " + tgl1);
        System.out.println("Tanggal2 : " + tgl2);
    }

    private void baca_data() {
        try {
            tgl1 = dtAwal.getText();
            tgl2 = dtAkhir.getText();
            stm = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            RsJual = stm.executeQuery("select * from v_penjualan where date(tgl_jual)>=date('" + tgl1 + "') and date(tgl_jual)<=date('" + tgl2 + "') order by tgl_jual desc");
            ResultSetMetaData meta = RsJual.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while (RsJual.next()) {
                baris = RsJual.getRow();
            }
            CustomFormat cf = new CustomFormat();
            dataTable = new Object[baris][col];
            int x = 0;
            RsJual.beforeFirst();
            while (RsJual.next()) {
                dataTable[x][0] = RsJual.getString("no_jual");
                dataTable[x][1] = RsJual.getDate("tgl_jual");
                dataTable[x][2] = RsJual.getString("nm_kons");
                dataTable[x][3] = RsJual.getString("kd_brg");
                dataTable[x][4] = RsJual.getString("nm_brg");
                dataTable[x][5] = cf.customFormat("###,###.##", RsJual.getDouble("harga_jual"));
                dataTable[x][6] = RsJual.getInt("jml_jual");
                dataTable[x][7] = cf.customFormat("###,###.##", RsJual.getDouble("totjual"));
                x++;
            }
            tblLapJual.setModel(new DefaultTableModel(dataTable, header));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            new ExportToExcel(tblLapJual, new File("DataPenjualan.xls"));
            JOptionPane.showMessageDialog(null, "Sukses Export data .....");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        dtAwal = new datechooser.beans.DateChooserCombo();
        jLabel2 = new javax.swing.JLabel();
        dtAkhir = new datechooser.beans.DateChooserCombo();
        cmdCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLapJual = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laporan Penjualan");

        jLabel1.setText("Tgl");

        jLabel2.setText("s/d");

        cmdCari.setText("Cari");

        tblLapJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Jual", "Tanggal", "Nama Konsumen", "Kode Barang", "Nama Barang", "Harga Satuan", "Jumlah", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblLapJual);

        jButton1.setText("Export");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmdCari))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dtAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmdCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LapPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LapPenjualan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCari;
    private datechooser.beans.DateChooserCombo dtAkhir;
    private datechooser.beans.DateChooserCombo dtAwal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLapJual;
    // End of variables declaration//GEN-END:variables
}
