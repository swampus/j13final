User
* id
* username
* email
* personalCode
* address
* favoriteBook


1. Create .SQL -> db.migration (create table)
2. Create Entity User -> model
3. Create UserDTO -> dto
4. Create UserMapper
5. UserRepository with findByPersonalCode method
6. UserService -> (using userRepository)
7. UserController (getAll) (addNewUser) (findByPersonalCode)  (using UserService)


- localhost:9000/h2-console
- localhost:9000/swagger-ui.html