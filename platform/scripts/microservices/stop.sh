#!/bin/sh
set -eu

ROOT=$(cd "$(dirname "$0")/../.." && pwd)

stop_service() {
  SERVICE_NAME=$1
  PID_FILE="$ROOT/scripts/microservices/${SERVICE_NAME}.pid"

  if [ ! -f "$PID_FILE" ]; then
    return 0
  fi

  PID=$(cat "$PID_FILE")

  if kill -0 "$PID" 2>/dev/null; then
    kill "$PID"
  fi

  rm -f "$PID_FILE"
}

stop_service org
stop_service license
