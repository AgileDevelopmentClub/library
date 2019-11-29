DROP TABLE LENDING_RECORD;

create TABLE LENDING_EVENT (
      id INT(10) NOT NULL AUTO_INCREMENT,
      isbn VARCHAR(13) references BOOK(isbn),
      user_id VARCHAR(7) references USERR(user_id),
      date timestamp,
      PRIMARY KEY(id)
  );


create TABLE RETURN_EVENT (
      id INT(10) NOT NULL AUTO_INCREMENT,
      isbn VARCHAR(13) references BOOK(isbn),
      user_id VARCHAR(7) references USERR(user_id),
      date timestamp,
      PRIMARY KEY(id)
  );