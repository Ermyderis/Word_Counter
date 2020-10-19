package com.example.word_counter;

public class Counter {
    public static int wordCounter(String writedtext)
    {

        writedtext = writedtext.replace("/n", " ");
        String[] textArray = writedtext.split(" ");
        return textArray.length;
    }
    public static int symbolsCounter(String writedtext)
    {
        int symbolamount = writedtext.length();
        return symbolamount;
    }


}
