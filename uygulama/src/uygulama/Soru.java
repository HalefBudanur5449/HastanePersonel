package uygulama;

public class Soru {
//hastanede hem doktor hemde hemşire görevlidir. doktor hemşireden üstündür. bu özellikler bellirtilmiştir.
//maaşlar private olduğundan dışardan yalnızca get ve set metotları ile kontrol edilebilir.
//görevli bölümündeki statu da dışardan değiştirilebilir.
//statu değeri de set ve get metodları ile mainden güncellenebilmektedir.
//maaş karşılaştırma mevcuttur.

    public static void main(String[] args) {

        gorevli m = new gorevli("öğrenci", "halef budanur", 22);
        m.yaz();
        m.setStatu("mühendis");
        m.yaz();

        doktor d = new doktor("doktor", "murat yüksek", 35, 12000);
        d.yaz();
        d.yaz(d.getMaas());
        d.setMaas(10000);
        d.yaz(d.getMaas());

        doktor d2 = new doktor("doktor", "mahmut candelen", 41, 15000);
        d2.yaz(d2.getMaas());
        d2.karsilastir(d, d2);
        d2.setMaas(10000);
        d2.yaz(d2.getMaas());
        d2.karsilastir(d, d2);

        doktor.hemsire h = new doktor.hemsire("hemsire", "pelin dönmez", 21, 10000);
        h.yaz();
        h.yaz(h.getMaas());
        h.setMaas(5000);
        h.yaz(h.getMaas());
        
        doktor.hemsire h2 = new doktor.hemsire("hemsire", "perihan aba", 25, 7500);
        h2.yaz(h2.getMaas());
        h2.karsilastir(h, h2);
        h2.setMaas(4500);
        h2.yaz(h2.getMaas());
        h2.karsilastir(h, h2);
        
    }

    static class gorevli {

        private String statu;
        public String adSoyad;
        public int yas;

        public gorevli(String statu, String adSoyad, int yas) {
            this.adSoyad = adSoyad;
            this.statu = statu;
            this.yas = yas;
        }

        public void setStatu(String statu) {
            this.statu = statu;
        }

        public String getStatu() {
            return this.statu;
        }

        public void yaz() {
            System.out.println("ad soyad : " + adSoyad + " ,statu : " + statu);
        }

        public void yaz(int maas) {
            System.out.println("ad Soyad : " + adSoyad + " ,yas : " + yas + " ,statu : " + statu + " ,maas : " + maas);
        }
    }

    static class doktor extends gorevli {

        private int maas;

        public doktor(String statu, String adSoyad, int yas, int maas) {
            super(statu, adSoyad, yas);
            this.maas = maas;
        }

        public void setMaas(int maas) {
            this.maas = maas;
        }

        public int getMaas() {
            return this.maas;
        }

        public void karsilastir(doktor a, doktor b) {
            if (a.getMaas() < b.getMaas()) {
                System.out.println(b.adSoyad + " isimli doktorun maaşı " + a.adSoyad + " isimli doktorun maaşından daha fazladır.");
            } else if (b.getMaas() < a.getMaas()) {
                System.out.println(b.adSoyad + " isimli doktorun maaşı " + a.adSoyad + " isimli doktorun maaşından daha azdır.");
            } else {
                System.out.println("maaşlar eşittir.");
            }
        }

        static class hemsire extends gorevli {

            private int maas;

            public hemsire(String statu, String adSoyad, int yas, int maas) {
                super(statu, adSoyad, yas);
                this.maas = maas;
            }

            public void setMaas(int maas) {
                this.maas = maas;
            }

            public int getMaas() {
                return this.maas;
            }
             public void karsilastir(hemsire a, hemsire b) {
            if (a.getMaas() < b.getMaas()) {
                System.out.println(b.adSoyad + " isimli hemşirenin maaşı " + a.adSoyad + " isimli hemşirenin maaşından daha fazladır.");
            } else if (b.getMaas() < a.getMaas()) {
                System.out.println(b.adSoyad + " isimli hemşirenin maaşı " + a.adSoyad + " isimli hemşirenin maaşından daha azdır.");
            } else {
                System.out.println("maaşlar eşittir.");
            }
        }

        }
    }
}
