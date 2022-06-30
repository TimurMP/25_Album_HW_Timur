package telran.album.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.album.dao.AlbumImpl;
import telran.album.interfaces.Album;
import telran.album.model.Photo;

import static org.junit.jupiter.api.Assertions.*;

class AlbumImplTest {
    Album album;
    Photo[] myVacation;

    @BeforeEach
    void setUp() {
        album = new AlbumImpl(5);
        myVacation = new  Photo[3];
        myVacation[0] = new Photo(0504, 001, "Sunset", "http://127.0.0.1/001", "01.01.2020");
    }

    @Test
    void addPhoto() {
    }

    @Test
    void removePhoto() {
    }

    @Test
    void updatePhoto() {
    }

    @Test
    void getPhotoFromAlbum() {
    }

    @Test
    void getAllPhotosFromAlbum() {
    }

    @Test
    void getPhotoBetweenDate() {
    }

    @Test
    void printPhotos() {
    }

    @Test
    void size() {
    }
}