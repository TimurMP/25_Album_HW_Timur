package telran.album.interfaces;

import telran.album.model.Photo;

import java.time.LocalDate;

public interface Album {
    boolean addPhoto (Photo photo);
    boolean removePhoto(int photoId, int albumId);
    boolean updatePhoto (int photoID, int albumId, String url);
    Photo getPhotoFromAlbum (int photoId, int albumId);
    Photo[] getAllPhotosFromAlbum(int albumId);
    Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    void printPhotos();
    int size();


}
