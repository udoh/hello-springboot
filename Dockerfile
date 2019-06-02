FROM busybox:latest
ADD hello-world-0.0.1.war ROOT.war
CMD "tail" "-f" "/dev/null"