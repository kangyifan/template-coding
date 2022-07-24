package com.evan.task;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/7/2022 4:21 PM
 */
public class WordSpliterator implements Spliterator<String> {

    private String words;

    public WordSpliterator(String words) {
        this.words = words;
    }
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        action.accept(words);
        return false;
    }

    @Override
    public Spliterator<String> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    public static int countWorlds(String sentences){
        int count = 0;
        boolean lastSpace = true;
        char[] charArray = sentences.toCharArray();
        for(char letter : charArray) {
            if(Character.isWhitespace(letter)){
                lastSpace = true;
            } else {
                if(lastSpace) {
                    count++;
                }
                lastSpace = false;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        String a = "Hello world a b c d  e !";
        System.out.println(countWorlds(a));

    }
}
