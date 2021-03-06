ZigBee API for Java
===================

ZigBee API for Java is a fork of ZB4OSGI for usage without OSGI. Changes include removal of OSGI related dependencies
and refactored API.

ZB4OSGI: http://zb4osgi.aaloa.org/

Questions can be sent to the following email address: 'tommi.s.e.laukkanen@gmail.com'.

Hardware
--------

This library provides API to ZigBee network through CC2531 dongle.

Example hardware that can be controlled with zigbee4java:

1. Philips Hue Bulb

Prerequisites
-------------

1. Java 7
2. Maven 3
3. CC2531 dongle with USB serial / coordinator firmware. Flashing new firmware requires CCDEBUGGER hardware component.

Buying Hardware
---------------

You need to buy the following items:

1. http://www.ti.com/tool/cc2531emk
2. http://www.ti.com/tool/cc-debugger

Flashing Dongle
---------------

You need to execute the steps as described in this guide provided by ZB4OSGI project:

* http://zb4osgi.aaloa.org/redmine/attachments/download/42/CC2531_Dongle_Firmware_compilation_guide.docx

Maven Repository
----------------

Serial-comm and zigbee4java dependencies can be found from the following repository for convenience.

```
<repositories>
    <repository>
        <id>tlaukkan-cloudbees-release</id>
        <url>http://repository-tlaukkan.forge.cloudbees.com/release/</url>
    </repository>
</repositories>
```

Using Maven Dependency
----------------------

```
<dependencies>
    <dependency>
        <groupId>org.bubblecloud.zigbee4java</groupId>
        <artifactId>zigbee-api</artifactId>
        <version>1.0.6</version>
    </dependency>
</dependencies>
```

Building from Sources
---------------------

```
git clone https://github.com/tlaukkan/zigbee4java.git zigbee4java
cd zigbee4java
mvn clean install
```

Usage
-----

```
ZigBeeApi zigbeeApi = new ZigBeeApi("/dev/ttyACM0", 4951, 11, false);
zigbeeApi.startup();

Device lamp = zigbeeApi.getZigBeeApiContext().getDevice("00:17:88:01:00:BE:51:EC/11");

Basic basic = lamp.getCluster(Basic);
String manufactureName = basic.getManufacturerName();

OnOff onOff = lamp.getCluster(OnOff.class);
onOff.on();

int onOffAttributeIndex = 0;
Reporter reporter = onOff.getAttribute(onOffAttributeIndex).getReporter();
reporter.addReportListener(reportListener);
```

Examples
--------

1. ZigBeeConsole.java
