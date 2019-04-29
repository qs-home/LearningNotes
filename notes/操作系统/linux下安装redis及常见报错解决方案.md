### 安装redis

1. $ wget http://download.redis.io/releases/redis-3.0.7.tar.gz
2. $ tar xzf redis-3.0.7.tar.gz
3. $ ln -s redis-3.0.7 redis
4. $ cd redis
5. $ make
6. $ make install 

安装常见错误及解决方案：

1. cc 未找到名称报错  解决方案：**yum -y install gcc automake autoconf libtool make**
2. 致命错误：jemalloc/jemalloc.h：没有那个文件或目录 解决方案：**make MALLOC=libc**




