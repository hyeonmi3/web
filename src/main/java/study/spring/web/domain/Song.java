package study.spring.web.domain;

public class Song {
    private Long idx;

    private String title;

    private String singer;

    private String composer;

    private int year;

    public Song(String title, String singer, String composer, int year) {
        this.title = title;
        this.composer = composer;
        this.singer = singer;
        this.year = year;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}