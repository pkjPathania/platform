#!/bin/sh
set -eu

ROOT=$(cd "$(dirname "$0")/../.." && pwd)

start_service() {
  SERVICE_NAME=$1
  POM_PATH=$2
  MAIN_CLASS=$3
  PID_FILE="$ROOT/scripts/microservices/${SERVICE_NAME}.pid"
  LOG_FILE="$ROOT/scripts/microservices/${SERVICE_NAME}.log"

  if [ -f "$PID_FILE" ] && kill -0 "$(cat "$PID_FILE")" 2>/dev/null; then
    return 0
  fi

  cd "$ROOT"

  nohup ./mvnw -q -f "$POM_PATH" -Dspring-boot.run.main-class="$MAIN_CLASS" spring-boot:run > "$LOG_FILE" 2>&1 &
  echo $! > "$PID_FILE"
}

start_service org microservices/org/pom.xml com.pankaj.platform.org.OrgApplication
start_service license microservices/license/pom.xml com.pankaj.platform.license.LicenseApplication
