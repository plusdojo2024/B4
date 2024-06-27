#出力形式
INSERT INTO tasks VALUES (NULL,'ユーザーID',到着時間,目的地,'登録日','更新日');

#出力例
INSERT INTO tasks VALUES (NULL,'yazima_go',18:00,"住所",'2024-06-18 09:49:2.038444','2024-06-18 09:49:28.038444');

/* 14【tasks テーブルを作成する SQL 文】*/
create table purpose (
id          integer auto_increment(1),
user_id     varchar (100) not null,
arrival        varchar (10) ,
destination     varchar (100) ,
created_at  datetime  default CURRENT_TIMESTAMP,
updated_at  datetime  default CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES USERS(user_id),
PRIMARY KEY (id)
);

-- ユーザー yazima_go のデータ
INSERT INTO tasks VALUES (NULL, 'yazima_go', 1, 20, true, '2024-06-20 12:00:00.000', '2024-06-20 12:00:00.000');
INSERT INTO tasks VALUES (NULL, 'yazima_go', 2, 25, false, '2024-06-20 12:01:00.000', '2024-06-20 12:01:00.000');
INSERT INTO tasks VALUES (NULL, 'yazima_go', 3, 18, true, '2024-06-20 12:02:00.000', '2024-06-20 12:02:00.000');
INSERT INTO tasks VALUES (NULL, 'yazima_go', 4, 22, true, '2024-06-20 12:03:00.000', '2024-06-20 12:03:00.000');
INSERT INTO tasks VALUES (NULL, 'yazima_go', 5, 15, false, '2024-06-20 12:04:00.000', '2024-06-20 12:04:00.000');

-- ユーザー alex_2024 のデータ
INSERT INTO tasks VALUES (NULL, 'alex_2024', 6, 23, true, '2024-06-20 12:05:00.000', '2024-06-20 12:05:00.000');
INSERT INTO tasks VALUES (NULL, 'alex_2024', 7, 19, false, '2024-06-20 12:06:00.000', '2024-06-20 12:06:00.000');
INSERT INTO tasks VALUES (NULL, 'alex_2024', 8, 20, true, '2024-06-20 12:07:00.000', '2024-06-20 12:07:00.000');

-- ユーザー Max-Power のデータ
INSERT INTO tasks VALUES (NULL, 'Max-Power', 9, 18, true, '2024-06-20 12:08:00.000', '2024-06-20 12:08:00.000');
INSERT INTO tasks VALUES (NULL, 'Max-Power', 10, 21, false, '2024-06-20 12:09:00.000', '2024-06-20 12:09:00.000');

-- 以下同様に、他のユーザーに対するデータを作成する。
