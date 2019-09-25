# jenkins-as-code

An example of how you can manage your Jenkins without a web interface

## How run?
Use docker-compose

`docker-compose up`

**OR**

1. Build docker image

`docker build -t jenkins-as-code .`

2. Run container

`docker run --name jenkins -p 8080:8080 jenkins-as-code`