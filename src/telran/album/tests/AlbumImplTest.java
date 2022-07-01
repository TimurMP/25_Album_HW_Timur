package telran.album.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.album.dao.AlbumImpl;
import telran.album.interfaces.Album;
import telran.album.model.Photo;
import static org.junit.jupiter.api.Assertions.*;


class AlbumImplTest {
    Album album;
    Album album2;
    Photo[] myVacation;

    @BeforeEach
    void setUp() {
        album = new AlbumImpl(7);
        myVacation = new  Photo[6];
        myVacation[0] = new Photo(504, 1, "Sunset", "http://127.0.0.1/001", album.parseDate("01.Feb.2020 03:08 PM"));
        myVacation[1] = new Photo(504, 2, "Drunk", "http://127.0.0.1/002", album.parseDate("02.Mar.2021 03:08 AM"));
        myVacation[2] = new Photo(504, 3, "Coliseum", "http://127.0.0.1/003", album.parseDate("01.Aug.2025 08:08 PM"));
        myVacation[3] = new Photo(505, 1, "NY", "http://127.0.0.1/myTrip/001", album.parseDate("25.Sep.2019 03:08 PM"));
        myVacation[4] = new Photo(505, 2, "TA", "http://127.0.0.1/myTrip/002", album.parseDate("02.Oct.2021 03:08 AM"));
        myVacation[5] = new Photo(505, 3, "Work", "http://127.0.0.1/myTrip/003", album.parseDate("01.Jun.2025 08:08 PM"));
        for (int i = 0; i < myVacation.length; i++) {
            album.addPhoto(myVacation[i]);
        }

    }

    @Test
    void addPhoto() {
        assertFalse(album.addPhoto(myVacation[2]));
        Photo newPhoto = new Photo(506, 3, "aaa", "http://127.0.0.1/myTrip/003aa", album.parseDate("01.Jun.2027 08:08 PM"));
        assertTrue(album.addPhoto(newPhoto));
        assertEquals(7, album.getSize());
        newPhoto = new Photo(666, 6, "aaa", "http://127.0.0.1/myTrip/003aa", album.parseDate("01.Jun.2027 08:08 PM"));
        assertFalse(album.addPhoto(newPhoto));
        album.printPhotos();


    }

    @Test
    void removePhoto() {
        assertFalse(album.removePhoto(666,666));
        album.removePhoto(3, 504);
        assertEquals(5, album.getSize());
        album.printPhotos();

    }

    @Test
    void updatePhoto() {
        Photo expected = new Photo(505, 2, "TA", "http://10.10.10.10/myTrip/002", album.parseDate("02.Oct.2021 03:08 AM"));
        album.updatePhoto(2,505,"http://10.10.10.10/myTrip/002");
        assertEquals(expected, myVacation[4]);
        album.printPhotos();

    }

    @Test
    void getPhotoFromAlbum() {
        Photo photo = album.getPhotoFromAlbum(3,504);
        assertEquals(myVacation[2], photo);
        assertNull(album.getPhotoFromAlbum(55, 555));
    }

    @Test
    void getAllPhotosFromAlbum() {
        Photo[] expected = {myVacation[3],myVacation[4],myVacation[5]};
        assertArrayEquals(expected, album.getAllPhotosFromAlbum(505));
    }

    @Test
    void getPhotoBetweenDate() {
    }

    @Test
    void printPhotos() {
    }

    @Test
    void testSize() {
    }





}