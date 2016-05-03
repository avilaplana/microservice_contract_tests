FROM java:openjdk-8-jdk


ADD target/universal/accountant-1.0-SNAPSHOT.zip /root/
WORKDIR /root
RUN unzip accountant-1.0-SNAPSHOT.zip 
RUN rm accountant-1.0-SNAPSHOT.zip

ADD run.sh /root/run.sh

CMD ["/bin/bash","/root/run.sh"]