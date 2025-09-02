# Demo Web Shop Automation

This project contains **end-to-end automation test cases** for the [Demo Web Shop](https://demowebshop.tricentis.com/) application.  It validates core e-commerce workflows such as **login, browse an item, add to cart, verify the price calculation, checkout, validate order histry and logout** using Selenium and BDD Cucumber.

---

## 🎯 Objectives
- Automate key functional test cases of Demo Web Shop
- Ensure reliability of major e-commerce flows
- Apply **Page Object Model (POM)** for maintainable test scripts
- Generate detailed execution reports

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** BDD - Cucumber 7  
- **Build Tool:** Maven  
- **Reporting:** Cucumber Reports  
- **Version Control:** Git  

---

## 📂 Project Structure
- **Project_DemoWebShop/**
  - **src/main/java/**
      - **com/example/pages/** → POM classes
  - **src/test/java/**    - 
    - **com/example/stepDefinition/** → Step definitions for Cucumber feature files  
    - **com/example/Test_Runner/** → Test runner class (Cucumber execution entry point)
    - **com/example/Utils/** → Utility classes (config reader and writer, Screenshot helper and Driver manager)  
  - **src/test/resources/**
    - **features/** → Cucumber feature files containing test scenarios and steps  
    - **config.properties** → Input/Environment configuration settings  
  - **pom.xml** → Maven build configuration with dependencies  
  - **target/** → Generated test reports after execution
    - **target/Screenshots/** → screenshots of failed test cases  
    
 ---
  
## ⚡ Getting Started
### Prerequisites
- Install **Java 11+**
- Install **Maven**
- Install **Chrome browser** 
- IDE (Eclipse/IntelliJ) and **Cucumber plugin**
### 🚀 How to Run
- Clone the repo - git clone https://github.com/Dhana-QAAnalyst/Selenium-Scripts/Project_DemoWebShop.git
- Import as a Maven project in your IDE
- [optional] Update the feature file input to test it with different test data
- Run the test scripts from Runner.java

  ---

## Note
- Login, Place order, Validate purchased order and Log out are the scripts in my test suite.
- Runner.java is configured to run the complete suite.
- **io.github.bonigarcia:webdrivermanager** dependency is added to pom.xml so it will automatically download the driver    binaries at runtime.
- The script automatically captures the screenshots of failed test cases.
    
  ---
  
### 👩‍💻 Author
**Dhanalakshmi Krishnan**  
🔗 [LinkedIn](https://www.linkedin.com/in/dhanalakshmi-krishnan/) | 📧 dhanalakshmi.k.work@gmail.com
