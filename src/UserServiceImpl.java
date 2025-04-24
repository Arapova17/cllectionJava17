import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>();
    @Override
    public Object addUser(User user) {
        users.add(user);
        return "Success!";
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getByIdUser(Long id) {
        for (User user : users){
            if (user.id().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Object updateUser(Long id, User newUser) {
        for (User user : users){
            if (user.id().equals(id)){
                user.setUserName(newUser.userName());
                user.setAge(newUser.age());
                user.setEmail(newUser.email());
                user.setFirstName(newUser.firstName());
                user.setLastName(newUser.lastName());
                return "Success";
            }
        }
        return "not found";
    }

    @Override
    public Object deleteUser(Long id) {
        for (User user : users){
            if (user.id().equals(id)) {
                users.remove(user);
                return "Success";
            }
        }
        return null;
    }
}
