#Qase automation framework

![Qase logo](https://dz2cdn1.dzone.com/storage/temp/14330818-qase-logo.png)

> [_Qase_](https://qase.io/) is a cloud test management tool that allows to manage 
> test cases, aggregate reports from both manual and automated 
> test runs, and provide analytics based on historical data.

____

###_Tech stack_
- Java 8
- Maven
- TestNG (v. 7.0.0)
- Selenium Java (v. 4.1.1)
- WebDriverManager (v. 5.0.2)
- REST Assured (v. 4.4.0)
- Gson (v. 2.8.9)
- Lombok (v. 1.18.22)
- Log4j (v. 2.17.1)
- Allure TestNG (v. 2.8.1)
- Jenkins

###_Patters used in the framework_
- Page Object Model
- Page Factory
- Page Element
- Steps Pattern
- Value Object
- Adapter Pattern

###_Automated tests_
| **Module**  |      **Submodule**      | **Description**                                                                                                                                                                                                                                                                                                              | **UI/API** |
|-------------|:-----------------------:|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:----------:|
| _Login_     |                         | - Log in filling in all the required input fields with valid data<br/> - Log in filling in all the required input fields using an invalid email                                                                                                                                                                              |     UI     |
| _Projects_  |                         | - Create a new project filling in all the required input fields<br/> - Delete a project                                                                                                                                                                                                                                      |     UI     |
| _Project_   | _Repository/Test Suite_ | - Create a test suite filling in all the input fields<br/> - Create a test suite filling in only the required input fields                                                                                                                                                                                                   |     UI     |
| _Project_   | _Repository/Test Case_  | - Create a test case filling in all the required fields<br/> - Create a test case filling in the required fields and selecting options from the dropdown<br/> - Create a test case filling in some fields and attaching a file to it<br/> - Create a test case filling in some fields and adding 'Steps to reproduce'        |  UI, API   |
| _Project_   |      _Milestones_       | - Create a milestone filling in the required fields<br/> - Create a milestone filling all the fields                                                                                                                                                                                                                         |     UI     |
| _Project_   |      _Test Plans_       | - Create a test plan filling in all the fields and adding test cases to it<br/>                                                                                                                                                                                                                                              |  UI, API   |
| _Project_   |        _Defects_        | - Create a defect report filling in the required fields<br/> - Create a defect report filling in the required fields and selecting options from the dropdowns<br/> - Create a defect report filling in the required fields and adding the attachment<br/> - Resolve a specific defect<br/> - Update a specific defect status |  UI, API   |
| _Workspace_ |        _Invites_        | - Invite a new member filling in all the fields<br/> - Invite a new member without filling in the required fields<br/> - Invite a new member using an invalid email                                                                                                                                                          |     UI     |
| _Workspace_ |      _Attachments_      | - Upload an attachment                                                                                                                                                                                                                                                                                                       |    API     |
| _Workspace_ |        _Groups_         | - Create a new group filling in all the fields<br/> - Create a new group without filling in the 'Description' field<br/> - Add a member to the created group                                                                                                                                                                 |     UI     |
| _User Menu_ |                         | - Sign out                                                                                                                                                                                                                                                                                                                   |     UI     |







