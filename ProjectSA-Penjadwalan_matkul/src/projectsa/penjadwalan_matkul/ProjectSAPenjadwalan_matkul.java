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
import java.util.Stack;
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
        public int getTampung() {
                return tampung2.size();
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
            int x = 1;
            for(MatKul matkul:tampung2)
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = (Connection) DriverManager.getConnection(url, user, password);
                    Statement start = (Statement) conn.createStatement();
                    Statement start2 = (Statement) conn.createStatement();
                        ResultSet rs = start.executeQuery("SELECT * FROM `datam` WHERE NAMA = '"+matkul.getNama()+"' ORDER BY JAM_AWAL ASC");
                        
                        while (rs.next()) {
                            int menit = 0;
                            String[] jamx = rs.getString("JAM_AWAL").split(":");
                            System.out.println("id matkul : "+matkul.getId()+""+", Nama Matkul : "+matkul.getNama()+""+", Jam Awal : "+rs.getString("JAM_AWAL")+" - "+x);
                            menit = Integer.parseInt(jamx[0]);
                            menit = menit*60;
                            menit = menit+Integer.parseInt(jamx[1]);
                            DFS.add(new dfs(matkul.getNama(),menit,x));
                        }
                } catch (Exception e) {
                    
                }
                
                x=x+1;
            }
        }
        public void showData2()
        {
            int x =0;
            Stack<dfs> nodeStack = new Stack<>();
            ArrayList<dfs> matkul1 = new ArrayList<>();
            ArrayList<dfs> matkul2 = new ArrayList<>();
            ArrayList<dfs> matkul3 = new ArrayList<>();
            ArrayList<dfs> matkul4 = new ArrayList<>();
            ArrayList<dfs> matkul5 = new ArrayList<>();
            int angka1=0;
            int angka2=0;
            int angka3=0;
            int angka4=0;
            int angka5=0;
            int loop = 1;
            while(DFS.size()>x)
            {
                System.out.println(DFS.get(x).getOpsi());
                if(DFS.get(x).getOpsi()==1){
                    matkul1.add(DFS.get(x));
                }
                if(DFS.get(x).getOpsi()==2){
                    matkul2.add(DFS.get(x));
                }
                if(DFS.get(x).getOpsi()==3){
                    matkul3.add(DFS.get(x));
                }
                if(DFS.get(x).getOpsi()==4){
                    matkul4.add(DFS.get(x));
                }
                if(DFS.get(x).getOpsi()==5){
                    matkul5.add(DFS.get(x));
                }
                x++;
            }
            while(loop<99){
                if(loop == 1){
                    if(matkul1.size()>angka1){
                        nodeStack.add(matkul1.get(angka1) );
                        System.out.println("add 1");

                        loop=2;
                    }
                    else{

                    }
                }
                if(loop == 2){
                    if(matkul2.isEmpty()){
                        break;
                    }
                    if(matkul2.size()>angka2){
                        if(nodeStack.get(0).getJam()==matkul2.get(angka2).getJam()){
                            angka2++;
                        }
                        else{
                            nodeStack.add(matkul2.get(angka2) );
                            System.out.println("add 2");

                            loop=3;
                        }
                    }
                    else{
                       angka2=0;
                       nodeStack.pop();
                        System.out.println("pop 1");
                       loop=1;
                       angka1++;
                    }
                }
                if(loop == 3){
                    if(matkul3.isEmpty()){
                        break;
                    }
                    if(matkul3.size()>angka3){
                        if(nodeStack.get(1).getJam()==matkul3.get(angka3).getJam()){
                            angka3++;
                        }
                        else if(nodeStack.get(0).getJam()==matkul3.get(angka3).getJam()){
                            angka3++;
                        }
                        else{
                            nodeStack.add(matkul3.get(angka3) );
                            System.out.println("add 3");

                            loop=4;
                        }
                    }
                    else{
                       angka3=0;
                       nodeStack.pop();
                        System.out.println("pop 2");
                       loop=2;
                       angka2++;
                    }
                }
                if(loop == 4){
                    if(matkul4.isEmpty()){
                        break;
                    }
                    if(matkul4.size()>angka4){
                        if(nodeStack.get(1).getJam()==matkul4.get(angka4).getJam()){
                            angka4++;
                        }
                        else if(nodeStack.get(2).getJam()==matkul4.get(angka4).getJam()){
                            angka4++;
                        }
                        else if(nodeStack.get(0).getJam()==matkul4.get(angka4).getJam()){
                            angka4++;
                        }
                        else{
                            nodeStack.add(matkul4.get(angka4) );
                            System.out.println("add 4");

                            loop=5;
                        }
                    }
                    else{
                       angka4=0;
                       nodeStack.pop();
                        System.out.println("pop 3");
                       loop=3;
                       angka3++;
                    }
                }
                if(loop == 5){
                    if(matkul5.isEmpty()){
                        break;
                    }
                    if(matkul5.size()>angka5){
                        if(nodeStack.get(1).getJam()==matkul5.get(angka5).getJam()){
                            angka5++;
                        }
                        else if(nodeStack.get(2).getJam()==matkul5.get(angka5).getJam()){
                            angka5++;
                        }
                        else if(nodeStack.get(3).getJam()==matkul5.get(angka5).getJam()){
                            angka5++;
                        }
                        else if(nodeStack.get(0).getJam()==matkul5.get(angka5).getJam()){
                            angka5++;
                        }
                        else{
                            nodeStack.add(matkul5.get(angka5) );
                            System.out.println("add 5");

                            loop=99;
                        }
                    }
                    else{
                       angka5=0;
                       nodeStack.pop();
                        System.out.println("pop 4");
                       loop=4;
                       angka4++;
                    }
                }
            }
            
                for(dfs hasil:nodeStack){
                    String realjam = "";
                    String realmin = "";
                    int xa = hasil.getJam()/60;
                    int ya = hasil.getJam()%60;
                    if(xa<10){
                        realjam = "0"+xa;
                    }else{
                        realjam = ""+xa;
                    }
                    if(ya<10){
                        realmin = "0"+ya;
                    }else{
                        realmin = ""+ya;
                    }
                    String real= realjam+":"+realmin; 
                    System.out.println(hasil.getNama()+" "+real+" "+hasil.getOpsi());
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
        
     int loop = 1;
     while(loop != 0){
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
             break;
         }
         else if(tanya.equals("y") || tanya.equals("Y")){
         if(td.td2.getTampung()==5){
           td.td2.showData();
             td.td2.showData2();
             break;  
         }
         }
         else{
             System.out.println("Inputan salah!!");
         }
     }
    }
    
}
