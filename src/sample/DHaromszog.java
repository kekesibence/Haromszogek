package sample;

public class DHaromszog {
    private double aOldal;
    private double bOldal;
    private double cOldal;
    private int sorSzama;

    public DHaromszog(String sor, int sorSzam) throws Exception {
        this.sorSzama = sorSzam;
        sor = sor.replace(',', '.');
        String[] adatok = sor.split(" ");

        this.setaOldal(Double.parseDouble(adatok[0]));
        this.setbOldal(Double.parseDouble(adatok[1]));
        this.setcOldal(Double.parseDouble(adatok[2]));
    }

    public double getaOldal() {
        return aOldal;
    }
    public double getbOldal() {
        return bOldal;
    }
    public double getcOldal() {
        return cOldal;
    }

    public void setaOldal(double aOldal) throws Exception {
        if (aOldal > 0) {
            this.aOldal = aOldal;
        } else {
            throw new Exception("A(z) 'a' oldal nem lehet nulla vagy negatív szám");
        }
    }
    public void setbOldal(double bOldal) throws Exception {
        if (aOldal > 0) {
            this.bOldal = bOldal;
        } else {
            throw new Exception("A(z) 'b' oldal nem lehet nulla vagy negatív szám");
        }

    }
    public void setcOldal(double cOldal) throws Exception {
        if (cOldal > 0) {
            this.cOldal = cOldal;
        } else {
            throw new Exception("A(z) 'c' oldal nem lehet nulla vagy negatív szám");
        }

    }

    private boolean EllDerekszogu() throws Exception{
       if(Math.pow(aOldal, 2) + Math.pow(bOldal, 2) == Math.pow(cOldal, 2)){
           return true;
       } else {
           throw new Exception(String.format("%d. sor: A háromszög nem derékszögű!", this.sorSzama));
       }
    }

    private boolean EllMegszerkesztheto() throws Exception{
        if (this.aOldal + this.bOldal > this.cOldal) {
            return true;
        } else {
            throw new Exception(String.format("%d. sor: A háromszöget nem megszerkezteni!", this.sorSzama));
        }

    }

    private boolean EllNovekvoSorrend() throws Exception {
        if (this.aOldal <= this.bOldal && this.bOldal <= this.cOldal) {
            return true;
        } else {
            throw new Exception(String.format("%d. sor: Az adatok nincsenek növekvő rendben!", this.sorSzama));
        }
    }

    public double getTerulet() {
        return aOldal*bOldal/3;
    }
    public double getKerulet() {
        return aOldal+bOldal+cOldal;
    }

    @Override
    public String toString() {
        return String.format("%d. sor: a=%.2f b=%.2f c=%.2f",sorSzama, aOldal,bOldal,cOldal);
    }
}

