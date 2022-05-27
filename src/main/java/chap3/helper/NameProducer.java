package chap3.helper;

import reactor.core.publisher.FluxSink;
import utility.Util;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread+" : "+name);
    }
}
