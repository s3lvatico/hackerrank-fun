package org.gmnz.prove;

class DummyOutputGen {

    // private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        // TimeUnit.SECONDS.sleep(2);
        // log.info("---------- INITIATED! --------");
        System.out.println("---------- INITIATED! --------");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " ::  I = " + i);
        }

    }

}