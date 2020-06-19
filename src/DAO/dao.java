/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITAS.entitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dao {

    private Connection conn = null;

    public dao(Connection con) {
        this.conn = con;
    }

//    public boolean inputdata(entitas t) {
//        boolean vali = false;
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement("INSERT INTO tbmakan (kode,nama_menu,harga,jumlah,total) VALUES(?,?,?,?,?)");
//            
//            ps.setString(1, t.getKode());
//            ps.setString(2, t.getNama_menu());
//            ps.setString(3, t.getHarga());
//            ps.setString(4, t.getJumlah());
//            ps.setString(5, t.getTotal());
//            if (ps.executeUpdate() > 0) {
//                vali = true;
//            }
//        } catch (Exception e) {
//        }
//        return vali;
//    }
    public boolean inputNota2(entitas t) {
        boolean vali = false;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO transaksi (id_nota,kode_menu,jumlah) VALUES(?,?,?)");
            ps.setInt(1, t.getId_nota());
            ps.setString(2, t.getKode_menu());
            ps.setInt(3, t.getJumlah());
            if (ps.executeUpdate() > 0) {
                vali = true;
            }
        } catch (Exception e) {
        }
        return vali;
    }

    public boolean inputTransaksi(entitas t) {
        boolean hasil = false;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO transaksi (id_nota,kode_menu,jumlah) VALUES(?,?,?)");
            ps.setInt(1, t.getId_nota());
            ps.setString(2, t.getKode_menu());
            ps.setInt(3, t.getJumlah());
            if (ps.executeUpdate() > 0) {
                hasil = true;
            }
        } catch (Exception e) {
        }
        return hasil;
    }

    public boolean inputNota(entitas t) {
        boolean hasil = false;
        PreparedStatement ps;

        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String sDate1 = formatter.format(date);

            

            ps = conn.prepareStatement("INSERT INTO nota_resto (id_nota,tanggal,total,di_karyawan) VALUES (?,?,?,?)");
            ps.setInt(1, t.getId_nota());
            ps.setString(2, sDate1);
            ps.setInt(3, t.getTotal());
            ps.setInt(4, t.getId_karyawan());
            if (ps.executeUpdate() > 0) {
                hasil = true;
            }
        } catch (Exception e) {
        }
        return hasil;
    }

    public List<entitas> getMenu() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM menu");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setKode_menu(rs.getString(1));
                t.setNama_menu(rs.getString(2));
                t.setHarga_menu(rs.getInt(3));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }

    public List<entitas> cariMenu(String cari) {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM menu where kode_menu LIKE '%"
                    + cari + "%' OR nama_menu LIKE '%" + cari + "%' OR harga_menu LIKE '%"
                    + cari + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setKode_menu(rs.getString(1));
                t.setNama_menu(rs.getString(2));
                t.setHarga_menu(rs.getInt(3));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }

    public List<entitas> getUser() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM user_karyawan");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setId_karyawan(rs.getInt(1));
                t.setNama_lengkap(rs.getString(2));
                t.setUsername(rs.getString(3));
                t.setPassword(rs.getString(4));

                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }

    public List<entitas> getNoNota() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT MAX(id_nota) FROM nota_resto");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setId_nota(rs.getInt(1));

                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }

}
