# AutomationProjectAugust
Test Automation for EcommerceSite Flax.ro
## Usage
To use this project you will need:
```
1. Jetbrains - IntelliJ IDEA, Java JDK, Apache Maven, TestNG.
2. Create a folder on your computer.
3. Clone with Git Bash
4. In Intellij click File>Open> import project to your workspace.

Tests are grouped in path: /AutomationProjectAugust/src/test/java/flaxTest
```
## About
This project focuses on automating the e-commerce product search process using filter options, followed by adding the selected product to the cart and completing the checkout. Specifically, it will test the functionality of filtering laptops based on specific criteria (category: gaming, display size: 18 inch, CPU: Intel Core i9, color: black), adding the chosen product to the cart, and proceeding through the checkout process, including entering and verifying delivery and billing addresses.

For this Maven Project, I have used:
- Data Driven Testing ( stored Test Data in a JSON format)
- Page Object Models
- Java OOP Concepts like Inheritence & Encapsulation
- Used Access Control (Private & Protected)
- Used log4j2 to document each action
- Used Java library Lombok to minimize/remove the boilerplate code
- Added Surefire plugin
- CI/CD pipeline
