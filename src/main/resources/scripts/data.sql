use library;

INSERT INTO ebook(id, title, author, link)
VALUES (1,"Organizimi dhe arkitektura e kompjuterave","Agim Cami",
        "https://books.google.al/books?id=Mif_AwAAQBAJ&printsec=frontcover&source=gbs_ge_summary_r&cad=0#v=onepage&q&f=true"),
       (2,"Arkitektura e kompjuterave","Agim Cami",
        "https://books.google.al/books?id=UQNsAwAAQBAJ&printsec=frontcover&source=gbs_ge_summary_r&cad=0#v=onepage&q&f=true");

INSERT INTO location(id, shelf_name)
VALUES (1,"drama"),
       (2,"classics"),
       (3,"thriller"),
       (4,"adventure"),
       (5,"fantasy"),
       (6,"manga"),
       (7,"romance"),
       (8,"sci fi"),
       (9,"history"),
       (10,"psychology"),
       (11,"children books"),
       (12,"mystery"),
       (13,"murder");

INSERT INTO reader(id, deleted, first_name, surname, email, address, phone_number)
VALUES (1, false, "Ana", "Bekteshi", "anabekteshi@gmail.com","Rruga 'Sami Frasheri'","0692732511"),
       (2, false, "Emiraldo", "Cakaj", "emiraldocakaj@gmail.com","Rruga 'Qemal Stafa'","0672261543"),
       (3, false, "Enkeleda", "Kalliri", "enkeledakalliri@gmail.com","Rruga 'Tasin Tafaj'","068321469"),
       (4, false, "Klaudja", "Hoxha", "klaudjahoxha@gmail.com","Rruga 'Marie Logoreci'","0692772422"),
       (5, false, "Eraldo", "Hoxha", "eraldohoxha@gmail.com","Rruga 'Marie Logoreci'","0684059319"),
       (6, false, "Serxho", "Gjoni","serxhogjoni@gmail.com","Rruga 'Qemal Stafa'","0673162511"),
       (7, false, "Rosilda", "Agolli", "rosildaagolli@gmail.com","Rruga 'Sami Frasheri'","0694077402");

INSERT INTO user
VALUES (1,"Ana Bekteshi","$2a$10$i8lUYAMiTs2vfdBOk.Q5vuI1RtpYcN4V4deZ9lORCm3HDmAe.ULd2","USER",1),
       (2,"Emiraldo Cakaj","$2a$10$i7lUYAMiTs2vfdBOk.Q5vuI1RtpYcN4V4deZ2lORCm3HDmAe.ULd2","USER",2),
       (3,"Enkeleda Kalliri","$3a$10$i6lUYAMiTs2vfdBOk.Q2vuI1RtpYcN4V4deZ9lORCm3HDmAe.ULd2","USER",3),
       (4,"Klaudja Hoxha","$2a$10$i9lUYAMiTs2vfdBOk.Q5vuI1RtpYcN6V4deZ9lORCm3HDmAe.ULd2","USER",4),
       (5,"Eraldo Hoxha","$3a$12$i7lUYAMiTs2vfdBOk.Q5vuI1RtpYcN4V4deZ9lORCm3HDmAe.ULd2","USER",5),
       (6,"Serxho Gjoni","$2a$20$i7lUYAMiTs2vfdBOk.Q5vuI1RtpYcN5V4deZ9lORCm3HDmAe.ULd2","USER",6),
       (7,"Rosilda Agolli","$2a$10$i3lUYAMiTs2vfdBOk.Q5vuI1RtpYcN7V4deZ9lORCm3HDmAe.ULd2","USER",7);

INSERT INTO user(id, username, password, authorities)
VALUES (8,"Leonardo Mezini","$5a$10$i8lUYAMiTs2vfdBOk.Q4vuI1RtpYcN4V4deZ9lORCm3HDmAe.ULd2","ADMIN"),
       (9,"Antonela Malaj","$5a$10$i8lUYAMiTs3vfdBOk.Q4vuI1RtpYcN4V4deZ9lORCm3HDmAe.ULd2","ADMIN");

INSERT INTO reservation(id, create_date, last_modified, deleted, id_reader)
VALUES (1,'2023-04-16','2023-04-16',false,1),
       (2,'2023-08-10','2023-08-12',false,1),
       (3,'2023-11-06','2023-11-06',false,3),
       (4,'2023-11-12','2023-11-12',false,2),
       (5,'2023-11-12','2023-11-16',false,5),
       (6,'2023-11-12','2023-11-12',false,3);

INSERT INTO book(isbn, title, author, genre, copies, copies_available, location_id)
VALUES (1,"Sepse te dua","Guillaume Musso", "mistery, romance, psychology" ,2, 1 , 12),
       (2,"Kokoro", "Natsume Soseki", "romance", 1, 0, 7),
       (3,"Dy vjet pushime","Zhyl Vern","kids book, adventure", 3, 2, 11),
       (4,"Princi i lumtur","Oscar Wilde","kids book", 2, 2, 11),
       (5,"Krim dhe ndeshkim","Fjodor Dostojevskij", "murder, mystery, psychology",4, 2, 13);

INSERT INTO book_reservation(id, create_date, last_modified, return_date, deleted, status, book_id, reservation_id)
VALUES (1,'2023-04-16','2023-04-16','2023-04-26',false, "RETURNED", 4, 1),
       (2,'2023-04-16','2023-04-16','2023-04-26',false, "RETURNED", 2, 1),
       (3,'2023-04-16','2023-04-16','2023-04-26',false, "RETURNED", 1, 1),
       (4,'2023-08-10','2023-08-10','2023-08-20',false, "RETURNED", 4, 2),
       (5,'2023-08-10','2023-08-12','2023-08-19',false, "RETURNED", 2, 2),
       (6,'2023-11-06','2023-11-06','2023-11-12',false, "RETURNED", 3, 3),
       (7,'2023-11-12','2023-11-12','2023-11-19',false, "RETURNED", 1, 4),
       (8,'2023-11-12','2023-11-12','2023-11-26',false, "RESERVED", 2, 5),
       (9,'2023-11-12','2023-11-12','2023-11-26',false, "RESERVED", 3, 5),
       (10,'2023-11-12','2023-11-16','2023-11-30',false, "RETURNED", 5, 5),
       (11,'2023-11-12','2023-11-12','2023-11-26',false, "POSTPONED", 1, 6),
       (12,'2023-11-12','2023-11-12','2023-11-26',false, "RESERVED", 5, 6);
