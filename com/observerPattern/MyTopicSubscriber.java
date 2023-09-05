package com.observerPattern;

public class MyTopicSubscriber implements Observer {

    private String name;
    private Observable topic;

    public MyTopicSubscriber(String nm){
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null){
            System.out.println(name + ":: No new message");
        } else {
            System.out.println(name + ":: Consuming message::" + msg);
        }
    }

    @Override
    public void setObservable(Observable sub) {
        this.topic = sub;
    }
}
