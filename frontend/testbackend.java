import backend.*;

public class testbackend {

    public static void main(String[] args) {
        Anggota ang1 = new Anggota("Rahmat Subandi", "Surabaya", "081111111");
//        Anggota ang2 = new Anggota("Referensi", "Buku referensi ilmiah");
//        Anggota ang3 = new Anggota("Komik", "Komik anak-anak");
// test insert
        ang1.save();
//        ang2.save();
//        ang3.save();
// test update
//        ang2.setKeterangan("Koleksi buku referensi ilmiah");
//        ang2.save();
//// test delete
//        ang3.delete();
// test select all
        for (Anggota ang : new Anggota().getAll()) {
            System.out.println("Nama: " + ang.getNama() + ", Ket: " + ang.getAlamat() + ", Telp: " + ang.getTelepon());
        }
// test search
//        for (Anggota k : new Anggota().search("ilmiah")) {
//            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
//        }
    }
}