create table if not exists tb_transaction (
  id int(11) NOT NULL,
  accountNumber varchar(100) NOT NULL,
  time_Stamp float NOT NULL,
  amount float DEFAULT NULL,
  description varchar(10) DEFAULT NULL,
  PRIMARY KEY (id)
)