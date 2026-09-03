package praktikum8;
public class MatematikaDemo {
    public static void main(String[] args) {
        Matematika mtk = new Matematika();
        mtk.pertambahan(20, 20);
        mtk.pengurangan(10, 5);
        mtk.perkalian(10, 20);
        mtk.pembagian(20, 2);
        System.out.println(" ");

        Matematika mtkku = new Matematika();
        mtkku.pertambahan(10.7f, 15);
        mtkku.pengurangan(77.7f, 27.5f);
        mtkku.perkalian(22.2f, 99.9f);
        mtkku.pembagian(100f, 6f);
        System.out.println(" ");
        
        Matematika mtkBaru = new Matematika();
        mtkBaru.pertambahan(12.5, 28.7, 14.2);
        mtkBaru.pengurangan(12.5, 28.7, 14.2);
        mtkBaru.perkalian(12.5, 28.7, 14.2);
        mtkBaru.pembagian(12.5, 28.7, 14.2);
    }
}
