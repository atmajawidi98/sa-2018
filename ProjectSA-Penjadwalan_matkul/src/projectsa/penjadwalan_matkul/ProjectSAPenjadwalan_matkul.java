package projectsa.penjadwalan_matkul;

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
        String url = "jdbc:mysql://localhost/datamat";
        String user = "root";
        String password = "";
        // TODO code application logic here
        ArrayList<MatKul> matkul;
        Scanner input = new Scanner(System.in);
        
        class TampilData2{

        ArrayList<MatKul> tampung2;
        int x;
        public TampilData2()
        {
            //instansiasi
            tampung2 = new ArrayList<MatKul>();
        }

        public void isiData(int id, String nama, String sks, String awal, String akhir, String dosen)
        {    
        }

        public void showData()
        {
            
            for(MatKul matkul:tampung2)
            {
            }
        }
        }
        class TampilData{
        ArrayList<MatKul> tampung;
        int x;
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
                System.out.println("id matkul : "+matkul.getId()+""+", Nama Matkul : "+matkul.getNama());
            }
        }
        
        }
        
    TampilData td = new TampilData();
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            Statement start = (Statement) conn.createStatement();
            Statement start2 = (Statement) conn.createStatement();
            
                ResultSet rs = start.executeQuery("SELECT * FROM datam GROUP BY NAMA order by ID");
                while (rs.next()) {
                    td.isiData(rs.getInt("ID"),rs.getString("NAMA"),rs.getString("SKS"),rs.getString("JAM_AWAL"),rs.getString("JAM_AKHIR"),rs.getString("DOSEN"));
                }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
     int loop = 0;
     while(loop == 0){
        td.showData();
         System.out.println("Pilih kode mata kuliah yang akan diambil :");
         int kode;
         kode = input.nextInt();
        
         System.out.println("Memilih mata kuliah lagi?");
         String tanya;
         tanya = input.next();
         if(tanya.equals("n") || tanya.equals("N")){
             loop = 1;
             break;
         }
     }
    }
    
}
