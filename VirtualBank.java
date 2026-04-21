// 1. Interface
interface MetodePembayaran {
    void prosesPembayaran(double nominal);
    boolean validasi(String va); 
}

// 2. BANK
class BankBCA implements MetodePembayaran {

    @Override
    public void prosesPembayaran(double nominal) {
        System.out.println("Pembayaran Rp" + nominal + " via BCA Berhasil");
    }

    @Override
    public boolean validasi(String va) {
        return va.length() == 10 && va.startsWith("111");
    }
}

class BankMandiri implements MetodePembayaran {

    @Override
    public void prosesPembayaran(double nominal) {
        System.out.println("Pembayaran Rp" + nominal + " via Mandiri Berhasil");
    }

    @Override
    public boolean validasi(String va) {
        return va.length() == 12 && va.startsWith("222");
    }
}

class BankBNI implements MetodePembayaran {

    @Override
    public void prosesPembayaran(double nominal) {
        System.out.println("Pembayaran Rp" + nominal + " via BNI Berhasil");
    }

    @Override
    public boolean validasi(String va) {
        return va.length() == 8 && va.startsWith("333");
    }
}

// 3. Checkout
class Checkout {
    public void bayarSekarang(MetodePembayaran metode, String va, double total) {
        if (metode.validasi(va)) {
            metode.prosesPembayaran(total);
        } else {
            System.out.println("Virtual Account tidak valid!");
        }
    }
}

// 4. Main
public class VirtualBank {
    public static void main(String[] args) {

        Checkout checkout = new Checkout();

        MetodePembayaran bca = new BankBCA();
        MetodePembayaran mandiri = new BankMandiri();
        MetodePembayaran bni = new BankBNI();

        System.out.println("=== PEMBAYARAN BANK ===");
        checkout.bayarSekarang(bca, "1111234567", 100000);
        checkout.bayarSekarang(mandiri, "222123456789", 200000);
        checkout.bayarSekarang(bni, "33312345", 300000);
    }
}