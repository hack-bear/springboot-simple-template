#!/bin/bash

deployDir=$(cd "$(dirname "$0")"; cd ..; pwd)
echo deployDir $deployDir

echo dubbo services are stoping...
echo JAVA_HOME:$JAVA_HOME

cd $deployDir




kill $(cat bin/service.pid )  


########### beign服务关闭了吗(避免kill 失败情况下 $?得不到正确的返回值)

PIDS=$( ps -f | grep java | grep "$deployDir" |awk '{print $2}' )
#if [ -n "$PIDS" ]; then
#    echo "ERROR: The $deployDir server stop failure! and kill -9 stoping server"
#    echo "PID: $PIDS"
#    kill -9 $PIDS
#fi

###########end
