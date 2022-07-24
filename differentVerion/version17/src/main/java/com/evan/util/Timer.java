package com.evan.util;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/4/2022 10:32 AM
 */
public class Timer {

    private static final Logger logger = Logger.getLogger(Timer.class.getName());

    private static final DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static <T,R> R timing(T input, Function<T,R> function){
        if(Objects.nonNull(input)) {
            System.out.println("input:\n" + Objects.toString(input) );
        }

        LocalDateTime now = LocalDateTime.now();
        String startTimeTxt = COMMON_FORMATTER.format(now);
        R r = function.apply(input);
        LocalDateTime end = LocalDateTime.now();
        String endTimeTxt = COMMON_FORMATTER.format(end);
        long useMillis = Duration.between(now, end).toNanos();

        if(Objects.nonNull(r)) {
            System.out.println("return:\n" + Objects.toString(r) );
        }
        logger.info(()->{
            var info = """
                    startTimeTxt: startTimeTxt
                    """;
            return String.join("","\n开始时间:", startTimeTxt, "\n结束时间:", endTimeTxt, "\n执行时间"+useMillis, "ns" );
        });
        return r;
    }

    public static <T> void timing(T input,final Consumer<T> consumer){
        timing(input, (t)->{
            consumer.accept(t);
            return null;
        });
    }

    public static <R> R timing(final Supplier<R> supplier){
        return timing(null, (t)->{
            return supplier.get();
        });
    }

    public static void timing(final Runnable runnable){
        timing(null, (t)->{
            runnable.run();
            return null;
        });
    }
}
