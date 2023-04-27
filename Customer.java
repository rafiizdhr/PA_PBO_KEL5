
package projekAkhir;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Customer extends Akun implements menuCustomer {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static ArrayList<Lapangan> Futsal = Admin.getlistfutsal();
    static ArrayList<Lapangan> sepakBola = Admin.getlistbola();
    static ArrayList<Lapangan> miniSoccer = Admin.getlistmini();
    static ArrayList<Penyewaan> sewaFutsal = new ArrayList<>();
    static ArrayList<Penyewaan>getfutsal(){
        return sewaFutsal;
    }
    static ArrayList<Penyewaan> sewaBola = new ArrayList<>();
    static ArrayList<Penyewaan>getbola(){
        return sewaBola;
    }
    static ArrayList<Penyewaan> sewaMini = new ArrayList<>();
    static ArrayList<Penyewaan>getmini(){
        return sewaMini;
    }
    
    private String nama;
    private String noTelp;
    
    public Customer(String User, String Pass, String Nama, String NoTelp){
        super(User,Pass);
        this.nama = Nama;
        this.noTelp = NoTelp;
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
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @Override
    public void Create() throws IOException {
        System.out.println("============================");
        System.out.println("|      Pesan Lapangan      |");
        System.out.println("============================");
        System.out.println("1.Futsal");
        System.out.println("2.Sepak Bola");
        System.out.println("3.Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        
        try{
            int pilih = Integer.parseInt(br.readLine());
            if(pilih == 1){
            clear();
            System.out.println("===Data Penyewa Sebelumnya===\n");
            futsal();
            Admin.futsal();

            System.out.println("============================");
            System.out.println("|      Pesan Lapangan      |");
            System.out.println("============================");
            System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
            int index = Integer.parseInt(br.readLine())-1;
            System.out.print("Hari : ");
            String hari = br.readLine();
            int jam;
            do{
               System.out.print("Jam (9 - 23) : ");
               jam = Integer.parseInt(br.readLine()); 
               if(jam<=9 && jam >=23){
               System.out.println("Silahkan Pilih Jam yang disediakan");
               }
            }while(jam <9 || jam > 23);
            System.out.print("Waktu Sewa : ");
            int waktu = Integer.parseInt(br.readLine());
            String lap = Futsal.get(index).getLapangan();
            String jenis = Futsal.get(index).getJenis();
            int harga = 0;
            int total = 0;
            if(jam < 18){
                harga = Futsal.get(index).getHarga();
                total = harga * waktu;
            }else if(jam > 17){
                harga = Futsal.get(index).getHarga() + 30000;
                total = harga * waktu;
            }
            Penyewaan p = new Penyewaan(getNama(),lap,jenis,hari,jam,harga,waktu,total);
            sewaFutsal.add(p);
            clear();

        }else if(pilih == 2){
            clear();
            System.out.println("===Data Penyewa Sebelumnya===\n");
            sepakBola();
            Admin.sepakBola();

            System.out.println("============================");
            System.out.println("|      Pesan Lapangan      |");
            System.out.println("============================");
            System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
            int index = Integer.parseInt(br.readLine())-1;
            System.out.print("Hari : ");
            String hari = br.readLine();
            int jam;
            do{
               System.out.print("Jam (9 - 23) : ");
               jam = Integer.parseInt(br.readLine()); 
               if(jam<=9 && jam >=23){
               System.out.println("Silahkan Pilih Jam yang disediakan");
               }
            }while(jam <9 || jam > 23);
            System.out.print("Waktu Sewa : ");
            int waktu = Integer.parseInt(br.readLine());
            String lap = sepakBola.get(index).getLapangan();
            String jenis = sepakBola.get(index).getJenis();
            int harga = 0;
            int total = 0;
            if(jam < 18){
                harga = sepakBola.get(index).getHarga();
                total = harga * waktu;
            }else if(jam > 17){
                harga = sepakBola.get(index).getHarga() + 200000;
                total = harga * waktu;
            }
            Penyewaan p = new Penyewaan(getNama(),lap,jenis,hari,jam,harga,waktu,total);
            sewaBola.add(p);
            clear();

        }else if(pilih == 3){
            clear();
            System.out.println("===Data Penyewa Sebelumnya===\n");
            miniSoccer();
            Admin.miniSoccer();

            System.out.println("============================");
            System.out.println("|      Pesan Lapangan      |");
            System.out.println("============================");
            System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
            int index = Integer.parseInt(br.readLine())-1;
            System.out.print("Hari : ");
            String hari = br.readLine();
            int jam;
            do{
               System.out.print("Jam (9 - 23) : ");
               jam = Integer.parseInt(br.readLine()); 
               if(jam<=9 && jam >=23){
               System.out.println("Silahkan Pilih Jam yang disediakan");
               }
            }while(jam <9 || jam > 23);
            System.out.print("Waktu Sewa : ");
            int waktu = Integer.parseInt(br.readLine());
            String lap = miniSoccer.get(index).getLapangan();
            String jenis = miniSoccer.get(index).getJenis();
            int harga= 0;
            int total = 0;
            if(jam < 18){
                harga = miniSoccer.get(index).getHarga();
                total = harga * waktu;
            }else if(jam > 17){
                harga = miniSoccer.get(index).getHarga() + 200000;
                total = harga * waktu;
            }
            
            Penyewaan p = new Penyewaan(getNama(),lap,jenis,hari,jam,harga,waktu,total);
            sewaMini.add(p);  
            clear();
        }
        }catch (IOException e) {
            System.out.println("Terjadi kesalahan pada input/output. Mohon coba lagi.");
        } catch (NumberFormatException e) {
            System.out.println("Input yang dimasukkan harus berupa angka. Mohon coba lagi.");
        }
    }
    public static void futsal(){
        if(sewaFutsal.isEmpty()){
            System.out.println("Data Masih Kosong\n");
        }else{
            System.out.println("==============================================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|","No","|","Nama Penyewa",
                    "|","Nomor Lapangan","|","Jenis Lapangan","|","Hari","|","Jam","|","Waktu Sewa","|","Total Harga","|\n");
            System.out.println("==============================================================================================================");
            for(int i = 0;i<sewaFutsal.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|",i+1,"|",sewaFutsal.get(i).getNama(),
                "|",sewaFutsal.get(i).getLap(),"|",sewaFutsal.get(i).getJenis(),"|",sewaFutsal.get(i).getHari(),"|",sewaFutsal.get(i).getJam()+".00",
                "|",sewaFutsal.get(i).getWaktu()+" Jam","|","Rp."+sewaFutsal.get(i).getTotal(),"|\n");
            }
            System.out.println("==============================================================================================================");
        }
    }
    
    public static void sepakBola(){
        if(sewaBola.isEmpty()){
            System.out.println("Data Masih Kosong\n");
        }else{
            System.out.println("==============================================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|","No","|","Nama Penyewa",
                    "|","Nomor Lapangan","|","Jenis Lapangan","|","Hari","|","Jam","|","Waktu Sewa","|","Total Harga","|\n");
            System.out.println("==============================================================================================================");
            for(int i = 0;i<sewaBola.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|",i+1,"|",sewaBola.get(i).getNama(),
                "|",sewaBola.get(i).getLap(),"|",sewaBola.get(i).getJenis(),"|",sewaBola.get(i).getHari(),"|",sewaBola.get(i).getJam()+".00",
                "|",sewaBola.get(i).getWaktu()+" Jam","|","Rp."+sewaBola.get(i).getTotal(),"|\n");
            }
            System.out.println("==============================================================================================================");
        }
    }
    
    public static void miniSoccer(){
        if(sewaMini.isEmpty()){
            System.out.println("Data Masih Kosong\n");
        }else{
            System.out.println("==============================================================================================================");
            System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|","No","|","Nama Penyewa",
                    "|","Nomor Lapangan","|","Jenis Lapangan","|","Hari","|","Jam","|","Waktu Sewa","|","Total Harga","|\n");
            System.out.println("==============================================================================================================");
            for(int i = 0;i<sewaMini.size();i++){
                System.out.format("%1s %2s %1s %-15s %1s %-15s %1s %-15s %1s %-8s %1s %-8s %1s %-10s %1s %-12s %1s","|",i+1,"|",sewaMini.get(i).getNama(),
                "|",sewaMini.get(i).getLap(),"|",sewaMini.get(i).getJenis(),"|",sewaMini.get(i).getHari(),"|",sewaMini.get(i).getJam()+".00",
                "|",sewaMini.get(i).getWaktu()+" Jam","|","Rp."+sewaMini.get(i).getTotal(),"|\n");
            }
            System.out.println("==============================================================================================================");
        }
    }
    // @Override
    // public void ReadSewa() throws IOException {
    //     System.out.println("============================");
    //     System.out.println("|   Lihat Data Penyewaan   |");
    //     System.out.println("============================");
    //     System.out.println("1.Lapangan Futsal");
    //     System.out.println("2.Lapangan Sepak Bola");
    //     System.out.println("3.Lapangan Mini Soccer");
    //     System.out.print("Masukkan Pilihan Anda : ");
    //     int pilih = Integer.parseInt(br.readLine());
    //     switch(pilih){
    //         case 1 :
    //             clear();
    //             futsal();
    //             Press();
    //             break;
    //         case 2 :
    //             clear();
    //             sepakBola();
    //             Press();
    //             break;
    //         case 3 :
    //             clear();
    //             miniSoccer();
    //             Press();
    //             break;
    //         default:
    //             System.out.println("Pilihan Tidak Ada!");
    //             Press();
    //             break;
    //     }
    // }

    public void readSewa() throws IOException {
        System.out.println("============================");
        System.out.println("|   Lihat Data Penyewaan   |");
        System.out.println("============================");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        int pilih = Integer.parseInt(br.readLine());
        clear();
        readSewa(pilih, -1);
    }

    public void readSewa(int pil1, int pil2) throws IOException {
        if (pil1 == 1){
            futsal();
            Press();clear();
        }

        else if (pil1 == 2){
            sepakBola();
            Press();clear();
        }

        else if (pil1 == 3){
            miniSoccer();
            Press();clear();
        }
    }
    public void Update() throws IOException{
        System.out.println("UPDATE SEWAAN");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        int pilih = Integer.parseInt(br.readLine());
        int index;
        if(pilih==1){
            if(!sewaFutsal.isEmpty()){
                futsal();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaFutsal.get(index).getNama())){
                    Admin.futsal();
                    System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
                    index = Integer.parseInt(br.readLine())-1;
                    System.out.print("Hari : ");
                    String hari = br.readLine();
                    int jam;
                    do{
                       System.out.print("Jam (9 - 23) : ");
                       jam = Integer.parseInt(br.readLine()); 
                       if(jam<=9 && jam >=23){
                       System.out.println("Silahkan Pilih Jam yang disediakan");
                       }
                    }while(jam <9 || jam > 23);
                    System.out.print("Waktu Sewa : ");
                    int waktu = Integer.parseInt(br.readLine());
                    String lap = Futsal.get(index).getLapangan();
                    String jenis = Futsal.get(index).getJenis();
                    int harga = 0;
                    if(jam < 18){
                        harga = Futsal.get(index).getHarga();
                    }else if(jam > 17){
                        harga = (Futsal.get(index).getHarga() + 30000);
                    }
                    int total = harga * waktu;
                    sewaFutsal.get(index).setNama(getNama());
                    sewaFutsal.get(index).setLap(lap);
                    sewaFutsal.get(index).setJenis(jenis);
                    sewaFutsal.get(index).setHari(hari);
                    sewaFutsal.get(index).setJam(jam);
                    sewaFutsal.get(index).setWaktu(waktu);
                    sewaFutsal.get(index).setTotal(total);
                    System.out.println("Data Berhasil diubah!");
                    Press();
                }else{
                    System.out.println("Anda Tidak Dapat Mengubah Data Ini!");
                    Press();
                }
            }else{
                futsal();
                Press();
            }
        }else if(pilih == 2){
            if(!sewaBola.isEmpty()){
                sepakBola();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaBola.get(index).getNama())){
                    Admin.sepakBola();
                    System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
                    index = Integer.parseInt(br.readLine())-1;
                    System.out.print("Hari : ");
                    String hari = br.readLine();
                    int jam;
                    do{
                       System.out.print("Jam (9 - 23) : ");
                       jam = Integer.parseInt(br.readLine()); 
                       if(jam<=9 && jam >=23){
                       System.out.println("Silahkan Pilih Jam yang disediakan");
                       }
                    }while(jam <9 || jam > 23);
                    System.out.print("Waktu Sewa : ");
                    int waktu = Integer.parseInt(br.readLine());
                    String lap = sepakBola.get(index).getLapangan();
                    String jenis = sepakBola.get(index).getJenis();
                    int harga = 0;
                    if(jam < 18){
                        harga = sepakBola.get(index).getHarga();
                    }else if(jam > 17){
                        harga = (sepakBola.get(index).getHarga() + 30000);
                    }
                    int total = harga * waktu;
                    sewaBola.get(index).setNama(getNama());
                    sewaBola.get(index).setLap(lap);
                    sewaBola.get(index).setJenis(jenis);
                    sewaBola.get(index).setHari(hari);
                    sewaBola.get(index).setJam(jam);
                    sewaBola.get(index).setWaktu(waktu);
                    sewaBola.get(index).setTotal(total);
                    System.out.println("Data Berhasil diubah!");
                    Press();
                }else{
                    System.out.println("Anda Tidak Dapat Mengubah Data Ini!");
                    Press();
                }
            }else{
                sepakBola();
                Press();
            }
        }else if(pilih == 3){
            if(!sewaMini.isEmpty()){
                futsal();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaMini.get(index).getNama())){
                    Admin.futsal();
                    System.out.print("Ingin Pesan Lapangan Nomor Berapa : ");
                    index = Integer.parseInt(br.readLine())-1;
                    System.out.print("Hari : ");
                    String hari = br.readLine();
                    int jam;
                    do{
                       System.out.print("Jam (9 - 23) : ");
                       jam = Integer.parseInt(br.readLine()); 
                       if(jam<=9 && jam >=23){
                       System.out.println("Silahkan Pilih Jam yang disediakan");
                       }
                    }while(jam <9 || jam > 23);
                    System.out.print("Waktu Sewa : ");
                    int waktu = Integer.parseInt(br.readLine());
                    String lap = miniSoccer.get(index).getLapangan();
                    String jenis = miniSoccer.get(index).getJenis();
                    int harga = 0;
                    if(jam < 18){
                        harga = miniSoccer.get(index).getHarga();
                    }else if(jam > 17){
                        harga = (miniSoccer.get(index).getHarga() + 30000);
                    }
                    int total = harga * waktu;
                    sewaMini.get(index).setNama(getNama());
                    sewaMini.get(index).setLap(lap);
                    sewaMini.get(index).setJenis(jenis);
                    sewaMini.get(index).setHari(hari);
                    sewaMini.get(index).setJam(jam);
                    sewaMini.get(index).setWaktu(waktu);
                    sewaMini.get(index).setTotal(total);
                    System.out.println("Data Berhasil diubah!");
                    Press();
                }else{
                    System.out.println("Anda Tidak Dapat Mengubah Data Ini!");
                    Press();
                }
            }else{
                miniSoccer();
                Press();
            }
        }
    }
    public void Delete()throws IOException{
        System.out.println("UPDATE SEWAAN");
        System.out.println("1.Lapangan Futsal");
        System.out.println("2.Lapangan Sepak Bola");
        System.out.println("3.Lapangan Mini Soccer");
        System.out.print("Masukkan Pilihan Anda : ");
        int pilih = Integer.parseInt(br.readLine());
        int index;
        if(pilih == 1){
            if(!sewaFutsal.isEmpty()){
                futsal();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaFutsal.get(index).getNama())){
                    sewaFutsal.remove(index);
                    System.out.println("Data Berhasil Dihapus!");
                }else{
                    System.out.println("Anda Tidak Dapat Menghapus Data Ini!");
                }
            }else{
                futsal();
                Press();
            }
        }else if(pilih == 2){
            if(!sewaBola.isEmpty()){
                futsal();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaBola.get(index).getNama())){
                    sewaBola.remove(index);
                    System.out.println("Data Berhasil Dihapus!");
                }else{
                    System.out.println("Anda Tidak Dapat Menghapus Data Ini!");
                }
            }else{
                futsal();
                Press();
            }
        }else if(pilih == 3){
            if(!sewaMini.isEmpty()){
                futsal();
                System.out.print("Ingin Ubah Data Sewaan Nomor Berapa : ");
                index = Integer.parseInt(br.readLine())-1;
                if(getNama().equals(sewaMini.get(index).getNama())){
                    sewaMini.remove(index);
                    System.out.println("Data Berhasil Dihapus!");
                }else{
                    System.out.println("Anda Tidak Dapat Menghapus Data Ini!");
                }
            }else{
                futsal();
                Press();
            }
        }
    }
    public void Press()throws IOException{
        System.out.print("Tekan Enter Untuk Kembali....");
        br.readLine();
        clear();
    }
    @Override
    public void Menu() throws IOException {
        int menu = 0;
        while(menu != 5){
            System.out.println("============================");
            System.out.println("|       MENU CUSTOMER      |");
            System.out.println("============================");
            System.out.println("1.Sewa Lapangan");
            System.out.println("2.Lihat Data Penyewaan");
            System.out.println("3.Ubah Data Sewaan");
            System.out.println("4.Delete Data Sewaan");
            System.out.println("5.Log Out");
            System.out.print("Masukkan Pilihan Anda : ");
            try{
                menu = Integer.parseInt(br.readLine());
                System.out.println("\n");
                switch(menu){
                    case 1:
                        clear();
                        Create();
                        break;
                    case 2:
                        clear();
                        readSewa();
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
