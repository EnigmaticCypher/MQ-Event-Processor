# MQ Event Processing
## Introduction
This project was originally conceived over a year ago, when I found that there weren't any free tools available
outside of the amqsevt sample that could take PCF event messages and convert them into JSON. amqsevt has several
issues that make it less likable, the biggest one being the manual JSON handling rather than the use of a proper
library such as json-c. Conversations with IBM about creating a supported PCF to JSON converter within the product
were not fruitful, they basically told me to make one myself. So here it is.

I have ported the code from amqsevt into Java in this project, and modified its functionality to use the well known
Java json library json.org. Support for getting messages under syncpoint is also lacking in amqsevt, which has been
resolved here. Normally event messages are non-persistent, but some organisations mandate that for security reasons,
all event data must be kept. In some cases, these organisations also have a legal obligation to keep this data, and
as such, it is critical that data integrity measures are used to ensure data safety.

## Project Status
Presently this project is in BETA. No guarantees are made about functionality or safety. It is **NOT** recommended
to run this in production until a stable 1.0 release occurs. The debug flag is currently hard coded to true. If set
to false, the app will run in an infinite loop and will not close handles to resources correctly when terminated.
(Graceful handling of SIGTERM is a work in progress)

## Design Goals
### Primary Goal - Flexibility of JSON Consumption
The main goal of this project is to make processing event data from IBM MQ as simple as possible. For this reason,
the application puts the JSON data back onto a queue (which will be configurable with regard to its location). This
is useful because it means organisations using this software have options around how they want to consume the JSON.
You could write a basic Python application leveraging PyMQI, you could use IBM's messaging REST API (since the JSON
is sent as an MQSTR message), or you could write something in Java, etc. The options are open.

### Secondary Goal - Scalability
One of the biggest issues in large enterprise is often scalability. Some organisations that use IBM MQ quite often
have large numbers of legacy systems that cause headaches in this area. Thankfully, event processing as a concept
is an embarrassingly parallel problem, and performance in relation to message consumption can be drastically
increased with a larger number of clients. If a single instance of this app is not capable of handling your event
workloads, run it in containers and spin up as many instances as you need in Docker, OpenShift, Kubernetes, whichever
flavour you prefer.
