#!/bin/bash
reset
spark-submit \
--class com.parker.david.Main \
--master localhost[*] \
--deploy-mode client \
/home/david/IdeaProjects/DemoProject/ScalaDemo/target/ScalaDemo-1.0.0.jar