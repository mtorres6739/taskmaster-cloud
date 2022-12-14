# taskmaster

TaskMaster is a simple android app that allows you to manage your tasks.

## Features

- Add tasks
- Add/save username
- View all tasks
- View task details
- View task status
- View task difficulty
- Save tasks to a database

## Change Log

## 1.0.10

- Added analytics to the project
- Added a `AnalyticsActivity` class

### 1.0.9

- Added google location services to the project
- Added a `LocationActivity` class
- Updated AAB file to a signed AAB file

### 1.0.8

- Added aab file to the project

### 1.0.7

- Added S3 to the project
- Added a `FileUploadActivity` class for images
- Added sign out functionality to the settings page

### 1.0.6

- Added AWS COGNITO to the project
- Sign in and Sign up buttons to the Main Activity screen
- Added a `SignInActivity` class
- Added a `SignUpActivity` class
- Added a `VerifySignUpActivity` class


### 1.0.5

- Added a SuperTeam Model class
  - Tasks can be assigned to a Team member
- Updated Add Task screen to allow user to select a Team member
- Setttings screen now allows user to select a Team member
- Main Activity recycler view now shows tasks filtered by Team member name that gets selected in settings page

### 1.0.4

- Removed room database from the project
- Added a DynamoDB database to the project
- Inegrated AWS Amplify into the project
- Updated the Task Model class to use the DynamoDB database
- Added TaskList schema to the project


### 1.0.3

- Added a difficulty text edit field to the Add Task screen
- Added a status spinner to the Add Task screen
- Added a Rooms database to the project
- Added a Dao interface to the project
- Refactored the Task Model class to use the Room database
- Refactored the Task Adapter class to use the Room database
- Refactored the Task Fragment class to use the Room database
- Refactored the Recycler View in the Home Screen to use the Room database
- Refactored the Task Detail Screen to use the Room database and render the task data from the database

### 1.0.2

- Added a TaskList Model class
- Added a TaskList Adapter class
- Added a TaskList Fragment class
- Added a TaskList Recycler View to the Home Screen


### 1.0.1

- Added Task Detail Screen
- Added a Settings Page to enter/save a username
- Home screen modified to show username entered from settings page to show at the top of the screen above the task buttons
- Task buttons hard coded to redirect to the task detail screen and show the task name at the top of the screen

### 1.0.0

- Added Home Screen
- Added Add Task Screen
- Added All Tasks Screen
- Added back button to all screens
- Added Snackbar to add task screen button

## Screenshots

Main Activity Screen
![Main Activity Screen](/readme-images/lab-26/MainActivityScreen3.png)

Add Task Activity Screen
![Add Task Activity Screen](/readme-images/lab-26/AddTaskActivityScreen.png)

All Tasks Activity Screen
![All Tasks Activity Screen](/readme-images/lab-26/AllTasksActivityScreen.png)

Settings Activity Screen
![Settings Activity Screen](/readme-images/lab-26/SettingsScreen.png)

Task Detail Activity Screen
![Task Detail Activity Screen](/readme-images/lab-26/TaskDetailScreen2.png)

#### Resources

- [Youtube: How to Add SnackBar](https://www.youtube.com/watch?v=R8HpNqha_VU)
- [Android Docs: Add Snackbar](https://developer.android.com/develop/ui/views/notifications/snackbar/showing)
- [Youtube: Image not showing resolved](https://www.youtube.com/watch?v=PKjjmhUCITo)
