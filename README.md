REtmall-mp-backend


将以前的JPA+thymeleaf项目重构成mybatis-plus+vue-cli

TODO:shiro控制权限,redis进行缓存,elasticsearch进行百万级数据秒级搜索

以及docker or docker compose部署

同时，这也是自己整合的后端模板的第二次运用开发效率upupup!

2020.08.09 第一代仓库已删

后续开发将基于此版本..

docker 运行:

docker rm tmallers -f

docker rmi liqiqiorz/tmaller

docker run --name tmallers -d -p 8002:8002 liqiqiorz/tmaller:latest

API:http://112.126.78.122:8004(我的8002在另一个项目所以映射8004)

08.14:更新:emm发现了一件沙雕的事,我没有把数据库参数变成可变参数,类似与{},所以你们下载的镜像

所用的数据会直接和我服务器上的进行同步...

貌似要改改dockerFile 的ENTRYPOINT命令参数...

暂时鸽几天吧...

话说看我的dockerhub关于这个镜像已经有300+的download了

这让萌新是没想到的...

该项目可视化页面目前只有swagger文档.



