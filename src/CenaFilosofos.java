public class CenaFilosofos {
    public static void main(String[] args) {

        int x = 5;

        Tenedor[] tenedores = new Tenedor[x];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new Tenedor(i);
        }

        Thread[] filosofos = new Thread[x];
        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i] = new Thread(new Filosofo(i, tenedores[i], tenedores[(i + 1) % x]));
        }

        for (int i = 0; i < filosofos.length; i++) {

            filosofos[i].start();
        }
    }
}
