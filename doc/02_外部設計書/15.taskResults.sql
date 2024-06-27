ID  	USER_ID  	TASK_ID  	EXECUTION  	CREATED_AT  	UPDATED_AT  
1	yazima_go	1	15	2024-06-20 12:00:00	2024-06-20 12:00:00
2	yazima_go	2	20	2024-06-20 12:01:00	2024-06-20 12:01:00
3	yazima_go	3	25	2024-06-20 12:02:00	2024-06-20 12:02:00
4	yazima_go	4	18	2024-06-20 12:03:00	2024-06-20 12:03:00
5	yazima_go	5	22	2024-06-20 12:04:00	2024-06-20 12:04:00
6	yazima_go	6	17	2024-06-20 12:05:00	2024-06-20 12:05:00
7	yazima_go	7	30	2024-06-20 12:06:00	2024-06-20 12:06:00
8	yazima_go	8	28	2024-06-20 12:07:00	2024-06-20 12:07:00
9	yazima_go	9	16	2024-06-20 12:08:00	2024-06-20 12:08:00
10	yazima_go	10	23	2024-06-20 12:09:00	2024-06-20 12:09:00
11	alex_2024	1	19	2024-06-20 12:10:00	2024-06-20 12:10:00
12	alex_2024	2	21	2024-06-20 12:11:00	2024-06-20 12:11:00
13	alex_2024	3	24	2024-06-20 12:12:00	2024-06-20 12:12:00
14	alex_2024	4	17	2024-06-20 12:13:00	2024-06-20 12:13:00
15	alex_2024	5	23	2024-06-20 12:14:00	2024-06-20 12:14:00
16	alex_2024	6	18	2024-06-20 12:15:00	2024-06-20 12:15:00
17	alex_2024	7	29	2024-06-20 12:16:00	2024-06-20 12:16:00
18	alex_2024	8	25	2024-06-20 12:17:00	2024-06-20 12:17:00
19	alex_2024	9	20	2024-06-20 12:18:00	2024-06-20 12:18:00
20	alex_2024	10	26	2024-06-20 12:19:00	2024-06-20 12:19:00


これからサンプルデータを作成します。
以下のルールに従い10個のデータを出力してください。

#ルール
・登録日、更新日は「YYYY-MM-DD hh:mm.nnn」の形式で出力してください。
・指定したユーザー名１つにつき１つのデータを作成してください。
・タスクIDは1～10の数字をランダムで代入してください。

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
・経過時間（分）
・登録日
・更新日

#出力形式
INSERT INTO task_result VALUES (NULL,'ユーザーID',タスクID,経過時間（分）,
'登録日','更新日');

#出力例
NSERT INTO task_result VALUES (NULL,'yazima_go',5,10,
'2024-06-18 09:49:2.038444','2024-06-18 09:49:28.038444');


/* 15【task_results テーブルを作成する SQL 文】*/
create table task_result (
id          integer auto_increment(1),
user_id     varchar (100)  not null  　,
task_id     integer ,
execution   integer ,
created_at  datetime  default CURRENT_TIMESTAMP,
updated_at  datetime  default CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES USERS(user_id),
FOREIGN KEY (task_id) REFERENCES task_types(id),
PRIMARY KEY (id)

);

-- ユーザー yazima_go のデータ
INSERT INTO task_result VALUES (NULL, 'yazima_go', 1, 15, '2024-06-20 12:00:00.000', '2024-06-20 12:00:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 2, 20, '2024-06-20 12:01:00.000', '2024-06-20 12:01:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 3, 25, '2024-06-20 12:02:00.000', '2024-06-20 12:02:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 4, 18, '2024-06-20 12:03:00.000', '2024-06-20 12:03:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 5, 22, '2024-06-20 12:04:00.000', '2024-06-20 12:04:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 6, 17, '2024-06-20 12:05:00.000', '2024-06-20 12:05:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 7, 30, '2024-06-20 12:06:00.000', '2024-06-20 12:06:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 8, 28, '2024-06-20 12:07:00.000', '2024-06-20 12:07:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 9, 16, '2024-06-20 12:08:00.000', '2024-06-20 12:08:00.000');
INSERT INTO task_result VALUES (NULL, 'yazima_go', 10, 23, '2024-06-20 12:09:00.000', '2024-06-20 12:09:00.000');

-- ユーザー alex_2024 のデータ
INSERT INTO task_result VALUES (NULL, 'alex_2024', 1, 19, '2024-06-20 12:10:00.000', '2024-06-20 12:10:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 2, 21, '2024-06-20 12:11:00.000', '2024-06-20 12:11:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 3, 24, '2024-06-20 12:12:00.000', '2024-06-20 12:12:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 4, 17, '2024-06-20 12:13:00.000', '2024-06-20 12:13:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 5, 23, '2024-06-20 12:14:00.000', '2024-06-20 12:14:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 6, 18, '2024-06-20 12:15:00.000', '2024-06-20 12:15:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 7, 29, '2024-06-20 12:16:00.000', '2024-06-20 12:16:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 8, 25, '2024-06-20 12:17:00.000', '2024-06-20 12:17:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 9, 20, '2024-06-20 12:18:00.000', '2024-06-20 12:18:00.000');
INSERT INTO task_result VALUES (NULL, 'alex_2024', 10, 26, '2024-06-20 12:19:00.000', '2024-06-20 12:19:00.000');

-- 以下同様に、他のユーザーに対するデータを作成する。
