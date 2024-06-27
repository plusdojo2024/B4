ID  	USER_ID  	INCOME  	CREATED_AT  	UPDATED_AT  
1	yazima_go	200000	2024-06-20 12:00:00	2024-06-20 12:00:00
2	alex_2024	180000	2024-06-20 12:01:00	2024-06-20 12:01:00
3	Max-Power	220000	2024-06-20 12:02:00	2024-06-20 12:02:00
4	Ruby2023!	190000	2024-06-20 12:03:00	2024-06-20 12:03:00
5	Cool+Guy	210000	2024-06-20 12:04:00	2024-06-20 12:04:00
6	Happy_Day	195000	2024-06-20 12:05:00	2024-06-20 12:05:00
7	star.777	205000	2024-06-20 12:06:00	2024-06-20 12:06:00
8	QueenBee@	225000	2024-06-20 12:07:00	2024-06-20 12:07:00
9	Mega-Tiger	185000	2024-06-20 12:08:00	2024-06-20 12:08:00
10	42_Shadow	230000	2024-06-20 12:09:00	2024-06-20 12:09:00

これからサンプルデータを作成します。
以下のルールに従い10個のデータを出力してください。

#ルール
・登録日、更新日は「YYYY-MM-DD hh:mm.nnn」の形式で出力してください
・指定したユーザー名１つにつき１つのデータを作成してください。

#ユーザー名
・yazima_go
・alex_2024
・Max-Power
・Ruby2023!
・Cool+Guy
・Happy_Day
・star.777
・QueenBee@
・Mega-Tiger
・42_Shadow

#出力内容
・手取り額
・登録日
・更新日

#出力形式
INSERT INTO incomes VALUES (NULL,'ユーザーID',手取り額,
'登録日','更新日');

#出力例
NSERT INTO incomes VALUES (NULL,'yazima_go',200000,
'2024-06-18 09:49:2.038444','2024-06-18 09:49:28.038444');

/* 7【incomes テーブルを作成する SQL 文】*/
create table incomes (
id          integer auto_increment(1),
user_id     varchar (100) not null 　,
income      integer ,
created_at  datetime  default CURRENT_TIMESTAMP,
updated_at  datetime  default CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES USERS(user_id),
PRIMARY KEY (id)
);


-- ユーザー yazima_go のデータ
INSERT INTO incomes VALUES (NULL, 'yazima_go', 200000, '2024-06-20 12:00:00.000', '2024-06-20 12:00:00.000');

-- ユーザー alex_2024 のデータ
INSERT INTO incomes VALUES (NULL, 'alex_2024', 180000, '2024-06-20 12:01:00.000', '2024-06-20 12:01:00.000');

-- ユーザー Max-Power のデータ
INSERT INTO incomes VALUES (NULL, 'Max-Power', 220000, '2024-06-20 12:02:00.000', '2024-06-20 12:02:00.000');

-- ユーザー Ruby2023! のデータ
INSERT INTO incomes VALUES (NULL, 'Ruby2023!', 190000, '2024-06-20 12:03:00.000', '2024-06-20 12:03:00.000');

-- ユーザー Cool+Guy のデータ
INSERT INTO incomes VALUES (NULL, 'Cool+Guy', 210000, '2024-06-20 12:04:00.000', '2024-06-20 12:04:00.000');

-- ユーザー Happy_Day のデータ
INSERT INTO incomes VALUES (NULL, 'Happy_Day', 195000, '2024-06-20 12:05:00.000', '2024-06-20 12:05:00.000');

-- ユーザー star.777 のデータ
INSERT INTO incomes VALUES (NULL, 'star.777', 205000, '2024-06-20 12:06:00.000', '2024-06-20 12:06:00.000');

-- ユーザー QueenBee@ のデータ
INSERT INTO incomes VALUES (NULL, 'QueenBee@', 225000, '2024-06-20 12:07:00.000', '2024-06-20 12:07:00.000');

-- ユーザー Mega-Tiger のデータ
INSERT INTO incomes VALUES (NULL, 'Mega-Tiger', 185000, '2024-06-20 12:08:00.000', '2024-06-20 12:08:00.000');

-- ユーザー 42_Shadow のデータ
INSERT INTO incomes VALUES (NULL, '42_Shadow', 230000, '2024-06-20 12:09:00.000', '2024-06-20 12:09:00.000');
