#!/bin/bash
cd code-arena-api
mvn clean install
cd ../code-arena-api-gateway
mvn clean install
cd ../code-arena-auth-server
mvn clean install