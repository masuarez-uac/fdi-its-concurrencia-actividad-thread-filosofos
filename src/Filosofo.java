public class Filosofo implements Runnable {
    final Tenedor TenedorDer;
    final Tenedor TenedorIzq;
    int id;
    public Filosofo (int n, Tenedor T1, Tenedor T2){
        this.TenedorDer = T1;
        this.TenedorIzq = T2;
        this.id = n;
    }
    @Override
    public void run() {
        synchronized (TenedorIzq) {
            System.out.println("Filosofo: " + id + ", tomo tenedor izq (" + TenedorIzq.getNum() + ")" + System.nanoTime());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
            System.out.println("Filosofo: " + id + ", espero tenedor der (" + TenedorDer.getNum() + ")" + System.nanoTime());

            synchronized (TenedorDer) {
                System.out.println("Filosofo: " + id + ", tomo tenedor der (" + TenedorDer.getNum() + ")");
                System.out.println("Filosofo: " + id + ", comio su maruchan " + System.nanoTime());
            }
        }
    }
}
