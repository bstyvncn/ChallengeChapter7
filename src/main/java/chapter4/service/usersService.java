package chapter4.service;

import chapter4.model.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersService implements IUsersService{
    @Autowired
    chapter4.repositories.userRepository userRepository;
    @Override
    public boolean checkUsernameAndPassword(users users) throws Exception {

        List<users> u = userRepository.findUserByUsernameAndPassword(users.getUsername(), users.getPassword());
        if(u.size() > 0) {
            return false;
        }else return true;
    }

    @Override
    public void newUsers(users users) {
        userRepository.save(users);
    }

    @Override
    public void deleteUsers(users users) {
        userRepository.deleteUser(users.getUsername());
    }

    @Override
    public void updateUsers(String from, String to) {
        userRepository.changeUsername(from, to);

    }


//6. Menambahkan user
//7. Mengupdate user
//8. Menghapus user

}
