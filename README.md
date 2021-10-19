# Shailendra_Nain_p1
# Tution Reimbursement
Project Description
TRMS, or Tuition Reimbursement Management System is a full-stack web application that allows employees to submit requests for reimbursements for courses, events, and certifications. These requests can then be approved or rejected by the employee's direct supervisor, department head, and a benefits coordinator while the employee is able to track the status of their requests.

## Technologies Used
- Java 
- Maven 
- PostgreSQL 
- Hibernate 
- Servlet
- Log4j 
- AWS RDS
- HTML/CSS
- Javascript

## Features
List of implemented features:
- Each employee is allowed to claim up to $1000 in tuition reimbursement. Event types have different standard reimbursement coverage: University Courses 80%, Seminars 60%, Certification Preparation Classes 75%, Certification 100%, Technical Training 90%, Other 30%. After a Benefits Coordinator (BenCo) has approved a reimbursement, the reimbursement is pending until a passing grade or presentation over the event is provided. The monetary amount available for an employee to reimburse is defined by the following equation: AvailableReimbursement = TotalReimbursement ($1000) – PendingReimbursements – AwardedReimbursements. If the projected reimbursement for an event exceeds the available reimbursement amount, it is adjusted to the amount available.
- Employee can submit a form to request reimbursement for an event's tuition.
- Supervisor, Manager & Benefit Coordinator can approve or reject employee application.

## Getting Started
To clone the project: git clone https://github.com/210823-java-msa-wvu/Shailendra_Nain_p1

Then to run the Java program, use SmartTomcat configuration, then go to http://localhost:8080/home/static/index.html to begin.
