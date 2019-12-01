## やり残し
* クラウドフォーメーションでの自動構築時にユーザデータで以下のインストールを自動でやる
    * jdk11　のインストール
    * postgresのインストール
    * DB用環境変数設定
    * コードデプロイのエージェントをインストール
    * 時刻やインスタンス名をいい感じにする

## 手作業で実施すること
* EC2にJDKインストール
* EC2にPostgreクライアントをインストール
* EC2に環境変数を設定
* PostgreにDBを作成
* Jarをコピー
* Jarを起動
* Ec2のセキュリティグループにHttpを追加


## codedeployのエージェント
```aidl
sudo yum update

sudo yum install ruby
# CodeDeployエージェントのインストール

wget https://aws-codedeploy-ap-northeast-1.s3.amazonaws.com/latest/install
chmod +x install
sudo ./install auto
```

* 非同期実行
```aidl
nohup java -jar hogehoge.jar &
```

* postgresのインストール
```aidl
sudo yum install -y  postgresql
```

* jarの中身を見る 
```aidl
jar tf hogehoge.jar
```

* jarとその他をZIPにする 
```aidl
jar -cMf hoge.zip
```


* jdk11のインストール
```aidl
sudo yum install -y java-11-amazon-corretto
```

* 手動で作成したリソースからクラウドフォーメーションのtemplateを作成する方法
```aidl
https://docs.aws.amazon.com/ja_jp/AWSCloudFormation/latest/UserGuide/cfn-using-cloudformer.html
```

```aidl
export DATABASE_PASS=xxxx
export DATABASE_URL_SPRINGBOOT=jdbc:postgresql://xxxx:5432/library}
export DATABASE_USER=libraryuser

```


userDataでやること（コードデプロイエージェントはIAMロールの設定が自動化できないのでやらない）
```aidl

#!/bin/bash

# ホスト名
sed -i 's/^HOSTNAME=[a-zA-Z0-9\.\-]*$/HOSTNAME=udemy-aws-14days-db-1a/g' /etc/sysconfig/network
hostname 'udemy-aws-14days-db-1a'

# タイムゾーン
cp /usr/share/zoneinfo/Japan /etc/localtime
sed -i 's|^ZONE=[a-zA-Z0-9\.\-\"]*$|ZONE="Asia/Tokyo”|g' /etc/sysconfig/clock

# 言語設定
echo "LANG=ja_JP.UTF-8" > /etc/sysconfig/i18n

# java11のダウンロード
yum install -y java-11-amazon-corretto

* postgresのインストール
yum install -y  postgresql

# 環境変数
export DATABASE_PASS=xxxx
export DATABASE_URL_SPRINGBOOT=jdbc:postgresql://xxxx:5432/library}
export DATABASE_USER=libraryuser
```