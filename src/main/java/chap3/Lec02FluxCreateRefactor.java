package chap3;

import chap3.helper.NameProducer;
import reactor.core.publisher.Flux;
import utility.Util;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());

        nameProducer.produce();

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(2);

    }
}
