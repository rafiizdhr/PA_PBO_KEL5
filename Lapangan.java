package projekAkhir;

public class Lapangan{
    protected String lapangan;
    protected int harga;
    protected String jenis;
    public Lapangan(String lap,int harga,String jenis){
        this.lapangan = lap;
        this.harga = harga;
        this.jenis = jenis;
    }

    public String getLapangan() {
        return lapangan;
    }

    public void setLapangan(String lapangan) {
        this.lapangan = lapangan;
    }
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public void sukses(){
        System.out.println("Data "+ getLapangan() + " berhasil ditambahkan!");
    }
}

