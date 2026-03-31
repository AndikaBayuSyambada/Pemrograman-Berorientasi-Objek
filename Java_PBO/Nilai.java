import java.util.Scanner; // library input Keyboard
public class Nilai {
    String nim, nama;
    float nilaiUts, nilaiTugas, nilaiUas, pNilaiUts, pNilaiTugas, pNilaiUas, nilaiAkhir;
    Scanner in=new Scanner (System.in); //  object keybord
    public Nilai(){

    }
    public Nilai(String nim, String nama, float nilaiUts, float nilaiTugas, float nilaiUas){
        this.nim=nim; this.nama=nama;
        this.nilaiTugas=nilaiTugas; this.nilaiUts=nilaiUts; this.nilaiUas=nilaiUas;
    }

    public void isiData()
    { 
        System.out.print("Nim : ");nim=in.nextLine(); //string
        System.out.print("Nama : ");nama=in.nextLine();
        System.out.print("N.Tugas : ");nilaiTugas=in.nextFloat(); //float
        System.out.print("N.UTS : ");nilaiUts=in.nextFloat();
        System.out.print("N.UAS : ");nilaiUas=in.nextFloat();
    }

    void setNim(String nim){this.nim=nim;}  //setter
    String getNim(){return nim;}  //getter
    void setUts(float nilaiUts){
        this.nilaiUts=nilaiUts;
    }  
    float getUts(){
        return  nilaiUts;
    }
    
    void hitungNilai(){
        pNilaiTugas=0.2f*nilaiTugas;
        pNilaiUts=0.35f*nilaiUts;
        pNilaiUas=0.45f*nilaiUas;
        nilaiAkhir=pNilaiTugas+pNilaiUts+pNilaiUas;
    }

    void cetakNilai(){
        System.out.println("Nim     :   " +nim);
        System.out.println("Nama    :   " +nama);
        System.out.println("N.Tugas :   " +nilaiTugas+ " 20% : " +pNilaiTugas );
        System.out.println("N.UTS   :   " +nilaiUts+ " 35% : " +pNilaiUts );
        System.out.println("N.UAS   :   " +nilaiUas+ " 45% : " +pNilaiUas );
        System.out.println("N.Akhir :   " +nilaiAkhir);
    } 
}
