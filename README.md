REtmall-mp-backend


将以前的JPA+thymeleaf项目重构成mybatis-plus+vue-cli

TODO:shiro控制权限,redis进行缓存,elasticsearch进行百万级数据秒级搜索

以及docker or docker compose部署

同时，这也是自己整合的后端模板的第二次运用开发效率upupup!

2020.08.09 第一代仓库已删

后续开发将基于此版本..

docker 运行:

docker rm tmall -f

docker rmi liqiqiorz/tmaller

docker run --name tmallers -d -p 8002:8002 liqiqiorz/tmaller:latest