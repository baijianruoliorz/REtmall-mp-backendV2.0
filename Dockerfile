FROM java:8
#把jar包靠上去,命名为app.jar
COPY *.jar /app.jar

CMD ["-----server.port=8001"]
#暴露你的端口
EXPOSE 8002

VOLUME /tmp
#执行jar命令,启动app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","jar","/app.jar"]
#部署到docker时,只需传Dockerfile和jar即可

