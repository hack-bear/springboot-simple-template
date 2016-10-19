#!/bin/bash

export JAVA_HOME=/opt/jdk8
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$PATH:$JAVA_HOME/bin


deployDir=$(cd "$(dirname "$0")"; cd ..; pwd)
echo deployDir $deployDir

echo JAVA_HOME:$JAVA_HOME
echo CLASSPATH:$CLASSPATH
echo PATH:$PATH

echo aries services are starting...


cd $deployDir

########### beign服务启动了吗(避免重复启动)
PIDS=$( ps -f | grep java | grep "$deployDir" |awk '{print $2}' )
if [ -n "$PIDS" ]; then
    echo "ERROR: The $deployDir already have server started!"
    echo "PID: $PIDS"
    exit 1
fi
###########end

####jvm参数设置
JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "

JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xrunjdwp:transport=dt_socket,address=7850,server=y,suspend=y  "
fi

 

JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx512m  -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled   -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
    JAVA_MEM_OPTS=" -server -Xms512m -Xmx512m   -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi

######
#-Dspring.profiles.active=prod/dev/test

JAVA_JMX="-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=7849 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"

if [ "$1" = "debug" ]; then
    java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS    -Dloader.path=$deployDir/config,$deployDir/lib -jar $deployDir/lib/mycustommodule-*.jar

elif [ "$1" = "b" ];then
    nohup java $JAVA_OPTS $JAVA_MEM_OPTS    -Dloader.path=$deployDir/config,$deployDir/lib -jar $deployDir/lib/mycustommodule-*.jar  > stdout.xml.log 2>&1 &

elif [ "$1" = "jmx" ];then
    nohup java  $JAVA_JMX $JAVA_OPTS $JAVA_MEM_OPTS    -Dloader.path=$deployDir/config,$deployDir/lib -jar $deployDir/lib/mycustommodule-*.jar  > stdout.xml.log 2>&1 &

else
    exec java $JAVA_OPTS $JAVA_MEM_OPTS    -Dloader.path=$deployDir/config,$deployDir/lib -jar $deployDir/lib/mycustommodule-*.jar
fi


echo $! > bin/service.pid
