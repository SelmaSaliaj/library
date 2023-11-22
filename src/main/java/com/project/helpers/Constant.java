package com.project.helpers;

public class Constant {

    public static final String SELECT_EBOOK_BY_ID = "SELECT e FROM EBookEntity e WHERE e.id = :id" ;

    public static final String SELECT_LOCATION_BY_ID = "SELECT l FROM LocationEntity l WHERE l.id = :id" ;

    public static final String SELECT_BOOK_BY_ID = "SELECT b FROM PhysicalCopyEntity b WHERE b.id = :id";
    public static final String SELECT_BOOKS_BY_TITLE = "SELECT b FROM PhysicalCopyEntity b WHERE b.title = :title";
    public static final String SELECT_BOOKS_BY_AUTHOR = "SELECT b FROM PhysicalCopyEntity b WHERE b.author = :author";
    public static final String SELECT_BOOKS_BY_TITLE_AND_AUTHOR = "SELECT b FROM PhysicalCopyEntity b WHERE b.title = :title AND b.author = :author";

    public static final String SELECT_READER_BY_ID = "SELECT r FROM ReaderEntity r WHERE r.id = :id";

    public static final String SELECT_BOOK_RESERVATION_BY_RESERVATION_ID = "SELECT b FROM BookReservationEntity b WHERE b.reservationEntity.id = :id";
    public static final String SELECT_BOOK_RESERVATION_BY_RESERVATION_ID_AND_STATUS_NOT_RETURNED = "SELECT b FROM BookReservationEntity b WHERE b.reservationEntity.id = :id AND b.status != 'RETURNED'";
    public static final String FIND_QUERY_BY_ID_USER = "SELECT u FROM UserEntity u WHERE u.id = :id";
    public static final String FIND_QUERY_BY_USERNAME_USER = "SELECT u FROM UserEntity u WHERE u.username = :username";
}
