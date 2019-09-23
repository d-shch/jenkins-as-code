# jenkins-as-code

An example of how you can manage your Jenkins without a web interface

docker build -t jenkins-as-code .
docker run -it --name jenkins -p 8080:8080 jenkins-as-code