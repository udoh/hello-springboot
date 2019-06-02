FROM busybox:latest
ADD target/hello-world-0.0.1.war ROOT.war
CMD "tail" "-f" "/dev/null"