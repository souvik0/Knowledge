package com.memeto;

public class Invoker {

    public static void main (String[] args) {
        Article article = new Article(1, "My Article");
        article.setContent("ABC"); //original content
        System.out.println(article);

        //Creating immutable memento from original object
        ArticleMemento memento = article.createMemento();

        article.setContent("123");    //changed content
        System.out.println(article);

        article.restore(memento);   //UNDO recent changes
        System.out.println(article);  //original content
    }
}
