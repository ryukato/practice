#!/bin/bash
export REDIS_CLUSTER_IP=0.0.0.0
docker-compose  -f ./docker-compose-infra-apps.yaml up -d
