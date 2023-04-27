
package projekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Akun implements menuAdmin{
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    static ArrayList<Lapangan> Futsal = new ArrayList<>();

    static ArrayList<Lapangan>getlistfutsal(){
        return Futsal;
    }
    static ArrayList<Lapangan> sepakBola = new ArrayList<>();

    static ArrayList<Lapangan>getlistbola(){
        return sepakBola;
    }
    static ArrayList<Lapangan> miniSoccer = new ArrayList<>();

    static ArrayList<Lapangan>getlistmini(){
        return miniSoccer;
    }

    static ArrayList<Penyewaan> sewaFutsal = Customer.getfutsal();
    static ArrayList<Penyewaan> sewaBola = Customer.getbola();
    static ArrayList<Penyewaan> sewaMini = Customer.getmini();
    
    private String nama;
    private String noTelp;
    
    public Admin(String User,String Pass, String Nama,String noTelp){
        super(User,Pass);
        this.nama = Nama;
        this.noTelp = noTelp;
    }
    
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNoTelp() {
        return nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    @Override
    public void Create() throws IOException{
        System.out.println("============================");
        System.out.println("|   Tambah Data Lapangan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        try{
            int pilih = Integer.parseInt(br.readLine());
        clear();
        switch (pilih) {
            case 1:
                {
                    System.out.println("===TAMBAH LAPANGAN FUTSAL===\n");
                    System.out.print("Masukkan Nama Lapangan : ");
                    String lap = br.readLine();
                    System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                    int harga = Integer.parseInt(br.readLine());
                    System.out.println("Masukkan Jenis Lapangan ");
                    System.out.println("\t1.Matras");
                    System.out.println("\t2.Rumput");
                    System.out.print("Masukkan Pilihan Anda : ");
                    int pil = Integer.parseInt(br.readLine());
                    String jenis = "";
                    if(pil == 1){
                        jenis = "Matras";
                    }
                    else if(pil == 2){
                        jenis = "Rumput";
                    }
                    Lapangan fut = new Lapangan(lap,harga,jenis);
                    Futsal.add(fut);
                    fut.sukses();
                    break;
                }
            case 2:
                {
                    System.out.println("===TAMBAH LAPANGAN SEPAK BOLA===\n");
                    System.out.print("Masukkan Nama Lapangan : ");
                    String lap = br.readLine();
                    System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                    int harga = Integer.parseInt(br.readLine());
                    System.out.println("Masukkan Jenis Lapangan : ");
                    System.out.println("1.Rumput Sintetis");
                    System.out.println("2.Rumput Biasa");
                    System.out.print("Masukkan Pilihan Anda : ");
                    int pil = Integer.parseInt(br.readLine());
                    String jenis = "";
                    if(pil == 1){
                        jenis = "Rumput Sintetis";
                    }
                    else if(pil == 2){
                        jenis = "Rumput Biasa";
                    }
                    Lapangan spk = new Lapangan(lap,harga,jenis);
                    sepakBola.add(spk);
                    spk.sukses();
                    break;
                }
            case 3:
                {
                    System.out.println("===TAMBAH LAPANGAN MINI SOCCER===\n");
                    System.out.print("Masukkan Nama Lapangan : ");
                    String lap = br.readLine();
                    System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                    int harga = Integer.parseInt(br.readLine());
                    String jenis = "Rumput Sintetis";
                    Lapangan mini = new Lapangan(lap,harga,jenis);
                    miniSoccer.add(mini);
                    mini.sukses();
                    break;
                }
            default:
                System.out.println("Pilihan Tidak Ada!");
                Press();
                break;      
            }
        }  catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    
    public static void futsal(){
        if(Futsal.isEmpty()){
            System.out.println("Data Masih Kosong!\n");
        }else{
            System.out.println("=======================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|","No","|","Nomor Lapangan",
                    "|","Harga Per-Jam(Siang)","|","Harga Per-Jam(Malam)","|","Jenis Lapangan","|\n");
            System.out.println("=======================================================================================");
            for(int i = 0;i<Futsal.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|",i+1,"|",Futsal.get(i).getLapangan(),
                    "|","Rp."+Futsal.get(i).getHarga(),"|","Rp."+(Futsal.get(i).getHarga() + 30000),"|",Futsal.get(i).getJenis(),"|\n");
            }
            System.out.println("=======================================================================================");           
        }
    }
    public static void sepakBola(){
        if(sepakBola.isEmpty()){
            System.out.println("Data Masih Kosong!\n");
        }else{
            System.out.println("=======================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|","No","|","Nomor Lapangan",
                    "|","Harga Per-Jam(Siang)","|","Harga Per-Jam(Malam)","|","Jenis Lapangan","|\n");
            System.out.println("=======================================================================================");
            for(int i = 0;i<sepakBola.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|",i+1,"|",sepakBola.get(i).getLapangan(),
                    "|","Rp."+sepakBola.get(i).getHarga(),"|","Rp."+(sepakBola.get(i).getHarga() + 200000),"|",sepakBola.get(i).getJenis(),"|\n");
            }
            System.out.println("=======================================================================================");
        }
    }
    public static void miniSoccer(){
        if(miniSoccer.isEmpty()){
            System.out.println("Data Masih Kosong!\n");
        }else{
            System.out.println("=======================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|","No","|","Nomor Lapangan",
                    "|","Harga Per-Jam(Siang)","|","Harga Per-Jam(Malam)","|","Jenis Lapangan","|\n");
            System.out.println("=======================================================================================");
            for(int i = 0;i<miniSoccer.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-20s %1s %-20s %1s %-15s %1s","|",i+1,"|",miniSoccer.get(i).getLapangan(),
                    "|","Rp."+miniSoccer.get(i).getHarga(),"|","Rp."+(miniSoccer.get(i).getHarga() + 200000),"|",miniSoccer.get(i).getJenis(),"|\n");
            }
            System.out.println("=======================================================================================");
        }
    }
    
    @Override
    public void ReadLap() throws IOException{
        System.out.println("============================");
        System.out.println("|    Lihat Data Lapangan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        try{
            int pilih = Integer.parseInt(br.readLine());
            switch(pilih){
            case 1 :
                clear();
                futsal();
                Press();
                break;
            case 2 :
                clear();
                sepakBola();
                Press();
                break;
            case 3 :
                clear();
                miniSoccer();
                Press();
                break;
            default:
                System.out.println("Pilihan Tidak Ada!");
                Press();
                break;
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    
    @Override
    public void ReadSewa() throws IOException{
        System.out.println("============================");
        System.out.println("|   Lihat Data Penyewaan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        try{
            int pilih = Integer.parseInt(br.readLine());
        switch(pilih){
            case 1 :
                clear();
                Customer.futsal();
                Press();
                break;
            case 2 :
                clear();
                Customer.sepakBola();
                Press();
                break;
            case 3 :
                clear();
                Customer.miniSoccer();
                Press();
                break;
            default:
                System.out.println("Pilihan Tidak Ada!");
                Press();
                break;
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    @Override
    public void Update() throws IOException{
        System.out.println("============================");
        System.out.println("|   Update Data Lapangan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        
        try{
            int pilih = Integer.parseInt(br.readLine());
        int index;
        if(pilih == 1){
            clear();
            if(!Futsal.isEmpty()){
                futsal();
                System.out.println("===UPDATE LAPANGAN FUTSAL===\n");
                System.out.print("Ingin Ubah Data Lapangan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                System.out.print("Masukkan Nama Lapangan : ");
                String upLap = br.readLine();
                System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                int upHarga = Integer.parseInt(br.readLine());
                System.out.println("Masukkan Jenis Lapangan : ");
                System.out.println("1.Matras");
                System.out.println("2.Rumput");
                System.out.print("Masukkan Pilihan Anda : ");
                int pil = Integer.parseInt(br.readLine());
                String Upjenis = "";
                if(pil == 1){
                    Upjenis = "Matras";
                }
                else if(pil == 2){
                    Upjenis = "Rumput";
                }
                Futsal.get(index).setLapangan(upLap);
                Futsal.get(index).setHarga(upHarga);
                Futsal.get(index).setJenis(Upjenis);
                System.out.println("Data Berhasil diubah!");
                Press();
            }else{
                futsal();
                Press();
            }
        }else if(pilih == 2){
            clear();
            if(!sepakBola.isEmpty()){
                sepakBola();
                System.out.println("===UPDATE LAPANGAN SEPAK BOLA===\n");
                System.out.print("Ingin Ubah Data Lapangan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                System.out.print("Masukkan Nama Lapangan : ");
                String upLap = br.readLine();
                System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                int upHarga = Integer.parseInt(br.readLine());
                System.out.println("Masukkan Jenis Lapangan : ");
                System.out.println("1.Rumput Sintetis");
                System.out.println("2.Rumput Biasa");
                System.out.print("Masukkan Pilihan Anda : ");
                int pil = Integer.parseInt(br.readLine());
                String Upjenis = "";
                if(pil == 1){
                    Upjenis = "Rumput Sintetis";
                }
                else if(pil == 2){
                    Upjenis = "Rumput Biasa";
                }
                sepakBola.get(index).setLapangan(upLap);
                sepakBola.get(index).setHarga(upHarga);
                sepakBola.get(index).setJenis(Upjenis);
                System.out.println("Data Berhasil diubah!");
                Press();
            }else{
                sepakBola();
                Press();
            }
        }else if(pilih == 3){
            clear();
            if(!miniSoccer.isEmpty()){
                miniSoccer();
                System.out.println("===UPDATE LAPANGAN MINI SOCCER===\n");
                System.out.print("Ingin Ubah Data Lapangan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                System.out.print("Masukkan Nama Lapangan : ");
                String upLap = br.readLine();
                System.out.print("Masukkan Harga Lapangan Per-Jam : ");
                int upHarga = Integer.parseInt(br.readLine());
                String Upjenis = "Rumput Sintetis";
                miniSoccer.get(index).setLapangan(upLap);
                miniSoccer.get(index).setHarga(upHarga);
                miniSoccer.get(index).setJenis(Upjenis);
                System.out.println("Data Berhasil diubah!");
                Press();
            }else{
                miniSoccer();
                Press();
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    @Override
    public void Delete() throws IOException{
        System.out.println("============================");
        System.out.println("|    Hapus Data Lapangan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        
        try{
            int pilih = Integer.parseInt(br.readLine());
            int index;
        clear();
        if(pilih == 1){
            clear();
            if(!Futsal.isEmpty()){
                futsal();
                System.out.println("===HAPUS LAPANGAN FUTSAL===\n");
                System.out.print("Ingin Hapus Data Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                Futsal.remove(index);
                System.out.println("Data Berhasil Dihapus!");
            }else{
                futsal();
                Press();
            }
        }else if(pilih == 2){
            clear();
            if(!sepakBola.isEmpty()){
                sepakBola();
                System.out.println("===HAPUS LAPANGAN SEPAK BOLA===\n");
                System.out.print("Ingin Hapus Data Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                sepakBola.remove(index);
                System.out.println("Data Berhasil Dihapus!");
            }else{
                sepakBola();
                Press();
            }
        }else if(pilih == 3){
            clear();
            if(!miniSoccer.isEmpty()){
                miniSoccer();
                System.out.println("===HAPUS LAPANGAN MINI SOCCER===\n");
                System.out.print("Ingin Hapus Data Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                miniSoccer.remove(index);
                System.out.println("Data Berhasil Dihapus!");
            }else{
                miniSoccer();
                Press();
            }
        }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    
    public void Press()throws IOException{
        System.out.print("Tekan Enter Untuk Kembali....");
        br.readLine();
    }
    
    @Override
    public void Menu()throws IOException{
        int menu = 0;
        while (menu != 5 ){
            clear();
            System.out.println("============================");
            System.out.println("|        MENU ADMIN        |");
            System.out.println("============================");
            System.out.println("1.Tambah Data Lapangan");
            System.out.println("2.Lihat Data");
            System.out.println("3.Ubah Data Lapangan");
            System.out.println("4.Hapus Data Lapangan");
            System.out.println("5.Log Out");
            System.out.print("Masukkan Pilihan Anda : ");
            
            try{
                menu = Integer.parseInt(br.readLine());
            clear();
            switch(menu){
                case 1:
                    clear();
                    Create();
                    break;
                case 2:
                    clear();
                    System.out.println("============================");
                    System.out.println("|        Lihat Data        |");
                    System.out.println("============================");
                    System.out.println("1.Lihat Data Lapangan");
                    System.out.println("2.Lihat Data Sewaan");
                    System.out.print("Masukkan Pilihan Anda : ");
                    int pilih = Integer.parseInt(br.readLine());
                    if (pilih == 1){
                        clear();
                        ReadLap();
                    }else if(pilih == 2){
                        clear();
                        ReadSewa();
                    }
                    break;
                case 3:
                    clear();
                    Update();
                    break;
                case 4:
                    clear();
                    Delete();
                    break;
                case 5:
                    clear();
                    System.out.println("Selamat Tinggal " + getNama());
                    return;
                default:
                    System.out.println("Pilihan Tidak Ada!");
                    break;
                }
            }catch (IOException e) {
                System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
            }
        }
    }
    
    final public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
