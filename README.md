# Assignment-RestAPI
# Docker
 
Docker is a set of platform as a service (PaaS) products that uses OS-level virtualization to deliver software in packages called containers.

## Installation

Install Docker or Docker toolbox on your system.

## Port defined

 The port used in this project is 8080. So, kill or stop any application that is already running on the port number 8080.

## Steps

 1. Open cmd/terminal.
 2. cd to the root directory
 3. Use this command to build : "docker build -t "tag_name" -f target/Dockerfile . " 
 4. Use this command to run it : "docker run -p 8080:8080 "tag_name" "

