package telran.album.dao;

import telran.album.interfaces.Album;
import telran.album.model.Photo;

import java.time.LocalDate;

public class AlbumImpl implements Album {
    Photo[] photos;
    int size;


    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        return false;
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

    }

    @Override
    public int size() {
        return size;
    }
}