public class Persegibaru {
    int p, l, luas, kel;

    void setP(int p){   //setter
        this.p=p;
    }
    int getP(){     //getter
        return p;
    }

    void setL(int l){
        this.l=l;
    }
    int getL(){
        return l;
    }
    void hitungLuas(){
        luas=p*l;
    }
    void hitungKel(){
        kel=2*p*l;
    }

    int getLuas(){
        return p*l;
    }
    int getKel(){
        return 2*(p*l);
    }

    void info(){
        System.out.println("p : "+p);
        System.out.println("l : "+l);
        System.out.println("Luas : "+luas);
        System.out.println("Kel : "+kel);
    }
}
