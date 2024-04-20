# WIP Platform Backend

## Prerequisites

Ensure that Docker and Java 21 are installed on your system.

## Setup

Clone repository (open with Intelij for development).

Start container that launches database in your local environment using `run_db.sh` for Linux/MacOS or `run_db.bat` for Windows.

Launch the entire project by executing `run_project.sh` for Linux/MacOS or `run_project.bat` for Windows.

## General rules

When writing code we follow the SOLID principles and try to keep the code clean.

More on SOLID: https://wearecommunity.io/communities/epam-poland/articles/1190

More on how to keep the code clean: https://gist.github.com/wojteklu/73c6914cc446146b8b533c0988cf8d29

**Follow the UML diagrams from Miro, in case of missing features contact people in charge of the project/backend.**

## Project Structure

We use the following project structure

![image](https://github.com/WIP-Work-In-Progress/wip-platform-be/assets/116646363/5010d8c3-0528-426f-9166-057902cb251a)


## Contributing
	
If you want to contribute, we require that you abide by the following conventions:

### Use English

Our codebase, branch names and commit messages are written in English exclusively.

### Branch naming

Branch names should follow this convention:<br><br>
**feature|fix|refactor/<*clickup task id*>-<*short description*>**

<details>
<summary>View branch name example</summary>

`feature/86bwy155h-email-password-authorization`
</details>

*(you don't have to create seperate branch for each subtask, use parent task id)*

### Writing commit message

Commit messages should follow this convention:<br><br>
**feature|feat|fix|refactor(<*clickup task id*>): <*short description*>**


<details>
<summary>View commit message example</summary>

`feature(86bwy155h): create and implement login handling`
</details>

### Git flow

- We contribute our changes by opening pull requests from the feature|fix|refactor branch (one branch per feature|fix|refactor) onto the dev branch
- Pull requests require approval from at least one other contributor
- The preferred way of merging approved pull requests is to use the fast-forward merge method

## Some recomendations 

- [Getting Started with Spring Boot](https://spring.io/guides/gs/rest-service)
- [Dan Vega Youtube Channel](https://www.youtube.com/@DanVega)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- Oracle Certified Professional Java® (Book)
- Head First Java (Book)
