# Experiments with Selenium Automation testing.

Demonstrate two ways of initializing Selenium Driver.


1. Using Remote `Standalone Selenium Grid` server running on PCF **io.microsamples.testz.automation.E2EUsingRemoteGridServerTest**.

```bash
cf push seleium-server --docker-image selenium/standalone-chrome:3.13.0-boron
```
Verify that Selenium Grid can be reached at [PWS.](http://seleium-server.cfapps.io/wd/hub)


2. Using `local chormedriver` binary.  **io.microsamples.testz.automation.E2EUsingRemoteGridServerTest**. Driver is platform specific, and for this example,
I am using Mac OS version.  Can be downloaded [here.](https://www.seleniumhq.org/download/)
