/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum11;

/**
 *
 * @author Andika Bayu S
 */
import java.sql.*;

public class KoneksiMysql {

    String url, usr, pwd, dbn;

    public KoneksiMysql(String dbn) {
        this.url = "jdbc:mysql://localhost/" + dbn;
        this.usr = "root";
        this.pwd = "";
    }

    public KoneksiMysql(String host, String user, String pass, String dbn) {
        this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr = user;
        this.pwd = pass;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.usr, this.pwd);
            System.out.println("Berhasil: Koneksi ke database '" + this.url + "' sukses!");
        } catch (ClassNotFoundException e) {
            System.err.println("Error #1: Driver MySQL tidak ditemukan!.");
            System.err.println("Detail Error: " + e.getMessage());
            System.exit(0);
        } catch (SQLException e) {
            System.err.println("Error #2: Gagal terhubung ke database!");
            System.err.println("Detail Error: " + e.getMessage());
            System.exit(0);
        }
        return con;
    }

    
    public static void main (String args[]) {
        KoneksiMysql kon = new KoneksiMysql ("penjualan");
        Connection c = kon.getConnection();
    }
}