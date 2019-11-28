#!/bin/bash
cd code-arena-api
mvn clean install
cd ../code-arena-api-gateway
mvn clean install
cd ../code-arena-oauth2-server
mvn clean install