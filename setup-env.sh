#!/bin/sh

TOMCAT_WEBAPP_DIR="$(readlink -f apache-tomcat-11.0.5/webapps)"
export TOMCAT_WEBAPP_DIR

alias gd="gradle deploy --no-configuration-cache"
