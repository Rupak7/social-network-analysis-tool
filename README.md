# Social Media Analysis tool
# Objective
## Problem Statement
- Develop a social media analysis tool that provides functionalities for managing user friendships and analyzing social network metrics. The tool should include the following features:
- Create and remove friendships between users.
- List friends of a specific user.
- Find the shortest path between two users.
- Calculate degree centrality of users.
- Identify communities within the social network.
- Ensure that the code:
- Supports parallel operations, allowing multiple users to interact with the system simultaneously.
- Handles exceptional situations gracefully.
- Includes appropriate unit test cases.
- Clearly states any assumptions made.
## NFRs
- Duration of this exercise is 90 minutes. Please manage your time accordingly,
- Make any necessary assumption, and clearly state the assumptions made.
- Do not seek any help online or through any other source.
## Evaluation Criteria
- **Code Completeness/ Correctness**
- **Code Structure**: Modularity, usage of 00Ps principles and design patterns, size of classes, and functions, n-path
  complexity of functions.
- **Code Quality**: class/function/variable naming conventions, package/class structure, log messages - please do not
  provide comments unless necessary
- **Choice of data structures**
- **Efficiency of code** (leverage multi-threading wherever it makes sense)
- **Code test Cases and follow TDD** (if know)
# Solution
## Implementation
1. Create an interface that defines the contract for user-related operations such as adding users, creating friendships, removing friendships, and listing friends.
2. Create a class that implements the `UserService` interface, providing concrete methods to manage users and their friendships.
3. Define a class to represent a user in the social network, including attributes like user ID and name.
4. Create an interface that defines the contract for social network analysis operations such as finding the shortest path, calculating degree centrality, and identifying communities.
5. Create a class that implements the `SocialNetworkService` interface, providing concrete methods for social network analysis.
6. Create a class that ensures friendship operations are thread-safe by using synchronization mechanisms or thread-safe data structures.
7. Define custom exception classes to handle specific exceptional situations that may arise during the execution of the application.
## How to Run ?
### Pre-requisites:
Tested with:
- Maven 3.9.6
- Java 21 (Should support till 17)
### Steps:
1. Clone the repository
2. Run `mvn clean install` to build the project
3. Run `mvn exec:java` to run the project
4. On execution, it will initialize the social network state and then demonstrate the functionalities.
### Assumptions:
1. Users are uniquely identified by their IDs.
2. Friendships are bidirectional.
3. The social network can have any number of users and friendships.
4. The tool supports basic social network analysis metrics.
### Future Scope:
1. Enhance the tool to support more complex social network metrics.
2. Integrate with a database for persistent storage of user and friendship data.
3. Implement more efficient algorithms for social network analysis.