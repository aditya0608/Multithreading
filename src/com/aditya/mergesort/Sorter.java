package com.aditya.mergesort;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> listToBeSorted;
    ExecutorService executorService;
    public Sorter(List<Integer> listToBeSorted, ExecutorService executorService)
    {
        this.listToBeSorted=listToBeSorted;
        this.executorService=executorService;
    }
    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {

        if(listToBeSorted.size()<=1) return listToBeSorted;
        int n=listToBeSorted.size();
        int mid=n/2;
        List<Integer> leftArray=new LinkedList<>();
        List<Integer> rightArray=new LinkedList<>();

        for(int i=0;i<mid;i++)
        leftArray.add(listToBeSorted.get(i));


        for(int i=mid;i<listToBeSorted.size();i++)
            rightArray.add(listToBeSorted.get(i));
        Future<List<Integer>> leftSortedFuture=this.executorService.submit(new Sorter(leftArray,executorService));
        Future<List<Integer>> rightSortedFuture=this.executorService.submit(new Sorter(rightArray,executorService));

        List<Integer> leftSortedList=leftSortedFuture.get();
        List<Integer> rightSortedList=rightSortedFuture.get();
        List<Integer> sorted=new LinkedList<>();

        int i=0;
        int j=0;
        while(i<leftSortedList.size() && j<rightSortedList.size())
        {
            if(leftSortedList.get(i)<=rightSortedList.get(j))
            {
                sorted.add(leftSortedList.get(i));
                i++;
            }
            else
            {
                sorted.add(rightSortedList.get(j));
                j++;
            }
        }

        while(i<leftSortedList.size()) {
            sorted.add(leftSortedList.get(i));
            i++;
        }

        while(j<rightSortedList.size()) {
            sorted.add(rightSortedList.get(j));
            j++;
        }
        return sorted;
    }
}
