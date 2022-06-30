package telran.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable<Photo>{
    int albumID;
    int photoID;
    String title;
    String url;
    LocalDateTime date;

    public Photo(int albumID, int photoID, String title, String url, LocalDateTime date) {
        this.albumID = albumID;
        this.photoID = photoID;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public int getAlbumID() {
        return albumID;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumID=" + albumID +
                ", photoID=" + photoID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return albumID == photo.albumID && photoID == photo.photoID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumID, photoID);
    }

    @Override
    public int compareTo(Photo o) {
        return 0;
    }
}
