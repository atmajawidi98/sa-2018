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
class dfs{
    String nama;
    int jam,opsi;
    public dfs(String nama, int jam, int opsi)
    {
        this.nama = nama;
        this.jam = jam;
        this.opsi = opsi;
    }
    public String getNama()
    {
       return nama;
    }
    public int getJam()
    {
       return jam;
    }
    public int getOpsi()
    {
       return opsi;
    }
}
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
        ArrayList<dfs> DFS;
        int x;
        public TampilData2()
        {
            //instansiasi
            tampung2 = new ArrayList<MatKul>();
            DFS = new ArrayList<dfs>();
        }

        public void isiData(int id, String nama, String sks, String awal, String akhir, String dosen)
        {
            if(tampung2.isEmpty()){
                tampung2.add(new MatKul(id,nama,sks,awal,akhir,dosen));
            }
            else{
                int x = 0;
                for(MatKul matkul:tampung2)
                {
                    if(matkul.getId()==id){
                        x=1;
                        System.out.println("Matakuliah sudah diambil");
                        break;
                    }
                    
                }
                if(x==0){
                    tampung2.add(new MatKul(id,nama,sks,awal,akhir,dosen));
                }
            }
            
        }

        public void showData()
        {
            
            for(MatKul matkul:tampung2)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = (Connection) DriverManager.getConnection(url, user, password);
                    Statement start = (Statement) conn.createStatement();
                    Statement start2 = (Statement) conn.createStatement();

                        ResultSet rs = start.executeQuery("SELECT * FROM datam WHERE NAMA='"+matkul.getNama()+"' order by ID");
                        int x = 1;
                        while (rs.next()) {
                            int menit = 0;
                            String[] jamx = rs.getString("JAM_AWAL").split(":");
                            System.out.println("id matkul : "+matkul.getId()+""+", Nama Matkul : "+matkul.getNama()+""+", Jam Awal : "+rs.getString("JAM_AWAL"));
                            menit = Integer.parseInt(jamx[0]);
                            menit = menit*60;
                            menit = menit+Integer.parseInt(jamx[1]);
                            
                            if(DFS.isEmpty()){
                                DFS.add(new dfs(matkul.getNama(),menit,x));
                            }else{
                                for(dfs xyz:DFS)
                                {
                                    if(matkul.getNama() == xyz.getNama()){
                                        x = x+1;
                                        break;
                                    }else{
                                        x=1;
                                    }
                                }
                                DFS.add(new dfs(matkul.getNama(),menit,x));
                            }
                        }
                } catch (Exception e) {
                    
                }
            }
        }
        public void showData2()
        {
            for(dfs xyz:DFS)
            {
                /*
                String realjam = "";
                String realmin = "";
                int x = xyz.getJam()/60;
                int y = xyz.getJam()%60;
                if(x<10){
                    realjam = "0"+x;
                }else{
                    realjam = ""+x;
                }
                if(y<10){
                    realmin = "0"+y;
                }else{
                    realmin = ""+y;
                }
                String real= realjam+":"+realmin; 
                System.out.println(xyz.getNama()+"  --  "+real+"  --  "+xyz.getOpsi());
                */
                String realjam = "";
                String realmin = "";
                int x = xyz.getJam()/60;
                int y = xyz.getJam()%60;
                if(x<10){
                    realjam = "0"+x;
                }else{
                    realjam = ""+x;
                }
                if(y<10){
                    realmin = "0"+y;
                }else{
                    realmin = ""+y;
                }
                String real= realjam+":"+realmin; 
                System.out.println(xyz.getNama()+""+real+""+xyz.getOpsi());
                
                System.out.println(DFS.size());
            }
        }
        }
        class TampilData{
        TampilData2 td2 = new TampilData2();
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
        public void showData2(int x)
        {
            for(MatKul matkul:tampung)
            {
                if(matkul.getId()==x){
                    td2.isiData(matkul.getId(), matkul.getNama(), matkul.getSks(), matkul.getAwal(), matkul.getAkhir(), matkul.getDosen());
                }
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
         td.showData2(kode);
         System.out.println("Memilih mata kuliah lagi?");
         String tanya;
         tanya = input.next();
         if(tanya.equals("n") || tanya.equals("N")){
             td.td2.showData();
             td.td2.showData2();
             loop = 1;
             break;
         }
     }
    }
    
}
