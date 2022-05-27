package chap1;

import reactor.core.publisher.Mono;
import utility.Util;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess()).subscribe(Util.onNext(), Util.onError(), () ->{
            System.out.println("process is done.. sending emails");
        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
