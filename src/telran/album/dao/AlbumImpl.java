package telran.album.dao;

import telran.album.interfaces.Album;
import telran.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
        if (getSize() == 2) {
            Photo[] photoCopy = new Photo[size];
            System.arraycopy(photos, 0, photoCopy, 0, size);
            Arrays.sort(photoCopy);
            System.arraycopy(photoCopy, 0, photos, 0, photoCopy.length);
        }
        if (getSize() > 2) {
            Photo[] photoCopy = new Photo[size + 1];
            int index = Arrays.binarySearch(photos, 0, size, photo);
            if (index < 0) {
                System.arraycopy(photos, 0, photoCopy, 0, (-index - 1));
                System.arraycopy(photos, (-index - 1), photoCopy, (-index - 1) + 1, size - (-index - 1));
                photoCopy[-index - 1] = photo;

            }
            if (index >= 0) {
                System.arraycopy(photos, index, photoCopy, index + 1, size - index);
                System.arraycopy(photos, 0, photoCopy, 0, index);
                photoCopy[index] = photo;
            }
            System.arraycopy(photoCopy, 0, photos, 0, photoCopy.length);
            size++;
            return true;

        }
        photos[size] = photo;
        size++;

        return true;
    }

    private Photo[] sortPhotos(Photo[] photos) {
        Photo[] photoCopy = new Photo[photos.length];
        Arrays.sort(photoCopy);
        return photoCopy;
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
        return findPhotosByPredicate(photo -> photo.getDate().toLocalDate().isEqual(dateFrom) ||
                photo.getDate().toLocalDate().isAfter(dateFrom) && photo.getDate().toLocalDate().isBefore(dateTo));
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
