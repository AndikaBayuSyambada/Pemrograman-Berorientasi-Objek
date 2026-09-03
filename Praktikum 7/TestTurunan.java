class Satu {
    Satu() { System.out.println("satu....."); }
}

class Dua extends Satu {
    Dua() { System.out.println("dua....."); }
}

class Tiga extends Dua {
    Tiga() { System.out.println("tiga....."); }
}

class Empat extends Tiga {
    Empat() { System.out.println("empat....."); }
}

public class TestTurunan {
public static void main(String[] a) {
    new Empat();
}
}