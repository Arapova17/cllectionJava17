import java.util.List;

public interface UserService <M>{
    M addUser (User user);
    List<User> getAll ();
    User getByIdUser (Long id);
    M updateUser (Long id, User newUser);
    M deleteUser (Long id);

}
