package com.evan.stream;

import com.evan.bean.Transaction;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/2/2022 10:15 AM
 */
public class CollectorsDemo {

    private List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        transactions = new ArrayList<>();
        transactions.add(new Transaction("测试1", "类别4"));
        transactions.add(new Transaction("测试2", "类别2"));
        transactions.add(new Transaction("测试3", "类别1"));
        transactions.add(new Transaction("测试4", "类别3"));
        transactions.add(new Transaction("测试5", "类别1"));
        transactions.add(new Transaction("测试6", "类别4"));
        transactions.add(new Transaction("测试7", "类别2"));
        transactions.add(new Transaction("测试8", "类别3"));
        transactions.add(new Transaction("测试9", ""));
    }

    @Test
    public void groupingTest(){

        Map<String, List<String>> maps = transactions.stream()
                .collect(Collectors.groupingBy(transactions -> transactions.getCurrency()
                        .orElse("UNKNOW"), new Collector<Transaction, List<String>, List<String>>() {
                    @Override
                    public Supplier<List<String>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<String>, Transaction> accumulator() {
                        return (list, transaction) -> {
                            list.add(transaction.getName());
                        };
                    }

                    @Override
                    public BinaryOperator<List<String>> combiner() {
                        return (list, list2) -> {
                            list.addAll(list2);
                            return list;
                        };
                    }

                    @Override
                    public Function<List<String>, List<String>> finisher() {
                        return Function.identity();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT, Characteristics.IDENTITY_FINISH));
                    }
                }));

        System.out.println(maps);
    }

    @Test
    void name() throws IOException {
        OptionalInt.of(1).orElse(0);
    }

}
