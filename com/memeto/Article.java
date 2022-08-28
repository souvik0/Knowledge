package com.memeto;

public class Article {

    private long id;
    private String title;
    private String content;

    public Article(long id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleMemento createMemento() {
        ArticleMemento snapshot = new ArticleMemento(id, title, content);
        return snapshot;
    }

    public void restore(ArticleMemento snapshot) {
        this.id = snapshot.getId();
        this.title = snapshot.getTitle();
        this.content = snapshot.getContent();
    }

    @Override
    public String toString() {
      return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}
