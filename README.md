# 🚀 Fake Store API Automation Framework

---

## 📌 Overview

This project is an end-to-end API automation framework designed to simulate a **real-world QA automation environment**.

It integrates **automated testing, CI/CD pipelines, webhook triggers, and detailed reporting**.

---

## 🛠️ Tech Stack

- ✅ Java
- ✅ REST Assured
- ✅ Cucumber (BDD)
- ✅ TestNG
- ✅ Jenkins (CI/CD)
- ✅ Allure Reporting
- ✅ GitHub Webhooks
- ✅ ngrok (local tunnel for webhook exposure)

---

## ✅ Features

### 🔹 API Test Coverage

Full CRUD automation for:

- ✅ Users
- ✅ Carts
- ✅ Products
- ✅ Authentication

---

### 🔹 Test Design

- ✅ Positive & Negative scenarios
- ✅ Scenario Outlines (data-driven testing)
- ✅ Externalized JSON payloads
- ✅ Clean reusable components

---

### 🔹 Architecture

This framework follows a **layered architecture**:
StepDefinitions → Service → Client → API
↓
Utilities

| Layer | Responsibility |
|------|---------------|
| StepDefinitions | Defines BDD steps |
| Service | Business logic |
| Client | API calls + Allure logging |
| Validator | Assertions & validations |
| Utils | Reusable helpers |

---

## 📁 Project Structure


src/test/java
│
├── clients          # Handles API calls + logging
├── services         # Business logic layer
├── validators       # Response validations
├── stepdefinitions  # Cucumber step definitions
├── utils            # AllureUtils, FileUtils
│
src/test/resources
├── payloads         # JSON request bodies
├── features         # Cucumber feature files

---

## ⚙️ CI/CD Pipeline (Jenkins)

This project is fully integrated with Jenkins for **continuous testing**.

---

### ✅ Pipeline Capabilities

- ✅ Runs automatically on Git push
- ✅ Supports scheduled builds
- ✅ Tracks build history
- ✅ Executes Maven tests
- ✅ Publishes Allure reports

---

## 🌐 Webhook Integration with ngrok

Since Jenkins runs locally, **ngrok is used to expose it to GitHub**.

---

### 🔄 Execution Flow



Code Change (Developer)
↓
Git Push to GitHub
↓
GitHub Webhook Trigger
↓
ngrok Tunnel (Public URL → Local Jenkins)
↓
Jenkins Pipeline Starts
↓
Tests Execute (Maven + Cucumber)
↓
Allure Report Generated


---

### ✅ Benefits

- Real-time pipeline triggering
- No polling required
- Mimics enterprise webhook pipelines
- Faster feedback loop

---

## 📊 Allure Reporting

This project integrates **Allure Reports** for rich test analysis.

---

### ✅ What is captured:

- ✅ Request payloads (JSON)
- ✅ Response bodies
- ✅ Status codes
- ✅ Step-by-step execution
- ✅ Test history and trends

---

### 📸 Example Output


✅ Request → JSON payload
✅ Response → API result
✅ Status Code → 200 / 201
✅ Structured test steps

---

## 🚀 Execution Flow (End-to-End)


Push Code → Webhook Trigger → Jenkins Build → Test Execution → Allure Report

---

## ✅ Key Highlights

- 🔥 Real-time CI/CD integration
- 🔥 Webhook-based test triggering
- 🔥 Layered architecture (clean + scalable)
- 🔥 Externalized test data (JSON payloads)
- 🔥 Full request/response visibility
- 🔥 BDD approach for readability

---

## ⚠️ Known Limitations

- FakeStore API does not strictly follow REST standards
    - Example: returns `200` instead of `404`
- Tests are designed to handle these API inconsistencies

---

## 🧠 Design Principles

- ✅ Separation of concerns
- ✅ Reusability
- ✅ Maintainability
- ✅ Scalability
- ✅ Clean code practices

---

## 🔮 Future Improvements

- 🚀 Parallel test execution
- 🚀 Docker containerization
- 🚀 Environment configuration (QA / UAT / PROD)
- 🚀 Automatic notifications (Email / Slack / Teams)
- 🚀 REST Assured filters for auto logging

---

## 📌 Conclusion

This project demonstrates a **production-style API automation framework** that combines:

✔ CI/CD automation  
✔ Real-time test execution  
✔ Clean architecture  
✔ Rich reporting

---

## 👨‍💻 Author

**Nkosingiphile Ncongwane**  
QA Automation Engineer

---

## 📣 Connect With Me

- 💼 LinkedIn: www.linkedin.com/in/nkosingiphile-ncongwane-b9574429a
- 💻 GitHub: https://github.com/Lero19/fake-store-api-automation

---

## ⭐ If you found this useful

Give it a ⭐ and feel free to connect — always open to collaboration and opportunities!