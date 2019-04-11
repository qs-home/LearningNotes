# Zookeeper 基础命令与Java客户端

部分内容参考自课程：[ZooKeeper分布式专题与Dubbo微服务](https://coding.imooc.com/class/201.html#Anchor)⭐️⭐️⭐️⭐️⭐️

## 第一章：ZooKeeper 简介



### 1.1 ZooKeeper简介

**参考**：[[可能是把 ZooKeeper 概念讲的最清楚的一篇文章]](https://github.com/Snailclimb/JavaGuide/blob/master/%E4%B8%BB%E6%B5%81%E6%A1%86%E6%9E%B6/ZooKeeper.md) :star::star::star::star::star:



### 1.2 ZooKeeper安装(单机版)

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

### 1.3 Zookeeper 集群搭建

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


### 1.4 基本命令

```shell
ZooKeeper -server host:port cmd args
stat path [watch]   #stat命令用于查看节点的状态信息
set path data [version]  #set命令用于设置节点的数据
ls path [watch]     #ls命令用于获取路径下的节点信息，注意路径为绝对路径
delquota [-n|-b] path #delquota命令用于删除配额，-n为子节点个数，-b为节点数据长度
ls2 path [watch]    #ls2命令是ls命令的增强版，比ls命令多输出本节点信息
setAcl path acl     #　setAcl命令用于设置节点Acl,Acl由三部分构成：1为scheme，2为user，3为permission，一般情况下表示为scheme:id:permissions
setquota -n|-b val path  #setquota命令用于设置节点个数以及数据长度的配额
history             #history用于列出最近的命令历史，可以和redo配合使用
redo cmdno          #redo命令用于再次执行某个命令
printwatches on|off  #printWatchers命令用于设置和显示监视状态，值为on或则off
delete path [version]  #delete命令用于删除节点，如delete /nodeDelete
sync path           #sync命令用于强制同步，由于请求在半数以上的zk server上生效就表示此请求生效，那么就会有一些zk server上的数据是旧的。sync命令就是强制同步所有的更新操作。
listquota path       #查看指定znode的配额
rmr path             #递归删除
get path [watch]     #get命令用于获取节点的信息，注意节点的路径必须是以/开头的绝对路径。如get /
create [-s] [-e] path data acl   #create命令用于创建节点，其中-s为顺序充点，-e临时节点
addauth scheme auth  #addauth命令用于节点认证，使用方式：如addauth digest username:password
quit                 #退出客户端
getAcl path          #获取节点的Acl，如getAcl /node1
close                #close命令用于关闭与服务端的链接
connect host:port    #连接zk服务端，与close命令配合使用可以连接或者断开zk服务端
```

```shell
[zk: localhost:2181(CONNECTED) 3] create /node1 world
Created /node1
[zk: localhost:2181(CONNECTED) 4] get /node1
world
cZxid = 0x3   #节点创建时的zxid
ctime = Mon Dec 03 10:21:49 CST 2018 # 节点创建时间
mZxid = 0x3   #节点最近一次更新时的zxid
mtime = Mon Dec 03 10:21:49 CST 2018  # 节点最近一次更新的时间
pZxid = 0x3  #子节点的id
cversion = 0  # 子节点数据版本
dataVersion = 0 # 本节点数据版本
aclVersion = 0 # 节点权限版本
ephemeralOwner = 0x0  # 如果该节点为临时节点，值表示与该节点绑定的session,如果不是临时节点，值为0
dataLength = 5  # 节点数据长度
numChildren = 0 # 子节点个数
```



### 1.5 zookeeper 四字命令

| 命令 | 功能描述                                                     |
| ---- | ------------------------------------------------------------ |
| conf | 输出相关服务配置的详细信息。                                 |
| cons | 列出所有连接到服务器的客户端的完全的连接 / 会话的详细信息。包括“接受 / 发送”的包数量、会话 id 、操作延迟、最后的操作执行等等信息。 |
| dump | 列出未经处理的会话和临时节点。                               |
| envi | 输出关于服务环境的详细信息（区别于 conf 命令）。             |
| reqs | 列出未经处理的请求                                           |
| ruok | 测试服务是否处于正确状态。如果确实如此，那么服务返回“imok ”，否则不做任何相应。 |
| stat | 输出关于性能和连接的的列表。                                 |
| wchs | 列出服务器 watch 的详细信息。                                |
| wchc | 通过 session 列出服务器 watch 的详细信息，它的输出是一个与watch 相关的会话的列表。 |
| wchp | 通过路径列出 watch 的详细。它输出一个与 session相关的路径。  |

```shell
# 使用前 需要使用 yum install nc 安装 nc 命令
# 需要注意 执行四字命令 不是在zookeeper客户端命令行环境下执行
[root@heibaiying ~]# echo stat | nc localhost 2181
Zookeeper version: 3.4.9-1757313, built on 08/23/2016 06:50 GMT
Clients:
 /0:0:0:0:0:0:0:1:44712[0](queued=0,recved=1,sent=0)
 /0:0:0:0:0:0:0:1:44662[1](queued=0,recved=176,sent=176)
Latency min/avg/max: 0/0/31
Received: 177
Sent: 176
Connections: 2
Outstanding: 0
Zxid: 0x3
Mode: standalone
Node count: 5

```



## 第二章 Zookeeper Curator 客户端命令

官网：http://curator.apache.org/index.html

**1.maven 依赖**

```xml
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>4.0.0</version>
</dependency>

<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-recipes</artifactId>
    <version>4.0.0</version>
</dependency>

<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.11</version>
</dependency>
```



**2.示例程序**

```java
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;


public class CuratorOperator {

    private static CuratorFramework client;
    private static final String zkServerPath = "192.168.200.228:2181";

    /*
     * 实例化zk客户端
     */
    static {
        /*
         * 同步创建zk示例，原生api是异步的
         *
         * curator链接zookeeper的策略:ExponentialBackoffRetry
         * baseSleepTimeMs：初始sleep的时间
         * maxRetries：最大重试次数
         * maxSleepMs：最大重试时间
         */

        RetryPolicy retryPolicy0 = new ExponentialBackoffRetry(1000, 5);

        /**
         * curator链接zookeeper的策略:RetryNTimes
         * n：重试的次数
         * sleepMsBetweenRetries：每次重试间隔的时间
         */
        RetryPolicy retryPolicy1 = new RetryNTimes(3, 5000);

        /*
         * curator链接zookeeper的策略:RetryOneTime
         * sleepMsBetweenRetry:每次重试间隔的时间
         */
        // RetryPolicy retryPolicy2 = new RetryOneTime(3000);

        /*
         * 永远重试，不推荐使用
         */
        RetryPolicy retryPolicy3 = new RetryForever(2000);

        /*
         * curator链接zookeeper的策略:RetryUntilElapsed
         * maxElapsedTimeMs:最大重试时间
         * sleepMsBetweenRetries:每次重试间隔
         * 重试时间超过maxElapsedTimeMs后，就不再重试
         */
        RetryPolicy retryPolicy4 = new RetryUntilElapsed(2000, 3000);

        client = CuratorFrameworkFactory.builder()
                .connectString(zkServerPath)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy0)
                .namespace("workspace").build();
        client.start();
    }

    /**
     * @Description: 关闭zk客户端连接
     */
    private static void closeZKClient() {
        if (client != null) {
            client.close();
        }
    }

    public static void main(String[] args) {
        try {
            // 实例化
            CuratorFrameworkState state = client.getState();
            System.out.println("当前客户的状态：" + state.name());

            //创建节点并读取节点数据
            String nodePath = "/parent/son";
            byte[] data = "xiaoMing".getBytes();
            client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath(nodePath, data);

            Stat stat = new Stat();
            byte[] resultData = client.getData().storingStatIn(stat).forPath(nodePath);
            System.out.println("节点" + nodePath + "的数据为: " + new String(resultData));
            System.out.println("该节点的版本号为: " + stat.getVersion());

            // 更新节点数据
            byte[] newData = "batman".getBytes();
            client.setData().withVersion(0).forPath(nodePath, newData);

            // 删除节点
            client.delete()
                    .guaranteed()                    // 如果删除失败，那么在后端还是继续会删除，直到成功
                    .deletingChildrenIfNeeded()     // 如果有子节点，就删除
                    .withVersion(0)
                    .forPath(nodePath);


            // 查询子节点
            List<String> childNodes = client.getChildren()
                    .forPath(nodePath);
            System.out.println("开始打印子节点：");
            for (String s : childNodes) {
                System.out.println(s);
            }


            // 判断节点是否存在,如果不存在则为空
            Stat statExist = client.checkExists().forPath(nodePath + "/abc");
            System.out.println(statExist);


            // watcher 事件  当使用usingWatcher的时候，监听只会触发一次，监听完毕后就销毁
            client.getData().usingWatcher(new CuratorWatcher() {
                public void process(WatchedEvent event) throws Exception {
                    System.out.println("触发watcher，节点路径为：" + event.getPath());
                }
            }).forPath(nodePath);

            client.getData().usingWatcher(new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("触发watcher，节点路径为：" + watchedEvent.getPath());
                }
            }).forPath(nodePath);

            // 为节点添加watcher 可以重复触发
            // NodeCache: 监听数据节点的变更，会触发事件
            final NodeCache nodeCache = new NodeCache(client, nodePath);
            // buildInitial : 初始化的时候获取node的值并且缓存
            nodeCache.start(true);
            if (nodeCache.getCurrentData() != null) {
                System.out.println("节点初始化数据为：" + new String(nodeCache.getCurrentData().getData()));
            } else {
                System.out.println("节点初始化数据为空...");
            }
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                public void nodeChanged() throws Exception {
                    if (nodeCache.getCurrentData() == null) {
                        System.out.println("空");
                        return;
                    }
                    String data = new String(nodeCache.getCurrentData().getData());
                    System.out.println("节点路径：" + nodeCache.getCurrentData().getPath() + "数据：" + data);
                }
            });


            // 为子节点添加watcher
            // PathChildrenCache: 监听数据节点的增删改，会触发事件
            // cacheData: 设置缓存节点的数据状态
            final PathChildrenCache childrenCache = new PathChildrenCache(client, nodePath, true);

            /*
             * StartMode: 初始化方式
             * POST_INITIALIZED_EVENT：异步初始化，初始化之后会触发事件
             * NORMAL：异步初始化
             * BUILD_INITIAL_CACHE：同步初始化
             */
            childrenCache.start(StartMode.POST_INITIALIZED_EVENT);

            List<ChildData> childDataList = childrenCache.getCurrentData();
            System.out.println("当前数据节点的子节点数据列表：");
            for (ChildData cd : childDataList) {
                String childData = new String(cd.getData());
                System.out.println(childData);
            }

            childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                    if (event.getType().equals(PathChildrenCacheEvent.Type.INITIALIZED)) {
                        System.out.println("子节点初始化ok...");
                    } else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)) {
                        String path = event.getData().getPath();
                        if (path.equals("super")) {
                            System.out.println("添加子节点:" + event.getData().getPath());
                            System.out.println("子节点数据:" + new String(event.getData().getData()));
                        } else if (path.equals("/super/e")) {
                            System.out.println("添加不正确...");
                        }

                    } else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
                        System.out.println("删除子节点:" + event.getData().getPath());
                    } else if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                        System.out.println("修改子节点路径:" + event.getData().getPath());
                        System.out.println("修改子节点数据:" + new String(event.getData().getData()));
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeZKClient();
        }
    }
}

```

**3.权限设置示例**

```java
import java.util.ArrayList;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;


public class CuratorAcl {

    private static CuratorFramework client;
    private static final String zkServerPath = "192.168.200.228:2181";

    static {
        RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
        client = CuratorFrameworkFactory.builder().authorization("digest", "root:123456".getBytes())
                .connectString(zkServerPath)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy)
                .namespace("workspace").build();
        client.start();
    }


    public static void main(String[] args) {
        // 实例化
        try {
            CuratorFrameworkState state = client.getState();
            System.out.println("当前客户的状态：" + state);

            String nodePath = "/acl/father/child/sub";

            List<ACL> acls = new ArrayList<ACL>();
            Id id01 = new Id("digest", DigestAuthenticationProvider.generateDigest("root:123456"));
            Id id02 = new Id("digest", DigestAuthenticationProvider.generateDigest("root:123456"));
            acls.add(new ACL(Perms.ALL, id01));
            acls.add(new ACL(Perms.READ, id02));
            acls.add(new ACL(Perms.DELETE | Perms.CREATE, id02));

            // 创建节点
            byte[] data = "content".getBytes();
            client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .withACL(acls, true)
                    .forPath(nodePath, data);


            client.setACL().withACL(acls).forPath("/curatorNode");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }

    }

}

```

