package content.chap1;

import reactor.core.publisher.Mono;
import content.utility.Util;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(2).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    public static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }
}
