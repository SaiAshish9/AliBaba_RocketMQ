```
RocketMQ is a cloud-native "messaging, eventing, streaming" real-time data processing platform,
covering cloud-edge-device collaboration scenarios

Reason It Has much following because its developed by Ali Baba.

People on AliBaba work on their own JDK.

Apache RocketMQ is used at scale and one of the biggest features of that time. Its vulnerable, reusable, well documented and has a nice spring boot
integration.
```

<img width="1318" alt="Screenshot 2023-03-05 at 1 53 57 AM" src="https://user-images.githubusercontent.com/43849911/222927157-5241787e-02e2-4380-9207-3f519a1f7e09.png">

https://rocketmq.apache.org/docs/quickStart/01quickstart

```
$ unzip rocketmq-all-5.1.0-source-release.zip
$ cd rocketmq-all-5.1.0/
$ mvn -Prelease-all -DskipTests -Dspotbugs.skip=true clean install -U
$ cd distribution/target/rocketmq-5.1.0/rocketmq-5.1.0
```
