package telran.album.dao;

import telran.album.interfaces.Album;
import telran.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class AlbumImpl implements Album {
    Photo[] photos;
    int size;


    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photos.length == size) {
            return false;
        }
        if (photo.equals(getPhotoFromAlbum(photo.getPhotoID(), photo.getAlbumID()))) {
            return false;
        }
        photos[size] = photo;
        size++;

        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photoId == photos[i].getPhotoID() && albumId == photos[i].getAlbumID()) {
                photos[i] = photos[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoID, int albumId, String newUrl) {
        for (int i = 0; i < size; i++) {
            if (photoID == photos[i].getPhotoID() && albumId == photos[i].getAlbumID()) {
                photos[i].setUrl(newUrl);
                return true;
            }

        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photoId == photos[i].getPhotoID() && albumId == photos[i].getAlbumID()) {
                return photos[i];
            }

        }

        return null;
    }

    @Override
    public Photo[] getAllPhotosFromAlbum(int albumId) {

        return findPhotosByPredicate((photo -> photo.getAlbumID() == albumId));
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

    public LocalDateTime parseDate(String date) {
        String pattern = "dd.MMM.yyyy h:mm a";
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public int getSize() {
        return size;
    }

    private Photo[] findPhotosByPredicate(Predicate<Photo> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                count++;
            }

        }
        Photo[] photos1 = new Photo[count];

        for (int i = 0, j = 0; j < photos1.length; i++) {
            if (predicate.test(photos[i])) {
                photos1[j++] = photos[i];

            }

        }

        for (Photo photo : photos1) {
            System.out.println(photo);

        }

        return photos1;

    }


}
