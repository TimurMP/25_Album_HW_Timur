package telran.album.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.album.dao.AlbumImpl;
import telran.album.interfaces.Album;
import telran.album.model.Photo;

class AlbumImplTest {
    Album album1;
    Album album2;
    Photo[] myVacation;
    Photo[] myTrip;

    @BeforeEach
    void setUp() {
        album1 = new AlbumImpl(5);
        myVacation = new  Photo[3];
        myVacation[0] = new Photo(504, 1, "Sunset", "http://127.0.0.1/001", album1.parseDate("01.Feb.2020 03:08 PM"));
        myVacation[1] = new Photo(504, 2, "Drunk", "http://127.0.0.1/002", album1.parseDate("02.Mar.2021 03:08 AM"));
        myVacation[2] = new Photo(504, 3, "Coliseum", "http://127.0.0.1/003", album1.parseDate("01.Aug.2025 08:08 PM"));
        for (int i = 0; i < myVacation.length; i++) {
            album1.addPhoto(myVacation[i]);

        }

        album2 = new AlbumImpl(5);
        myTrip = new  Photo[3];
        myTrip[0] = new Photo(505, 1, "NY", "http://127.0.0.1/myTrip/001", album2.parseDate("25.Sep.2019 03:08 PM"));
        myTrip[1] = new Photo(505, 2, "TA", "http://127.0.0.1/myTrip/002", album2.parseDate("02.Oct.2021 03:08 AM"));
        myTrip[2] = new Photo(505, 3, "Work", "http://127.0.0.1/myTrip/003", album2.parseDate("01.Jun.2025 08:08 PM"));
        for (int i = 0; i < myTrip.length; i++) {
            album2.addPhoto(myTrip[i]);

        }
    }

    @Test
    void addPhoto() {
        for (int i = 0; i < myVacation.length; i++) {
            System.out.println(myVacation[i]);


        }
        System.out.println(album1.parseDate("01.Feb.2020 03:08 PM"));

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