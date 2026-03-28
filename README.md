🚀 Selenium Automation Framework (Java + TestNG)

📌 Overview

This project is a test automation framework built using Java, Selenium WebDriver, and TestNG.
It follows Page Object Model (POM) design pattern and supports data-driven testing, reusable utilities, and CI/CD integration.

🧰 Tech Stack
•	Java
•	Selenium WebDriver
•	TestNG
•	Maven
•	Git
•	Jenkins (CI/CD)
•	RestAssured (API Testing - optional)

src
├── main
│    └── java
│         ├── pages        # Page classes (POM)
│         ├── utils        # Reusable utilities
│         └── config       # Config files
│
├── test
│    └── java
│         ├── tests        # Test classes
│         └── base         # Base test setup
│
├── resources
│    ├── testdata         # Excel/JSON test data
│    └── config.properties
│
└── testng.xml            # TestNG suite file

⚙️ Setup Instructions

1️⃣ Prerequisites
•	Java (JDK 8 or higher)
•	Maven installed
•	IDE (IntelliJ / Eclipse)

2️⃣ Clone Repository
git clone https://github.com/your-repo-name.git
cd your-repo-name

3️⃣ Install Dependencies
mvn clean install

▶️ Running Tests

Run All Tests
mvn test

Run Specific TestNG Suite
mvn test -DsuiteXmlFile=testng.xml

🧪 Framework Features

✔ Page Object Model (POM)
✔ Data-driven testing (Excel/JSON)
✔ Cross-browser testing
✔ Reusable utilities (Waits, Config, File handling)
✔ Screenshot capture on failure
✔ Logging & reporting (Extent Reports optional)
✔ CI/CD integration with Jenkins

🔄 CI/CD Integration
•	Jenkins pipeline triggers test execution on code changes
•	Generates reports after execution
•	Supports scheduled runs (nightly regression)

📊 Reporting
•	TestNG Reports
•	Extent Reports (if configured)

🔐 Configuration

Update config.properties file:
browser=chrome
url=https://example.com
timeout=10

📌 Best Practices
•	Use explicit waits
•	Follow POM structure
•	Keep test data separate
•	Write reusable methods
•	Maintain clean code

