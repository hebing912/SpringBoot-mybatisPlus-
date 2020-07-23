# 新疆电网后端

#### 项目介绍
新疆电网后台源代码

#### [API接口查看地址(Swagger地址)](http://localhost:8077/swagger-ui.html)

#### 部署

1.将target文件夹里的压缩文件，解压到服务器某个目录下，比如/opt下
2.修改启动代理文件agent.sh：
- 1.修改JAVA_HOME为指定的jdk路径  
- 2.修改启动参数JAVA_OPTS中配置文件路径等配置信息  

#### 启动
```bash
./agent.sh start
```
#### 关闭
```bash
./agent.sh stop
```
#### 重启
```bash
./agent.sh restart
```
#### 远程调试
此模式下，需要服务器防火墙打开5005端口，同时本地IDE连接远程调试
```bash
./agent.sh debug
```