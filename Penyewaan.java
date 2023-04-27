
package projekAkhir;


public class Penyewaan{
    private String nama;
    private String lap;
    private String jenis;
    private String hari;
    private int jam;
    private int harga;
    private int waktu;
    private int total;
    
    public Penyewaan(String nama,String lap,String jenis,String hari, int jam, int harga,int waktu,int total){
        this.nama = nama;
        this.lap = lap;
        this.jenis = jenis;
        this.hari = hari;
        this.jam = jam;
        this.harga = harga;
        this.waktu = waktu;
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public int getJam() {
        return jam;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }
    
}
