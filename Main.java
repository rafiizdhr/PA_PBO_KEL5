
package projekAkhir;

import java.util.*;
import java.io.*;
    
public class Main {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static Admin admin = new Admin("admin","admin123","Dillah","085955208715");
    static ArrayList<Customer> cust = new ArrayList();

    static Scanner input = new Scanner(System.in);
    static final String FILENAME = "akun.txt";

    public static void main(String[] args) throws IOException{
        

        int pilih = 0;
        while(pilih != 3){
            clear();
            loadData();
            System.out.println("============================");
            System.out.println("|           LOGIN          |");
            System.out.println("============================");
            System.out.println("|1.Login                   |");
            System.out.println("|2.Register                |");
            System.out.println("|3.Exit                    |");
            System.out.println("============================");
            System.out.print("\nMasukkan Pilihan Anda : ");
            
            try {
                pilih = Integer.parseInt(br.readLine());
                System.out.println("\n");
                clear();
                switch (pilih) {
                    case 1:
                        clear();
                        login();
                        break;
                    case 2:
                        clear();
                        register();
                        break;
                    case 3:
                        System.out.println("\nProgram Berakhir.\n");
                        saveData();
                        break;
                    default:
                        System.out.println("Pilihan Tidak Ada!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input yang dimasukkan tidak valid. Silakan masukkan angka saja.");
                br.readLine();
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan saat membaca input. Silakan coba lagi.");
            }
        }
        
    }
    static void login() throws IOException{
        int loginAttempt = 1;
        boolean login = false;
        do {
            System.out.println("============================");
            System.out.println("|        FORM LOGIN        |");
            System.out.println("============================");
            System.out.print("Masukkan Username : ");
            String username = br.readLine();
            System.out.print("Masukkan Password : ");
            String password = br.readLine();
            System.out.println("\n");
            clear();

            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                login = true;
                admin.Menu();
            } else {
                boolean customerFound = false;
                for (Customer customer : cust) {
                    if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                        login = true;
                        customerFound = true;
                        customer.Menu();
                        break;
                    }
                }
                if (!customerFound) {
                    System.out.println("Username atau password salah!\n");
                    Enter(); clear();
                    if (loginAttempt == 3) {
                        System.out.println("Anda telah mencoba login sebanyak 3 kali, silakan coba lagi nanti.");
                        Enter();
                        break;
                    }
                    loginAttempt++;
                }
            }
        } while (!login);
    }
    static void register() throws IOException {
        System.out.println("============================");
        System.out.println("|      FORM REGISTRASI     |");
        System.out.println("============================");
        System.out.print("Masukkan Nama : ");
        String name = br.readLine();
        System.out.print("Masukkan No. Telepon : ");
        String phone = br.readLine();
        System.out.print("Masukkan Username : ");
        String username = br.readLine();
        System.out.print("Masukkan Password : ");
        String password = br.readLine();
        System.out.println("\n");
        clear();

        Customer customer = new Customer(username, password, name,phone);
        cust.add(customer);
        System.out.println("Registrasi berhasil!\n");
        Enter();
        login();
    }

    static void loadData() {
        try {
            File file = new File(FILENAME);
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNextLine()) {
                String[] data = fileInput.nextLine().split(",");
                String username = data[0];
                String password = data[1];
                String nama = data[2];
                String notelp = data[3];
                Customer customer = new Customer(username, password, nama, notelp);
                cust.add(customer);

            }

            fileInput.close();
        } catch (IOException e) {
            System.out.println("file tidak ditemukan");
        }
    }

    static void saveData() {
        try {
            File file = new File("akun.txt");
            FileWriter fileWriter = new FileWriter(file);

            for (Customer customer : cust) {
                fileWriter.write(customer.getUsername() + "," + customer.getPassword() + "," + customer.getNama() + "," + customer.getNoTelp() + "\n");
            }
            fileWriter.close();
            System.out.println("data akun tersimpan");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file.");
        }
    }

    final public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    final public static void Enter() {
        Scanner input = new Scanner(System.in);
        String anyInput = input.nextLine();
        System.out.println("tolong tekan enter!!!");
        clear();
    }
}
