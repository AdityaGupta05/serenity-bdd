# serenity-bdd

Web application Testing with serenity framework using Selenium and Java

Project Description It is a behavior driven development (BDD) approach to write automation test script to test Web applications. It enables you to write and execute automated acceptance tests. This automation framework is developed using selenium, Serenity BDD, java and maven, Junit.

Installation Pre-requisite You need to have following softwares installed on your computer

Install JDK 1.8 and set path Install Maven and set path Eclipse Eclipse Plugins: Maven and Serenity BDD Installation In order to start using the project you need to create your own Fork on Github and then clone the project.

![image](https://user-images.githubusercontent.com/15683764/129185173-f118f581-85ba-404d-8865-1345f5ca0bc7.png)


**├───target**

How to run the Tests? mvn clean verify -Dcucumber.options="--tags @ui=addwishlist"

**View test results:**

Go to target\site\serenity folder and open index.html

E.g: 
![image](https://user-images.githubusercontent.com/15683764/129185591-3a1da516-c5cb-4a49-8a26-c58f0c19f65e.png)


**Further Improvements: Tooling improvements:**

1.Grid Solution: Tool that I would highly recommend is Selenoid as a first preference and if not Zalenium as a backup. Seleenoid/Zalenium is limited to the type of browser available, howeever based on business need other paid tools like Saucelabs, Perfecto or browserstack can be integrated

2.Every Application is important to meet the WCAG 2.0, 2.1 standards, so it is important to introduce Accessibility testing into Automation. So I suggest the open source tool name AXE-core from Deque that allows us to scan the application as we need. With this integration , while we run the Functional test Axe can be invoked.

3.Along with UI Functional testing it is good feature to automated GUI tests which again reduces manual dependency and allows us to function more of Exploratory testing. The toold that I was recently working and closly Applitools

4.When we consider shift left approach, it is right that we move the DAST testing(Security testing) within the pipeline , everknown OWASP-ZAP is an amazing predefind tool that helps us to scan while the functional tests are running. Note: When we merge these tools and invoke part of the functional test, this allows us to perform all different phases of testing in one go. No addtional coding needed, No additional maintenance needed also allows us the possible coverages in pipeline


**Technical improvements:**

Json to maintain and manage test datas
To stabilise the reusable instances to avoid performance issue
To further extend the haspmap implementaion done for setContext
Good logger capability across classes
