package telran.album.dao;

import telran.album.interfaces.Album;
import telran.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlbumImpl implements Album {
    Photo[] photos;
    int size;


    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photos.length == size){
            return false;

        }
//        if (photo.equals())
        photos[size] = photo;
        size ++;

        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        return false;
    }

    @Override
    public boolean updatePhoto(int photoID, int albumId, String url) {
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photoId == photos[i].getPhotoID() && albumId == photos[i].getAlbumID()){
                System.out.println(photos[i]);
                return photos[i];
            }

        }

        return null;
    }

    @Override
    public Photo[] getAllPhotosFromAlbum(int albumId) {
        return new Photo[0];
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return new Photo[0];
    }

    @Override
    public void printPhotos() {
        for (int i = 0; i < size; i++) {
            System.out.println(photos[i]);
        }

    }

    @Override

    public LocalDateTime parseDate(String date){
      String pattern = "dd.MMM.yyyy h:mm a";
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public int size() {
        return size;
    }
}
