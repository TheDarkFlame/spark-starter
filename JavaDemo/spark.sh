#!/bin/bash
reset
spark-submit \
--class com.parker.david.Main \
--master localhost[*] \
--deploy-mode client \
/home/david/IdeaProjects/DemoProject/JavaDemo/target/JavaDemo-1.0.0.jar