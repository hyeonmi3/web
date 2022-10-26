package study.spring.web.service;

import study.spring.web.domain.Song;

import java.util.List;

public interface SongService {
    /**
     * 새 노래를 등록한다.
     *
     * @param song 노래 정보
     * @return 등록된 노래 정보
     */
    public Song addSong(Song song);

    /**
     * 등록된 노래 목록을 가져온다.
     *
     * @return 등록된 노래 목록
     */
    public List<Song> getList();

    public List<Song> getList(String title);

    public List<Song> getList(int year);

    /**
     * 주어진 idx을 가진 노래를 가져온다.
     *
     * @param idx 노래 idx
     * @return 노래
     */
    public Song read(Long idx);

    public void update(Song song);

    public void delete(Long idx);

}