import backend.*;

public class testbackend
{
    public static void main(String[] args)
    {
        Kategori novel = new Kategori().getById(6);
        Kategori scifi = new Kategori().getById(16);

        Buku buku1 = new Buku(novel, "Minum Mas", "Inex Media", "Rang Supri");
        Buku buku2 = new Buku(scifi, "Metode Linier", "Springer", "Alex Baldwin");
        Buku buku3 = new Buku(novel, "Bintang Terang", "Erlangga", "Max Seowot");

        // test insert
        buku1.save();
        buku2.save();

        // test update
        buku2.setJudul("Aljabar Linier");
        buku2.save();

        // test delete
        buku3.delete();

        // test select all
        for(Buku b : new Buku().getAll())
        {
            System.out.println("Kategori : " + b.getKategori().getNama() + 
                               ", Judul : " + b.getJudul());
        }

        // test search
        for(Buku b : new Buku().search("Lima"))
        {
            System.out.println("Kategori : " + b.getKategori().getNama() + 
                               ", Judul : " + b.getJudul());
        }
    }
}
