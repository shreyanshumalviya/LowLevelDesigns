@startuml
class User{
List<Group> groups
List<Transaction> transactions;

}

class Group{
List<Transactions> transactions;
addUser();
addTransaction();

}

class Transaction{
User creator;
List<User> users;
Double getShareOfUser();
}


Group "0" -> "*" User
Group "0" -> "*" Transaction
Transaction "1" -> User
@enduml
