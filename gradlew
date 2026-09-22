#!/usr/bin/env sh
DIRNAME=$(dirname "$0")
PROGNAME=$(basename "$0")
APP_BASE_NAME=$(basename "$0")
# Запуск через gradle из системы, если нет обертки
gradle "$@"
