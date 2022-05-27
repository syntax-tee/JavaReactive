package chap3;

import reactor.core.publisher.Flux;

public class Lect03FluxTake {
    public static void main(String[] args) {
        Flux.range(1,10).log().take(3).subscribe(System.out::println);
    }
}
