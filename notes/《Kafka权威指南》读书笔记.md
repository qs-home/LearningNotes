# 《Kafka权威指南》读书笔记

## 目录<br/>
<a href="#第一章-初识kafka">第一章 初识kafka</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#123-主题和分区">1.2.3 主题和分区</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#124-生产者和消费者">1.2.4 生产者和消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1生产者">1.生产者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2消费者">2.消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#125-broker和集群">1.2.5 broker和集群</a><br/>
<a href="#第二章-安装kafka">第二章 安装kafka</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#21-环境安装">2.1 环境安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#212-安装Java">2.1.2 安装Java</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#213-安装zookeeper">2.1.3 安装zookeeper</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1-ZooKeeper安装"> 1. ZooKeeper安装</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2-Zookeeper-集群搭建">2. Zookeeper 集群搭建</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#22-安装kafka-Broker">2.2 安装kafka Broker</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#23-broker-配置">2.3 broker 配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#231-常规配置">2.3.1 常规配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1brokerid">1.broker.id </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2port">2.port</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3-zookeeperconnect">3. zookeeper.connect</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4logdirs">4.log.dirs</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5numrecoverythreadsperdatadir">5.num.recovery.threads.per.data.dir</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6autocreatetopicsenables">6.auto.create.topics.enables</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#232-主题的默认配置">2.3.2 主题的默认配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1numpartitions">1.num.partitions</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2logretentionms">2.log.retention.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3logretentionbytes">3.log.retention.bytes</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4logsegmentbytes">4.log.segment.bytes</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5logsegmentms">5.log.segment.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6messagemaxbytes">6.message.max.bytes</a><br/>
<a href="#第三章-kafka生产者">第三章 kafka生产者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#32-创建-kafka-生产者">3.2 创建 kafka 生产者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1生产者必选属性">1.生产者必选属性</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2发送消息的方式">2.发送消息的方式</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#34-生产者配置">3.4 生产者配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1acks">1.acks</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2buffermemory">2.buffer.memory</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3compressiontype">3.compression.type</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4retries">4.retries</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5batchsize">5.batch.size</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6lingerms">6.linger.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7clentid">7.clent.id</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8maxinflightrequestsperconnection">8.max.in.flight.requests.per.connection</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#9timeoutms,-requesttimeoutms和metadatafetchtimeoutms">9.timeout.ms, request.timeout.ms和metadata.fetch.timeout.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#10maxblockms">10.max.block.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#11maxrequestsize">11.max.request.size</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#12receivebufferbytes-和-sendbufferbyte">12.receive.buffer.bytes 和 send.buffer.byte</a><br/>
<a href="#第四章-kafka消费者">第四章 kafka消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#41-分区再均衡">4.1 分区再均衡</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#42-创建kafka消费者">4.2 创建kafka消费者</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#43-订阅主题">4.3 订阅主题</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#44-轮询">4.4 轮询</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#45-消费者配置">4.5 消费者配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1fetchminbyte">1.fetch.min.byte</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2fetchmaxwaitms">2.fetch.max.wait.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#3maxpartitionfetchbytes">3.max.partition.fetch.bytes</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#4sessiontimeoutms">4.session.timeout.ms</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#5autooffsetreset">5.auto.offset.reset</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#6enableautocommit">6.enable.auto.commit</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#7clientid">7.client.id</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#8maxpollrecords">8.max.poll.records</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#9receivebufferbytes-和-sendbufferbyte">9.receive.buffer.bytes 和 send.buffer.byte</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#46-提交和偏移量">4.6 提交和偏移量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#1提交当前偏移量">1.提交当前偏移量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#2提交特定偏移量">2.提交特定偏移量</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#47-再均衡监听器">4.7 再均衡监听器</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#48-从特定偏移量处开始处理数据">4.8 从特定偏移量处开始处理数据</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#49-如何退出">4.9 如何退出</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#411-独立消费者">4.11 独立消费者</a><br/>
<a href="#第五章-深入kafka">第五章 深入kafka</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#51-集群与成员之间的关系">5.1 集群与成员之间的关系</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#52-控制器">5.2 控制器 </a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#53-复制">5.3 复制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#55-文件管理">5.5 文件管理</a><br/>
<a href="#第六章-可靠的数据传递">第六章 可靠的数据传递</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#62-复制">6.2 复制</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="#63-broker-配置">6.3 broker 配置</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#631-复制系数">6.3.1 复制系数</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#632-不完全的首领选举">6.3.2 不完全的首领选举</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#633-最少同步副本">6.3.3 最少同步副本</a><br/>
<a href="#第九章-管理kafka">第九章 管理kafka</a><br/>
## 正文<br/>




## 第一章 初识kafka

### 1.2.3 主题和分区

kafka 的消息通过主题进行分类。一个主题可以被分为若干个分区，一个分区就是一个提交日志。消息以追加的方式写入分区，然后以先入先出的顺序读取。kafka通过分区来实现数据的冗余和伸缩性，分区可以分布在不同的服务器上，也就是说一个主题可以横跨多个服务器，以此来提供比单个服务器更强大的性能（类比HDFS分布式文件系统）。

注意：由于一个主题包含多个分区，因此无法在整个主题范围内保证消息的顺序性，**但可以保证消息在单个分区内的顺序性**。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/kafka主题和分区.png"/> </div></br>

### 1.2.4 生产者和消费者

#### 1.生产者

默认情况下生产者在把消息均衡地分布到在主题的所有分区上，而并不关心特定消息会被写到那个分区。也可以通过消息键和分区器来实现把消息直接写到指定的分区，**通过分区器对消息键进行散列实现**。

#### 2.消费者

消费者是**消费者群组**的一部分。也就是说，会有一个或者多个消费者共同读取一个主题，群组保证每个分区只能被一个消费者使用。

注：原文这个地方的意思应该是，**一个分区只能被同一个消费者群组里面的一个消费者读取，但可以被不同消费者群组里面的多个消费者读取。多个消费者群组可以共同读取同一个主题，彼此之间互不影响**。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/kafka消费者.png"/> </div></br>

### 1.2.5 broker和集群

一个独立的kafka服务器被称为broker。broker 接收来自生产者的消息，为消息设置偏移量，并提交消息到磁盘保存。broker为消费者提供服务，对读取分区的请求做出响应，返回已经提交到磁盘的消息。

broker是集群的组成部分。每一个集群都有一个broker同时充当了集群控制器的角色（自动从集群的活跃成员中选举出来）。控制器负责管理工作，包括将分区分配给broker和监控broker。**在集群中，一个分区从属一个broker,该broker被称为分区的首领**。一个分区可以分配给多个broker,这个时候会发生分区复制。这种复制机制为分区提供了消息冗余，如果有一个broker失效，其他broker可以接管领导权。

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/kafka集群复制.png"/> </div></br>

## 第二章 安装kafka

### 2.1 环境安装

#### 2.1.2 安装Java

**在安装Zookeeper和kafka之前，需要安装java环境。**

1. 下载 java对应版本,上传至服务器对应文件夹（usr/local）下, 解压 tar  zxvf jdk-8u121-linux-x64.tar.gz

2. 设置环境变量 sudo vim /etc/profile  在文件最后，添加如下内容：       

```shell
export JAVA_HOME=/usr/local/jdk1.8.0_121
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin
```

3. 设置环境变量立即生效  source /etc/profile
4. 执行 java -version 查看安装结果



#### 2.1.3 安装zookeeper

#####  1. ZooKeeper安装

1. 下载 zookeeper 对应版本，地址：https://archive.apache.org/dist/zookeeper/

2. 上传至服务器对应文件夹（usr/local）下，解压**tar -zxvf zookeeper-3.4.9.tar.gz**

3. cd  到 conf 目录下，拷贝配置文件**cp zoo_sample.cfg  zoo.cfg**，修改 zoo.cfg 配置文件.指定数据目录和日志目录如下：

   ```cmd
   # The number of milliseconds of each tick
   tickTime=2000
   # The number of ticks that the initial 
   # synchronization phase can take
   initLimit=10
   # The number of ticks that can pass between 
   # sending a request and getting an acknowledgement
   syncLimit=5
   # the directory where the snapshot is stored.
   # do not use /tmp for storage, /tmp here is just 
   # example sakes.
   dataDir=/usr/local/zookeeper-data
   dataLogDir=/usr/local/zookeeper-log
   # the port at which the clients will connect
   clientPort=2181
   # the maximum number of client connections.
   # increase this if you need to handle more clients
   #maxClientCnxns=60
   #
   # Be sure to read the maintenance section of the 
   # administrator guide before turning on autopurge.
   #
   # http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
   #
   # The number of snapshots to retain in dataDir
   #autopurge.snapRetainCount=3
   
   ```

4. 导出环境变量

   ```shell
   [root@heibaiying conf]# export ZOOKEEPER_INSTALL=/usr/local/zookeeper-3.4.9
   [root@heibaiying conf]# export PATH=$PATH:$ZOOKEEPER_INSTALL/bin
   ```

5. 启动并查看

   ```shell
   [root@heibaiying bin]# ./zkServer.sh start
   [root@heibaiying bin]# ps -ef | grep zookeeper
   ```

6. 利用客户端连接

   ```shell
   [root@heibaiying bin]# zkCli.sh -server localhost:2181
   ```

**注：配置文件参数说明**：

- **tickTime**:用于计算的时间单元。比如session超时：N*tickTime.
- **initLimit**:用于集群，允许从节点连接并同步到 master节点的初始化连接时间，以tickTime 的倍数来表示.
- **syncLimit**:用于集群， master主节点与 从节点 之间发送消息，请求和应答 时间长度（心跳机制）
- **dataDir**:必须配置。
- **dataLogDir**:日志目录。
- **clientPort**：连接服务器的端口，默认2181



##### 2. Zookeeper 集群搭建

1. 解压三份Zookeeper安装包(**zookeeper-3.4.9, zookeeper02, zookeeper03**)，并建立对应的data目录和log目录，如下：

   ```shell
   drwxr-xr-x. 10 root         root      4096 12月  3 14:22 zookeeper02
   drwxr-xr-x. 10 root         root      4096 12月  3 14:22 zookeeper03
   drwxr-xr-x. 10 beibairuiwen hello     4096 8月  23 2016 zookeeper-3.4.9
   -rw-r--r--.  1 root         root  22724574 12月  3 09:33 zookeeper-3.4.9.tar.gz
   drwxr-xr-x.  3 root         root        63 12月  3 15:24 zookeeper-data
   drwxr-xr-x.  3 root         root        63 12月  3 15:28 zookeeper-data-02
   drwxr-xr-x.  3 root         root        63 12月  3 14:59 zookeeper-data-03
   drwxr-xr-x.  3 root         root        23 12月  3 09:50 zookeeper-log
   drwxr-xr-x.  3 root         root        23 12月  3 14:40 zookeeper-log-02
   drwxr-xr-x.  3 root         root        23 12月  3 14:40 zookeeper-log-03
   ```

2. zookeeper-3.4.9 中 zoo.cfg 配置如下,**单机伪集群版zookeeper02,03 中需要修改对应的clientPort为2182,2183**，真实集群版可保持一致：

   ```shell
   # The number of milliseconds of each tick
   tickTime=2000
   # The number of ticks that the initial 
   # synchronization phase can take
   initLimit=10
   # The number of ticks that can pass between 
   # sending a request and getting an acknowledgement
   syncLimit=5
   # the directory where the snapshot is stored.
   # do not use /tmp for storage, /tmp here is just 
   # example sakes.
   dataDir=/usr/local/zookeeper-data
   dataLogDir=/usr/local/zookeeper-log
   # the port at which the clients will connect
   clientPort=2181
   # the maximum number of client connections.
   # increase this if you need to handle more clients
   #maxClientCnxns=60
   #
   # Be sure to read the maintenance section of the 
   # administrator guide before turning on autopurge.
   #
   # http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
   #
   # The number of snapshots to retain in dataDir
   #autopurge.snapRetainCount=3
   # Purge task interval in hours
   # Set to "0" to disable auto purge feature
   #autopurge.purgeInterval
   # 后面两个端口分别是集群间通讯端口和数据端口
   server.1=127.0.0.1:2287:3387
   server.2=127.0.0.1:2288:3388
   server.3=127.0.0.1:2289:3389
   ```

3. 在zookeeper-data，zookeeper-data-01，zookeeper-data-02文件夹下分别新建myid文件，三个myid文件中并分别写入1,2,3,  对应配置文件中的server.1,server.2,server.3 

4. 分别启动并查看对应的节点状态：

   ```shell
   [root@heibaiying bin]# ./zkServer.sh start
   ```

   ```shell
   [root@heibaiying bin]# ./zkServer.sh status
   ZooKeeper JMX enabled by default
   Using config: /usr/local/zookeeper03/bin/../conf/zoo.cfg
   Mode: follower # 从节点
   
   [root@heibaiying bin]# cd /usr/local/zookeeper-3.4.9/bin/
   [root@heibaiying bin]# ./zkServer.sh status
   ZooKeeper JMX enabled by default
   Using config: /usr/local/zookeeper-3.4.9/bin/../conf/zoo.cfg
   Mode: leader  # 主节点
   ```



### 2.2 安装kafka Broker

1. 下载 kafka对应版本,上传至服务器对应文件夹（usr/local）下,解压 tar -zxvf  kafka_2.11 -0.9.0.1.tgz 

2. 使用默认配置启动：bin/kafka-server-start.sh config/server.properties

3. 停止： bin/kafka-server-stop.sh config/server.properties

   注：安装后可以创建一个主题（Hello-Kafka）用于测试：

   bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1   --partitions 1 --topic Hello-Kafka



### 2.3 broker 配置

#### 2.3.1 常规配置

##### 1.broker.id 

broker在集群中的唯一标识，默认为0。

##### 2.port

启动的端口，默认为9092。

##### 3. zookeeper.connect

zookeeper 连接地址，集群可以用分号分隔。

##### 4.log.dirs

**kafka把所有消息都保存在磁盘上，存放这些日志片段的目录是通过log.dirs指定的**。它是一组用逗号分隔得本地文件系统路径，如果指定了多个路径，根据“最少使用”原则，把一个分区的日志片段保存在同一个路径下，broker会往拥有最少分区数目的路径新增分区。

##### 5.num.recovery.threads.per.data.dir

配置处理日志片段的线程数量。默认情况下，每个日志只用一个线程。

##### 6.auto.create.topics.enables

是否自动创建主题。



#### 2.3.2 主题的默认配置

##### 1.num.partitions

指定新创建的主题将包含多少个分区。默认为1。

##### 2.log.retention.ms

kafka数据的保存时间，默认为1周。

##### 3.log.retention.bytes

分区最大保存的字节数。

##### 4.log.segment.bytes

日志片段的大小。消息持久化是保存在日志片段上，日志片段达到log.segment.bytes指定的上限（默认为1GB）时，当前日志片段就会被关闭，新的日志片段会被打开。

##### 5.log.segment.ms

指定日志过了多长时间之后被关闭。

##### 6.message.max.bytes

单个消息的大小，默认值是1MB。



## 第三章 kafka生产者

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/kafka生产组件图.png"/> </div></br>

服务器在收到生产者的消息后悔返回一个响应信息，如果消息成功写入kafka,就返回一个RecordMetaData对象，它包含了主题和分区信息，已经记录在分区里的偏移量。如果写入失败，则会返回一个错误。生产者在收到错误之后尝试进行重新发送消息。



### 3.2 创建 kafka 生产者

#### 1.生产者必选属性

**bootstrap.servers**

指定broker的地址清单，清单里不需要包含所有的broker地址，生产者会从给定的broker里查找broker的信息。不过建议至少要提供两个broker的信息作为容错。

**key.serializer**

指定键的序列化器。

**value.serializer**

指定值的序列化器。



#### 2.发送消息的方式

**发送并忘记**

把消息发送给服务器，但并不关心它是否到达。

**同步发送**

使用send()方法发送消息，它会返回一个Future对象，调用get()方法进行等待，就可以知道消息是否发送成功。

**异步发送**

调用send()方法，并制定回调函数，服务器在返回响应时调用该函数。



### 3.4 生产者配置

#### 1.acks

acks 参数指定了必须要有多少个分区副本收到消息，生产者才会认为消息写入是成功的。

- acks=0 ： 生产者在成功写入消息之前不会等待任何来自服务器的响应。
- acks=1 ： 只要集群的首领节点收到消息，生产者就会收到一个来自服务器成功响应。
- acks=all ：只有当所有参与复制的节点全部收到消息时，生产者才会收到一个来自服务器的成功响应。

#### 2.buffer.memory

设置生产者内存缓冲区的大小。

#### 3.compression.type

消息压缩的方法，snappy, gzip ,lz4。

#### 4.retries

发生错误后，消息重发的次数。

#### 5.batch.size

当有多个消息需要被发送到同一个分区时，生产者会把它们放在同一个批次里。该参数指定了一个批次可以使用的内存大小，按照字节数计算。

#### 6.linger.ms

该参数制定了生产者在发送批次之前等待更多消息加入批次的时间。

#### 7.clent.id

客户端id,服务器用来识别消息的来源。

#### 8.max.in.flight.requests.per.connection

指定了生产者在收到服务器响应之前可以发送多少个消息。它的值越高，就会占用越多的内存，不过也会提升吞吐量，**把它设置为1可以保证消息是按照发送的顺序写入服务器，即使发生了重试**。

#### 9.timeout.ms, request.timeout.ms和metadata.fetch.timeout.ms

- timeout.ms 指定了borker等待同步副本返回消息的确认时间；
- request.timeout.ms 指定了生产者在发送数据时等待服务器返回响应的时间；
- metadata.fetch.timeout.ms 指定了生产者在获取元数据（比如分区首领是谁）时等待服务器返回响应的时间。

#### 10.max.block.ms

指定了在调用send()方法或使用partitionsFor()方法获取元数据时生产者的阻塞时间。当生产者的发送缓冲区已满，或者没有可用的元数据时，这些方法会阻塞。在阻塞时间达到max.block.ms 时，生产者会抛出超时异常。

#### 11.max.request.size

改参数用于控制生产者发送的请求大小。它可以指定能发送的单个消息的最大值，也可以指单个请求里所有消息总的大小。

#### 12.receive.buffer.bytes 和 send.buffer.byte

这两个参数分别指定TCP socket 接收和发送数据包缓冲区的大小，-1代表使用操作系统的默认值。

```java
// 生产者示例
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) {

        String topicName = "Hello-Kafka";

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.200.228:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 10; i++) {
            System.out.println("Message sent start");
            producer.send(new ProducerRecord<>(topicName,
                    Integer.toString(i), Integer.toString(i)));
            System.out.println("Message sent successfully");
        }
        producer.close();
    }
}
```



## 第四章 kafka消费者

<div align="center"> <img src="https://github.com/heibaiying/LearningNotes/blob/master/pictures/kafka多消费者组.png"/> </div></br>

### 4.1 分区再均衡

**分区的所有权从一个消费者转移到另一个消费者，这样的行为被称为再均衡。**

消费者通过向被指派为**群组协调器**的 broker （不同的群组可以有不同的协调器）发送心跳来维持它们和群组的从属关系以及它们对分区的所有权关系。只要消费者以正常的时间间隔发送心跳，就被认为是活跃的，说明它还在读取分区里的消息。消费者会在轮询消息（为了获取消息）或提交偏移量时发送心跳。如果消费者停止发送心跳的时间足够长，会话就会过期，群组协调器认为它已经死亡，就会触发一次再均衡。 



### 4.2 创建kafka消费者

**消费者必选属性**

**bootstrap.servers**

指定broker的地址清单，清单里不需要包含所有的broker地址，生产者会从给定的broker里查找broker的信息。不过建议至少要提供两个broker的信息作为容错。

**key.serializer**

指定键的序列化器。

**value.serializer**

指定值的序列化器。



### 4.3 订阅主题

```java
public void subscribe(Collection<String> topics) 
// 支持正则
consumer.subscribe("test.*")    
```



### 4.4 轮询

消息轮询（poll）是消费者 API 的核心，通过一个简单的轮询向服务器请求数据。一旦消费者订阅了主题，轮询就会处理所有的细节，包括群组协调、分区再均衡、发送心跳和获取数据，开发者只需要使用一组简单的 API 来处理从分区返回的数据。 



### 4.5 消费者配置

#### 1.fetch.min.byte

消费者从服务器获取记录的最小字节数。如果可用的数据量小于设置值，broker会等待有足够的可用数据时才会把它返回给消费者。

#### 2.fetch.max.wait.ms

broker返回给消费者数据的等待时间，默认是500ms

#### 3.max.partition.fetch.bytes

分区返回给消费者的最大字节数，默认为1MB

#### 4.session.timeout.ms

消费者在被认为死亡之前可以与服务器断开连接的时间，默认是3s。

#### 5.auto.offset.reset

该属性指定了消费者在读取一个没有偏移量的分区或者偏移量无效的情况下该作何处理：

- latest（默认值 ） ：在偏移量无效的情况下，消费者将从最新的记录开始读取数据（在消费者启动之后生成的记录）

- earliest ：在偏移量无效的情况下，消费者将从起始位置读取分区的记录

#### 6.enable.auto.commit

是否自动提交偏移量，默认值是true,为了避免出现重复数据和数据丢失，可以把它设置为false。

#### 7.client.id

客户端id,服务器用来识别消息的来源。

#### 8.max.poll.records

单次调用call()方法能够返回的记录数量。

#### 9.receive.buffer.bytes 和 send.buffer.byte

这两个参数分别指定TCP socket 接收和发送数据包缓冲区的大小，-1代表使用操作系统的默认值。

```java
// 消费者示例
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerGroup {

    public static void main(String[] args) {
        String topic = "Hello-Kafka";
        String group = "group1";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", group);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic " + topic);

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
        }
    }
}
```

### 4.6 提交和偏移量

#### 1.提交当前偏移量

```java
// 1、手动提交
while (true) {
    ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
    for (ConsumerRecord<String, String> record : records)
        System.out.printf("offset = %d, key = %s, value = %s\n",
                record.offset(), record.key(), record.value());
    // 手动提交 在成功提交之前或碰到无法恢复的错误之前，会一直重试
    consumer.commitSync();
}


///2、异步提交 带回调函数
while (true) {
    ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
    for (ConsumerRecord<String, String> record : records)
        System.out.printf("offset = %d, key = %s, value = %s\n",
                record.offset(), record.key(), record.value());
    // 异步提交 不会重试
    consumer.commitAsync((offsets, e) -> {
        if (e != null) {
            System.out.println("commit Async fail,offset");
            e.printStackTrace();
        }
    });
}


// 3、同步加异步的组合
try {
    ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
    for (ConsumerRecord<String, String> record : records)
        System.out.printf("offset = %d, key = %s, value = %s\n",
                record.offset(), record.key(), record.value());
    // 异步提交
    consumer.commitAsync();
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        // 因为即将要关闭消费者，所以要用同步尽量保证提交成功
        consumer.commitSync();
    } finally {
        consumer.close();
    }
}
```



#### 2.提交特定偏移量

commitSync() 和  consumer.commitAsync() 默认提交的是最后一个偏移量，如果要提交特定偏移量，需要传入偏移量参数。不过，**因为消费者可能不只读取一个分区，所以需要跟踪所有分区的偏移量，然后全部提交**。

```java
 Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        int count = 0;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
                currentOffsets.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1, "mo metadata"));
            }
            if (count % 1000 == 0) {
                consumer.commitAsync(currentOffsets, null);
            }
            consumer.commitSync();
            count++;
        }
```



### 4.7 再均衡监听器

通过在**subscribe**订阅消费者时候传入**ConsumerRebalanceListener** 可以对再均衡行为进行监听。

- **onPartitionsRevoked**：方法会在再均衡开始之前和消费者停止读取消息之后被调用。如果在这里提交偏移量，下一个接管分区的消费者就知道该从哪里开始读取了。 
- **onPartitionsAssigned**：方法会在重新分配分区之后和消费者开始读取消息之前被调用。 

```java
Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();

consumer.subscribe(Collections.singletonList(topic), new ConsumerRebalanceListener() {
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        System.out.println("再均衡即将触发");
        // 提交当前偏移量
        consumer.commitSync(currentOffsets);
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

    }
});
```



### 4.8 从特定偏移量处开始处理数据

- seekToBeginning(Collection\<TopicPartition> partitions) 从分区的起始位置开始读取消息；
- seekToEnd(Collection\<TopicPartition> partitions) 从分区的末尾开始读取消息；
- seek(TopicPartition partition, long offset) 从分区的指定位置开始读取消息。



### 4.9 如何退出

```java
/**
* Wakeup the consumer. This method is thread-safe and is useful in particular to abort a long poll.
* 唤醒消费者。此方法是线程安全的，特别适用于中止长轮询
*/
@Override
public void wakeup() {
    this.client.wakeup();
}
```

**consumer.wakeup()是消费者唯一一个可以从其他线程里安全调用的方法。** 在退出线程之前调用consumer.close() 是很有必要的， 它会提交任何还没有提交的东西 ， 并向群组协调器发送消息，告知自己要离开群组，接下来就会触发再均衡 ，而不需要等待会话超时。 



### 4.11 独立消费者

你可能只需要一个消费者从一个主题的所有分区或者某个特定的分区读取数据。这个时候就不需要消费者群组和再均衡了， 只需要把主题或者分区分配给消费者，然后开始读取消息井提交偏移量。 

```java
List<TopicPartition> partitions = new ArrayList<>();
List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);

for (PartitionInfo partition : partitionInfos) {
    partitions.add(new TopicPartition(partition.topic(), partition.partition()));
}
// 为消费者指定分区
consumer.assign(partitions);


while (true) {
    ConsumerRecords<String, String> records = consumer.poll(Duration.of(100, ChronoUnit.MILLIS));
    for (ConsumerRecord<String, String> record : records)
        System.out.printf("offset = %d, key = %s, value = %s\n",
                record.offset(), record.key(), record.value());
    consumer.commitSync();
}
```

除了不会发生再均衡，也不需要手动查找分区 ， 其他的看起来一切正常。不过要记住 ，**如果主题增加了新的分区，消费者并不会收到通知**。 所以 ，要么周期性地调用consumer.partitionsFor（）方法来检查是否有新分区加入， 要么在添加新分区后重启应用程序。 



## 第五章 深入kafka

### 5.1 集群与成员之间的关系

**kafka 使用 Zookeeper 来维护集群成员的信息**。每个 broker 都有一个唯一标识符，这个标识符可以在配置文件里指定 ，也可以自动生成。在 broker启动的时候，它通过创建临时节点把自己的 ID 注册到 Zookeeper。 Kafka 组件订阅 Zookeeper 的／brokers/ids 路径(broker在 Zookeeper上的注册路径），当有 broker 加入集群或退出集群时，这些组件就可以获得通知。 



### 5.2 控制器 

控制器其实就是一个 broker，只不过它除了具有一般 broker的功能之外，还负责分区首领的选举。



### 5.3 复制

每个主题被分为若干个分区，每个分区有多个副本。那些副本被保存在 broker 上，每个 broker 可以保存成百上千个属于不同主题和分区的副本。副本有以下两种类型 ：

- 首领副本
  每个分区都有一个首领副本 。 为了保证一致性，所有生产者请求和消费者请求都会经过这个副本。
- 跟随者副本
  首领以外的副本都是跟随者副本。跟随者副本不处理来自客户端的请求，它们唯一的任务就是从首领那里复制消息，保持与首领一致的状态。如果首领发生崩渍，其中的一个跟随者会被提升为新首领。 



### 5.5 文件管理

因为在一个大文件里查找和删除消息是很费时的，也很容易出错，所以我们把分区分成若干个片段 。 默认情况下，每个片段包含 1GB 或一周的数据，以较小的那个为准。在 broker往分区写入数据时，如果达到片段上限，就关闭当前文件，井打开一个新文件。 当前正在写入数据的片段叫作活跃片段 活动片段永远不会被删除。



## 第六章 可靠的数据传递

### 6.2 复制

每个分区可以有多个副本，其中一个副本是首领**。所有的事件都直接发送给首领副本，或者直接从首领副本读取事件**。其他副本只需要与首领保持同步，并及时复制最新的事件。当首领副本不可用时，其中一个同步副本将成为新首领。 

对于跟随者副本来说，它需要满足以下条件才能被认为是同步的：

- 与 Zookeeper 之间有 一 个活跃的会话，也就是说，它在过去的6s(可配置)内向Zookeeper 发送过心跳。
- 在过去的 10s 内（可配置）从首领那里获取过消息。
- 在过去的 10s 内从首领那里获取过最新的消息。光从首领那里获取消息是不够的，它还必须是儿乎零延迟的。 



### 6.3 broker 配置

#### 6.3.1 复制系数

主题级别的配置参数是**replication.factor**,而在broker级别则可以通过**default.replication.factor** 来配置自动创建的主题。我们假设主题的复制系数是3，也就是说分区总共会被3个不同的broker复制3次。



#### 6.3.2 不完全的首领选举

**unclean.leader.election** 只能在broker 级别（实际上是在集群范围内）进行配置，它的默认值是true。**如果首领在不可用时其他副本都是不同步的，如果该值为true,则代表允许运行不同步的副本成为首领，这就是不完全的首领选举**。我们将面临丢失消息的风险。如果这个值为false,则需要等待原先的首领重新上线，从而降低了可用性。



#### 6.3.3 最少同步副本

在主题级别和broker级别上，这个参数都叫**min.insync.replicas**，用于确保已提交的数据至少要写入多少个副本。



## 第九章 管理kafka

这一章主要讲解kafka的命令行操作，可以参考官方文档[[6. Operations](http://kafka.apache.org/documentation/#operations)](http://kafka.apache.org/documentation/#operations)



