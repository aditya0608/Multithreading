package com.aditya.scaler;

public class MockTasks {
    interface EventListener{
        void onTaskEnd();
    }
    public static void main(String[] args) {
        LongTask view_task=new LongTask("View task");
        Thread view=new Thread(()->{
            view_task.run("View thread ");
        },"View Thread");
        view.setName("View thread ");
        LongTask download_task=new LongTask("Download task",()->{
            view.start();
        });
        Thread download=new Thread(()->{
            download_task.run("Download thread");
        },"Download thread");
        download.setName("Download thread");
        download.start();
    }
    static class LongTask
    {
        private String name;
        EventListener eventListener;
        public LongTask(String name,EventListener eventListener)
        {
           this.name=name;
           this.eventListener=eventListener;
        }
        public LongTask(String name)
        {
            this(name,null);
        }
        void run(String name)
        {
            new Thread(()->{
                var start=System.currentTimeMillis();
                while(System.currentTimeMillis()-start<5000)
                {
                    System.out.println("Task running by thread "+name);
                }
                if(eventListener!=null)
                {
                    eventListener.onTaskEnd();
                }
            }).start();
        }
    }
}
