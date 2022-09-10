package com.aditya.mergesort;

import java.util.List;
import java.util.concurrent.*;

public class MergeSort {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(6);
        List<Integer> listInput=List.of(
                10,
                6,
                8,
                -1,
                0,
                90
        );
       Future<List<Integer>> future= executorService.submit(new Sorter(listInput,executorService));
       List<Integer> list=future.get();
       executorService.shutdown();
       executorService.awaitTermination(6,TimeUnit.SECONDS);
        //System.out.println(list.size());
       for(Integer ele:list)
           System.out.println(ele+" ");
    }

}
