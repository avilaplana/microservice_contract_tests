FROM java:openjdk-8-jdk


ADD target/universal/customer-1.0-SNAPSHOT.zip /root/
WORKDIR /root
RUN unzip customer-1.0-SNAPSHOT.zip 
RUN rm customer-1.0-SNAPSHOT.zip

ADD run.sh /root/run.sh

CMD ["/bin/bash","/root/run.sh"]