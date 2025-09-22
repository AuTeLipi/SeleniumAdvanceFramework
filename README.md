# 🚀 Selenium Automation Framework (with Java)
### Author - Dubbaka Lipi Goud

A Production-Ready Selenium framework in Java that pairs TestNG and Maven with the Page Object Model to keep UI tests scalable and maintainable. It supports safe parallel execution via ThreadLocal WebDriver, produces rich Allure reports, and logs with Log4j2 while SonarLint improves code quality. Configuration is cleanly managed through properties, with Excel‑driven DataProviders enabling data‑driven testing across environments. Tests can run locally or on a Selenoid Docker Grid for fast, distributed, cross‑browser execution.

### ✅ Selenium Framework Highlights:
- 💻 **Java + Selenium + TestNG** for cross-browser web automation
- 📦 **Maven** for build management and dependency control
- 🧪 **AssertJ** for fluent, readable assertions
- 🧩 **Page Object Model (POM)** for scalable test design
- 🔒 **Thread Local Support** → Thread Safety → ThreadLocal WebDriver for safe parallel execution
- 📊 **Allure Reports** for rich, visual test reporting
- 📁 **Excel Sheet** for Test Data → Data Provider for Data-Driven Testing (DDT)
- ⚙️ **Properties File** to manage credentials & environment configs
- 🔁 **TestNG Annotations:** @Test, @BeforeMethod, @AfterMethod
- ☁️ **Selenoid Docker Grid** for distributed cloud test execution
- 📈 **SonarLint** for code quality and static analysis
- ☕ Built with **Java 8+** compatibility
- 🏃‍♂️ Run tests locally or on remote cloud grid **(Selenoid)**

<img width="1024" alt="Screenshot 2023-10-31 at 12 27 14 PM" src="https://github.com/PramodDutta/AdvanceSeleniumFrameworkTTA/assets/1409610/02b0ef3b-1165-46cf-8c9d-89e41b17032f">

`mvn test -Dsurefire.suiteXmlFiles=testng.xml`

<img width="1215" alt="Screenshot 2023-10-31 at 12 27 28 PM" src="https://github.com/PramodDutta/AdvanceSeleniumFrameworkTTA/assets/1409610/b0905741-d88d-4559-93c2-65433e668170">


### ✅ Project Structure
<pre> SeleniumAutomationFramework/
├── 📁 src/
│   ├── 📁 main/
│   │   └── 📁 java/com/automation/framework/
│   │       ├── 📁 base/              # Test setup + teardown
│   │       │   └── BaseTest.java
│   │       ├── 📁 driver/            # Driver manager (ThreadLocal)
│   │       │   ├── DriverFactory.java
│   │       │   └── DriverManagerTL.java
│   │       ├── 📁 pages/             # Page Object Model classes
│   │       │   ├── LoginPage.java
│   │       │   └── DashboardPage.java
│   │       ├── 📁 utils/             # Helpers for waits, props, Excel
│   │       │   ├── WaitUtils.java
│   │       │   ├── ExcelUtils.java
│   │       │   └── ConfigReader.java
│   │       └── 📁 constants/         # Static final config values
│   │           └── FrameworkConstants.java
│   ├── 📁 resources/
│   │   ├── config.properties         # username, password, url, etc.
│   │   ├── TestData.xlsx             # Excel sheet for data provider
│   │   └── log4j2.xml                # Logging config
│
├── 📁 test/
│   └── 📁 java/com/automation/tests/
│       ├── LoginTests.java
│       ├── RetryAnalyzer.java
│       ├── ScreenshotListener.java
│       └── TestDataProvider.java
│
├── testng.xml                        # Test suite configuration
├── pom.xml                           # Maven config with Allure, Selenium, etc.
└── README.md                         # Project documentation
</pre>

### ✅ Seleniod - Docker Grid Running
- Selenoid is a powerful tool for running Selenium tests in Docker containers.
- which can help you manage and scale your test automation infrastructure more efficiently.

![Screenshot 2024-06-13 at 15 56 21](https://github.com/PramodDutta/ATB5xWebAutomationFramework/assets/1409610/3c957a88-8cf5-4e3c-9134-9fd41fd41d9b)

### 📌 Notes
- All configs are in config.properties
- Test data is read from TestData.xlsx
- Reports auto-generated using Allure

---

✨ “A **Hybrid Framework** is not just a blend of techniques — it’s the art of bringing together the best of **Data-Driven, Keyword-Driven, and Modular** approaches into one powerful engine, ensuring automation is as **scalable, maintainable, and future-ready** as the applications it tests.” 🚀

---
