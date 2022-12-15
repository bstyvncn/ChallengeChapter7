package chapter4.service;

import chapter4.model.users;
import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
    boolean checkUsernameAndPassword(users username) throws Exception;
    void newUsers(users users);
    void deleteUsers(users users);

    void updateUsers(String from, String to);
}

//6. Menambahkan user
//7. Mengupdate user
//8. Menghapus user