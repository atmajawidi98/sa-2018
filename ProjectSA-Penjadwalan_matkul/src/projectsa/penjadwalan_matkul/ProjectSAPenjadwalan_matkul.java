/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsa.penjadwalan_matkul;

/**
 *
 * @author mbek
 */
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;
class MatKul{
    int id;
    String nama,sks,awal,akhir,dosen;
 
    public MatKul(int id, String nama, String sks, String awal, String akhir, String dosen)
    {
        this.id = id;
        this.nama = nama;
        this.sks = sks;
        this.awal = awal;
        this.akhir = akhir;
        this.dosen = dosen;
    }
     
    public int getId()
    {
       return id;
    }
     
    public String getNama()
    {
       return nama;
    }
     
    public String getSks()
    {
       return sks;
    }
    public String getAwal()
    {
       return awal;
    }
    public String getAkhir()
    {
       return akhir;
    }
    public String getDosen()
    {
       return dosen;
    }
}
public class ProjectSAPenjadwalan_matkul {
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<MatKul> matkul;
        class TampilData{

        ArrayList<MatKul> tampung;

        public TampilData()
        {
            //instansiasi
            tampung = new ArrayList<MatKul>();
        }

        public void isiData(int id, String nama, String sks, String awal, String akhir, String dosen)
        {
            tampung.add(new MatKul(id,nama,sks,awal,akhir,dosen));
        }

        public void showData()
        {
            for(MatKul matkul:tampung)
            {
                System.out.println("id matkul : "+matkul.getId()+""+", Nama Matkul : "+matkul.getNama()+""+", sks : "+matkul.getSks()+""+", Jam Awal : "+matkul.getAwal()+""+", Jam Akhir : "+matkul.getAkhir()+""+", Dosen : "+matkul.getDosen());
            }
        }
        }
        
    TampilData td = new TampilData();
 
    String url = "jdbc:mysql://localhost/datamat";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            Statement start = (Statement) conn.createStatement();
            Statement start2 = (Statement) conn.createStatement();
            
                ResultSet rs = start.executeQuery("SELECT * FROM datam");
                while (rs.next()) {
                    td.isiData(rs.getInt("ID"),rs.getString("NAMA"),rs.getString("SKS"),rs.getString("JAM_AWAL"),rs.getString("JAM_AKHIR"),rs.getString("DOSEN"));
                }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        
     td.showData();
    }
    
}
