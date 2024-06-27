
ID  	USER_ID  	TASK_ID  	TIME  	SHOW  	CREATED_AT  	UPDATED_AT  
1	yazima_go	1	20	TRUE	2024-06-20 12:00:00	2024-06-20 12:00:00
2	yazima_go	2	25	FALSE	2024-06-20 12:01:00	2024-06-20 12:01:00
3	yazima_go	3	18	TRUE	2024-06-20 12:02:00	2024-06-20 12:02:00
4	yazima_go	4	22	TRUE	2024-06-20 12:03:00	2024-06-20 12:03:00
5	yazima_go	5	15	FALSE	2024-06-20 12:04:00	2024-06-20 12:04:00
6	alex_2024	6	23	TRUE	2024-06-20 12:05:00	2024-06-20 12:05:00
7	alex_2024	7	19	FALSE	2024-06-20 12:06:00	2024-06-20 12:06:00
8	alex_2024	8	20	TRUE	2024-06-20 12:07:00	2024-06-20 12:07:00
9	Max-Power	9	18	TRUE	2024-06-20 12:08:00	2024-06-20 12:08:00
10	Max-Power	10	21	FALSE	2024-06-20 12:09:00	2024-06-20 12:09:00

これからサンプルデータを作成します。
以下のルールに従い10個のデータを出力してください。

#ルール
・登録日、更新日は「YYYY-MM-DD hh:mm.nnn」の形式で出力してください。
・指定したユーザー名１つにつき３～５個のデータを作成してください。
・タスクIDは1～10の数字をランダムで代入してください。
・表示の有無は「true」もしくは「false」のどちらかを代入してください。

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
・タスクID
・所要時間（分）
・表示の有無
・登録日
・更新日

#出力形式
INSERT INTO tasks VALUES (NULL,'ユーザーID',タスクID,所要時間（分）,表示の有無,
'登録日','更新日');

#出力例
NSERT INTO tasks VALUES (NULL,'yazima_go',4,15,true,
'2024-06-18 09:49:2.038444','2024-06-18 09:49:28.038444');


/*内部結合*/
SELECT t.id,t.user_id,tt.task,t.time,t.show,t.created_at,t.updated_at
FROM TASKS as t
INNER JOIN TASK_TYPES as tt
ON t.TASK_ID = tt.ID;

/* 14【tasks テーブルを作成する SQL 文】*/
create table tasks (
id          integer auto_increment(1),
user_id     varchar (100) not null 　,
task_id     integer ,
time        integer ,
show        boolean ,
created_at  datetime  default CURRENT_TIMESTAMP,
updated_at  datetime  default CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES USERS(user_id),
FOREIGN KEY (task_id) REFERENCES task_types(id),
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
