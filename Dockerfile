FROM jenkins/jenkins:2.193-alpine
MAINTAINER Dmitry Shcherbakov

ENV CASC_JENKINS_CONFIG /usr/share/jenkins/jenkins.yaml

USER root
RUN apk update && \
    apk add python \
    py-pip && \
    pip install jenkins-job-builder==2.10.0 && \
    chown -R 1000:1000 /usr/share/jenkins/

USER jenkins

COPY jenkins.yaml /usr/share/jenkins/jenkins.yaml
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt; exit 0