これからサンプルデータを作成します。
以下のルールに従い10個のデータを出力してください。

#ルール
・登録日、更新日は「YYYY-MM-DD hh:mm.nnn」の形式で出力してください。
・運動強度はdouble型


#出力内容
・運動強度
・運動名
・登録日
・更新日


#出力形式
INSERT INTO exercises VALUES (NULL,'運動強度','運動名','登録日','更新日');

#出力例
NSERT INTO exercises VALUES (NULL,'3.5','運動名','current_timestamp','current_timestamp');


INSERT INTO exercises VALUES (NULL, 3.5, 'ウォーキング', '2024-06-18 09:49:2.038444', '2024-06-18 09:49:2.038444');
INSERT INTO exercises VALUES (NULL, 7.0, 'ランニング', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 5.0, '筋トレ', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 5.0, 'スクワット', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 2.5, 'ヨガ', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 6.19, 'ホットヨガ', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 6.36, 'バイシクルクランチ', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 3.2, '腕立て伏せ', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');
INSERT INTO exercises VALUES (NULL, 3.75, '腹筋', '2024-06-18 09:49:28.038444', '2024-06-18 09:49:28.038444');